package com.bottles.five.isisalarm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bottles.five.isisalarm.model.PhotoInfo;
import com.bottles.five.isisalarm.restclient.HttpFaceDetectTask;
import com.bottles.five.isisalarm.storage.StorageUtils;

import java.util.ArrayList;


public class PhotosActivity extends ActionBarActivity {

    private static Boolean imageChosed;
    private static ProgressDialog progressBar;

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
        imageChosed = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((PhotoRecyclerViewAdapter) mAdapter).setOnItemClickListener(
                new PhotoRecyclerViewAdapter.MyClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        synchronized (imageChosed) {
                            if (imageChosed)
                                return;
                            else {
                                imageChosed = true;
                                progressBar = new ProgressDialog(v.getContext());
                                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressBar.setCancelable(false);
                                progressBar.show();
                            }
                        }
                        String filename = photos.get(position).getName();
                        byte[] binary = StorageUtils.getPhotoAsBinaryData(filename, PhotosActivity.this);
                        new HttpFaceDetectTask(PhotosActivity.this, filename).execute(binary);
                    }
                }
        );
    }

    public static void resetProgressBar() {
        imageChosed = false;
        progressBar.hide();
    }

}
