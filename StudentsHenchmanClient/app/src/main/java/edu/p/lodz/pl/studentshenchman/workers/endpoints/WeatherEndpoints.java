package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import edu.p.lodz.pl.studentshenchman.workers.woeid_dto.WOEID;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Michał on 2016-10-08.
 */
public interface WeatherEndpoints {
	@GET("v1/public/yql?q=select%20woeid%20from%20geo.places(1)%20where%20text=\"Lodz\"&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
	Observable<WOEID> getWoeid();
}
