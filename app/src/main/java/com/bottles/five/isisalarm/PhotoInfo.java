package com.bottles.five.isisalarm;

public class PhotoInfo {
    private String name;
    private String date;

    public PhotoInfo() {
    }

    public PhotoInfo(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
