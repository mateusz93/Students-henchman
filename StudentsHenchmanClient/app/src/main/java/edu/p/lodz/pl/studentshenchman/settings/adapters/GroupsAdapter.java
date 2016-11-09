package edu.p.lodz.pl.studentshenchman.settings.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;

/**
 * Created by Michał on 2016-11-09.
 */

public class GroupsAdapter extends BaseAdapter {

	private static final String TAG = GroupsAdapter.class.getName();
	private final Context mContext;
	private List<DeanGroup> mValues;

	public GroupsAdapter(Context context, List<DeanGroup> values) {
		mContext = context;
		init(values);
	}

	private void init(List<DeanGroup> values) {
		mValues = new ArrayList<>(values);
		DeanGroup deanGroup = new DeanGroup();
		deanGroup.setId(Long.MIN_VALUE);
		deanGroup.setExternalGroupId(Long.MIN_VALUE);
		deanGroup.setExternalFieldId(Long.MIN_VALUE);
		deanGroup.setTerm(0);
		deanGroup.setDegree(0);
		deanGroup.setName(mContext.getString(R.string.spinner_option_choose));
		deanGroup.setAbbreviation("");
		mValues.add(0, deanGroup);
	}

	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public DeanGroup getItem(int position) {
		return mValues.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mValues.get(position).getExternalGroupId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (null == convertView) {
			LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(convertView);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		DeanGroup deanGroup = getItem(position);
		viewHolder.textView.setText(deanGroup.getAbbreviation() + " " + deanGroup.getName());

		return convertView;
	}

	public void setValues(List<DeanGroup> newValues) {
		init(newValues);
		notifyDataSetChanged();
	}

	public int getPosForId(long id) {
		int i = 0;
		Iterator<DeanGroup> iterator = mValues.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getExternalGroupId() == id) {
				return i;
			}
			i++;
		}
		return 0;
	}

	private class ViewHolder {
		public TextView textView;

		public ViewHolder(View view) {
			textView = (TextView) view.findViewById(android.R.id.text1);
		}
	}
}
