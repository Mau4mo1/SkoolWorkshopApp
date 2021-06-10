package com.example.homelayout.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WorkshopAPI {

    @GET("workshop")
    Call<WorkshopsAPIResponse> loadAllWorkshops();

    @GET("workshop/{workshopId}")
    Call<WorkshopsAPIResponse> loadInfoAboutWorkshop(@Path("workshopId") int id);

}
