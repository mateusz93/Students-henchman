package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import java.util.Date;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Michał on 2016-10-08.
 */
public interface DateEndpoints {

	@GET("date")
	Observable<Date> getDate();

}
