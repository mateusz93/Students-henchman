package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.constants.Constants;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments.ChooseCourseDialogFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.dialog_fragments.EditTimeTableDialogFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.DayFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.SubjectDetailsEmptyFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.SubjectDetailsFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.interfaces.CourseDialogFragmentInterface;
import edu.p.lodz.pl.studentshenchman.utils.SelectedCourseContext;


public class TimetableActivity extends StudentShenchmanMainActivity implements EditTimeTableDialogFragment.EditedCoursesOptionsInterface,
		DayFragment.SelectedCourseInterface, CourseDialogFragmentInterface {

	private static final String TAG = TimetableActivity.class.getName();
	private static final String DUAL_PANE = ":dual_pane";
	private static final String LAST_SELECTED_COURSE = ":last_selected_course";
	private static final String ARE_LOCAL_CHANGES = ":are_local_changes";
	private static final String CONTEXT_TO_EDIT = ":context_to_edit";


	private Toolbar toolbar;

	private SelectedCourseContext mSelectedCourseContext;
	private SelectedCourseContext mCourseContextToEdit;
	private boolean mDualPane = false;
	private boolean mAreLocalChanges = false;

	enum DialogType {
		EDIT, CHOOSE
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

		if (null != savedInstanceState) {
			mCourseContextToEdit = savedInstanceState.getParcelable(CONTEXT_TO_EDIT);
			mAreLocalChanges = savedInstanceState.getBoolean(ARE_LOCAL_CHANGES, false);
		}

		if (null != (findViewById(R.id.timetable_details_container))) {
			mDualPane = true;
		}

		if (null != savedInstanceState) {
			mSelectedCourseContext = savedInstanceState.getParcelable(LAST_SELECTED_COURSE);
		}

		selectedCourse(mSelectedCourseContext);
	}

	private void prepareToolbar() {
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.timetable_activity_title);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(DUAL_PANE, mDualPane);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			goToDashboard();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		goToDashboard();
	}

	private void goToDashboard() {
		Intent previousActivity = new Intent(TimetableActivity.this, DashboardActivity.class);
		finish();
		startActivity(previousActivity);
	}

	@Override
	public void courseToEditSelected(long id) {
		Toast.makeText(getApplicationContext(), "no cos dziala", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void courseToDeleteSelected(long id) {
		Toast.makeText(getApplicationContext(), "no cos dziala", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void selectedCourse(SelectedCourseContext selectedCourseContext) {
		mSelectedCourseContext = selectedCourseContext;
		Bundle bundle = new Bundle();
		bundle.putParcelable(Constants.SELECTED_COURSE_CONTEXT, selectedCourseContext);
		if (mDualPane) {
			Fragment fragment;
			if (null == selectedCourseContext)
				fragment = new SubjectDetailsEmptyFragment();
			else
				fragment = new SubjectDetailsFragment();

			fragment.setArguments(bundle);
			getSupportFragmentManager().beginTransaction().replace(R.id.timetable_details_container, fragment).commit();
		} else {
			if (null != selectedCourseContext) {
				Intent intent = new Intent(TimetableActivity.this, SubjectDetailsActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		}
	}

	@Override
	public void showEditOptionsDialogFragment(SelectedCourseContext courseContext) {
		buildDialogByType(DialogType.EDIT, courseContext);
	}

	private void buildDialogByType(DialogType dialogType, SelectedCourseContext courseContext) {
		FragmentManager fm = getSupportFragmentManager();
		switch (dialogType) {
			case EDIT:
				EditTimeTableDialogFragment editTimeTableDialogFragment = EditTimeTableDialogFragment.getInstance("taki sobie tytul ale juz z activity");
				editTimeTableDialogFragment.show(fm, TAG);
				break;
			case CHOOSE:
				ChooseCourseDialogFragment chooseCourseDialogFragment = ChooseCourseDialogFragment.getInstance("taki sobie tytul ale juz z activity");
				chooseCourseDialogFragment.show(fm, TAG);
				break;
			default:
				break;
		}
	}
}
