package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

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

	//TODO trzeba zaimplementowac przyjmowanie w kazdym workerze zamiast samego zwracanego obiektu to Response<responseObject> co pozwoli na sprawdzanie response codu
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
			AlertDialogHelper.showErrorDialog("Error", httpException.getMessage() + "\nAction: " + mBundle.getString(WORKER_NAME));
		} else if (throwable instanceof SocketTimeoutException) {
			AlertDialogHelper.showErrorDialog("Socket Timeout", throwable.getMessage());
		} else if (throwable instanceof IOException) {
			AlertDialogHelper.showErrorDialog("Network conversion error", throwable.getMessage());
		} else {
			AlertDialogHelper.showErrorDialog("Error", throwable.getMessage());
		}
		Log.i(TAG, throwable.toString());

	}

	public String listIntegerToString(List<Integer> values) {
		StringBuilder sb = new StringBuilder();
		for (Integer iValue : values) {
			if (!sb.toString().isEmpty())
				sb.append(",");
			sb.append(iValue);
		}

		return sb.toString();
	}

	public String listLongToString(List<Long> values) {
		StringBuilder sb = new StringBuilder();
		for (Long lValue : values) {
			if (!sb.toString().isEmpty())
				sb.append(",");
			sb.append(lValue);
		}

		return sb.toString();
	}

	public List<Long> fromStringToLongList(String value, String separator) {
		List<Long> list = new ArrayList<>();
		String[] separatedValues = value.split(separator);
		for (String s : separatedValues) {
			list.add(Long.valueOf(s));
		}
		return list;
	}

	public List<Integer> fromStringToIntegerList(String value, String separator) {
		List<Integer> list = new ArrayList<>();
		String[] separatedValues = value.split(separator);
		for (String s : separatedValues) {
			list.add(Integer.valueOf(s));
		}
		return list;
	}
}
