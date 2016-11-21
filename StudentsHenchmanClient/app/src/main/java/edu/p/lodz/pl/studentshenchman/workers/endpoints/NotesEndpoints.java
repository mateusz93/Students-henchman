package edu.p.lodz.pl.studentshenchman.workers.endpoints;

import cdm.NoteRQ;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Michał on 2016-11-20.
 */

public interface NotesEndpoints {

	@POST("setNote")
	Observable<Response<Void>> addNote(@Body NoteRQ noteRQ);

	@DELETE("deleteNote/{id}")
	Observable<Response<Void>> deleteNote(@Path("id") long noteId);
}
