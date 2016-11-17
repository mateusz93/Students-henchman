package edu.p.lodz.pl.studentshenchman.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.workers.helpers.WorkerRunnerManager;

/**
 * Created by Michał on 2016-11-17.
 */

public class CrashErrorSender implements ReportSender {

	@Override
	public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
		WorkerRunnerManager.getInstance(context).stopAllWorkers();
		saveCrashReport(context, errorContent);
	}

	private void saveCrashReport(Context context, CrashReportData errorContent) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();

	}
}
