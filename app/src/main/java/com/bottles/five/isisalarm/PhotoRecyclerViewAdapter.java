package com.bottles.five.isisalarm;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PhotoRecyclerViewAdapter extends RecyclerView
        .Adapter<PhotoRecyclerViewAdapter.PhotoInfoHolder> {
    private static String LOG_TAG = "PhotoRecyclerViewAdapter";
    private ArrayList<PhotoInfo> mDataset;
    private static MyClickListener myClickListener;

    public static class PhotoInfoHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;

        public PhotoInfoHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textViewName);
            dateTime = (TextView) itemView.findViewById(R.id.textViewDate);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public PhotoRecyclerViewAdapter(ArrayList<PhotoInfo> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public PhotoInfoHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_item, parent, false);

        PhotoInfoHolder dataObjectHolder = new PhotoInfoHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(PhotoInfoHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getName());
        holder.dateTime.setText(mDataset.get(position).getDate());
    }

    public void addItem(PhotoInfo dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
