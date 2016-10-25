package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;
import edu.p.lodz.pl.studentshenchman.constants.Constants;
import edu.p.lodz.pl.studentshenchman.timetable_plan.activity.SubjectDetailsActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.adapters.SubjectListAdapter;
import edu.p.lodz.pl.studentshenchman.utils.SelectedCourseContext;
import edu.p.lodz.pl.studentshenchman.utils.Utils;

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
		mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
		mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				SelectedCourseContext courseContext = null;
				Log.i(TAG, "onItemClick: " + position);
				Toast.makeText(getContext(), "onclick:" + position, Toast.LENGTH_SHORT).show();
				long courseId = mAdapter.getItemId(position);
				try {
					courseContext = Utils.createCourseContext(getContext(), courseId);
				} catch (Exception e) {
					Toast.makeText(getContext(), "onclick:" + position, Toast.LENGTH_SHORT).show();
				}
				Intent intent = new Intent(getActivity(), SubjectDetailsActivity.class);
				intent.putExtra(Constants.SELECTED_COURSE_CONTEXT, courseContext);
				getActivity().startActivity(intent);
			}

			@Override
			public void onLongItemClick(View view, int position) {
				Toast.makeText(getContext(), "onCLick LONG:" + position, Toast.LENGTH_SHORT).show();
				Log.i(TAG, "onLongItemClick: " + position);
				EditTimeTableDialogFragment editTimeTableDialogFragment = EditTimeTableDialogFragment.getInstance("taki sobie tytul");
				FragmentManager fm = getChildFragmentManager();
				editTimeTableDialogFragment.show(fm, TAG);
			}
		}));
		mRecyclerView.setHasFixedSize(true);
		mAdapter = new SubjectListAdapter(getContext());
		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnItemClickListener(onItemClickListener);
		return view;

	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

	}

	private SubjectListAdapter.OnItemClickListener onItemClickListener = new SubjectListAdapter.OnItemClickListener() {
		@Override
		public void onItemClick(View view, int position) {
			Log.i(TAG, "onItemCLick z adaptera!!!!!");
		}
	};

	private static class DividerItemDecoration extends RecyclerView.ItemDecoration {

		private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

		private Drawable mDivider;

		/**
		 * Default divider will be used
		 */
		public DividerItemDecoration(Context context) {
			final TypedArray styledAttributes = context.obtainStyledAttributes(ATTRS);
			mDivider = styledAttributes.getDrawable(0);
			styledAttributes.recycle();
		}

		/**
		 * Custom divider will be used
		 */
		public DividerItemDecoration(Context context, int resId) {
			mDivider = ContextCompat.getDrawable(context, resId);
		}

		@Override
		public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
			int left = parent.getPaddingLeft();
			int right = parent.getWidth() - parent.getPaddingRight();

			int childCount = parent.getChildCount();
			for (int i = 0; i < childCount; i++) {
				View child = parent.getChildAt(i);

				RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

				int top = child.getBottom() + params.bottomMargin;
				int bottom = top + mDivider.getIntrinsicHeight();

				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(c);
			}
		}
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
