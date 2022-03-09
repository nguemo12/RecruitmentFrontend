package com.example.go_jobs;

import com.example.go_jobs.pojo.ModelOffer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //    http://localhost:14484/RecruitmentPlatformBackend/webresources/offercontroller/listeoffer
    public static String OFFER_CONTROLLER_URL = "offercontroller/";
    public static String JOBAPPLICATION_CONTROLLER_URL = "jobapplicationcontroller/";
    public static String GET_ALL_OFFERS_URL = OFFER_CONTROLLER_URL + "listeoffer";
    public static String ADD_OFFER_URL = OFFER_CONTROLLER_URL + "joboffer";

    @GET(GET_ALL_OFFERS_URL)
    Call<ArrayList<ModelOffer>> getAllOffers();
}
