package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.EditTimeTableDialogFragment;


public class TimetableActivity extends StudentShenchmanMainActivity implements EditTimeTableDialogFragment.EditedCoursesDialogInterface {

	private static final String TAG = TimetableActivity.class.getName();
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

	}

	private void prepareToolbar() {
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.timetable_activity_title);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
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
	public void courseToSwapSelected(long id) {
		Toast.makeText(getApplicationContext(), "swap callback:" + id, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void courseToDeleteSelected(long id) {
		Toast.makeText(getApplicationContext(), "delete callback:" + id, Toast.LENGTH_SHORT).show();
	}
}
