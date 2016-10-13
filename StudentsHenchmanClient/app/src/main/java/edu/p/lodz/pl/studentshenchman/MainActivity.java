package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

        buttonTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTimetable();
            }
        });


       /* Button button = (Button) findViewById(R.id.timesheetButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadWeatherSimpleWorker downloadDateWorker = new DownloadWeatherSimpleWorker(getApplicationContext());
                downloadDateWorker.runService();
            }
        });*/

        Button settingsButton = (Button) findViewById(R.id.settingsButon);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });

        Button saveDataButton = (Button) findViewById(R.id.saveDataButton);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSaveData();
            }
        });

        Button readDataButton = (Button) findViewById(R.id.readDataButton);

        readDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReadData();
            }
        });

        Button scanQRCode = (Button) findViewById(R.id.scanQRCode);

        scanQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToScanQRCode();
            }
        });
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

    private void goToSaveData() {
        Intent intent = new Intent(MainActivity.this, SaveDataActivity.class);
        finish();
        startActivity(intent);
    }

    private void goToReadData() {
        Intent intent = new Intent(MainActivity.this, ReadDataActivity.class);
        finish();
        startActivity(intent);
    }

    private void goToScanQRCode() {
        Intent intent = new Intent(MainActivity.this, QRCodeScanActivity.class);
        finish();
        startActivity(intent);
    }

}
