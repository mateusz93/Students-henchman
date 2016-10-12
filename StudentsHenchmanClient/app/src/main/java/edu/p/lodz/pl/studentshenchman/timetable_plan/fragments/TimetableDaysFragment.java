package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.TimetableActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.TimeTableDaysAdapter;

/**
 * Created by Michał on 2016-10-12.
 */

public class TimetableDaysFragment extends StudentShenchmanMainFragment {

    private static final String TAG = TimetableDaysFragment.class.getName();

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TimeTableDaysAdapter mTimeTableDaysAdapter;
    private TimetableActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.timetable_days_fragment, container, false);

        mActivity = (TimetableActivity) getActivity();

        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        List<Fragment> fragments = getRequiredFragments();
        mTimeTableDaysAdapter = new TimeTableDaysAdapter(getContext(), getFragmentManager(), fragments);
        mViewPager.setAdapter(mTimeTableDaysAdapter);
        setUpActionBar(fragments);

        return view;

    }

    private void setUpActionBar(List<Fragment> fragments) {

        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.monday)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.tuesday)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.wednesday)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.thursday)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.friday)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.saturday)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.sunday)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }

    private List<Fragment> getRequiredFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DayFragment.getInstance(getString(R.string.monday), 1));
        fragments.add(DayFragment.getInstance(getString(R.string.tuesday), 2));
        fragments.add(DayFragment.getInstance(getString(R.string.wednesday), 3));
        fragments.add(DayFragment.getInstance(getString(R.string.thursday), 4));
        fragments.add(DayFragment.getInstance(getString(R.string.friday), 5));
        fragments.add(DayFragment.getInstance(getString(R.string.saturday), 6));
        fragments.add(DayFragment.getInstance(getString(R.string.sunday), 7));

        return fragments;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
