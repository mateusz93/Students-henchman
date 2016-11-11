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
import edu.p.lodz.pl.studentshenchman.settings.classes.Type;

/**
 * @author Michal Warcholinski
 */
public class TypeAdapter extends BaseAdapter {
	private static final String TAG = TypeAdapter.class.getName();

	private Context mContext;
	private List<Type> mValues;

	public TypeAdapter(Context context) {
		mContext = context;
		init();
	}

	private void init() {
		mValues = new ArrayList<>();
		mValues.add(new Type(mContext.getString(R.string.spinner_option_choose), 0L));
		mValues.add(new Type("Studia dzienne", 1L));
		mValues.add(new Type("Studia zaoczne", 2L));
	}

	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public Type getItem(int position) {
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

		Type type = mValues.get(position);

		viewHolder.text.setText(type.getName());

		return convertView;
	}

	public int getPosForId(long id) {
		int i = 0;
		Iterator<Type> iterator = mValues.iterator();
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
