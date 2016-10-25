package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;

/**
 * Created by Michał on 2016-10-25.
 */

public class EditTimeTableListAdapter extends BaseAdapter {

	private final LayoutInflater mInflater;
	private Context mContext;

	public EditTimeTableListAdapter(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.edit_timetable_item_list, null);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.teacher.setText("Rafal Kielbik");
		viewHolder.localization.setText("CTI");
		viewHolder.time.setText("10:15 - 11:45");

		return convertView;
	}

	private class ViewHolder {
		public TextView teacher;
		public TextView localization;
		public TextView time;

		public ViewHolder(View view) {
			teacher = (TextView) view.findViewById(R.id.teacher);
			localization = (TextView) view.findViewById(R.id.localization);
			time = (TextView) view.findViewById(R.id.time);
		}
	}
}
