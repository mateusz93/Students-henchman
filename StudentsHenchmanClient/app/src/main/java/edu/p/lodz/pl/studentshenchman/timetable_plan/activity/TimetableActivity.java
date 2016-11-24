package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ViewSwitcher;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.constants.Constants;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.event.RefreshTabs;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.DayFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.SubjectDetailsEmptyFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.SubjectDetailsFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.TimetableDaysFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.utils.CoursesLoader;
import edu.p.lodz.pl.studentshenchman.timetable_plan.utils.CoursesLoaderObject;
import edu.p.lodz.pl.studentshenchman.utils.SelectedCourseContext;


public class TimetableActivity extends StudentShenchmanMainActivity implements DayFragment.SelectedCourseInterface,
		LoaderManager.LoaderCallbacks<Map<String, List<CoursesLoaderObject>>> {

	private static final String TAG = TimetableActivity.class.getName();
	private static final int COURSES_LOADER_ID = TimetableActivity.class.hashCode();

	private static final String DUAL_PANE = ":dual_pane";
	private static final String LAST_SELECTED_COURSE = ":last_selected_course";

	private Toolbar toolbar;
	private ViewSwitcher mViewSwitcher;

	private Map<String, List<CoursesLoaderObject>> coursesForTheWeek = new ArrayMap<>();
	private SelectedCourseContext mSelectedCourseContext;
	private boolean mDualPane = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

		mViewSwitcher = (ViewSwitcher) findViewById(R.id.view_switcher);
		TimetableDaysFragment fragment = new TimetableDaysFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.days_container, fragment).commit();
		if (null != savedInstanceState) {
			mSelectedCourseContext = savedInstanceState.getParcelable(Constants.SELECTED_COURSE_CONTEXT);
		}

		if (null != (findViewById(R.id.timetable_details_container))) {
			mDualPane = true;
		}

		if (null != savedInstanceState) {
			mSelectedCourseContext = savedInstanceState.getParcelable(LAST_SELECTED_COURSE);
		}

		getSupportLoaderManager().initLoader(COURSES_LOADER_ID, null, this);
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
		outState.putBoolean(DUAL_PANE, mDualPane);
		outState.putParcelable(Constants.SELECTED_COURSE_CONTEXT, mSelectedCourseContext);
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			goToDashboard();
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

	public SelectedCourseContext getSelectedCourseContext() {
		return mSelectedCourseContext;
	}

	public Map<String, List<CoursesLoaderObject>> getCoursesForTheWeek() {
		return coursesForTheWeek;
	}

	@Override
	public Loader<Map<String, List<CoursesLoaderObject>>> onCreateLoader(int id, Bundle args) {
		if (id == COURSES_LOADER_ID) {
			mViewSwitcher.setDisplayedChild(0);
			return new CoursesLoader(getApplicationContext());
		}
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Map<String, List<CoursesLoaderObject>>> loader, Map<String, List<CoursesLoaderObject>> data) {
		if (loader.getId() == COURSES_LOADER_ID) {
			coursesForTheWeek = data;
			mViewSwitcher.setDisplayedChild(1);
			refreshTabs();
		}
	}

	public void refreshTabs() {
		EventBus.getDefault().postSticky(new RefreshTabs());
		//selectedCourse(mSelectedCourseContext);
	}

	@Override
	public void onLoaderReset(Loader<Map<String, List<CoursesLoaderObject>>> loader) {
//		coursesForTheWeek = null;
	}

	@Override
	public void selectedCourse(SelectedCourseContext selectedCourseContext) {
		mSelectedCourseContext = selectedCourseContext;
		if (mDualPane) {
			Fragment fragment;
			if (null == selectedCourseContext)
				fragment = new SubjectDetailsEmptyFragment();
			else
				fragment = new SubjectDetailsFragment();

			getSupportFragmentManager().beginTransaction().replace(R.id.timetable_details_container, fragment).commit();
		} else {
			if (null != selectedCourseContext) {
				Intent intent = new Intent(TimetableActivity.this, SubjectDetailsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.SELECTED_COURSE_CONTEXT, mSelectedCourseContext);
				intent.putExtras(bundle);
				finish();
				startActivity(intent);
			}
		}
	}
}
