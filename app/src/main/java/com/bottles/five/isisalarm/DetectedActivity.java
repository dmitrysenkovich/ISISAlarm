package com.bottles.five.isisalarm;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bottles.five.isisalarm.call.CallUtils;
import com.bottles.five.isisalarm.mapping.MappingUtils;

import java.text.MessageFormat;

public class DetectedActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detected);

        Bundle b = getIntent().getExtras();
        String id = b.getString("id");

        textView = (TextView) findViewById(R.id.detected_textview);
        String terroristName = MappingUtils.getTerroristName(id);
        String detectedMessageTemplate = getString(R.string.detected);
        String detectedMessage = MessageFormat.format(detectedMessageTemplate, terroristName);
        textView.setText(detectedMessage);
        imageView = (ImageView) findViewById(R.id.detected_imageview);
        Drawable image = MappingUtils.getTerroristImage(id, DetectedActivity.this);
        imageView.setImageDrawable(image);
    }

    public void call911(View view) {
        CallUtils.call911(DetectedActivity.this);
    }

    public static void startActivity(String terroristId, Context context) {
        Intent detectedActivity = new Intent(context, DetectedActivity.class);
        Bundle b = new Bundle();
        b.putString("id", terroristId);
        detectedActivity.putExtras(b);
        context.startActivity(detectedActivity);
        PhotosActivity.resetProgressBar();
    }
}
