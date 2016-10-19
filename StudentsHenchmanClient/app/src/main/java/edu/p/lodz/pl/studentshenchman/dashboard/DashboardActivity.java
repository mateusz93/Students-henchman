package edu.p.lodz.pl.studentshenchman.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import edu.p.lodz.pl.studentshenchman.QRCodeScanActivity;
import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.SettingsActivity;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;

public class DashboardActivity extends StudentShenchmanMainActivity {
    private static final String TAG = DashboardActivity.class.getName();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /*toolbar = (Toolbar) findViewById(R.id.tool_bar);
        prepareToolbar();*/

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

    public void prepareToolbar() {

        setSupportActionBar(toolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                goToSettings();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
