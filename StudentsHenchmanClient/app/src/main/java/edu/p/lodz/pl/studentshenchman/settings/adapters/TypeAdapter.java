package edu.p.lodz.pl.studentshenchman.settings.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michal Warcholinski
 */
public class TypeAdapter extends BaseAdapter {
    private static final String TAG = TypeAdapter.class.getName();

    Context mContext;
    List<Object> mValues;

    public TypeAdapter(Context context, List<Object> values) {
        mContext = context;
        init(values);
    }

    private void init(List<Object> values) {
        mValues = new ArrayList<>(values);
        //mValues.add(0, new Type());
    }

    @Override
    public int getCount() {
        //return mValues.size();
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

        viewHolder.text.setText("Studia dzienne");

        return convertView;
    }


    private class ViewHolder {

        public TextView text;

        public ViewHolder(View convertView) {
            text = (TextView) convertView.findViewById(android.R.id.text1);
        }
    }
}
