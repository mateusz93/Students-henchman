package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import cdm.SettingsRS;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by Michał on 2016-10-26.
 */

public interface SettingsEndpoints {

	@GET("settings")
	Observable<SettingsRS> getSettings();
}
