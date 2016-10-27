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
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.DayFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.EditTimeTableDialogFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.SubjectDetailsEmptyFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.SubjectDetailsFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.interfaces.CourseDialogFragmentInterface;
import edu.p.lodz.pl.studentshenchman.utils.SelectedCourseContext;


public class TimetableActivity extends StudentShenchmanMainActivity implements EditTimeTableDialogFragment.EditedCoursesOptionsInterface,
		DayFragment.SelectedCourseInterface, CourseDialogFragmentInterface {

	private static final String TAG = TimetableActivity.class.getName();
	private static final String DUAL_PANE = "dual_pane";
	private static final String LAST_SELECTED_COURSE = "last_selected_course";

	private Toolbar toolbar;

	private SelectedCourseContext mSelectedCourseContext;
	private boolean mDualPane = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

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
	protected void onResume() {
		super.onResume();
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
		EditTimeTableDialogFragment editTimeTableDialogFragment = EditTimeTableDialogFragment.getInstance("taki sobie tytul ale juz z activity");
		FragmentManager fm = getSupportFragmentManager();
		editTimeTableDialogFragment.show(fm, TAG);
	}
}
