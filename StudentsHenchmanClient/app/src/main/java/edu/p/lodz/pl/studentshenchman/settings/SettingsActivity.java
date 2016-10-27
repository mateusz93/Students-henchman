package edu.p.lodz.pl.studentshenchman.settings;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.Department;
import edu.p.lodz.pl.studentshenchman.database.models.Field;
import edu.p.lodz.pl.studentshenchman.database.models.Kind;
import edu.p.lodz.pl.studentshenchman.database.models.Specialization;
import edu.p.lodz.pl.studentshenchman.database.models.Type;
import edu.p.lodz.pl.studentshenchman.settings.adapters.DepartmentAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.FieldAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.KindAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.SpecializationAdapter;
import edu.p.lodz.pl.studentshenchman.settings.adapters.TypeAdapter;
import edu.p.lodz.pl.studentshenchman.settings.datastore.DependentDataHelper;
import edu.p.lodz.pl.studentshenchman.settings.datastore.SettingsDataStoreHelper;
import edu.p.lodz.pl.studentshenchman.workers.DownloadWeatherSimpleWorker;

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
	private Button mSave;
	private Button mClear;
	private Button mCancel;

	private DepartmentAdapter mDepartmentAdapter;
	private FieldAdapter mFieldAdapter;
	private SpecializationAdapter mSpecializationAdapter;
	private TypeAdapter mTypeAdapter;
	private KindAdapter mKindAdapter;

	private List<Department> mDepartments;
	private List<Field> mFields;
	private List<Specialization> mSpecialization;
	private List<Type> mTypes;
	private List<Kind> mKinds;

	private SettingsDataStoreHelper mSettingsDataHelper;
	private DependentDataHelper dependentDataHelper;

	public enum SpinnerType {
		DEPARTMENTS, FIELDS, SPECIALIZATIONS
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		mSettingsDataHelper = new SettingsDataStoreHelper(getApplicationContext());
		dependentDataHelper = new DependentDataHelper();

		loadAllRequiredData();
		initAdapters();

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		prepareToolbar();

		mDepartmentLinear = (LinearLayout) findViewById(R.id.department_content);
		mFieldLinear = (LinearLayout) findViewById(R.id.field_content);
		mSpecializationLinear = (LinearLayout) findViewById(R.id.specialization_content);

		mDepartmentSpinner = (Spinner) findViewById(R.id.department_spinner);
		mDepartmentSpinner.setOnItemSelectedListener(new DepartmentOnItemSelectedListener());
		mDepartmentSpinner.setAdapter(mDepartmentAdapter);

		mFieldSpinner = (Spinner) findViewById(R.id.field_spinner);
		mFieldSpinner.setOnItemSelectedListener(new FieldOnItemSelectedListener());
		mFieldSpinner.setAdapter(mFieldAdapter);

		mSpecializationSpinner = (Spinner) findViewById(R.id.specialization_spinner);
		mSpecializationSpinner.setOnItemSelectedListener(new SpecializationOnItemSelectedListener());
		mSpecializationSpinner.setAdapter(mSpecializationAdapter);

		mTypeSpinner = (Spinner) findViewById(R.id.type_spinner);
		mTypeSpinner.setOnItemSelectedListener(new TypeOnItemSelectedListener());
		mTypeSpinner.setAdapter(mTypeAdapter);


		mKindSpinner = (Spinner) findViewById(R.id.kind_spinner);
		mKindSpinner.setOnItemSelectedListener(new KindOnItemSelectedListener());
		mKindSpinner.setAdapter(mKindAdapter);

		mSave = (Button) findViewById(R.id.save_button);
		mSave.setOnClickListener(new SaveOnClickListener());

		mCancel = (Button) findViewById(R.id.cancel_button);
		mCancel.setOnClickListener(new CancelOnClickListener());

		mClear = (Button) findViewById(R.id.clear_button);
		mClear.setOnClickListener(new ClearOnClickListener());

		generateView();
	}

	private void initAdapters() {
		mDepartmentAdapter = new DepartmentAdapter(getApplicationContext(), mDepartments);
		mFieldAdapter = new FieldAdapter(getApplicationContext(), new ArrayList<>());
		mSpecializationAdapter = new SpecializationAdapter(getApplicationContext(), new ArrayList<>());
		mTypeAdapter = new TypeAdapter(getApplicationContext(), mTypes);
		mKindAdapter = new KindAdapter(getApplicationContext(), mKinds);

	}

	private void loadAllRequiredData() {
		SQLiteDatabase db = DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase();
		mDepartments = dependentDataHelper.loadDepartments(db);
		mFields = dependentDataHelper.loadFields(db, mSettingsDataHelper.getFieldId());
		mSpecialization = dependentDataHelper.loadSpecializations(db, mSettingsDataHelper.getSpecializationId());
		mTypes = dependentDataHelper.loadTypes(db);
		mKinds = dependentDataHelper.loadKinds(db);
	}

	private void generateView() {
		updateDependentSpinner(SpinnerType.DEPARTMENTS, 0);

		long selectedTypeId = mSettingsDataHelper.getTypeId();
		if (selectedTypeId > 0) {
			mTypeSpinner.setSelection(mTypeAdapter.getPosForId(selectedTypeId), true);
		} else {
			mTypeSpinner.setSelection(0, true);
		}

		long selectedKindId = mSettingsDataHelper.getKindId();
		if (selectedKindId > 0) {
			mKindSpinner.setSelection(mKindAdapter.getPosForId(selectedKindId), true);
		} else {
			mKindSpinner.setSelection(0, true);
		}

	}


	private void updateDependentSpinner(SpinnerType spinnerType, long parentValueId) {
		SQLiteDatabase db = DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase();
		long cachedValue;
		switch (spinnerType) {
			case DEPARTMENTS:
				cachedValue = mSettingsDataHelper.getDepartmentId();
				if (cachedValue > 0)
					mDepartmentSpinner.setSelection(mDepartmentAdapter.getPosForId(cachedValue), false);
				else
					mDepartmentSpinner.setSelection(0, false);
				break;

			case FIELDS:
				cachedValue = mSettingsDataHelper.getFieldId();
				mFieldAdapter.setValues(dependentDataHelper.loadFields(db, parentValueId));
				if (cachedValue > 0)
					mFieldSpinner.setSelection(mFieldAdapter.getPosForId(cachedValue), false);
				else
					mFieldSpinner.setSelection(0, false);

				if (parentValueId > 0)
					mFieldLinear.setVisibility(View.VISIBLE);
				else
					mFieldLinear.setVisibility(View.GONE);
				break;

			case SPECIALIZATIONS:
				cachedValue = mSettingsDataHelper.getSpecializationId();
				mSpecializationAdapter.setValues(dependentDataHelper.loadSpecializations(db, parentValueId));
				if (cachedValue > 0)
					mSpecializationSpinner.setSelection(mSpecializationAdapter.getPosForId(cachedValue), false);
				else
					mSpecializationSpinner.setSelection(0, false);

				if (parentValueId > 0)
					mSpecializationLinear.setVisibility(View.VISIBLE);
				else
					mSpecializationLinear.setVisibility(View.GONE);
				break;
			default:
				break;
		}

	}

	private void prepareToolbar() {
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.settings_activity_title);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			goToDashBoard();
			return true;
		}
		return super.onOptionsItemSelected(item);
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

	private class DepartmentOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			mSettingsDataHelper.setDepartmentId(id);
			updateDependentSpinner(SpinnerType.FIELDS, id);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	}


	private class FieldOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			mSettingsDataHelper.setFieldId(id);
			updateDependentSpinner(SpinnerType.SPECIALIZATIONS, id);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	}

	private class SpecializationOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			mSettingsDataHelper.setSpecializationId(id);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	}

	private class TypeOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			mSettingsDataHelper.setTypeId(id);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	}

	private class KindOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			mSettingsDataHelper.setKindId(id);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	}

	private class SaveOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			mSettingsDataHelper.save();
			goToDashBoard();
		}
	}

	private class CancelOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			mSettingsDataHelper.load();
			goToDashBoard();
		}
	}

	private class ClearOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			mSettingsDataHelper.setDefault();
			generateView();
		}
	}

}
