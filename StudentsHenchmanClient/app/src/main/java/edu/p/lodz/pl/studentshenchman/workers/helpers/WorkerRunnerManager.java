package edu.p.lodz.pl.studentshenchman.workers.helpers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.factories.WorkerFactory;
import edu.p.lodz.pl.studentshenchman.workers.AbstractWorker;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;
import rx.Subscription;

import static edu.p.lodz.pl.studentshenchman.workers.AbstractWorker.WORKER_NAME;

/**
 * Created by Michał on 2016-10-24.
 */

public class WorkerRunnerManager {
	private static final String TAG = WorkerRunnerManager.class.getName();

	public static void startWorker(Context context, Bundle bundle) {
		WorkerType workerType = WorkerType.valueOf(bundle.getString(WORKER_NAME));
		AbstractWorker abstractWorker = WorkerFactory.produce(context, workerType, bundle);
		Log.i(TAG, "Uruchamianie nowego workera typu: " + workerType.name() + " klasy: " + abstractWorker.getClass().getName());
		try {
			Subscription subscription = abstractWorker.run();
		} catch (Exception e) {
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}
