package com.bottles.five.isisalarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bottles.five.isisalarm.storage.StorageUtils;

import java.util.ArrayList;


public class PhotosActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<PhotoInfo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        mRecyclerView = (RecyclerView) findViewById(R.id.photos_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        photos = StorageUtils.retrieveAllPhotos();
        mAdapter = new PhotoRecyclerViewAdapter(photos);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((PhotoRecyclerViewAdapter) mAdapter).setOnItemClickListener(
                new PhotoRecyclerViewAdapter.MyClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        startNotDetectedActivity(position);
                    }
                }
        );
    }

    public void startNotDetectedActivity(int position) {
        PhotoInfo photoInfo = photos.get(position);
        String filename = photoInfo.getName();
        Intent notDetectedActivity = new Intent(this, NotDetectedActivity.class);
        Bundle b = new Bundle();
        b.putString("filename", filename);
        notDetectedActivity.putExtras(b);
        startActivity(notDetectedActivity);
    }
}
