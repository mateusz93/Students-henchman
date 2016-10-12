package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.SubjectListAdapter;

/**
 * Created by Michał on 2016-10-12.
 */

public class DayFragment extends StudentShenchmanMainFragment {

    private static final String TAG = DayFragment.class.getName();


    public static final String TAB_NAME = "tab_name";
    public static final String TAB_NUMBER = "tab_number";

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private SubjectListAdapter mAdapter;

    public static DayFragment getInstance(String tabName, int tabNumber) {
        DayFragment day = new DayFragment();

        Bundle bundle = new Bundle();
        bundle.putString(TAB_NAME, tabName);
        bundle.putInt(TAB_NUMBER, tabNumber);
        day.setArguments(bundle);

        return day;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.day_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SubjectListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);

        // mAdapter.setOnItemClickListener(onItemClickListener);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeBasic();
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.grid_manager_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_toggle_grid) {
            toggleGrid();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleGrid() {
        // menager moze zmienic widok
    }*/
}
