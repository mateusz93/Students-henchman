package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.workers.DownloadWeatherSimpleWorker;

public class MainActivity extends StudentShenchmanMainActivity {
    private static final String TAG = MainActivity.class.getName();

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //prepareToolbar();


        Button button = (Button) findViewById(R.id.readDataButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadWeatherSimpleWorker downloadDateWorker = new DownloadWeatherSimpleWorker(getApplicationContext());
                downloadDateWorker.runService();
            }
        });
    }

    public void prepareToolbar() {
        toolbar.setTitle(R.string.dashboard);
        toolbar.setNavigationIcon(android.R.drawable.btn_plus);
        setSupportActionBar(toolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
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

    private void goToSettings() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        finish();
        startActivity(intent);
    }

}
