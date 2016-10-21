package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;

/**
 * Created by Michał on 2016-10-13.
 */

public class SubjectDetailsActivity extends StudentShenchmanMainActivity {
    private static final String TAG = SubjectDetailsActivity.class.getName();

    private Toolbar toolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        prepareToolbar();


    }

    private void prepareToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.subject_details_activity_title);
        toolbar.setNavigationIcon(android.R.drawable.btn_plus);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onBackPressed() {
        goToTimeTable();
    }

    private void goToTimeTable() {
        Intent intent = new Intent(SubjectDetailsActivity.this, TimetableActivity.class);
        finish();
        startActivity(intent);
    }

}
