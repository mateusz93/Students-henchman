package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;

/**
 * Created by Michał on 2016-10-05.
 */
public abstract class AbstractWorker<T> implements Observer<T> {

    private static final String TAG = AbstractWorker.class.getName();

    public static final String WORKER_TYPE = "WORKER_TYPE";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";

    public void sendResponse(Intent responseIntent) {

    }

    public abstract void run();

    public void runService() {
        run();
    }

    // tymczasowa obsluga bledow, trzeba zwracac bardziej czytelne bledy
    public void onError(Context context, Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            Toast.makeText(context, httpException.code() + " - " + httpException.response().message(), Toast.LENGTH_LONG).show();
        } else if (throwable instanceof SocketTimeoutException) {
            Toast.makeText(context, "Socket Timeout Exception", Toast.LENGTH_LONG).show();
        } else if (throwable instanceof IOException) {
            Toast.makeText(context, "Network conversion error", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
        }
        Log.i(TAG, throwable.toString());

    }

}
