package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import cdm.PreferencesRQ;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Michał on 2016-11-20.
 */

public interface UserEndpoints {

	@POST("user/setPreferences")
	Observable<Response<Void>> setUserPreferences(@Body PreferencesRQ userPreferences);
}
