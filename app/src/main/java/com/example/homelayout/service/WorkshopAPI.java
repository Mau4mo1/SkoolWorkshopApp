package com.example.homelayout.service;
import com.example.homelayout.domain.WorkshopsObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WorkshopAPI {

    @GET("/api/workshop")
    Call<WorkshopsObject> loadTrendingMoviesByWeek(@Query("page") int pageNr);
}
