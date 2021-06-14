package com.example.homelayout.controller;

import android.util.Log;

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

public class WorkshopController implements Callback<WorkshopsAPIResponse> {
    public static final String BASE_URL = "https://skool-workshop.herokuapp.com/api/v1/";
    private final String TAG = this.getClass().getSimpleName();
    private final Retrofit retrofit;
    private final Gson gson;
    private WorkshopAPI workshopAPI;
    private String usedMethod;
    private WorkshopsControllerListener listener;


    public WorkshopController(WorkshopsControllerListener listener) {
        this.listener = listener;

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        workshopAPI = retrofit.create(WorkshopAPI.class);
    }

    public void loadAllWorkshops(){
        usedMethod = "loadAllWorkshops";
        Call<WorkshopsAPIResponse> call = workshopAPI.loadAllWorkshops();
        Log.d(TAG, "loadAllWorkshops called");
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<WorkshopsAPIResponse> call, Response<WorkshopsAPIResponse> response) {
        Log.d(TAG, "onResponse() - statuscode: " + response.code());

        if(response.isSuccessful()) {
            Log.d(TAG, "response: " + response.body());

            // Deserialization
            if(usedMethod.equals("loadAllWorkshops")){
                assert response.body() != null;
                ArrayList<WorkshopsObject> workshopsObjectList =
                        (ArrayList<WorkshopsObject>) response.body().getResults();
                listener.onWorkshopsAvailable(workshopsObjectList);
            }
        } else {
            Log.e(TAG, "Not successful! Message: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<WorkshopsAPIResponse> call, Throwable t) {
        Log.e(TAG, "onFailure - " + t.getMessage());
    }

    public interface WorkshopsControllerListener {
        void onWorkshopsAvailable(List<WorkshopsObject> workshopsObjectList);
        void onError (String message);
    }
}
