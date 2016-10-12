package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;

/**
 * Created by Michał on 2016-10-12.
 */

public class DayFragment extends StudentShenchmanMainFragment {

    private static final String TAG = DayFragment.class.getName();


    public static final String TAB_NAME = "tab_name";
    public static final String TAB_NUMBER = "tab_number";

    private TextView mEmptyText;

    public static DayFragment getInstance(String tabName, int tabNumber) {
        DayFragment day = new DayFragment();

        Bundle bundle = new Bundle();
        bundle.putString(TAB_NAME, tabName);
        bundle.putInt(TAB_NUMBER, tabNumber);
        day.setArguments(bundle);

        return day;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.day_fragment, container, false);
        mEmptyText = (TextView) view.findViewById(R.id.empty_text);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mEmptyText.setText(getArguments().getString(TAB_NAME));

    }

}
