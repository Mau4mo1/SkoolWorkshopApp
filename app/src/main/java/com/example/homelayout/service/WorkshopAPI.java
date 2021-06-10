package com.example.homelayout.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WorkshopAPI {

    @GET("workshop")
    Call<WorkshopsAPIResponse> loadAllWorkshops();
}
