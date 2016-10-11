package edu.p.lodz.pl.studentshenchman;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class TimetableActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        viewPager = (ViewPager) findViewById(R.id.container);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        if (viewPager != null) {
            DayPageAdapter dayPageAdapter = new DayPageAdapter(getSupportFragmentManager(), getApplicationContext());
            viewPager.setAdapter(dayPageAdapter);

            if (tabLayout != null)
            {
                tabLayout.setupWithViewPager(viewPager);
            }
        }
    }
}
