package edu.p.lodz.pl.studentshenchman.dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.dashboard.drawer_data.DrawerItem;

/**
 * Created by Michał on 2016-10-24.
 */

public class DrawerListAdapter extends BaseAdapter {
    private static final String TAG = DrawerListAdapter.class.getName();
    private final List<DrawerItem> mValues;

    Context mContext;

    public DrawerListAdapter(Context context, List<DrawerItem> values) {
        mContext = context;
        mValues = values;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public DrawerItem getItem(int position) {
        return mValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (null == convertView) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.drawer_item_list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageResource(getItem(position).getIcon());
        viewHolder.name.setText(getItem(position).getName());

        return convertView;
    }

    private class ViewHolder {
        public ImageView icon;
        public TextView name;

        public ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.drawer_item_icon);
            name = (TextView) view.findViewById(R.id.drawer_item_name);

        }
    }
}
