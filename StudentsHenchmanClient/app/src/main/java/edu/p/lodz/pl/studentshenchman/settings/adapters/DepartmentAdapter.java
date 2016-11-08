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

import edu.p.lodz.pl.studentshenchman.database.models.Department;

/**
 * @author Michal Warcholinski
 */
public class DepartmentAdapter extends BaseAdapter {
    private static final String TAG = DepartmentAdapter.class.getName();

    Context mContext;
    List<Department> mValues;

    public DepartmentAdapter(Context context, List<Department> values) {
        mContext = context;
        init(values);
    }

    private void init(List<Department> values) {
        mValues = new ArrayList<>(values);
        Department department = new Department();
        department.setId(Long.MIN_VALUE);
        department.setExternalId(Long.MIN_VALUE);
        department.setName("choose");
        mValues.add(0, department);
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Department getItem(int position) {
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

        Department department = getItem(position);

        viewHolder.text.setText(department.getName());

        return convertView;

    }

    public void setValues(List<Department> newValues) {
        init(newValues);
        notifyDataSetChanged();
    }

    public int getPosForId(long id) {
        int i = 0;
        Iterator<Department> iterator = mValues.iterator();
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

        public ViewHolder(View view) {
            text = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}
