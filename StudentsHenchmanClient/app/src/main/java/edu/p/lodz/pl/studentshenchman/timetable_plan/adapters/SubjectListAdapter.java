package edu.p.lodz.pl.studentshenchman.timetable_plan.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        holder.subjectName.setText("Analiza Matematyczna");
        holder.time.setText("8:15 - 9:45");
        holder.place.setText("Budynek xxx sala 104");
        Picasso.with(mContext).load(R.drawable.bg).into(holder.subjectImage);

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
            holder.subjectName = (TextView) convertView.findViewById(R.id.subject_name);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.place = (TextView) convertView.findViewById(R.id.place);
            holder.subjectInfoHolder = (LinearLayout) convertView.findViewById(R.id.subject_info_holder);
            holder.subjectImage = (ImageView) convertView.findViewById(R.id.subject_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.subjectName.setText("Analiza Matematyczna");
        holder.time.setText("8:15 - 9:45");
        holder.place.setText("Budynek xxx sala 104");
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
        public LinearLayout mainHolder;
        public LinearLayout subjectInfoHolder;
        public TextView subjectName;
        public TextView time;
        public TextView place;
        public ImageView subjectImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mainHolder = (LinearLayout) itemView.findViewById(R.id.main_holder);
            subjectName = (TextView) itemView.findViewById(R.id.subject_name);
            time = (TextView) itemView.findViewById(R.id.time);
            place = (TextView) itemView.findViewById(R.id.place);
            subjectInfoHolder = (LinearLayout) itemView.findViewById(R.id.subject_info_holder);
            subjectImage = (ImageView) itemView.findViewById(R.id.subject_image);
            mainHolder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // mItemClickListener.onItemClick(v, getPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
