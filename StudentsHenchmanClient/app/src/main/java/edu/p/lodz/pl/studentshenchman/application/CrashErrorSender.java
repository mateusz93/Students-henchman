package edu.p.lodz.pl.studentshenchman.application;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import java.util.Date;

import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.ErrorReport;
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

		String errorReportContent = createErrorContent(errorContent);
		ContentValues cv = new ContentValues();
		cv.put(ErrorReport.CONTENT, errorReportContent);
		cv.put(ErrorReport.DATE, new Date().getTime());

		db.insert(ErrorReport.TABLE_NAME, null, cv);
	}

	private String createErrorContent(CrashReportData errorContent) {
		StringBuilder sb = new StringBuilder();

		sb.append(errorContent.getProperty(ReportField.APP_VERSION_CODE)).append("\n");
		sb.append(errorContent.getProperty(ReportField.APP_VERSION_CODE)).append("\n");
		sb.append(errorContent.getProperty(ReportField.PACKAGE_NAME)).append("\n");
		sb.append(errorContent.getProperty(ReportField.FILE_PATH)).append("\n");
		sb.append(errorContent.getProperty(ReportField.PHONE_MODEL)).append("\n");
		sb.append(errorContent.getProperty(ReportField.ANDROID_VERSION)).append("\n");
		sb.append(errorContent.getProperty(ReportField.TOTAL_MEM_SIZE)).append("\n");
		sb.append(errorContent.getProperty(ReportField.STACK_TRACE)).append("\n");
		sb.append(errorContent.getProperty(ReportField.USER_CRASH_DATE)).append("\n");
		sb.append(errorContent.getProperty(ReportField.DEVICE_ID)).append("\n");
		sb.append(errorContent.getProperty(ReportField.LOGCAT)).append("\n");

		return sb.toString();
	}
}
