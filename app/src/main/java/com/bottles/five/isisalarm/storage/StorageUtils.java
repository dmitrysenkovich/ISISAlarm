package com.bottles.five.isisalarm.storage;

import android.net.Uri;
import android.os.Environment;

import com.bottles.five.isisalarm.PhotoInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StorageUtils {

    public static final int MEDIA_TYPE_IMAGE = 1;

    private static File photosStorageDir = new File(Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES), "AntiISIS");

    public static Uri getOutputPhotoUri(int type) {
        return Uri.fromFile(getOutputPhotoFile(type));
    }

    public static File getOutputPhotoFile(int type) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "AntiISIS");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return mediaFile;
    }

    public static ArrayList<PhotoInfo> retrieveAllPhotos() {
        ArrayList<PhotoInfo> photoInfoList = new ArrayList<>();
        File[] photos = photosStorageDir.listFiles();
        for (File photo : photos) {
            Date creationDate = new Date(photo.lastModified());
            PhotoInfo photoInfo = new PhotoInfo(photo.getName(), creationDate.toString());
            photoInfoList.add(photoInfo);
        }
        return photoInfoList;
    }
}
