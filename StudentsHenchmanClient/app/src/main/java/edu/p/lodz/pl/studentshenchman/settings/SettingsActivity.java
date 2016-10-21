package edu.p.lodz.pl.studentshenchman.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.DepartmentAdapter;

public class SettingsActivity extends StudentShenchmanMainActivity {
	private static final String TAG = SettingsActivity.class.getName();

	private Toolbar toolbar;
	private LinearLayout mDepartmentLinear;
	private LinearLayout mFieldLinear;
	private LinearLayout mSpecializationLayout;
	private Spinner mDepartmentSpinner;
	private Spinner mFieldSpinner;
	private Spinner mSpecializationSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

		mDepartmentLinear = (LinearLayout) findViewById(R.id.department_content);
		mFieldLinear = (LinearLayout) findViewById(R.id.field_content);
		mSpecializationLayout = (LinearLayout) findViewById(R.id.specialization_content);

		mDepartmentSpinner = (Spinner) findViewById(R.id.department_spinner);
		mDepartmentSpinner.setAdapter(new DepartmentAdapter(getApplicationContext(), new ArrayList<>()));
	}

	private void prepareToolbar() {
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.settings_activity_title);
		toolbar.setNavigationIcon(android.R.drawable.btn_plus);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
	}

	@Override
	public void onBackPressed() {
		goToDashBoard();
	}

	private void goToDashBoard() {
		Intent previousActivity = new Intent(SettingsActivity.this, DashboardActivity.class);
		finish();
		startActivity(previousActivity);
	}

}
