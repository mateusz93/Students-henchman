package edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.timetable_plan.utils.TimeTableUtils;
import edu.p.lodz.pl.studentshenchman.utils.animation.AnimationHelper;

/**
 * Created by Michał on 2016-10-25.
 */

public class AddNoteDialogFragment extends DialogFragment {
	private static final String TAG = AddNoteDialogFragment.class.getName();

	private TextView mExpandableDateLable;
	private DatePicker mActivationDate;
	private EditText mNoteContent;
	private Button mOkButton;
	private Button mCancelButton;

	public static AddNoteDialogFragment getInstance() {

		return new AddNoteDialogFragment();
	}

	@Override
	public void onStart() {
		super.onStart();
		final View decorView = getDialog()
				.getWindow()
				.getDecorView();

		AnimationHelper.startFallAnimation(decorView);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.add_note_dialog_fragment, container);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		mExpandableDateLable = (TextView) view.findViewById(R.id.expandable_date_view);
		mExpandableDateLable.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mActivationDate.setVisibility(mActivationDate.isShown() ? View.GONE : View.VISIBLE);
			}
		});
		mActivationDate = (DatePicker) view.findViewById(R.id.note_activation_date);
		mActivationDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mActivationDate.setVisibility(View.GONE);
			}
		});
		mNoteContent = (EditText) view.findViewById(R.id.content);
		mOkButton = (Button) view.findViewById(R.id.ok_button);
		mOkButton.setOnClickListener(new OkOnClickListener());
		mCancelButton = (Button) view.findViewById(R.id.cancel_button);
		mCancelButton.setOnClickListener(new CancelOnClickListener());
	}


	private class OkOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Date date = new Date(mActivationDate.getYear() - 1900, mActivationDate.getMonth(), mActivationDate.getDayOfMonth());
			String content = mNoteContent.getText().toString().trim();
			long activationDate = date.getTime();
			Log.i(TAG, "Tresc notatki: " + content + " data aktywacji: " + activationDate);
			if (!content.isEmpty())
				TimeTableUtils.addNoteToDB(getContext(), 1, 1, content, activationDate);
			dismiss();
		}
	}

	private class CancelOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}
}
