package edu.p.lodz.pl.studentshenchman.settings;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import edu.p.lodz.pl.studentshenchman.settings.controller.SettingsController;

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

    private SettingsController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mController = SettingsController.getInstance(getApplicationContext());

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
        mDepartments = loadDepartments(db);
        mFields = loadFields(db, mController.getFieldId());
        mSpecialization = loadSpecializations(db, mController.getSpecializationId());
        mTypes = loadTypes(db);
        mKinds = loadKinds(db);
    }

    private List<Kind> loadKinds(SQLiteDatabase db) {
        List<Kind> values = new ArrayList<>();

        Cursor c = db.query(Kind.TABLE_NAME, null, null, null, null, null, null);
        while (c.moveToNext()) {
            Kind kind = new Kind();
            kind.setId(c.getLong(c.getColumnIndexOrThrow(Kind._ID)));
            kind.setExternalId(c.getLong(c.getColumnIndexOrThrow(Kind.EXTERNAL_KIND_ID)));
            kind.setName(c.getString(c.getColumnIndexOrThrow(Kind.NAME)));
            values.add(kind);
        }
        c.close();

        return values;
    }

    private List<Type> loadTypes(SQLiteDatabase db) {
        List<Type> values = new ArrayList<>();

        Cursor c = db.query(Type.TABLE_NAME, null, null, null, null, null, null);
        while (c.moveToNext()) {
            Type type = new Type();
            type.setId(c.getLong(c.getColumnIndexOrThrow(Type._ID)));
            type.setExternalId(c.getLong(c.getColumnIndexOrThrow(Type.EXTERNAL_TYPE_ID)));
            type.setName(c.getString(c.getColumnIndexOrThrow(Type.NAME)));
            values.add(type);
        }
        c.close();

        return values;

    }

    private List<Specialization> loadSpecializations(SQLiteDatabase db, long id) {
        List<Specialization> values = new ArrayList<>();

        Cursor c = db.query(Specialization.TABLE_NAME, null, Specialization.EXTERNAL_FIELD_ID + "=?", new String[]{id + ""}, null, null, null);
        while (c.moveToNext()) {
            Specialization specialization = new Specialization();
            specialization.setId(c.getLong(c.getColumnIndexOrThrow(Specialization._ID)));
            specialization.setExternalId(c.getLong(c.getColumnIndexOrThrow(Specialization.EXTERNAL_SPECIALIZATION_ID)));
            specialization.setExternalFieldId(c.getLong(c.getColumnIndexOrThrow(Specialization.EXTERNAL_FIELD_ID)));
            specialization.setName(c.getString(c.getColumnIndexOrThrow(Specialization.NAME)));
            values.add(specialization);
        }
        c.close();

        return values;
    }

    private List<Field> loadFields(SQLiteDatabase db, long id) {
        List<Field> values = new ArrayList<>();

        Cursor c = db.query(Field.TABLE_NAME, null, Field.EXTERNAL_DEPARTMENT_ID + "=?", new String[]{id + ""}, null, null, null);
        while (c.moveToNext()) {
            Field field = new Field();
            field.setId(c.getLong(c.getColumnIndexOrThrow(Field._ID)));
            field.setExternalId(c.getLong(c.getColumnIndexOrThrow(Field.EXTERNAL_FIELD_ID)));
            field.setExternalDepartmentId(c.getLong(c.getColumnIndexOrThrow(Field.EXTERNAL_DEPARTMENT_ID)));
            field.setName(c.getString(c.getColumnIndexOrThrow(Field.NAME)));
            values.add(field);
        }
        c.close();

        return values;
    }

    private List<Department> loadDepartments(SQLiteDatabase db) {
        List<Department> values = new ArrayList<>();

        Cursor c = db.query(Department.TABLE_NAME, null, null, null, null, null, null);
        while (c.moveToNext()) {
            Department department = new Department();
            department.setId(c.getLong(c.getColumnIndexOrThrow(Department._ID)));
            department.setExternalId(c.getLong(c.getColumnIndexOrThrow(Department.EXTERNAL_DEPARTMENT_ID)));
            department.setCode(c.getString(c.getColumnIndexOrThrow(Department.CODE)));
            department.setName(c.getString(c.getColumnIndexOrThrow(Department.NAME)));
            values.add(department);
        }
        c.close();

        return values;
    }

    private void generateView() {
        SQLiteDatabase db = DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase();
        long selectedDepartmentId = mController.getDepartmentId();
        if (selectedDepartmentId > 0) {
            mDepartmentSpinner.setSelection(mDepartmentAdapter.getPosForId(selectedDepartmentId), true);
            mFieldAdapter.setValues(loadFields(db, selectedDepartmentId));
            mFieldLinear.setVisibility(View.VISIBLE);
        } else {
            mDepartmentSpinner.setSelection(0, true);
            mFieldLinear.setVisibility(View.GONE);
            mSpecializationLinear.setVisibility(View.GONE);
        }

        long selectedFieldExternalId = mController.getFieldId();
        if (selectedFieldExternalId > 0) {
            mFieldSpinner.setSelection(mFieldAdapter.getPosForId(selectedFieldExternalId), true);
            mSpecializationAdapter.setValues(loadSpecializations(db, selectedFieldExternalId));
            mSpecializationLinear.setVisibility(View.VISIBLE);
        } else {
            mFieldSpinner.setSelection(0, true);
            mSpecializationLinear.setVisibility(View.GONE);
        }

        long selectedSpecializationId = mController.getSpecializationId();
        if (selectedSpecializationId > 0) {
            mFieldSpinner.setSelection(mSpecializationAdapter.getPosForId(selectedSpecializationId), true);
        } else {
            mSpecializationSpinner.setSelection(0, true);
        }

        long selectedTypeId = mController.getTypeId();
        if (selectedTypeId > 0) {
            mTypeSpinner.setSelection(mTypeAdapter.getPosForId(selectedTypeId), true);
        } else {
            mTypeSpinner.setSelection(0, true);
        }

        long selectedKindId = mController.getKindId();
        if (selectedKindId > 0) {
            mKindSpinner.setSelection(mSpecializationAdapter.getPosForId(selectedKindId), true);
        } else {
            mKindSpinner.setSelection(0, true);
        }

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

    private class DepartmentOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mController.setDepartmentId(id);
            mController.setmSpecializationId(Long.MIN_VALUE);
            mController.setFieldId(Long.MIN_VALUE);
            mFieldSpinner.setSelection(0, true);
            mSpecializationSpinner.setSelection(0, true);
            generateView();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class FieldOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mController.setFieldId(id);
            mSpecializationSpinner.setSelection(0, true);
            mController.setmSpecializationId(Long.MIN_VALUE);
            generateView();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class SpecializationOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mController.setmSpecializationId(id);
            generateView();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class TypeOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mController.setTypeId(id);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class KindOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mController.setKindId(id);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class SaveOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mController.save();
            goToDashBoard();
        }
    }

    private class CancelOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mController.load();
            goToDashBoard();
        }
    }

    private class ClearOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mController.setDefault();
            generateView();
        }
    }

}
