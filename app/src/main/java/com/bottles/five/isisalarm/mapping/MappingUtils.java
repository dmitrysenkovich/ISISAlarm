package com.bottles.five.isisalarm.mapping;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

import com.bottles.five.isisalarm.R;
import com.bottles.five.isisalarm.parser.ParserUtils;

import org.xmlpull.v1.XmlPullParser;

public class MappingUtils {
    public static Drawable getTerroristImage(int id, AppCompatActivity activity) {
        XmlPullParser xmlPullParser = activity.getResources().getXml(R.xml.id_to_terrorist_image);
        String terroristImageName = ParserUtils.getValue(xmlPullParser, Integer.toString(id));
        int resourceId = activity.getResources().getIdentifier(terroristImageName, "drawable", activity.getPackageName());
        return activity.getResources().getDrawable(resourceId);
    }

    public static String getTerroristName(int id, AppCompatActivity activity) {
        XmlPullParser xmlPullParser = activity.getResources().getXml(R.xml.id_to_terrorist_name);
        String terroristName = ParserUtils.getValue(xmlPullParser, Integer.toString(id));
        return terroristName;
    }
}
