package com.bottles.five.isisalarm;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class PhotosActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        mRecyclerView = (RecyclerView) findViewById(R.id.photos_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(
                new
                        RecyclerViewAdapter.PhotoItemClickListener() {
                            @Override
                            public void onItemClick(int position, View v) {
                                Log.i(LOG_TAG, " Clicked on Item " + position);
                            }
                        }
        );
    }

    private ArrayList<PhotoInfo> getDataSet() {
        ArrayList results = new ArrayList<PhotoInfo>();
        for (int index = 0; index < 20; index++) {
            PhotoInfo obj = new PhotoInfo(R.drawable.abu_bakr_al_baghdadi);
            results.add(index, obj);
        }
        return results;
    }
}

