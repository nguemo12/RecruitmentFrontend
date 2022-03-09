package com.example.go_jobs;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Retrofit retrofit;
    public static String PROTOCOL = "http://";
    public static String SERVER_URL = "192.168.1.186";
    public static String SERVER_PORT = "14484";
    public static String APP_NAME = "/RecruitmentPlatformBackend";
    public static String API_ROOT = "/webresources";
    static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder().baseUrl(PROTOCOL + SERVER_URL + ":" + SERVER_PORT + APP_NAME + API_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
