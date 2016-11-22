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
import edu.p.lodz.pl.studentshenchman.settings.classes.Term;

/**
 * Created by Michał on 2016-11-11.
 */

public class TermAdapter extends BaseAdapter {
	private static final String TAG = TermAdapter.class.getName();

	private final Context mContext;
	private List<Term> mValues;

	public TermAdapter(Context context) {
		this.mContext = context;
		init();
	}

	private void init() {
		mValues = new ArrayList<>();
		mValues.add(new Term(mContext.getString(R.string.spinner_option_choose), 0L));
		mValues.add(new Term("1", 1L));
		mValues.add(new Term("2", 2L));
		mValues.add(new Term("3", 3L));
		mValues.add(new Term("4", 4L));
		mValues.add(new Term("5", 5L));
		mValues.add(new Term("6", 6L));
		mValues.add(new Term("7", 7L));
	}

	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public Term getItem(int position) {
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

		Term term = mValues.get(position);

		viewHolder.text.setText(term.getName());

		return convertView;
	}

	public int getPosForValue(long value) {
		int i = 0;
		Iterator<Term> iterator = mValues.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue() == value) {
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
