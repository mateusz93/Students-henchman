package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;
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

	public static final String WORKER_NAME = "WORKER_NAME";
	public static final String RESPONSE_STATUS = "RESPONSE_STATUS";

	public void notifyTaskFinished(Bundle bundle) {

	}

	public abstract void run();

	// tymczasowa obsluga bledow, trzeba zwracac bardziej czytelne bledy
	public void onError(Context context, Throwable throwable) {
		if (throwable instanceof HttpException) {
			HttpException httpException = (HttpException) throwable;
			Toast.makeText(context, httpException.code() + " - " + httpException.message(), Toast.LENGTH_LONG).show();
		} else if (throwable instanceof SocketTimeoutException) {
			Toast.makeText(context, "Socket Timeout Exception: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
		} else if (throwable instanceof IOException) {
			Toast.makeText(context, "Network conversion error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(context, "Error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
		}
		Log.i(TAG, throwable.toString());

	}

}
