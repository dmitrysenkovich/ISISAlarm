package com.bottles.five.isisalarm;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PhotoViewHolder> {

    List<PhotoInfo> photos;
    private static PhotoItemClickListener photoItemClickListener;

    public static class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView name;
        TextView date;
        ImageView photo;

        PhotoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            photo = (ImageView) itemView.findViewById(R.id.photo);
//            photo.setScaleType(ImageView.ScaleType.FIT_XY);
//            photo.setAdjustViewBounds(true);
        }

        @Override
        public void onClick(View v) {
            photoItemClickListener.onItemClick(getPosition(), v);
        }
    }

    RecyclerViewAdapter(List<PhotoInfo> photos){
        this.photos = photos;
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_item, viewGroup, false);
        PhotoViewHolder pvh = new PhotoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder personViewHolder, int i) {
        personViewHolder.photo.setImageResource(photos.get(i).getPhotoId());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setOnItemClickListener(PhotoItemClickListener photoItemClickListener) {
        this.photoItemClickListener = photoItemClickListener;
    }


    public interface PhotoItemClickListener {
        void onItemClick(int position, View v);
    }
}



