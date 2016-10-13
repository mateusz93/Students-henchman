package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // do whatever
            }

            @Override
            public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SubjectListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);

        // mAdapter.setOnItemClickListener(onItemClickListener);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    private static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            void onItemClick(View view, int position);


            void onLongItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
