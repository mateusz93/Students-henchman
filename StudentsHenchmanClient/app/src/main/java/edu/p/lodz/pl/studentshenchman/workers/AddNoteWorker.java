package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cdm.NoteRQ;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.Note;
import edu.p.lodz.pl.studentshenchman.workers.endpoints.NotesEndpoints;
import edu.p.lodz.pl.studentshenchman.workers.factories.ServiceFactory;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2016-11-21.
 */

public class AddNoteWorker extends AbstractWorker<Response<Void>> {
	private static final String TAG = AddNoteWorker.class.getName();

	public static final String NOTES_TO_ADD_IDS = TAG + ":notes_ids";

	public AddNoteWorker(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public Subscription run() {
		ArrayList<Integer> notesIds = mBundle.getIntegerArrayList(NOTES_TO_ADD_IDS);
		NoteRQ noteRQ = createNoteRQ(notesIds);
		NotesEndpoints notesEndpoints = ServiceFactory.produceService(NotesEndpoints.class, false);
		Observable<Response<Void>> call = notesEndpoints.addNote(noteRQ);

		Subscription subscription = call.subscribeOn(Schedulers.newThread())
				.observeOn(Schedulers.newThread())
				.subscribe(this);

		return subscription;
	}

	private NoteRQ createNoteRQ(ArrayList<Integer> notesIds) {
		NoteRQ noteRQ = new NoteRQ();
		Set<model.Note> notes = new HashSet<>();
		SQLiteDatabase db = DatabaseHelper.getInstance(mContext).getReadableDatabase();
		String idsAsString = listIntegerToString(notesIds);
		Cursor cursor = db.query(Note.TABLE_NAME, null, Note._ID + " in (" + idsAsString + ")", null, null, null, null);
		while (cursor.moveToNext()) {
			model.Note note = new model.Note();
			note.setContent(cursor.getString(cursor.getColumnIndexOrThrow(Note.CONTENT)));
			note.setActivationDate(cursor.getLong(cursor.getColumnIndexOrThrow(Note.ACTIVATION_DATE)));
			notes.add(note);
		}
		cursor.close();
		noteRQ.setNotes(notes);
		return noteRQ;
	}

	@Override
	public void onCompleted() {
		Log.i(TAG, "Added notes successfully");
		notifyTaskFinished(FinishedWorkerStatus.SUCCESS);
	}

	@Override
	public void onError(Throwable e) {
		Log.i(TAG, "Added notes failure");
		onError(mContext, e);
		notifyTaskFinished(FinishedWorkerStatus.FAIL);
	}

	@Override
	public void onNext(Response<Void> voidResponse) {
		// now do nothing just save the note on the server
	}
}
