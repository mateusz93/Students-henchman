package edu.p.lodz.pl.studentshenchman.timetable_plan.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.Course;
import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;
import edu.p.lodz.pl.studentshenchman.database.models.Teacher;

/**
 * Created by Michał on 2016-11-20.
 */

public class CoursesLoader extends AsyncTaskLoader<List<CoursesLoaderObject>> {

	private List<CoursesLoaderObject> mData;
	private String mDayCode;
	private String mDayAbbreviation;

	public CoursesLoader(Context context, String dayCode, String dayAbbreviation) {
		super(context);

		mDayCode = dayCode;
		mDayAbbreviation = dayAbbreviation;
	}

	@Override
	public List<CoursesLoaderObject> loadInBackground() {
		List<CoursesLoaderObject> courses = new ArrayList<>();
		courses = loadCourses();

		return courses;
	}

	private List<CoursesLoaderObject> loadCourses() {
		List<CoursesLoaderObject> values = new ArrayList<>();
		Calendar calendar = new GregorianCalendar();
		String formattedDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
		int weekNo = 0;
		SQLiteDatabase db = DatabaseHelper.getInstance(getContext()).getReadableDatabase();

		/*Cursor c = db.query(Date.TABLE_NAME, null, Date.DATE + "=?", new String[]{formattedDate}, null, null, null, null);
		if (c.moveToFirst()) {
			weekNo = c.getInt(c.getColumnIndexOrThrow(Date.WEEK_NO));
		}*/

		Cursor c = db.query(Course.TABLE_NAME, null, Course.DAY + "=?", new String[]{mDayAbbreviation}, null, null, null);
		Course course;
		Teacher teacher = new Teacher();
		DeanGroup deanGroup = new DeanGroup();
		while (c.moveToNext()) {
			course = new Course(c);
			CoursesLoaderObject loaderObject = new CoursesLoaderObject();
			Cursor teacherCursor = db.query(Teacher.TABLE_NAME, null, Teacher.EXTERNAL_TEACHER_ID + "=?",
					new String[]{course.getExternalTeacherId() + ""}, null, null, null);
			if (teacherCursor.moveToFirst()) {
				teacher = new Teacher(teacherCursor);
			}
			Cursor deanGroupCursor = db.query(DeanGroup.TABLE_NAME, null, DeanGroup.EXTERNAL_DEAN_GROUP_ID + "=?",
					new String[]{course.getExternalDeanGroupId() + ""}, null, null, null);
			if (deanGroupCursor.moveToFirst()) {
				deanGroup = new DeanGroup(deanGroupCursor);
			}
			teacherCursor.close();
			deanGroupCursor.close();

			loaderObject.setCourseId(course.getId());
			loaderObject.setExternalCourseId(course.getExternalId());
			loaderObject.setCourseName(course.getName());
			loaderObject.setTime(course.getTime());
			loaderObject.setTeacherName(teacher.getName());
			loaderObject.setDeanGroupName(deanGroup.getName());
			values.add(loaderObject);
		}
		c.close();
		return values;
	}


	@Override
	public void deliverResult(List<CoursesLoaderObject> data) {
		if (isReset()) {
			// The Loader has been reset; ignore the result and invalidate the data.
			releaseResources(data);
			return;
		}

		// Hold a reference to the old data so it doesn't get garbage collected.
		// We must protect it until the new data has been delivered.
		List<CoursesLoaderObject> oldData = mData;
		mData = data;

		if (isStarted()) {
			// If the Loader is in a started state, deliver the results to the
			// client. The superclass method does this for us.
			super.deliverResult(data);
		}

		// Invalidate the old data as we don't need it any more.
		if (oldData != null && oldData != data) {
			releaseResources(oldData);
		}
	}

	@Override
	protected void onStartLoading() {
		if (mData != null) {
			// Deliver any previously loaded data immediately.
			deliverResult(mData);
		}


		if (mObserver == null) {
			mObserver = new CoursesLoaderObserver(getContext(), this);
			IntentFilter intentFilter = new IntentFilter("COURSES_CHANGED");
			getContext().registerReceiver(mObserver, intentFilter);
		}

		if (takeContentChanged() || mData == null) {
			// When the observer detects a change, it should call onContentChanged()
			// on the Loader, which will cause the next call to takeContentChanged()
			// to return true. If this is ever the case (or if the current data is
			// null), we force a new load.
			forceLoad();
		}
	}

	@Override
	protected void onStopLoading() {
		// The Loader is in a stopped state, so we should attempt to cancel the
		// current load (if there is one).
		cancelLoad();

		// Note that we leave the observer as is. Loaders in a stopped state
		// should still monitor the data source for changes so that the Loader
		// will know to force a new load if it is ever started again.
	}

	@Override
	protected void onReset() {
		// Ensure the loader has been stopped.
		onStopLoading();

		// At this point we can release the resources associated with 'mData'.
		if (mData != null) {
			releaseResources(mData);
			mData = null;
		}

		// The Loader is being reset, so we should stop monitoring for changes.
		if (mObserver != null) {
			getContext().unregisterReceiver(mObserver);
			mObserver = null;
		}
	}

	@Override
	public void onCanceled(List<CoursesLoaderObject> data) {
		// Attempt to cancel the current asynchronous load.
		super.onCanceled(data);

		// The load has been canceled, so we should release the resources
		// associated with 'data'.
		releaseResources(data);
	}

	private void releaseResources(List<CoursesLoaderObject> data) {
		// For a simple List, there is nothing to do. For something like a Cursor, we
		// would close it in this method. All resources associated with the Loader
		// should be released here.
	}

	private CoursesLoaderObserver mObserver;
}

