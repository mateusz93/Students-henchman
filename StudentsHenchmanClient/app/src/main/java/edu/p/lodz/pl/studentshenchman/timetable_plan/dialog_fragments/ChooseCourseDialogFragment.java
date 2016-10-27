package edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Michał on 2016-10-27.
 */

public class ChooseCourseDialogFragment extends DialogFragment {

	private static final String TITLE = ":title";

	public static ChooseCourseDialogFragment getInstance(String title) {
		ChooseCourseDialogFragment dialogFragment = new ChooseCourseDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		dialogFragment.setArguments(bundle);

		return dialogFragment;
	}
}
