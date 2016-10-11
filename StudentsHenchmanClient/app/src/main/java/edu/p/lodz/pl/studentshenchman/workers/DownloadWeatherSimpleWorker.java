package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.factories.ServiceFactory;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.WeatherEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.utils.ResponseError;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerResponseCode;
import edu.p.lodz.pl.studentshenchman.workers.woeid_dto.WOEID;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-10-05.
 */

public class DownloadWeatherSimpleWorker extends AbstractWorker<WOEID> {
    private static final String TAG = DownloadWeatherSimpleWorker.class.getName();

    private Context mContext;

    public DownloadWeatherSimpleWorker(Context context) {
        mContext = context;
    }

    @Override
    public void sendResponse(Intent responseIntent) {
    }

    @Override
    public void run() {
        WeatherEndpoints weatherInterface = ServiceFactory.produceService(WeatherEndpoints.class, false);
        Observable<WOEID> call = weatherInterface.getWoeid();
        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
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
