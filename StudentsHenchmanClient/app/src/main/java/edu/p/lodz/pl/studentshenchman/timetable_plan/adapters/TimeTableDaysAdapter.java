package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.DayFragment;

/**
 * Created by Michał on 2016-10-12.
 */

public class TimeTableDaysAdapter extends FragmentPagerAdapter {

	private Context mContext;
	private List<Fragment> mFragments;

	public TimeTableDaysAdapter(Context context, FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		mContext = context;
		mFragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mFragments.get(position).getArguments().getString(DayFragment.TAB_NAME);
	}
}
