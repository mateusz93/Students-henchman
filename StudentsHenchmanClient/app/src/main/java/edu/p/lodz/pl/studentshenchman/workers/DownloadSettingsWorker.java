package edu.p.lodz.pl.studentshenchman.workers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import cdm.SettingsRS;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;
import edu.p.lodz.pl.studentshenchman.database.models.Department;
import edu.p.lodz.pl.studentshenchman.database.models.Field;
import edu.p.lodz.pl.studentshenchman.settings.datastore.SettingsDataStoreHelper;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.SettingsEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.factories.ServiceFactory;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-10-26.
 */

public class DownloadSettingsWorker extends AbstractWorker<Response<SettingsRS>> {
	private static final String TAG = DownloadSettingsWorker.class.getName();

	public DownloadSettingsWorker(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public Subscription run() {
		SettingsEndpoints settingsEndpoints = ServiceFactory.produceService(SettingsEndpoints.class, false);
		Observable<Response<SettingsRS>> call = settingsEndpoints.getSettings();

		Subscription subscription = call.subscribeOn(Schedulers.newThread())
				.observeOn(Schedulers.newThread())
				.subscribe(this);

		return subscription;
	}

	@Override
	public void onCompleted() {
		Log.i(TAG, "Settings downloaded successfully");
		Toast.makeText(mContext, "Settings downloaded successfully", Toast.LENGTH_SHORT).show();
		notifyTaskFinished(FinishedWorkerStatus.SUCCESS);
	}

	@Override
	public void onError(Throwable e) {
		Log.i(TAG, "Settings downloaded failure");
		onError(mContext, e);
		notifyTaskFinished(FinishedWorkerStatus.FAIL);
	}

	@Override
	public void onNext(Response<SettingsRS> settingsRS) {
		SettingsDataStoreHelper settingsDataStoreHelper = new SettingsDataStoreHelper(mContext);
		settingsDataStoreHelper.setDefault().save();
		Log.i(TAG, "Setting default user preferences");
		if (settingsRS.isSuccessful()) {
			SQLiteDatabase db = DatabaseHelper.getInstance(mContext).getWritableDatabase();
			deleteOldSettings(db);
			saveDepartmentsIntoDB(db, settingsRS.body().getDepartments());
			saveFieldsIntoDB(db, settingsRS.body().getFields());
			saveDeanGroupsIntoDB(db, settingsRS.body().getDeanGroups());
		} else
			onError(new HttpException(settingsRS));

	}

	private void saveDeanGroupsIntoDB(SQLiteDatabase db, List<model.DeanGroup> deanGroups) {
		for (model.DeanGroup deanGroup : deanGroups) {
			insertDataIntoDB(db, DeanGroup.TABLE_NAME, DeanGroup.fromDto2CV(deanGroup));
		}
	}


	private void saveFieldsIntoDB(SQLiteDatabase db, List<model.Field> fields) {
		for (model.Field field : fields) {
			insertDataIntoDB(db, Field.TABLE_NAME, Field.fromDto2CV(field));
		}
	}

	private void saveDepartmentsIntoDB(SQLiteDatabase db, List<model.Department> departments) {
		for (model.Department department : departments) {
			insertDataIntoDB(db, Department.TABLE_NAME, Department.fromDto2CV(department));
		}
	}


	private void insertDataIntoDB(SQLiteDatabase db, String tableName, ContentValues contentValues) {
		db.insert(tableName, null, contentValues);
	}

	private void deleteOldSettings(SQLiteDatabase db) {
		db.delete(DeanGroup.TABLE_NAME, null, null);
		db.delete(Field.TABLE_NAME, null, null);
		db.delete(Department.TABLE_NAME, null, null);
	}
}
