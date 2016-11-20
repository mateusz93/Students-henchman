package edu.p.lodz.pl.studentshenchman.workers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.SettingsEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.factories.ServiceFactory;
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
		Log.i(TAG, "Settings downloaded successfully");
		notifyTaskFinished(FinishedWorkerStatus.SUCCESS);
	}

	@Override
	public void onError(Throwable e) {
		onError(mContext, e);
		notifyTaskFinished(FinishedWorkerStatus.FAIL);
	}

	@Override
	public void onNext(Date date) {
		Log.i(TAG, "Zapisywanie dat uczelnianych pobranych z serwera");
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
