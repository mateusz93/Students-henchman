package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.database.models.Department;

/**
 * @author Michal Warcholinski
 */
public class DepartmentAdapter extends BaseAdapter {
	private static final String TAG = DepartmentAdapter.class.getName();

	Context mContext;
	List<Department> mValues;

	public DepartmentAdapter(Context context, List<Department> values) {
		mContext = context;
		init(values);
	}

	private void init(List<Department> values) {
		mValues = new ArrayList<>(values);
		mValues.add(0, new Department());
	}

	@Override
	public int getCount() {
		//return mValues.size();
		return 10;
	}

	@Override
	public Department getItem(int position) {
		return mValues.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (null == convertView) {
			LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(android.R.layout.simple_list_item_single_choice, parent, false);
			TextView text = (TextView) convertView.findViewById(android.R.id.text1);
			text.setText("Department");
		}

		return convertView;
	}
}
