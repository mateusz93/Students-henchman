package edu.p.lodz.pl.studentshenchman.dashboard;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.dashboard.adapters.DrawerListAdapter;
import edu.p.lodz.pl.studentshenchman.dashboard.drawer_data.DrawerItem;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.Department;
import edu.p.lodz.pl.studentshenchman.database.models.Field;
import edu.p.lodz.pl.studentshenchman.database.models.Kind;
import edu.p.lodz.pl.studentshenchman.database.models.Specialization;
import edu.p.lodz.pl.studentshenchman.database.models.Type;
import edu.p.lodz.pl.studentshenchman.qr_scanner.SimpleScanner;
import edu.p.lodz.pl.studentshenchman.settings.SettingsActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;
import edu.p.lodz.pl.studentshenchman.workers.DownloadSettingsWorker;

public class DashboardActivity extends StudentShenchmanMainActivity {
	private static final String TAG = DashboardActivity.class.getName();
	private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private TextView mLessonName;
	private TextView mTeacher;
	private TextView mBuilding;
	private TextView mRoom;
	private TextView mLessonTime;

	private DrawerListAdapter mDrawerAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.drawer_list);
		mLessonName = (TextView) findViewById(R.id.item_lesson_name);
		mTeacher = (TextView) findViewById(R.id.item_teacher_name);
		mBuilding = (TextView) findViewById(R.id.item_building_name);
		mRoom = (TextView) findViewById(R.id.item_room_name);
		mLessonTime = (TextView) findViewById(R.id.item_lesson_time);

		mDrawerAdapter = new DrawerListAdapter(getApplicationContext(), getDrawerItemList());
		mDrawerList.setAdapter(mDrawerAdapter);
		mDrawerList.setOnItemClickListener(new DrawerOnItemClickListener());

		mLessonName.setText("Projektowanie aplikacji internetowych");
		mTeacher.setText("Dr. inz Rafal Kielbik");
		mBuilding.setText("CTI");
		mRoom.setText("303");
		mLessonTime.setText("8:15 - 10:00");

		DatabaseHelper.getInstance(getApplicationContext());

		Cursor c = DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase().query(Department.TABLE_NAME, null, null,
				null, null, null, null);
		if (c.moveToFirst()) {

		} else {
			saveTestDataIntoDatabase();
		}
		c.close();


		ImageButton buttonTimetable = (ImageButton) findViewById(R.id.timetable_icon);

		buttonTimetable.setOnClickListener((view) ->
				goToTimetable()
		);

		ImageButton settingsButton = (ImageButton) findViewById(R.id.settings_icon);

		settingsButton.setOnClickListener((view) ->
				goToSettings()
		);

		ImageButton scanQRCode = (ImageButton) findViewById(R.id.qrcode_scanner_icon);

		scanQRCode.setOnClickListener((view) ->
				goToScanQRCode()
		);

		ImageButton testButton = (ImageButton) findViewById(R.id.test_button);
		testButton.setOnClickListener((view) -> {
//			DownloadSettingsWorker worker = new DownloadSettingsWorker(getApplicationContext(), new Bundle());
//			worker.run();

			NiftyDialogBuilder.getInstance(this)
					.withTitle("Animated Fall Dialog Title")
					.withMessage("Add your dialog message here. Animated dialog description place.")
					.withDialogColor("#1c90ec")
					.withButton1Text("OK")
					.withButton2Text("Cancel")
					.withDuration(700)
					.withEffect(Effectstype.Fall)
					.show();
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	private List<DrawerItem> getDrawerItemList() {
		List<DrawerItem> drawerItems = new ArrayList<>();
		//drawerItems.add(new DrawerItem(getString(R.string.drawer_settings_name), R.drawable.logo_mini));
		drawerItems.add(new DrawerItem(getString(R.string.drawer_refresh_timetable_data), R.drawable.download_plan_icon));
		drawerItems.add(new DrawerItem(getString(R.string.drawer_refresh_settings_data), R.drawable.download_plan_icon));
		drawerItems.add(new DrawerItem(getString(R.string.drawer_about_app), R.drawable.about_app_icon));
		drawerItems.add(new DrawerItem(getString(R.string.drawer_logout_name), R.drawable.logout_icon));
		return drawerItems;

	}

	private void saveTestDataIntoDatabase() {
		SQLiteDatabase db = DatabaseHelper.getInstance(getApplicationContext()).getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(Department.EXTERNAL_DEPARTMENT_ID, 1);
		cv.put(Department.CODE, "kod elektryczny");
		cv.put(Department.NAME, "Wydzial Elektryczny");
		db.insert(Department.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Department.EXTERNAL_DEPARTMENT_ID, 2);
		cv.put(Department.CODE, "kod mechaniczny");
		cv.put(Department.NAME, "Wydzial Mechaniczny");
		db.insert(Department.TABLE_NAME, null, cv);

		// **************************************************

		cv = new ContentValues();
		cv.put(Field.EXTERNAL_FIELD_ID, 1);
		cv.put(Field.EXTERNAL_DEPARTMENT_ID, 1);
		cv.put(Field.NAME, "Informatyka");
		db.insert(Field.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Field.EXTERNAL_FIELD_ID, 2);
		cv.put(Field.EXTERNAL_DEPARTMENT_ID, 1);
		cv.put(Field.NAME, "Robotyka");
		db.insert(Field.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Field.EXTERNAL_FIELD_ID, 3);
		cv.put(Field.EXTERNAL_DEPARTMENT_ID, 2);
		cv.put(Field.NAME, "Transport");
		db.insert(Field.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Field.EXTERNAL_FIELD_ID, 4);
		cv.put(Field.EXTERNAL_DEPARTMENT_ID, 2);
		cv.put(Field.NAME, "Telekomunikacja");
		db.insert(Field.TABLE_NAME, null, cv);

		// **************************************************


		cv = new ContentValues();
		cv.put(Specialization.EXTERNAL_SPECIALIZATION_ID, 1);
		cv.put(Specialization.EXTERNAL_FIELD_ID, 1);
		cv.put(Specialization.NAME, "Specjalizacja 1");
		db.insert(Specialization.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Specialization.EXTERNAL_SPECIALIZATION_ID, 2);
		cv.put(Specialization.EXTERNAL_FIELD_ID, 2);
		cv.put(Specialization.NAME, "Specjalizacja 2");
		db.insert(Specialization.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Specialization.EXTERNAL_SPECIALIZATION_ID, 3);
		cv.put(Specialization.EXTERNAL_FIELD_ID, 3);
		cv.put(Specialization.NAME, "Specjalziacja 3");
		db.insert(Specialization.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Specialization.EXTERNAL_SPECIALIZATION_ID, 4);
		cv.put(Specialization.EXTERNAL_FIELD_ID, 4);
		cv.put(Specialization.NAME, "Specjalizacja 4");
		db.insert(Specialization.TABLE_NAME, null, cv);

		// **************************************************


		cv = new ContentValues();
		cv.put(Kind.EXTERNAL_KIND_ID, 1);
		cv.put(Kind.NAME, "Studia 1 stopnia");
		db.insert(Kind.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Kind.EXTERNAL_KIND_ID, 2);
		cv.put(Kind.NAME, "Studia 2 stopnia");
		db.insert(Kind.TABLE_NAME, null, cv);

		// **************************************************


		cv = new ContentValues();
		cv.put(Type.EXTERNAL_TYPE_ID, 1);
		cv.put(Type.NAME, "Studia zaoczne");
		db.insert(Type.TABLE_NAME, null, cv);

		cv = new ContentValues();
		cv.put(Type.EXTERNAL_TYPE_ID, 2);
		cv.put(Type.NAME, "Studia dzienne");
		db.insert(Type.TABLE_NAME, null, cv);

		// **************************************************
	}

	private void goToTimetable() {
		Intent intent = new Intent(DashboardActivity.this, TimetableActivity.class);
		finish();
		startActivity(intent);
	}

	private void goToSettings() {
		Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
		finish();
		startActivity(intent);
	}

	private void goToScanQRCode() {
		if (ContextCompat.checkSelfPermission(DashboardActivity.this,
				Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(DashboardActivity.this,
					new String[]{Manifest.permission.CAMERA},
					MY_PERMISSIONS_REQUEST_CAMERA);
		} else {
			Intent intent = new Intent(DashboardActivity.this, SimpleScanner.class);
			finish();
			startActivity(intent);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
	                                       @NonNull String permissions[], @NonNull int[] grantResults) {
		switch (requestCode) {
			case MY_PERMISSIONS_REQUEST_CAMERA: {
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					Intent intent = new Intent(DashboardActivity.this, SimpleScanner.class);
					finish();
					startActivity(intent);
				} else {
					Toast.makeText(this, "Brak uprawnień do aparatu!", Toast.LENGTH_SHORT).show();
				}
			}
		}
	}


	private class DrawerOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			switch (position) {
				case 0:

					break;
				case 1:

					break;
				case 2:

					break;
				case 3:
					finish();
					break;
				/*case 4:
			        finish();
                    break;*/
				default:
					break;
			}
		}
	}
}
