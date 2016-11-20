package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;

import cdm.CourseRS;
import rx.Subscription;

/**
 * Created by Michał on 2016-11-20.
 */

public class DownloadTimeTableWorker extends AbstractWorker<CourseRS> {
	private static final String TAG = DownloadTimeTableWorker.class.getName();

	public DownloadTimeTableWorker(Context context, Bundle bundle) {
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
	public void onNext(CourseRS courseRS) {

	}
}
