package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.NotesAdapter;

/**
 * Created by Michał on 2016-10-20.
 */

public class SubjectDetailsFragment extends StudentShenchmanMainFragment {
	private static final String TAG = SubjectDetailsFragment.class.getName();

	private ListView mSubjectNoteList;
	private FloatingActionButton mAddSubjectNoteFAB;
	private TextView mHeaderTitle;
	private TextView mSubjectName;
	private TextView mSubjectType;
	private TextView mTime;
	private TextView mLector;
	private TextView mLocationBuild;
	private TextView mLocationRoom;
	private ImageView mLessonNavigator;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.subject_details_fragment, container, false);

		mSubjectName = (TextView) view.findViewById(R.id.item_lesson_name);
		//mSubjectType = (TextView) view.findViewById(R.id.subject_type);
		mHeaderTitle = (TextView) view.findViewById(R.id.item_lesson_header_title);
		mTime = (TextView) view.findViewById(R.id.item_lesson_time);
		mLector = (TextView) view.findViewById(R.id.item_teacher_name);
		mLocationBuild = (TextView) view.findViewById(R.id.item_building_name);
		mLocationRoom = (TextView) view.findViewById(R.id.item_room_name);
		mSubjectNoteList = (ListView) view.findViewById(R.id.subject_note_list);
		mLessonNavigator = (ImageView) view.findViewById(R.id.navigate_item_icon);
		mAddSubjectNoteFAB = (FloatingActionButton) view.findViewById(R.id.add_note_fab);
		mAddSubjectNoteFAB.setOnClickListener(new AddNoteOnClickListener());

		mHeaderTitle.setText("WYKLAD");

		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		NotesAdapter notesAdapter = new NotesAdapter(getContext());
		mSubjectNoteList.setAdapter(notesAdapter);

	}

	public class AddNoteOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Toast.makeText(getContext(), "DODAJ NOTATKE DO PRZEDMIOTU", Toast.LENGTH_SHORT).show();
		}
	}
}
