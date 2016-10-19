package edu.p.lodz.pl.studentshenchman.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.qr_scanner.QRCodeScanActivity;
import edu.p.lodz.pl.studentshenchman.settings.SettingsActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;

public class DashboardActivity extends StudentShenchmanMainActivity {
    private static final String TAG = DashboardActivity.class.getName();

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
        Intent intent = new Intent(DashboardActivity.this, QRCodeScanActivity.class);
        finish();
        startActivity(intent);
    }

}
