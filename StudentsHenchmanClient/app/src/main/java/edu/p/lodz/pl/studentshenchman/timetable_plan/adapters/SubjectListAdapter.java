package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;

/**
 * Created by Michał on 2016-10-12.
 */

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.ViewHolder> /*implements CursorAdapter*/ {
    private static final String TAG = SubjectListAdapter.class.getName();

    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mItemClickListener;

    public SubjectListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.lessonName.setText("Analiza Matematyczna");
        holder.lessonTime.setText("8:15 - 9:45");
        holder.lessonBuilding.setText("CTI");
        holder.lessonRoom.setText("301");
        holder.lessonTeacher.setText("Dr. inz. Rafal Kielbik");
        holder.navigateLesson.setVisibility(View.GONE);


        // Bitmap photo = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.bg);

       /* Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int mutedLight = palette.getMutedColor(mContext.getResources().getColor(android.R.color.black));
                holder.subjectInfoHolder.setBackgroundColor(mutedLight);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return 5;
    }


    @Override
    public long getItemId(int position) {
        return 3;
    }

   /* @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.subject_item_list, parent, false);
            holder.mainHolder = (LinearLayout) convertView.findViewById(R.id.main_holder);
            holder.lessonName = (TextView) convertView.findViewById(R.id.subject_name);
            holder.lessonTime = (TextView) convertView.findViewById(R.id.lessonTime);
            holder.lessonBuilding = (TextView) convertView.findViewById(R.id.lessonBuilding);
            holder.subjectInfoHolder = (LinearLayout) convertView.findViewById(R.id.subject_info_holder);
            holder.subjectImage = (ImageView) convertView.findViewById(R.id.subject_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.lessonName.setText("Analiza Matematyczna");
        holder.lessonTime.setText("8:15 - 9:45");
        holder.lessonBuilding.setText("Budynek xxx sala 104");
        Picasso.with(mContext).load(R.drawable.bg).into(holder.subjectImage);
        holder.subjectInfoHolder.setBackgroundColor(mContext.getColor(android.R.color.black));
        return convertView;

    }*/

    /*@Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public RelativeLayout lessonMainHolder;
        public TextView lessonName;
        public TextView lessonTime;
        public TextView lessonBuilding;
        public TextView lessonRoom;
        public TextView lessonTeacher;
        public ImageView navigateLesson;


        public ViewHolder(View itemView) {
            super(itemView);
            lessonMainHolder = (RelativeLayout) itemView.findViewById(R.id.lesson_main_holder);
            lessonName = (TextView) itemView.findViewById(R.id.item_lesson_name);
            lessonTime = (TextView) itemView.findViewById(R.id.item_lesson_time);
            lessonBuilding = (TextView) itemView.findViewById(R.id.item_building_name);
            lessonTeacher = (TextView) itemView.findViewById(R.id.item_teacher_name);
            lessonRoom = (TextView) itemView.findViewById(R.id.item_room_name);
            navigateLesson = (ImageView) itemView.findViewById(R.id.navigate_item_icon);
            lessonMainHolder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(v, getPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
