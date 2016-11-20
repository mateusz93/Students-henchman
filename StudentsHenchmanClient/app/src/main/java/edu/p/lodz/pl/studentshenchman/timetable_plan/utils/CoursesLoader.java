package edu.p.lodz.pl.studentshenchman.timetable_plan.utils;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Michał on 2016-11-20.
 */

public class CoursesLoader extends AsyncTaskLoader<List<CoursesLoaderObject>> {
	public CoursesLoader(Context context) {
		super(context);
	}

	@Override
	public List<CoursesLoaderObject> loadInBackground() {

		return null;
	}
}

