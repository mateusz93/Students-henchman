package edu.p.lodz.pl.studentshenchman.factories;

import android.content.Context;

import edu.p.lodz.pl.studentshenchman.workers.AbstractWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadDateWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadWeatherSimpleWorker;
import edu.p.lodz.pl.studentshenchman.workers.IdleWorker;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;

/**
 * Created by Michał on 2016-10-05.
 */
public class WorkerFactory {

    public static AbstractWorker produce(Context context, WorkerType workerType) {
        switch (workerType) {
            case DOWNLOAD_DATE:
                return new DownloadDateWorker(context);
            case DOWNLOAD_WOEID_WEATHER:
                return new DownloadWeatherSimpleWorker(context);
            default:
                return new IdleWorker(context);
        }

    }

}
