package edu.p.lodz.pl.studentshenchman.workers.factories;

import android.content.Context;
import android.os.Bundle;

import edu.p.lodz.pl.studentshenchman.workers.AbstractWorker;
import edu.p.lodz.pl.studentshenchman.workers.AddNoteWorker;
import edu.p.lodz.pl.studentshenchman.workers.DeleteNoteWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadDateWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadSettingsWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadTeachersWorker;
import edu.p.lodz.pl.studentshenchman.workers.DownloadTimeTableWorker;
import edu.p.lodz.pl.studentshenchman.workers.IdleWorker;
import edu.p.lodz.pl.studentshenchman.workers.SetUserPreferencesWorker;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;

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
			case DOWNLOAD_COURSES:
				return new DownloadTimeTableWorker(context, bundle);
			case DOWNLOAD_TEACHERS:
				return new DownloadTeachersWorker(context, bundle);
			case SET_USER_PREFERENCES:
				return new SetUserPreferencesWorker(context, bundle);
			case ADD_NOTE:
				return new AddNoteWorker(context, bundle);
			case DELETE_NOTE:
				return new DeleteNoteWorker(context, bundle);
			default:
				return new IdleWorker(context, bundle);
		}

	}

}
