package com.bottles.five.isisalarm.parser;

import org.xmlpull.v1.XmlPullParser;

public class ParserUtils {
    public static String getValue(XmlPullParser xmlPullParser, String key) {
        String value = null;
        try {
            while (xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xmlPullParser.getEventType()==XmlPullParser.START_TAG) {
                    String currentKey = xmlPullParser.getAttributeValue(0);
                    if (currentKey.equals(key)) {
                        value = xmlPullParser.getText();
                    }
                }

                xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            value = null;
        } finally {
            return value;
        }
    }
}
