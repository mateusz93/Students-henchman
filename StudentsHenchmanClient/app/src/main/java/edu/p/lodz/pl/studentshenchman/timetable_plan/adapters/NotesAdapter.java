package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;

import edu.p.lodz.pl.studentshenchman.R;

/**
 * Created by Michał on 2016-10-20.
 */

public class NotesAdapter extends BaseAdapter {
    private static final String TAG = NotesAdapter.class.getName();

    private final Context mContext;
    private final LayoutInflater mInflater;

    public NotesAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.note_item_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.noteContent.setText("Notatka do przedmiotu");
        viewHolder.addedDate.setText(new Date().toString());

        return convertView;
    }

    private class ViewHolder {
        public TextView noteContent;
        public TextView addedDate;

        public ViewHolder(View view) {
            noteContent = (TextView) view.findViewById(R.id.note_item_content);
            addedDate = (TextView) view.findViewById(R.id.note_item_added_date);

        }

    }
}
