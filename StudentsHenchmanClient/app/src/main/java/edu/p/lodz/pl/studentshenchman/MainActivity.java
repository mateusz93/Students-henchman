package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;

public class MainActivity extends StudentShenchmanMainActivity {
    private static final String TAG = MainActivity.class.getName();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        prepareToolbar();

        DatabaseHelper.getInstance(getApplicationContext());

        Button buttonTimetable = (Button) findViewById(R.id.timesheetButton);

        buttonTimetable.setOnClickListener((view) ->
                goToTimetable()

        );

        Button settingsButton = (Button) findViewById(R.id.settingsButon);

        settingsButton.setOnClickListener((view) ->
                goToSettings()
        );

        Button scanQRCode = (Button) findViewById(R.id.scanQRCode);

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
        Intent intent = new Intent(MainActivity.this, TimetableActivity.class);
        finish();
        startActivity(intent);
    }

    private void goToSettings() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        finish();
        startActivity(intent);
    }


    private void goToScanQRCode() {
        Intent intent = new Intent(MainActivity.this, QRCodeScanActivity.class);
        finish();
        startActivity(intent);
    }

}
