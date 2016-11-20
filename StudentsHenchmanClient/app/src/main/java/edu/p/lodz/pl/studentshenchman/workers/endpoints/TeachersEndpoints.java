package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import cdm.TeacherRS;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Michał on 2016-11-20.
 */

public interface TeachersEndpoints {

	@GET("teachers")
	Observable<TeacherRS> getTeachers();
}
