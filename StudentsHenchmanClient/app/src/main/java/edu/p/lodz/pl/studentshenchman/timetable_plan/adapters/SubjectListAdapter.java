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
    private OnItemClickListener mItemClickListener;

    public SubjectListAdapter(Context context) {
        this.mContext = context;
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
        Picasso.with(mContext).load(R.color.colorPrimary).into(holder.placeImage);

        Bitmap photo = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.nav);

        Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int mutedLight = palette.getMutedColor(mContext.getResources().getColor(android.R.color.black));
                holder.placeNameHolder.setBackgroundColor(mutedLight);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    /*@Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }*/

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView subjectName;
        public TextView time;
        public TextView place;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            subjectName = (TextView) itemView.findViewById(R.id.subject_name);
            time = (TextView) itemView.findViewById(R.id.time);
            place = (TextView) itemView.findViewById(R.id.place);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
            // placeHolder.setOnClickListener(this);
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
