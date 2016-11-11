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
import edu.p.lodz.pl.studentshenchman.settings.classes.Degree;

/**
 * @author Michal Warcholinski
 */
public class DegreeAdapter extends BaseAdapter {
	private static final String TAG = DegreeAdapter.class.getName();

	private Context mContext;
	private List<Degree> mValues;

	public DegreeAdapter(Context context) {
		mContext = context;
		init();
	}

	private void init() {
		mValues = new ArrayList<>();
		mValues.add(new Degree(mContext.getString(R.string.spinner_option_choose), 0L));
		mValues.add(new Degree(mContext.getString(R.string.settings_degree_spinner_value_label, 1), 1L));
		mValues.add(new Degree(mContext.getString(R.string.settings_degree_spinner_value_label, 2), 2L));
		mValues.add(new Degree(mContext.getString(R.string.settings_degree_spinner_value_label, 2), 3L));
	}


	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public Degree getItem(int position) {
		return mValues.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mValues.get(position).getValue();
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

		Degree degree = getItem(position);

		viewHolder.text.setText(degree.getName());

		return convertView;
	}

	public int getPosForId(long id) {
		int i = 0;
		Iterator<Degree> iterator = mValues.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue() == id) {
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
