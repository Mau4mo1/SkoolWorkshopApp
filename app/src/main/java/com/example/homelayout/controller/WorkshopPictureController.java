package com.example.homelayout.controller;

import android.util.Log;

import com.example.homelayout.MainActivity;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.WorkshopsObject;
import com.example.homelayout.service.WorkshopAPI;
import com.example.homelayout.service.WorkshopPictureResponse;
import com.example.homelayout.service.WorkshopsAPIResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkshopPictureController  {
    public static final String BASE_URL = "https://skool-workshop.herokuapp.com/api/v1/";
    private final String TAG = this.getClass().getSimpleName();
    private final Retrofit retrofit;
    private final Gson gson;
    private WorkshopAPI workshopAPI;
    private String usedMethod;
    private WorkshopPictureControllerListener listener;

    public WorkshopPictureController(WorkshopPictureControllerListener listener) {
        this.listener = listener;

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        workshopAPI = retrofit.create(WorkshopAPI.class);
    }

    public void loadPictureWorkshops(int id) {
        usedMethod = "loadPictureWorkshops";
        Call<WorkshopPictureResponse> call = workshopAPI.loadPictureWorkshops(id);
        call.enqueue(new Callback<WorkshopPictureResponse>() {
            @Override
            public void onResponse(Call<WorkshopPictureResponse> call, Response<WorkshopPictureResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response: " + response.body());

                    // Deserialization
                    if (usedMethod.equals("loadPictureWorkshops")) {
                        assert response.body() != null;
                        List<WorkshopPictureObject> workshopsPicturesObjectList =
                                (List<WorkshopPictureObject>) response.body().getResults();
                        listener.onWorkshopPicturesAvailable(workshopsPicturesObjectList);
                    } else {
                        Log.e(TAG, "Not successful! Message: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<WorkshopPictureResponse> call, Throwable t) {
                Log.e(TAG, "onFailure - " + t.getMessage());
            }
        });
    }


    public interface WorkshopPictureControllerListener {
        void onError(String message);
        void onWorkshopPicturesAvailable(List<WorkshopPictureObject> workshopPictureObjectList);
    }
}
