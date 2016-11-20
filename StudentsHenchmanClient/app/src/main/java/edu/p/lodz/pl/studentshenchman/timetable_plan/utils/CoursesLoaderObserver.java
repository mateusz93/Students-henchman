package edu.p.lodz.pl.studentshenchman.timetable_plan.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Michał on 2016-11-20.
 */

public class CoursesLoaderObserver extends BroadcastReceiver {

	private Context context;
	private CoursesLoader mCoursesLoader;

	public CoursesLoaderObserver(Context context, CoursesLoader coursesLoader) {

		this.context = context;
		this.mCoursesLoader = coursesLoader;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		mCoursesLoader.onContentChanged();
	}
}
