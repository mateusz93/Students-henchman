package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;

/**
 * Created by Michał on 2016-10-13.
 */

public class SubjectDetailsActivity extends StudentShenchmanMainActivity {
	private static final String TAG = SubjectDetailsActivity.class.getName();

	private Toolbar toolbar;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject_details);
		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();


	}

	private void prepareToolbar() {
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.subject_details_activity_title);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			goToTimeTable();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		goToTimeTable();
	}

	private void goToTimeTable() {
		Intent intent = new Intent(SubjectDetailsActivity.this, TimetableActivity.class);
		finish();
		startActivity(intent);
	}

}
