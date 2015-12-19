package com.bottles.five.isisalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class NotDetectedActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_detected);

        /*Bundle b = getIntent().getExtras();
        String filename = b.getString("filename");

        imageView = (ImageView) findViewById(R.id.not_detected_image);
        Bitmap file = StorageUtils.getPhotoByName(filename);
        imageView.setImageBitmap(file);*/
    }
}
