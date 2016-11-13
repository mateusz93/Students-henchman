package edu.p.lodz.pl.studentshenchman.utils.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments.AddNoteDialogFragment;
import edu.p.lodz.pl.studentshenchman.utils.animation.AnimationHelper;
import edu.p.lodz.pl.studentshenchman.utils.dialog.interfaces.AlertDialogCallback;

/**
 * Created by Michał on 2016-11-13.
 */

public class UserYesNoDialog extends DialogFragment {
	private static final String TAG = AddNoteDialogFragment.class.getName();

	private static final String TITLE = TAG + ":title";
	private static final String MESSAGE = TAG + ":message";

	private TextView mTitle;
	private TextView mMessage;
	private Button mOkButton;
	private Button mNoButton;

	private AlertDialogCallback callback;

	public static UserYesNoDialog getInstance(AlertDialogCallback callback, String title, String message) {
		UserYesNoDialog dialog = new UserYesNoDialog(callback);
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		bundle.putString(MESSAGE, message);

		dialog.setArguments(bundle);
		return dialog;
	}

	public UserYesNoDialog() {

	}

	private UserYesNoDialog(AlertDialogCallback callback) {
		this.callback = callback;
	}

	@Override
	public void onStart() {
		super.onStart();
		final View decorView = getDialog()
				.getWindow()
				.getDecorView();

		AnimationHelper.startFallAnimation(decorView);
	}

	public void readjustCallback(AlertDialogCallback callback) {
		this.callback = callback;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.user_yes_no_dialog_fragment, container);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {

		mTitle = (TextView) view.findViewById(R.id.title);
		mMessage = (TextView) view.findViewById(R.id.message);
		mOkButton = (Button) view.findViewById(R.id.ok_button);
		mOkButton.setOnClickListener(new YesOnClickListener());
		mNoButton = (Button) view.findViewById(R.id.no_button);
		mNoButton.setOnClickListener(new NoOnClickListener());

		Bundle args = getArguments();
		mTitle.setText(args.getString(TITLE));
		mMessage.setText(args.getString(MESSAGE));
	}


	private class YesOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			callback.positiveCallback();
			dismiss();
		}
	}

	private class NoOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			callback.negativeCallback();
			dismiss();
		}
	}
}
