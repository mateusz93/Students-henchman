package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.util.Log;

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
    public void run() {
        Log.i(TAG, "Idle service - nothing to do");
    }

    @Override
    public void onCompleted() {
        Log.i(TAG, "Idle worker - onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        onError(mContext, e);
    }

    @Override
    public void onNext(Object o) {
        Log.i(TAG, "Idle worker - onNext - nothing to do just finish it");
    }
}
