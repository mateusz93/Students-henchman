package edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * Created by Michał on 2016-10-25.
 */

public class AddNoteDialogFragment extends DialogFragment {

	private static final String TITLE = "title";

	public static AddNoteDialogFragment getInstance(String title) {
		AddNoteDialogFragment dialogFragment = new AddNoteDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		dialogFragment.setArguments(bundle);

		return dialogFragment;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {

	}
}
