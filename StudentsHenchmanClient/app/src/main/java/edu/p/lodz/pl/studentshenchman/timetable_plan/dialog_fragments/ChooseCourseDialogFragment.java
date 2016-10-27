package edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;

/**
 * Created by Michał on 2016-10-27.
 */

public class ChooseCourseDialogFragment extends DialogFragment {

	private static final String TITLE = ":title";

	private SelectedCourseToSwap callback;
	private TextView mTitle;
	private Button mOkButton;
	private Button mCancelButton;

	public static ChooseCourseDialogFragment getInstance(String title) {
		ChooseCourseDialogFragment dialogFragment = new ChooseCourseDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		dialogFragment.setArguments(bundle);

		return dialogFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		callback = (TimetableActivity) getActivity();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		getDialog().requestWindowFeature(STYLE_NO_TITLE);
		return inflater.inflate(R.layout.choose_course_edit_dialog_fragment, container);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mTitle = (TextView) view.findViewById(R.id.title);
		mOkButton = (Button) view.findViewById(R.id.ok_button);
		mOkButton.setOnClickListener(new OkOnClickListener());

		mCancelButton = (Button) view.findViewById(R.id.cancel_button);
		mCancelButton.setOnClickListener(new CancelOnClickListener());

		String title = getArguments().getString(TITLE);
		mTitle.setText(title);
	}

	public interface SelectedCourseToSwap {

		void courseSelectedFromListToSwap(long id);
	}

	private class OkOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {

		}
	}

	private class CancelOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}
}
