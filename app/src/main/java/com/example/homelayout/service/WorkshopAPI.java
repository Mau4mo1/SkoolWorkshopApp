package com.example.homelayout.service;

import com.example.homelayout.domain.WorkshopPictureObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WorkshopAPI {

    @GET("workshop")
    Call<WorkshopsAPIResponse> loadAllWorkshops();

    @GET("workshop/{workshopId}/pictures")
    Call<WorkshopPictureResponse> loadPictureWorkshops(@Path("workshopId") int id);
}
