package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import cdm.CourseRS;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Michał on 2016-11-20.
 */

public interface TimeTableEndpoints {

	@GET("courses")
	Observable<Response<CourseRS>> getMyTimeTable();
}
