package edu.p.lodz.pl.studentshenchman.settings.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Michal Warcholinski
 */
public class SpecializationAdapter extends BaseAdapter {


    private final Context mContext;
    private ArrayList<Object> mValues;

    public SpecializationAdapter(Context context, ArrayList<Object> values) {
        mContext = context;
        init(values);
    }

    private void init(ArrayList<Object> values) {
        mValues = new ArrayList<>(values);
        //mValues.add(0,new Specialization);
    }

    @Override
    public int getCount() {
        return 15;
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
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(android.R.layout.simple_list_item_single_choice, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text.setText("Specjalizacja");

        return convertView;
    }

    private class ViewHolder {
        public TextView text;

        public ViewHolder(View convertView) {
            text = (TextView) convertView.findViewById(android.R.id.text1);
        }
    }
}
