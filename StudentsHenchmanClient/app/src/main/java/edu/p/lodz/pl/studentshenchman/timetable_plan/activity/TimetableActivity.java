package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import edu.p.lodz.pl.studentshenchman.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;


public class TimetableActivity extends StudentShenchmanMainActivity {

    private static final String TAG = TimetableActivity.class.getName();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        prepareToolbar();

    }

    private void prepareToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.timetable_activity_title);
        toolbar.setNavigationIcon(android.R.drawable.btn_plus);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onBackPressed() {
        goToDashboard();
    }

    private void goToDashboard() {
        Intent previousActivity = new Intent(TimetableActivity.this, DashboardActivity.class);
        finish();
        startActivity(previousActivity);
    }
}
