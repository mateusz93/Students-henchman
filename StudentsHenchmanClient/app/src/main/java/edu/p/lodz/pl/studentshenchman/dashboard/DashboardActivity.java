package edu.p.lodz.pl.studentshenchman.dashboard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.SimpleScanner;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.settings.SettingsActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;

public class DashboardActivity extends StudentShenchmanMainActivity {
    private static final String TAG = DashboardActivity.class.getName();
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;

    private TextView mLessonName;
    private TextView mTeacher;
    private TextView mBuilding;
    private TextView mRoom;
    private TextView mLessonTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mLessonName = (TextView) findViewById(R.id.item_lesson_name);
        mTeacher = (TextView) findViewById(R.id.item_teacher_name);
        mBuilding = (TextView) findViewById(R.id.item_building_name);
        mRoom = (TextView) findViewById(R.id.item_room_name);
        mLessonTime = (TextView) findViewById(R.id.item_lesson_time);

        mLessonName.setText("Projektowanie aplikacji internetowych");
        mTeacher.setText("Dr. inz Rafal Kielbik");
        mBuilding.setText("CTI");
        mRoom.setText("303");
        mLessonTime.setText("8:15 - 10:00");

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
        if(ContextCompat.checkSelfPermission(DashboardActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
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
                                           String permissions[], int[] grantResults) {
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
}
