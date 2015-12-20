package com.bottles.five.isisalarm.mapping;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

import com.bottles.five.isisalarm.data.IdToTerroristName;
import com.bottles.five.isisalarm.data.IdToTerroristPhoto;

public class MappingUtils {
    public static Drawable getTerroristImage(String id, AppCompatActivity activity) {
        String terroristImageName = IdToTerroristPhoto.DANNIE.get(id);
        int resourceId = activity.getResources().getIdentifier(terroristImageName, "drawable", activity.getPackageName());
        return activity.getResources().getDrawable(resourceId);
    }

    public static String getTerroristName(String id) {
        String terroristName = IdToTerroristName.DANNIE.get(id);
        return terroristName;
    }
}
