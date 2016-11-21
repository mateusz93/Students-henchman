package edu.p.lodz.pl.studentshenchman.application;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;

import edu.p.lodz.pl.studentshenchman.login.utils.LoginManager;

/**
 * Created by Michał on 2016-11-16.
 */
@ReportsCrashes(reportSenderFactoryClasses = {CrashSenderFactory.class},
		customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL,
				ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT}
)
public class StudentApplication extends Application {

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		// Initialise ACRA
		LoginManager.initiate(getApplicationContext());

		ACRA.init(this);
	}
}
