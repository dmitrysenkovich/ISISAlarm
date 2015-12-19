package com.bottles.five.isisalarm.service;


import retrofit.Retrofit;

public class FaceVerifyServiceClient {
    private static String API = "https://api.projectoxford.ai/face/v1.0/";
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(API).build();


}
