package com.bottles.five.isisalarm.call;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class CallUtils {

    public static final String EMERGENCY_PHONE_NUMBER = "+375299420344";

    public static void call911(AppCompatActivity activity) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + EMERGENCY_PHONE_NUMBER));
        try {
            activity.startActivity(callIntent);
        } catch (SecurityException e) {
            Log.e("PERMISSION_EXCEPTION", "PERMISSION_NOT_GRANTED");
        }
    }
}
