package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.EditTimeTableListAdapter;

/**
 * Created by Michał on 2016-10-25.
 */

public class EditTimeTableDialogFragment extends DialogFragment {

	private static final String TITLE = "title";
	private TextView mTitle;
	private ListView mList;
	private Button mEditButton;
	private Button mDeleteButton;
	private EditTimeTableListAdapter mEditListAdapter;

	public EditTimeTableDialogFragment() {
	}

	public static EditTimeTableDialogFragment getInstance(String title) {

		EditTimeTableDialogFragment editTimeTableDialogFragment = new EditTimeTableDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);

		editTimeTableDialogFragment.setArguments(bundle);

		return editTimeTableDialogFragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
		mList = (ListView) view.findViewById(R.id.list);
		mEditListAdapter = new EditTimeTableListAdapter(getContext());
		mList.setAdapter(mEditListAdapter);

		String title = getArguments().getString(TITLE);
		mTitle.setText(title);
	}


	private class EditOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Toast.makeText(getContext(), "edit button", Toast.LENGTH_SHORT).show();
		}
	}

	private class DeleteOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Toast.makeText(getContext(), "delete button", Toast.LENGTH_SHORT).show();
		}
	}
}
