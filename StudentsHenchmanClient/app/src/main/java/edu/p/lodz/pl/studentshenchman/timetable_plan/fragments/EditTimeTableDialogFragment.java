package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

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
 * Created by Michał on 2016-10-25.
 */

public class EditTimeTableDialogFragment extends DialogFragment {

	private static final String TITLE = "title";

	private TextView mTitle;
	private Button mEditButton;
	private Button mDeleteButton;
	private Button mCancelButton;

	private EditedCoursesOptionsInterface callback;

	public EditTimeTableDialogFragment() {
	}

	public static EditTimeTableDialogFragment getInstance(String title) {

		EditTimeTableDialogFragment editTimeTableDialogFragment = new EditTimeTableDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);

		editTimeTableDialogFragment.setArguments(bundle);

		return editTimeTableDialogFragment;
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
		return inflater.inflate(R.layout.edit_timetable_dialog_fragment, container);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mTitle = (TextView) view.findViewById(R.id.title);
		mEditButton = (Button) view.findViewById(R.id.edit_button);
		mEditButton.setOnClickListener(new EditOnClickListener());
		mDeleteButton = (Button) view.findViewById(R.id.delete_button);
		mDeleteButton.setOnClickListener(new DeleteOnClickListener());
		mCancelButton = (Button) view.findViewById(R.id.cancel_button);
		mCancelButton.setOnClickListener(new CancelOnClickListener());

		String title = getArguments().getString(TITLE);
		mTitle.setText(title);
	}

	private class EditOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			callback.courseToEditSelected(5);
			//mList.setVisibility(View.VISIBLE);
			// tutaj trzeba wywolac workera ktory pobierze odpowiednie dane a w callbacku ustawi adapter na liscie z pobranymi danymi
			// i pokaze odpowiedni widok
		}
	}

	private class DeleteOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			// trzeba wywaloc np callback albo zaimplementowac jakis interfejs i przekazac id wybranych zajec do usuniecia oraz
			// ustawic flage zmiany danych na true
			callback.courseToDeleteSelected(5);
			dismiss();
		}
	}

	private class CancelOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}

	public interface EditedCoursesOptionsInterface {
		void courseToEditSelected(long id);

		void courseToDeleteSelected(long id);
	}


}
