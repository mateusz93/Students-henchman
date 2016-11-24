package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.AddNoteActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.SubjectDetailsActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.NotesAdapter;
import edu.p.lodz.pl.studentshenchman.utils.SelectedCourseContext;
import edu.p.lodz.pl.studentshenchman.utils.animation.AnimationHelper;

/**
 * Created by Michał on 2016-10-20.
 */

public class SubjectDetailsFragment extends StudentShenchmanMainFragment {
	private static final String TAG = SubjectDetailsFragment.class.getName();
	public static final String COURSE_ID = TAG + ":course_id";

	public static final int ADD_NOTE_REQUEST_CODE = 102;

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

	NotesAdapter mNotesAdapter;
	SelectedCourseContext mCourseContext;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.subject_details_fragment, container, false);

		mCourseContext = new SelectedCourseContext();
		if (getActivity() instanceof TimetableActivity)
			mCourseContext = ((TimetableActivity) getActivity()).getSelectedCourseContext();
		else if (getActivity() instanceof SubjectDetailsActivity)
			mCourseContext = ((SubjectDetailsActivity) getActivity()).getSelectedCourseContext();

		mSubjectName = (TextView) view.findViewById(R.id.item_lesson_name);
		//mSubjectType = (TextView) view.findViewById(R.id.subject_type);
		mHeaderTitle = (TextView) view.findViewById(R.id.item_lesson_header_title);
		mTime = (TextView) view.findViewById(R.id.item_lesson_time);
		mLector = (TextView) view.findViewById(R.id.item_teacher_name);
		mLocationBuild = (TextView) view.findViewById(R.id.item_building_name);
		mLocationRoom = (TextView) view.findViewById(R.id.item_room_name);
		mAddSubjectNoteFAB = (FloatingActionButton) view.findViewById(R.id.add_note_fab);
		mAddSubjectNoteFAB.setOnClickListener(new AddNoteOnClickListener());
		mSubjectNoteList = (ListView) view.findViewById(R.id.subject_note_list);
		mSubjectNoteList.setOnScrollListener(new NoteOnScrollListener());
		mLessonNavigator = (ImageView) view.findViewById(R.id.navigate_item_icon);

		mSubjectName.setText(mCourseContext.getCourseName());
		mLector.setText(mCourseContext.getTeacher());
		mLocationBuild.setText(mCourseContext.getBuildName());
		mLocationRoom.setText(mCourseContext.getRoomName());
		mTime.setText(mCourseContext.getTime());

		mHeaderTitle.setText(mCourseContext.getGroupName());

		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		mNotesAdapter = new NotesAdapter(getContext(), getActivity().getSupportFragmentManager(), mCourseContext.getCourseId());
		mSubjectNoteList.setAdapter(mNotesAdapter);
	}

	public class AddNoteOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getActivity(), AddNoteActivity.class);
			intent.putExtra(COURSE_ID, mCourseContext.getCourseId());
			startActivityForResult(intent, ADD_NOTE_REQUEST_CODE);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == ADD_NOTE_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				mNotesAdapter.refreshNotes();
			}
		}

	}

	private class NoteOnScrollListener implements AbsListView.OnScrollListener {
		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {

		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
			AnimationHelper.startSlideBottomAnimation(mAddSubjectNoteFAB);
			if (totalItemCount <= visibleItemCount) {
				AnimationHelper.startSlideBottomAnimation(mAddSubjectNoteFAB);
				mAddSubjectNoteFAB.setVisibility(View.VISIBLE);
			} else if (firstVisibleItem + visibleItemCount >= totalItemCount - visibleItemCount) {
				mAddSubjectNoteFAB.setVisibility(View.GONE);
			} else {
				AnimationHelper.startSlideBottomAnimation(mAddSubjectNoteFAB);
				mAddSubjectNoteFAB.setVisibility(View.VISIBLE);
			}
		}
	}
}