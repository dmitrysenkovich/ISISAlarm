package com.bottles.five.isisalarm.restclient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.bottles.five.isisalarm.DetectedActivity;
import com.bottles.five.isisalarm.NotDetectedActivity;
import com.bottles.five.isisalarm.model.face.Face;
import com.bottles.five.isisalarm.model.face.verify.FaceVerifyRequest;
import com.bottles.five.isisalarm.model.face.verify.FaceVerifyResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HttpFaceVerifyTask extends AsyncTask<FaceVerifyRequest, FaceVerifyRequest, FaceVerifyResponse[]> {

    private static final String URL = "https://api.projectoxford.ai/face/v1.0/findsimilars";

    private Context context;
    private String terroristId;
    private String filename;

    public HttpFaceVerifyTask(String terroristId, Context context, String filename) {
        this.context = context;
        this.terroristId = terroristId;
        this.filename = filename;
    }

    @Override
    protected FaceVerifyResponse[] doInBackground(FaceVerifyRequest... params) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Ocp-Apim-Subscription-Key", "3334783ec03f46abb547b64cc2c3643b");
            HttpEntity<?> requestEntity = new HttpEntity<Object>(params[0], headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<FaceVerifyResponse[]> response = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, FaceVerifyResponse[].class);
            return response.getBody();
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    protected void onPostExecute(FaceVerifyResponse[] faces) {
        super.onPostExecute(faces);
        if (faces.length == 0) {
            NotDetectedActivity.startActivty(filename, context);
        } else {
            for (FaceVerifyResponse face : faces) {
                Log.d("TERRORIST", face.getPersistedFaceId());
                Log.d("TERRORIST", face.getConfidence().toString());
                if (face.getConfidence() > 0.7) {
                    DetectedActivity.startActivity(face.getPersistedFaceId(), context);
                }
            }
        }
    }
}
