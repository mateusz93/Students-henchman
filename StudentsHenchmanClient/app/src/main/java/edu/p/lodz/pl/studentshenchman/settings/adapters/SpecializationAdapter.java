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
import edu.p.lodz.pl.studentshenchman.database.models.Specialization;

/**
 * @author Michal Warcholinski
 */
public class SpecializationAdapter extends BaseAdapter {


	private final Context mContext;
	private List<Specialization> mValues;

	public SpecializationAdapter(Context context, List<Specialization> values) {
		mContext = context;
		init(values);
	}

	private void init(List<Specialization> values) {
		mValues = new ArrayList<>(values);
		Specialization specialization = new Specialization();
		specialization.setId(Long.MIN_VALUE);
		specialization.setExternalId(Long.MIN_VALUE);
		specialization.setExternalFieldId(Long.MIN_VALUE);
		specialization.setName(mContext.getString(R.string.spinner_option_choose));
		mValues.add(0, specialization);
	}

	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public Specialization getItem(int position) {
		return mValues.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mValues.get(position).getExternalId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (null == convertView) {
			LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(android.R.layout.simple_list_item_single_choice, parent, false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		Specialization specialization = getItem(position);

		viewHolder.text.setText(specialization.getName());

		return convertView;
	}

	public void setValues(List<Specialization> newValues) {
		init(newValues);
		notifyDataSetChanged();
	}

	public int getPosForId(long id) {
		int i = 0;
		Iterator<Specialization> iterator = mValues.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getExternalId() == id) {
				return i;
			}
			i++;
		}
		return 0;
	}

	private class ViewHolder {
		public TextView text;

		public ViewHolder(View convertView) {
			text = (TextView) convertView.findViewById(android.R.id.text1);
		}
	}
}
