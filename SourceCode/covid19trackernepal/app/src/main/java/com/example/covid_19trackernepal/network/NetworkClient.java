package com.example.covid_19trackernepal.network;


import com.example.covid_19trackernepal.model.HospitalReceiveParameters;
import com.example.covid_19trackernepal.model.NepalCovidUpdatesReceiveParameters;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.example.covid_19trackernepal.model.WorldCovidUpdatesReceiveParameters;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface NetworkClient {

    @GET("news")
    Call<NewsReceiveParameters> getCovidNews();

    @GET("hospitals")
    Call<HospitalReceiveParameters> getCovidHospital();

    @GET("data/nepal")
    Call<NepalCovidUpdatesReceiveParameters> getCovidNepalUpdates();

    @GET("world")
    Call<WorldCovidUpdatesReceiveParameters> getCovidWorldUpdates();

}
