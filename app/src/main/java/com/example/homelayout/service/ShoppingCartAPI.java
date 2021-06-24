package com.example.homelayout.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShoppingCartAPI {

    @GET("/")
    Call<DistanceAPIResponse> loadDistance(@Query("origins")String origin, @Query("destinations")String destination,@Query("travelMode")String mode, @Query("key") String key);
}
