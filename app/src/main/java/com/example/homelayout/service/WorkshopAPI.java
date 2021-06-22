package com.example.homelayout.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WorkshopAPI {

    @GET("workshop")
    Call<WorkshopsAPIResponse> loadAllWorkshops();

    @GET("category/workshops")
    Call<WorkshopsAPIResponse> loadWorkshopsByCategory(@Query("category") String category);

    @GET("workshop/{workshopId}/translations")
    Call<TranslationsAPIResponse> loadTranslations(@Path("workshopId") int workshopId);

    @GET("")
    Call<WorkshopsAPIResponse> loadPopularWorkshops();
}
