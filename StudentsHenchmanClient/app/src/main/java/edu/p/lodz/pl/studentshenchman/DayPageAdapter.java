package edu.p.lodz.pl.studentshenchman;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.p.lodz.pl.studentshenchman.fragments.MondayFragment;
import edu.p.lodz.pl.studentshenchman.fragments.TuesdayFragment;

public class DayPageAdapter extends FragmentPagerAdapter {

    Context context;

    public DayPageAdapter(FragmentManager fragmentManager, Context fmContext)
    {
        super(fragmentManager);
        context = fmContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return MondayFragment.getInstance(0);

            case 1:
                return TuesdayFragment.getInstance(1);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                return context.getResources().getString(R.string.monday);

            case 1:
                return context.getResources().getString(R.string.tuesday);

            default:
                return null;
        }
    }

}
