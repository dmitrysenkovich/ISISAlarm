package com.bottles.five.isisalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bottles.five.isisalarm.call.CallUtils;

public class DetectedActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detected);

        /*Bundle b = getIntent().getExtras();
        int id = b.getInt("id");

        textView = (TextView) findViewById(R.id.detected_textview);
        String terroristName = MappingUtils.getTerroristName(id, DetectedActivity.this);
        String detectedMessageTemplate = getString(R.string.detected);
        String detectedMessage = MessageFormat.format(detectedMessageTemplate, terroristName);
        textView.setText(detectedMessage);
        imageView = (ImageView) findViewById(R.id.detected_imageview);
        Drawable image = MappingUtils.getTerroristImage(id, DetectedActivity.this);
        imageView.setImageDrawable(image);*/
    }

    public void call911(MenuItem item) {
        CallUtils.call911(DetectedActivity.this);
    }
}
