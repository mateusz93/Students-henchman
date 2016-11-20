package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;

import cdm.TeacherRS;
import rx.Subscription;

/**
 * Created by Michał on 2016-11-20.
 */

public class DownloadTeachersWorker extends AbstractWorker<TeacherRS> {
	private static final String TAG = DownloadTeachersWorker.class.getName();

	public DownloadTeachersWorker(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public Subscription run() {
		return null;
	}

	@Override
	public void onCompleted() {

	}

	@Override
	public void onError(Throwable e) {

	}

	@Override
	public void onNext(TeacherRS teacherRS) {

	}
}
