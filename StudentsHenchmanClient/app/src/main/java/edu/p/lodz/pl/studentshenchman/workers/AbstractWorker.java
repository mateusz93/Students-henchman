package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import edu.p.lodz.pl.studentshenchman.workers.utils.ResponseError;
import rx.Observer;

/**
 * Created by Michał on 2016-10-05.
 */
public abstract class AbstractWorker<T> implements Observer<T> {

    private static final String TAG = AbstractWorker.class.getName();

    public static final String WORKER_TYPE = "WORKER_TYPE";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";

    public abstract void sendResponse(Intent responseIntent);

    public abstract void run();

    public void runService() {
        run();
    }

    public void onError(Context context, ResponseError responseError) {
        Log.i(TAG, responseError.toString());
    }
}
