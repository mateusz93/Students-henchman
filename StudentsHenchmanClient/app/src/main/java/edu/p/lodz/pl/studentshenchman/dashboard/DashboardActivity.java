package edu.p.lodz.pl.studentshenchman.dashboard;

import android.Manifest;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.animation.Animation;
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
import edu.p.lodz.pl.studentshenchman.qr_scanner.SimpleScanner;
import edu.p.lodz.pl.studentshenchman.settings.SettingsActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;
import edu.p.lodz.pl.studentshenchman.utils.AllOptionsToSelect;
import edu.p.lodz.pl.studentshenchman.workers.helpers.WorkerRunnerHelper;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerType;

import static edu.p.lodz.pl.studentshenchman.workers.AbstractWorker.WORKER_NAME;

public class DashboardActivity extends StudentShenchmanMainActivity {
	private static final String TAG = DashboardActivity.class.getName();
	private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;

	private Toolbar toolbar;
	private DrawerLayout mDrawerLayout;
	private TextView mLessonName;
	private TextView mTeacher;
	private TextView mBuilding;
	private TextView mRoom;
	private TextView mLessonTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		toolbar.setNavigationIcon(R.drawable.error_icon);
		setSupportActionBar(toolbar);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mLessonName = (TextView) findViewById(R.id.item_lesson_name);
		mTeacher = (TextView) findViewById(R.id.item_teacher_name);
		mBuilding = (TextView) findViewById(R.id.item_building_name);
		mRoom = (TextView) findViewById(R.id.item_room_name);
		mLessonTime = (TextView) findViewById(R.id.item_lesson_time);

		//mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN, mDrawerList);
//		mDrawerLayout.setScrimColor(Color.TRANSPARENT);

		mLessonName.setText("Projektowanie aplikacji internetowych");
		mTeacher.setText("Dr. inz Rafal Kielbik");
		mBuilding.setText("CTI");
		mRoom.setText("303");
		mLessonTime.setText("8:15 - 10:00");

		//setAnimation();

		DatabaseHelper.getInstance(getApplicationContext());

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

	@Override
	protected void onPause() {
		super.onPause();
		//mLessonName.clearAnimation();
	}

	private void setAnimation() {
		int colorFrom = getResources().getColor(android.R.color.white);
		int colorTo = getResources().getColor(R.color.light_blue_color);
		ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
		colorAnimation.setDuration(3000); // milliseconds
		colorAnimation.setRepeatCount(Animation.INFINITE);
		colorAnimation.addUpdateListener((animator) ->
				mLessonName.setTextColor((int) animator.getAnimatedValue())

		);
		colorAnimation.start();
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
				case AllOptionsToSelect.DOWNLOAD_PLAN:

					break;
				case AllOptionsToSelect.DOWNLOAD_SETTINGS:
					Bundle bundle = new Bundle();
					bundle.putString(WORKER_NAME, WorkerType.DOWNLOAD_SETTINGS.name());
					WorkerRunnerHelper.startWorker(getApplicationContext(), bundle);
					break;
				case AllOptionsToSelect.APP_INFO:

					break;
				case AllOptionsToSelect.LOGOUT:
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
