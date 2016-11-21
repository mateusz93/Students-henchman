package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import edu.p.lodz.pl.studentshenchman.workers.endpoints.NotesEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.factories.ServiceFactory;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-11-21.
 */

public class DeleteNoteWorker extends AbstractWorker<Response<Void>> {
	private static final String TAG = DeleteNoteWorker.class.getName();

	public static final String NOTE_ID = TAG + ":note_id";

	public DeleteNoteWorker(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public Subscription run() {
		long noteId = mBundle.getLong(NOTE_ID);

		NotesEndpoints notesEndpoints = ServiceFactory.produceService(NotesEndpoints.class, false);
		Observable<Response<Void>> call = notesEndpoints.deleteNote(noteId);

		Subscription subscription = call.subscribeOn(Schedulers.newThread())
				.observeOn(Schedulers.newThread())
				.subscribe(this);

		return subscription;
	}

	@Override
	public void onCompleted() {
		Log.i(TAG, "Note deleted successfully");
		notifyTaskFinished(FinishedWorkerStatus.SUCCESS);
	}

	@Override
	public void onError(Throwable e) {
		Log.i(TAG, "Note deleted failure");
		onError(mContext, e);
		notifyTaskFinished(FinishedWorkerStatus.FAIL);
	}

	@Override
	public void onNext(Response<Void> voidResponse) {

	}
}
