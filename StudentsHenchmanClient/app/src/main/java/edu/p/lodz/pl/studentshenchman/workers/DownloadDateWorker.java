package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;

import edu.p.lodz.pl.studentshenchman.factories.ServiceFactory;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.DateEndpoints;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-10-08.
 */
public class DownloadDateWorker extends AbstractWorker<Date> {
    private static final String TAG = DownloadDateWorker.class.getName();

    private final Context mContext;
    private final Bundle mBundle;

    public DownloadDateWorker(Context context, Bundle bundle) {
        mContext = context;
        mBundle = bundle;
    }

    @Override
    public void run() {
        DateEndpoints dateEndpoints = ServiceFactory.produceService(DateEndpoints.class, false);
        Observable<Date> call = dateEndpoints.getDate();

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
    public void onNext(Date date) {
        Toast.makeText(mContext, date.toString(), Toast.LENGTH_LONG).show();
    }
}
