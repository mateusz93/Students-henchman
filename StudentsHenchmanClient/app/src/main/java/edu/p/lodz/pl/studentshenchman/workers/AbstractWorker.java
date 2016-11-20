package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.SocketTimeoutException;

import edu.p.lodz.pl.studentshenchman.utils.dialog.helper.AlertDialogHelper;
import edu.p.lodz.pl.studentshenchman.workers.helpers.WorkerRunnerManager;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;
import rx.Subscription;

/**
 * Created by Michał on 2016-10-05.
 */
public abstract class AbstractWorker<T> implements Observer<T> {

	private static final String TAG = AbstractWorker.class.getName();

	public static final String WORKER_NAME = "WORKER_NAME";
	public static final String FINISHED_STATUS = "FINISHED_STATUS";

	protected Context mContext;
	protected Bundle mBundle;

	public enum FinishedWorkerStatus {
		SUCCESS, FAIL
	}

	public AbstractWorker(Context context, Bundle bundle) {
		mContext = context;
		mBundle = bundle;
	}

	public void notifyTaskFinished(FinishedWorkerStatus finishedWorkerStatus) {
		WorkerType workerType = WorkerType.valueOf(mBundle.getString(WORKER_NAME));
		Log.i(TAG, "Worker: " + workerType.name() + " finished with status: " + finishedWorkerStatus.name());
		WorkerRunnerManager.getInstance(mContext).deleteFromRunningWorkers(workerType);
		Intent intent = new Intent(workerType.name());
		intent.putExtra(FINISHED_STATUS, finishedWorkerStatus.name());
		mContext.sendBroadcast(intent);

	}

	public abstract Subscription run();

	// tymczasowa obsluga bledow, trzeba zwracac bardziej czytelne bledy
	public void onError(Context context, Throwable throwable) {
		if (throwable instanceof HttpException) {
			HttpException httpException = (HttpException) throwable;
			AlertDialogHelper.showErrorDialog("Error", httpException.code() + " - " + httpException.message());
		} else if (throwable instanceof SocketTimeoutException) {
			AlertDialogHelper.showErrorDialog("Socket Timeout", throwable.getMessage());
		} else if (throwable instanceof IOException) {
			AlertDialogHelper.showErrorDialog("Network conversion error", throwable.getMessage());
		} else {
			AlertDialogHelper.showErrorDialog("Error", throwable.getMessage());
		}
		Log.i(TAG, throwable.toString());

	}

}
