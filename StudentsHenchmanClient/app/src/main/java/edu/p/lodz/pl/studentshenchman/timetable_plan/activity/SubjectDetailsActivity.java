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
    private ListView mSubjectNoteList;
    private FloatingActionButton mAddSubjectNoteFAB;
    private TextView mHeaderTitle;
    private TextView mSubjectName;
    private TextView mSubjectType;
    private TextView mTime;
    private TextView mLector;
    private TextView mLocationBuild;
    private TextView mLocationRoom;
    private ImageView mLessonNavigator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        prepareToolbar();

        mSubjectName = (TextView) findViewById(R.id.item_lesson_name);
        //mSubjectType = (TextView) findViewById(R.id.subject_type);
        mHeaderTitle =(TextView) findViewById(R.id.item_lesson_header_title);
        mTime = (TextView) findViewById(R.id.item_lesson_time);
        mLector = (TextView) findViewById(R.id.item_teacher_name);
        mLocationBuild = (TextView) findViewById(R.id.item_building_name);
        mLocationRoom = (TextView) findViewById(R.id.item_room_name);
        mSubjectNoteList = (ListView) findViewById(R.id.subject_note_list);
        mLessonNavigator = (ImageView) findViewById(R.id.navigate_item_icon);
        mAddSubjectNoteFAB = (FloatingActionButton) findViewById(R.id.add_note_fab);
        mAddSubjectNoteFAB.setOnClickListener(new AddNoteOnClickListener());

        mHeaderTitle.setText("WYKLAD");
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

    public class AddNoteOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "DODAJ NOTATKE DO PRZEDMIOTU", Toast.LENGTH_SHORT).show();
        }
    }

}
