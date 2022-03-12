package com.example.go_jobs;

import android.util.Log;

import com.example.go_jobs.pojo.ModelApplicant;
import com.example.go_jobs.pojo.ModelCategory;
import com.example.go_jobs.pojo.ModelCompany;
import com.example.go_jobs.pojo.ModelJobApplication;
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
    public static String JOBAPPLICANT_CONTROLLER_URL = "applicantcontroller/";
    public static String COMPANY_CONTROLLER_URL="companycontroller/";
    public static String CATEGORY_CONTROLLER_URL="categorycontroller/";

    public static String GET_ALL_OFFERS_URL = OFFER_CONTROLLER_URL + "listeoffer";
    public static String ADD_OFFER_URL = OFFER_CONTROLLER_URL + "joboffer";
    public static String ADD_COMPANY_URL = COMPANY_CONTROLLER_URL +"company";
    public static String ADD_APPLICANT_URL = JOBAPPLICANT_CONTROLLER_URL + "applicant";
    public static String ADD_JOBAPPLICATION_URL= JOBAPPLICATION_CONTROLLER_URL + "jobapply";
    public static String ADD_CATEGORY_URL = CATEGORY_CONTROLLER_URL + "category";
    public static String GET_ALL_COMPANY_URL =COMPANY_CONTROLLER_URL + "listecompany";
    public static String GET_ALL_CATEGORY_URL = CATEGORY_CONTROLLER_URL + "listecategory";
    public static String GET_ALL_APPLICANT_URL = JOBAPPLICANT_CONTROLLER_URL + "listeapplicant";
    public static String GET_JOBAPPLICATION_URL = JOBAPPLICATION_CONTROLLER_URL + "listeapply";


    @GET(GET_ALL_OFFERS_URL)
    Call<ArrayList<ModelOffer>> getAllOffers();
    @POST(ADD_APPLICANT_URL)
    Call<ModelApplicant> addApplicant(@Body ModelApplicant applicant);
    @POST(ADD_COMPANY_URL)
    Call <ModelCompany> addCompany(@Body ModelCompany company);
    @POST (ADD_OFFER_URL)
    Call<ModelOffer> addOffer(@Body ModelOffer offer);
    @POST (ADD_JOBAPPLICATION_URL)
    Call<ModelJobApplication> addJobapply (@Body ModelJobApplication jobApplication);
    @POST (ADD_CATEGORY_URL)
    Call<ModelCategory> addCategory (@Body ModelCategory modelCategory);
    @GET (GET_ALL_COMPANY_URL)
    Call<ArrayList<ModelCompany>>getAllCompany();
    @GET(GET_ALL_APPLICANT_URL)
    Call<ArrayList<ModelApplicant>>getAllApplicant();
    @GET (GET_JOBAPPLICATION_URL)
    Call<ArrayList<ModelJobApplication>>getAllApplications();
    @GET(GET_ALL_CATEGORY_URL)
    Call<ArrayList<ModelCategory>>getAllCategory();
}
