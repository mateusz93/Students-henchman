package edu.p.lodz.pl.studentshenchman.workers.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import edu.p.lodz.pl.studentshenchman.workers.factories.WorkerFactory;
import edu.p.lodz.pl.studentshenchman.workers.AbstractWorker;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;
import rx.Subscription;

import static edu.p.lodz.pl.studentshenchman.workers.AbstractWorker.WORKER_NAME;

/**
 * Created by Michał on 2016-10-24.
 */

public class WorkerRunnerManager {
	private static final String TAG = WorkerRunnerManager.class.getName();

	private static WorkerRunnerManager mInstance;

	private Context mContext;
	private Map<WorkerType, Subscription> runningWorkers;

	public static WorkerRunnerManager getInstance(Context context) {
		if (null == mInstance)
			mInstance = new WorkerRunnerManager(context);
		return mInstance;
	}

	private WorkerRunnerManager(Context context) {
		mContext = context;
		runningWorkers = new HashMap<>();
	}

	public void startWorker(Bundle bundle) {
		WorkerType workerType = WorkerType.valueOf(bundle.getString(WORKER_NAME));
		AbstractWorker abstractWorker = null;
		abstractWorker = WorkerFactory.produce(mContext, workerType, bundle);
		try {
			if (canRunWorker(workerType)) {
				Log.i(TAG, "Uruchamianie nowego workera typu: " + workerType.name() + " klasy: " + abstractWorker.getClass().getName());
				Subscription subscription = abstractWorker.run();
				runningWorkers.put(workerType, subscription);
			} else {
				Log.i(TAG, "Worker typu: " + workerType.name() + " klasy: " + abstractWorker.getClass().getName() + " jest juz uruchominy !!! Pominiecie akcji");
			}
		} catch (Exception e) {
			Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	private boolean canRunWorker(WorkerType workerType) {
		if (runningWorkers.containsKey(workerType))
			return false;
		return true;
	}

	public void deleteFromRunningWorkers(WorkerType workerType) {
		if (runningWorkers.containsKey(workerType)) {
			Subscription subscription = runningWorkers.remove(workerType);
			if (!subscription.isUnsubscribed()) {
				subscription.unsubscribe();
				Log.i(TAG, "Usuniecie z listy workerow i odsubskrybowanie workera typu: " + workerType.name());
			}
		} else {
			Log.i(TAG, "Brak aktualnie odpalonego workera typu: " + workerType.name());
		}
	}

	public void stopAllWorkers() {
		for (Map.Entry<WorkerType, Subscription> entry : runningWorkers.entrySet()) {
			deleteFromRunningWorkers(entry.getKey());
		}
	}

	public void registerBroadcastForWorkerType(BroadcastReceiver receiver, WorkerType workerType) {
		Log.i(TAG, "Rejstracja broadcast receiver dla akcji: " + workerType.name());
		mContext.registerReceiver(receiver, new IntentFilter(workerType.name()));
	}

	public void unregisterBroadcastReceiverForWorkerType(BroadcastReceiver receiver) {
		Log.i(TAG, "Wyrejstrowanie broadcast receiver: ");
		mContext.unregisterReceiver(receiver);
	}


}
