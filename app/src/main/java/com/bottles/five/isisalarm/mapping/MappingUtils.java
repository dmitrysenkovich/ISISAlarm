package com.bottles.five.isisalarm.mapping;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

import com.bottles.five.isisalarm.R;
import com.bottles.five.isisalarm.parser.ParserUtils;

import org.xmlpull.v1.XmlPullParser;

public class MappingUtils {
    public static Drawable getTerroristImage(String id, AppCompatActivity activity) {
        XmlPullParser xmlPullParser = activity.getResources().getXml(R.xml.id_to_terrorist_image);
        String terroristImageName = ParserUtils.getValue(xmlPullParser, id);
        int resourceId = activity.getResources().getIdentifier(terroristImageName, "drawable", activity.getPackageName());
        return activity.getResources().getDrawable(resourceId);
    }

    public static String getTerroristName(String id, AppCompatActivity activity) {
        XmlPullParser xmlPullParser = activity.getResources().getXml(R.xml.id_to_terrorist_name);
        String terroristName = ParserUtils.getValue(xmlPullParser, id);
        return terroristName;
    }
}
