package com.bottles.five.isisalarm.restclient;

import android.os.AsyncTask;
import android.util.Log;

import com.bottles.five.isisalarm.model.Face;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HttpFaceDetectTask extends AsyncTask<Void, Void, Face> {

    private static final String URL = "http://rest-service.guides.spring.io/greeting";

    @Override
    protected void onPostExecute(Face face) {
        Log.d("HttpDetectTask", face.getId());
        Log.d("HttpDetectTask", face.getContent());
    }

    @Override
    protected Face doInBackground(Void... params) {
        Log.d("HttpDetectTask", "doInBack");
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Face ebalo = restTemplate.getForObject(URL, Face.class);
            return ebalo;
        } catch (Exception e) {
            Log.d("HttpDetectTask", e.getMessage());
        }
        return null;
    }
}
