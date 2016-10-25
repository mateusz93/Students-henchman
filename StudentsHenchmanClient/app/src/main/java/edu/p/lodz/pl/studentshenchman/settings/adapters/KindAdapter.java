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

import edu.p.lodz.pl.studentshenchman.database.models.Kind;

/**
 * @author Michal Warcholinski
 */
public class KindAdapter extends BaseAdapter {
	private static final String TAG = KindAdapter.class.getName();

	private Context mContext;
	private List<Kind> mValues;

	public KindAdapter(Context context, List<Kind> values) {
		mContext = context;
		init(values);
	}

	private void init(List<Kind> values) {
		mValues = new ArrayList<>(values);
		Kind kind = new Kind();
		kind.setId(Long.MIN_VALUE);
		kind.setExternalId(Long.MIN_VALUE);
		kind.setName("choose");
		mValues.add(0, kind);
	}


	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public Kind getItem(int position) {
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

		Kind kind = getItem(position);

		viewHolder.text.setText(kind.getName());

		return convertView;
	}

	public void setValues(List<Kind> newValues) {
		init(newValues);
		notifyDataSetChanged();
	}

	public int getPosForId(long id) {
		int i = 0;
		Iterator<Kind> iterator = mValues.iterator();
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
