package edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;
import edu.p.lodz.pl.studentshenchman.utils.Utils;

/**
 * Created by Michał on 2016-10-27.
 */

public class LocalChangesDialogFragment extends DialogFragment {

	private static final String TITLE = "title";
	private static final String MESSAGE = "message";

	private UserCallInterface callback;


	public static LocalChangesDialogFragment getInstance(String title, String message) {
		LocalChangesDialogFragment dialogFragment = new LocalChangesDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		bundle.putString(MESSAGE, message);
		dialogFragment.setArguments(bundle);

		return dialogFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		callback = (TimetableActivity) getActivity();
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity())
				// Set Dialog Title
				.setTitle(getArguments().getString(TITLE))
				// Set Dialog Message
				.setMessage(getArguments().getString(MESSAGE))

				// Positive button
				.setPositiveButton(getString(R.string.ok), (dialog, which) -> {
							callback.notifyUserCall(Utils.UserCallType.ACCEPT);
							dismiss();
						}
				)

				// Negative Button
				.setNegativeButton(getString(R.string.cancel_button), (dialog, which) -> {
							callback.notifyUserCall(Utils.UserCallType.DECLINE);
							dismiss();
						}
				).create();
	}

	public interface UserCallInterface {
		void notifyUserCall(Utils.UserCallType userCallType);
	}
}
