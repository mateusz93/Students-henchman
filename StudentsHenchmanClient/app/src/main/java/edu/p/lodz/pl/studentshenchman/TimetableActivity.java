package edu.p.lodz.pl.studentshenchman;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


public class TimetableActivity extends AppCompatActivity {

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        viewPager = (ViewPager) findViewById(R.id.container);

        if (viewPager != null) {
            DayPageAdapter dayPageAdapter = new DayPageAdapter(getSupportFragmentManager(), getApplicationContext());
            viewPager.setAdapter(dayPageAdapter);

        }
    }
}
