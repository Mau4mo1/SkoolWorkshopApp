package com.example.homelayout.service;

import com.example.homelayout.domain.WorkshopPictureObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WorkshopAPI {
    String standardUrl = "https://dev.virtualearth.net/REST/v1/Routes/DistanceMatrix";

    @GET("workshop")
    Call<WorkshopsAPIResponse> loadAllWorkshops();

    @GET("category/workshops")
    Call<WorkshopsAPIResponse> loadWorkshopsByCategory(@Query("category") String category);

    @GET("workshop/{workshopId}/translations")
    Call<TranslationsAPIResponse> loadTranslations(@Path("workshopId") int workshopId);

    @GET(standardUrl + "{origins}&destinations=45.5347,-122.6231&travelMode=driving&{key}")
    Call<TranslationsAPIResponse> loadDistance(@Query("origins")String origin, @Query("key") String key);


}
