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

import edu.p.lodz.pl.studentshenchman.database.models.Field;

/**
 * @author Michal Warcholinski
 */
public class FieldAdapter extends BaseAdapter {
    private static final String TAG = FieldAdapter.class.getName();
    private final Context mContext;
    private List<Field> mValues;

    public FieldAdapter(Context context, List<Field> values) {
        mContext = context;
        init(values);
    }

    private void init(List<Field> values) {
        mValues = new ArrayList<>(values);
        Field field = new Field();
        field.setId(Long.MIN_VALUE);
        field.setExternalId(Long.MIN_VALUE);
        field.setExternalDepartmentId(Long.MIN_VALUE);
        field.setName("choose");
        mValues.add(0, field);
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Field getItem(int position) {
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
            convertView = layoutInflater.inflate(android.R.layout.simple_list_item_single_choice, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Field field = getItem(position);

        viewHolder.text.setText(field.getName());

        return convertView;
    }

    public void setValues(List<Field> newValues) {
        init(newValues);
        notifyDataSetChanged();
    }

    public int getPosForId(long id) {
        int i = 0;
        Iterator<Field> iterator = mValues.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getExternalId() == id) {
                break;
            }
            i++;
        }
        return i;
    }

    private class ViewHolder {

        public TextView text;

        public ViewHolder(View view) {
            text = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}
