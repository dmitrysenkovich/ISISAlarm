package com.bottles.five.isisalarm.restclient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.bottles.five.isisalarm.NotDetectedActivity;
import com.bottles.five.isisalarm.model.face.Face;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HttpFaceDetectTask extends AsyncTask<byte[], byte[], Face[]> {

    private static final String URL = "https://api.projectoxford.ai/face/v1.0/detect";

    private Context context;
    private String filename;

    public HttpFaceDetectTask(Context context, String filename) {
        this.context = context;
        this.filename = filename;
    }

    public void startNotDetectedActivity(String filename) {
        Intent notDetectedActivity = new Intent(context, NotDetectedActivity.class);
        Bundle b = new Bundle();
        b.putString("filename", filename);
        notDetectedActivity.putExtras(b);
        context.startActivity(notDetectedActivity);
    }

    @Override
    protected void onPostExecute(Face[] face) {
        if (face.length == 0) {
            startNotDetectedActivity(filename);
        }
    }

    @Override
    protected Face[] doInBackground(byte[]... params) {
        Log.d("HttpDetectTask", "doInBack");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.set("Ocp-Apim-Subscription-Key", "3334783ec03f46abb547b64cc2c3643b");
            HttpEntity<?> requestEntity = new HttpEntity<Object>(params[0], headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Face[]> response = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, Face[].class);
            return response.getBody();
        } catch (Exception e) {
            Log.d("HttpDetectTask", e.getMessage());
        }
        return null;
    }
}
