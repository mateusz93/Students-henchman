package edu.p.lodz.pl.studentshenchman.workers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.factories.ServiceFactory;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.SettingsEndpoints;
import model.Date;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-10-08.
 */
public class DownloadDateWorker extends AbstractWorker<Date> {
	private static final String TAG = DownloadDateWorker.class.getName();

	public DownloadDateWorker(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public Subscription run() {
		SettingsEndpoints dateEndpoints = ServiceFactory.produceService(SettingsEndpoints.class, false);
		Observable<Date> call = dateEndpoints.getDate();

		Subscription subscription = call.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this);

		return subscription;
	}

	@Override
	public void onCompleted() {
		Toast.makeText(mContext, "Date downloaded successfully", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onError(Throwable e) {
		onError(mContext, e);
	}

	@Override
	public void onNext(Date date) {
		SQLiteDatabase db = DatabaseHelper.getInstance(mContext).getWritableDatabase();
		deleteOldSettings(db);
		saveDateIntoDB(db, date);
	}

	private void saveDateIntoDB(SQLiteDatabase db, Date date) {
		ContentValues cv = edu.p.lodz.pl.studentshenchman.database.models.Date.fromDTO2CV(date);
		db.insert(edu.p.lodz.pl.studentshenchman.database.models.Date.TABLE_NAME, null, cv);
	}

	private void deleteOldSettings(SQLiteDatabase db) {
		db.delete(edu.p.lodz.pl.studentshenchman.database.models.Date.TABLE_NAME, null, null);
	}
}
