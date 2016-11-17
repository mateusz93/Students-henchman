package edu.p.lodz.pl.studentshenchman.application;

import android.content.Context;

import org.acra.config.ACRAConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderFactory;

/**
 * Created by Michał on 2016-11-17.
 */

public class CrashSenderFactory implements ReportSenderFactory {

	public ReportSender create(Context context, ACRAConfiguration config) {

		return new CrashErrorSender();
	}
}
