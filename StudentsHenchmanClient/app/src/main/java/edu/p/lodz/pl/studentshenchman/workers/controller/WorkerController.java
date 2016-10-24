package edu.p.lodz.pl.studentshenchman.workers.controller;

import android.content.Context;
import android.os.Bundle;

import edu.p.lodz.pl.studentshenchman.factories.WorkerFactory;
import edu.p.lodz.pl.studentshenchman.workers.AbstractWorker;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;

import static edu.p.lodz.pl.studentshenchman.workers.AbstractWorker.WORKER_TYPE;

/**
 * Created by Michał on 2016-10-24.
 */

public class WorkerController {
    public static void startWorker(Context context, Bundle bundle) {
        WorkerType workerType = WorkerType.valueOf(bundle.getString(WORKER_TYPE));
        AbstractWorker abstractWorker = WorkerFactory.produce(context, workerType, bundle);
        abstractWorker.runService();
    }
}
