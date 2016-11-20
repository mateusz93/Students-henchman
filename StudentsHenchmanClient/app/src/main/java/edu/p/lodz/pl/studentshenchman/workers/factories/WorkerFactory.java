package edu.p.lodz.pl.studentshenchman.workers.factories;

import android.content.Context;
import android.os.Bundle;

import edu.p.lodz.pl.studentshenchman.workers.AbstractWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadDateWorker;
import edu.p.lodz.pl.studentshenchman.workers.IdleWorker;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;
import edu.p.lodz.pl.studentshenchman.workers.DownloadSettingsWorker;

/**
 * Created by Michał on 2016-10-05.
 */
public class WorkerFactory {

	public static AbstractWorker produce(Context context, WorkerType workerType, Bundle bundle) {
		switch (workerType) {
			case DOWNLOAD_DATE:
				return new DownloadDateWorker(context, bundle);
			case DOWNLOAD_SETTINGS:
				return new DownloadSettingsWorker(context, bundle);
			default:
				return new IdleWorker(context, bundle);
		}

	}

}
