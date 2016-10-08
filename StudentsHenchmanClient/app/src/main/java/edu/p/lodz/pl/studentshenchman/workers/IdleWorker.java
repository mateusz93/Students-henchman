package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import edu.p.lodz.pl.studentshenchman.workers.utils.ResponseError;

/**
 * Created by Michał on 2016-10-05.
 */
public class IdleWorker extends AbstractWorker {
    public static final String TAG = IdleWorker.class.getName();

    private final Context mContext;

    public IdleWorker(Context context) {
        mContext = context;
    }

    @Override
    public void sendResponse(Intent responseIntent) {

    }

    @Override
    public void run() {
        Log.i(TAG, "Idle service - nothing to do");
    }

    @Override
    public void onCompleted() {
        Log.i(TAG, "Idle worker - onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        ResponseError responseError = new ResponseError(400, e.getMessage(), e);
        onError(mContext, responseError);
    }

    @Override
    public void onNext(Object o) {
        Log.i(TAG, "Idle worker - onNext - nothing to do just finish it");
    }
}
