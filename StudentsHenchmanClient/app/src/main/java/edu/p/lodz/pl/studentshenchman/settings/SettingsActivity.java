package edu.p.lodz.pl.studentshenchman.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.settings.adapters.DepartmentAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.FieldAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.KindAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.SpecializationAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.TypeAdapter;

public class SettingsActivity extends StudentShenchmanMainActivity {
	private static final String TAG = SettingsActivity.class.getName();

	private Toolbar toolbar;
	private LinearLayout mDepartmentLinear;
	private LinearLayout mFieldLinear;
	private LinearLayout mSpecializationLinear;
	private Spinner mDepartmentSpinner;
	private Spinner mFieldSpinner;
	private Spinner mSpecializationSpinner;
	private Spinner mTypeSpinner;
	private Spinner mKindSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

		mDepartmentLinear = (LinearLayout) findViewById(R.id.department_content);
		mFieldLinear = (LinearLayout) findViewById(R.id.field_content);
		mSpecializationLinear = (LinearLayout) findViewById(R.id.specialization_content);

		mDepartmentSpinner = (Spinner) findViewById(R.id.department_spinner);
		mDepartmentSpinner.setAdapter(new DepartmentAdapter(getApplicationContext(), new ArrayList<>()));

		mFieldSpinner = (Spinner) findViewById(R.id.field_spinner);
		mFieldSpinner.setAdapter(new FieldAdapter(getApplicationContext(), new ArrayList<Object>()));
		mFieldLinear.setVisibility(View.VISIBLE);

		mSpecializationSpinner = (Spinner) findViewById(R.id.specialization_spinner);
		mSpecializationSpinner.setAdapter(new SpecializationAdapter(getApplicationContext(), new ArrayList<Object>()));
		mSpecializationLinear.setVisibility(View.VISIBLE);

		mTypeSpinner = (Spinner) findViewById(R.id.type_spinner);
		mTypeSpinner.setAdapter(new TypeAdapter(getApplicationContext(), new ArrayList<Object>()));


		mKindSpinner = (Spinner) findViewById(R.id.kind_spinner);
		mKindSpinner.setAdapter(new KindAdapter(getApplicationContext(), new ArrayList<Object>()));


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
