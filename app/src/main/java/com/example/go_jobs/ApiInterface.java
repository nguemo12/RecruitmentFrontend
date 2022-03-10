package com.example.go_jobs;

import android.util.Log;

import com.example.go_jobs.pojo.ModelApplicant;
import com.example.go_jobs.pojo.ModelOffer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    //    http://localhost:14484/RecruitmentPlatformBackend/webresources/offercontroller/listeoffer
    public static String OFFER_CONTROLLER_URL = "offercontroller/";
    public static String JOBAPPLICATION_CONTROLLER_URL = "jobapplicationcontroller/";
    public static String JOBAPPLICANT_CONTROLLER_URL = "jobapplicant/";

    public static String GET_ALL_OFFERS_URL = OFFER_CONTROLLER_URL + "listeoffer";
    public static String ADD_OFFER_URL = OFFER_CONTROLLER_URL + "joboffer";
    public static String ADD_APPLICANT_URL = JOBAPPLICANT_CONTROLLER_URL + "applicant";

    @GET(GET_ALL_OFFERS_URL)
    Call<ArrayList<ModelOffer>> getAllOffers();
    @POST(ADD_APPLICANT_URL)
    Call<ModelApplicant> addApplicant(@Body ModelApplicant applicant);
}
