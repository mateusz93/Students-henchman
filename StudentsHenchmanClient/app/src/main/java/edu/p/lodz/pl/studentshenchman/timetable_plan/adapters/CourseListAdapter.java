package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;

/**
 * Created by Michał on 2016-10-12.
 */

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {
	private static final String TAG = CourseListAdapter.class.getName();

	private Context mContext;
	private LayoutInflater mInflater;

	public CourseListAdapter(Context context) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item_list, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.lessonHeaderTitle.setText("WYKLAD");
		holder.lessonName.setText("Analiza Matematyczna");
		holder.lessonTime.setText("8:15 - 9:45");
		holder.lessonBuilding.setText("CTI");
		holder.lessonRoom.setText("301");
		holder.lessonTeacher.setText("Dr. inz. Rafal Kielbik");
		holder.navigateLesson.setVisibility(View.GONE);

	}

	@Override
	public int getItemCount() {
		return 5;
	}


	@Override
	public long getItemId(int position) {
		return 3;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public RelativeLayout lessonMainHolder;
		public TextView lessonHeaderTitle;
		public TextView lessonName;
		public TextView lessonTime;
		public TextView lessonBuilding;
		public TextView lessonRoom;
		public TextView lessonTeacher;
		public ImageView navigateLesson;


		public ViewHolder(View itemView) {
			super(itemView);
			lessonMainHolder = (RelativeLayout) itemView.findViewById(R.id.lesson_main_holder);
			lessonHeaderTitle = (TextView) itemView.findViewById(R.id.item_lesson_header_title);
			lessonName = (TextView) itemView.findViewById(R.id.item_lesson_name);
			lessonTime = (TextView) itemView.findViewById(R.id.item_lesson_time);
			lessonBuilding = (TextView) itemView.findViewById(R.id.item_building_name);
			lessonTeacher = (TextView) itemView.findViewById(R.id.item_teacher_name);
			lessonRoom = (TextView) itemView.findViewById(R.id.item_room_name);
			navigateLesson = (ImageView) itemView.findViewById(R.id.navigate_item_icon);
		}
	}
}
