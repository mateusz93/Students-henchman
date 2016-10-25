package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.EditTimeTableListAdapter;

/**
 * Created by Michał on 2016-10-25.
 */

public class EditTimeTableDialogFragment extends DialogFragment {

	private static final String TITLE = "title";
	private static final String WORKER_RUNNING = "worker_running";
	private static final String CANCELABLE = "cancelable";
	private TextView mTitle;
	private ListView mList;
	private LinearLayout mButtonsLinear;
	private Button mEditButton;
	private Button mDeleteButton;
	private LinearLayout mProgressBarContent;
	private EditTimeTableListAdapter mEditListAdapter;
	private EditedCoursesDialogInterface callback;

	private boolean mIsWorkerRunning;
	private boolean mIsCancelable;

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
		if (null != savedInstanceState) {
			mIsWorkerRunning = savedInstanceState.getBoolean(WORKER_RUNNING, false);
			mIsCancelable = savedInstanceState.getBoolean(CANCELABLE, false);
		}
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
		mButtonsLinear = (LinearLayout) view.findViewById(R.id.buttons);
		mEditButton = (Button) view.findViewById(R.id.edit_button);
		mEditButton.setOnClickListener(new EditOnClickListener());
		mDeleteButton = (Button) view.findViewById(R.id.delete_button);
		mDeleteButton.setOnClickListener(new DeleteOnClickListener());
		mProgressBarContent = (LinearLayout) view.findViewById(R.id.progress_bar_content);
		mList = (ListView) view.findViewById(R.id.list);
		mEditListAdapter = new EditTimeTableListAdapter(getContext());
		mList.setAdapter(mEditListAdapter);
		mList.setOnItemClickListener(new EditItemListOnItemClickListener());

		String title = getArguments().getString(TITLE);
		mTitle.setText(title);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putBoolean(WORKER_RUNNING, mIsWorkerRunning);
		outState.putBoolean(CANCELABLE, mIsCancelable);
	}

	@Override
	public void onResume() {
		super.onResume();
		if (mIsWorkerRunning) {
			showProgressBar();
		}
		setCancelable(mIsCancelable);
	}

	private void showProgressBar() {
		mButtonsLinear.setVisibility(View.GONE);
		mList.setVisibility(View.GONE);
		mProgressBarContent.setVisibility(View.VISIBLE);
	}


	private class EditOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			mIsCancelable = false;
			setCancelable(mIsCancelable);
			mIsWorkerRunning = true;
			showProgressBar();
			//mList.setVisibility(View.VISIBLE);
			// tutaj trzeba wywolac workera ktory pobierze odpowiednie dane a w callbacku ustawi adapter na liscie z pobranymi danymi
			// i pokaze odpowiedni widok
		}
	}

	private class DeleteOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			mIsCancelable = false;
			setCancelable(mIsCancelable);
			// trzeba wywaloc np callback albo zaimplementowac jakis interfejs i przekazac id wybranych zajec do usuniecia oraz
			// ustawic flage zmiany danych na true
			callback.courseToDeleteSelected(5);
			dismiss();
		}
	}

	private class EditItemListOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			callback.courseToSwapSelected(id);
			dismiss();
		}
	}

	public interface EditedCoursesDialogInterface {
		void courseToSwapSelected(long id);

		void courseToDeleteSelected(long id);
	}

}
