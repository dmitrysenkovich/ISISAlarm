package com.bottles.five.isisalarm.storage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.bottles.five.isisalarm.PhotoInfo;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
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

    public static Bitmap getPhotoByName(final String name, Context context) {
        File photoFile = photosStorageDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals(name);
            }
        })[0];
        Uri photoUri = Uri.fromFile(photoFile);
        Bitmap photo = null;
        try {
            photo = MediaStore.Images.Media.getBitmap(context.getContentResolver(), photoUri);
        } catch (IOException ignored) {

        }
        return photo;
    }
}
