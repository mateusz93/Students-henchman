package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import cdm.SettingsRS;
import edu.p.lodz.pl.studentshenchman.factories.ServiceFactory;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.SettingsEndpoints;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-10-26.
 */

public class DownloadSettingsWorker extends AbstractWorker<SettingsRS> {
	private static final String TAG = DownloadSettingsWorker.class.getName();

	private Context mContext;
	private Bundle mBundle;

	public DownloadSettingsWorker(Context context, Bundle bundle) {
		mContext = context;
		mBundle = bundle;
	}

	@Override
	public void run() {
		SettingsEndpoints settingsEndpoints = ServiceFactory.produceService(SettingsEndpoints.class, false);
		Observable<SettingsRS> call = settingsEndpoints.getSettings();

		call.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this);
	}

	@Override
	public void onCompleted() {
		Toast.makeText(mContext, "Completed Task", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onError(Throwable e) {
		onError(mContext, e);
	}

	@Override
	public void onNext(SettingsRS settingsRS) {
		Toast.makeText(mContext, settingsRS.getDepartments().toString(), Toast.LENGTH_SHORT).show();
	}
}
