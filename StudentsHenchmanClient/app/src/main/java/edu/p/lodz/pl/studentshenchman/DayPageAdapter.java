package edu.p.lodz.pl.studentshenchman;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.p.lodz.pl.studentshenchman.fragments.MondayFragment;

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

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                return context.getResources().getString(R.string.monday);

            default:
                return null;
        }
    }

}
