package edu.p.lodz.pl.studentshenchman;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;

public class DashboardActivity extends StudentShenchmanMainActivity {
    private static final String TAG = DashboardActivity.class.getName();
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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
