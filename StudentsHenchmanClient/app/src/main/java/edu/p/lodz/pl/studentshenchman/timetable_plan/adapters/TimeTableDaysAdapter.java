package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import edu.p.lodz.pl.studentshenchman.timetable_plan.fragments.DayFragment;

/**
 * Created by Michał on 2016-10-12.
 */

public class TimeTableDaysAdapter extends FragmentStatePagerAdapter {

	private Context mContext;
	private List<DayFragment> mFragments;

	public TimeTableDaysAdapter(Context context, FragmentManager fm, List<DayFragment> fragments) {
		super(fm);
		mContext = context;
		mFragments = fragments;
	}

	@Override
	public DayFragment getItem(int position) {
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

	public void refresh() {

		for (DayFragment f : mFragments) {
			f.refreshDataView();
		}
	}
}
