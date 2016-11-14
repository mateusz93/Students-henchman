package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.factories.ServiceFactory;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.WeatherEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.woeid_dto.WOEID;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-10-05.
 */

public class DownloadWeatherSimpleWorker extends AbstractWorker<WOEID> {
	private static final String TAG = DownloadWeatherSimpleWorker.class.getName();

	private Bundle mBundle;

	public DownloadWeatherSimpleWorker(Context context, Bundle bundle) {
		super(context);
		mBundle = bundle;
	}

	@Override
	public Subscription run() {
		WeatherEndpoints weatherInterface = ServiceFactory.produceService(WeatherEndpoints.class, false);
		Observable<WOEID> call = weatherInterface.getWoeid();
		Subscription subscription = call.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this);

		return subscription;
	}

	@Override
	public void onCompleted() {
		// do nothing
	}

	@Override
	public void onError(Throwable e) {
		onError(mContext, e);
	}

	@Override
	public void onNext(WOEID data) {
		Log.i(TAG, data.toString());
		Toast.makeText(mContext, data.toString(), Toast.LENGTH_LONG).show();
	}
}
