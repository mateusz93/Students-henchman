package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import cdm.CourseRS;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.Course;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.TimeTableEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.factories.ServiceFactory;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-11-20.
 */

public class DownloadTimeTableWorker extends AbstractWorker<Response<CourseRS>> {
	private static final String TAG = DownloadTimeTableWorker.class.getName();

	public DownloadTimeTableWorker(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public Subscription run() {
		TimeTableEndpoints settingsEndpoints = ServiceFactory.produceService(TimeTableEndpoints.class, false);
		Observable<Response<CourseRS>> call = settingsEndpoints.getMyTimeTable();

		Subscription subscription = call.subscribeOn(Schedulers.newThread())
				.observeOn(Schedulers.newThread())
				.subscribe(this);

		return subscription;

	}

	@Override
	public void onCompleted() {
		Log.i(TAG, "Timetable downloaded successfully");
		Toast.makeText(mContext, "Timetable downloaded successfully", Toast.LENGTH_SHORT).show();
		notifyTaskFinished(FinishedWorkerStatus.SUCCESS);
	}

	@Override
	public void onError(Throwable e) {
		onError(mContext, e);
		notifyTaskFinished(FinishedWorkerStatus.FAIL);
	}

	@Override
	public void onNext(Response<CourseRS> courseRS) {
		Log.i(TAG, "Saving timetable downloaded from server");
		SQLiteDatabase db = DatabaseHelper.getInstance(mContext).getWritableDatabase();
		deleteOldTimeTable(db);
		saveNewTimeTable(db, courseRS.body().getCourses());
	}

	private void saveNewTimeTable(SQLiteDatabase db, List<model.Course> courses) {
		//for (model.Course courseDto : courses)
		//db.insert(Course.TABLE_NAME, null, Course.fromDTO2CV(courseDto));
	}

	private void deleteOldTimeTable(SQLiteDatabase db) {
		int amountOfDeletedCourses = db.delete(Course.TABLE_NAME, null, null);
		Log.i(TAG, "Amount of deleted courses: " + amountOfDeletedCourses);
	}
}
