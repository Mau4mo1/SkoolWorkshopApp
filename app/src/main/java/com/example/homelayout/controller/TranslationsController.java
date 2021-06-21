package com.example.homelayout.controller;

import android.util.Log;

import com.example.homelayout.domain.TranslationsObject;
import com.example.homelayout.domain.WorkshopsObject;
import com.example.homelayout.service.TranslationsAPIResponse;
import com.example.homelayout.service.WorkshopAPI;
import com.example.homelayout.service.WorkshopsAPIResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslationsController implements Callback<TranslationsAPIResponse> {
    public static final String BASE_URL = "https://skool-workshop.herokuapp.com/api/v1/";
    private final String TAG = this.getClass().getSimpleName();
    private final Retrofit retrofit;
    private final Gson gson;
    private WorkshopAPI workshopAPI;
    private WorkshopsObject workshopsObject;
    private String usedMethod;
    private TranslationsController.TranslationsControllerListener listener;

    public TranslationsController(TranslationsController.TranslationsControllerListener listener) {
        this.listener = listener;

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        workshopAPI = retrofit.create(WorkshopAPI.class);
    }

    public void loadTranslations(int id, WorkshopsObject workshopsObject){
        usedMethod = "loadTranslations";
        this.workshopsObject = workshopsObject;
        Call<TranslationsAPIResponse> call = workshopAPI.loadTranslations(id);
        Log.d(TAG, "loadTranslations called");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<TranslationsAPIResponse> call, Response<TranslationsAPIResponse> response) {
        Log.d(TAG, "onResponse() - statuscode: " + response.code());

        if(response.isSuccessful()) {
            Log.d(TAG, "response: " + response.body());

            // Deserialization
            ArrayList<TranslationsObject> translationsObjectsList =
                    (ArrayList<TranslationsObject>) response.body().getResults();

                workshopsObject.setTranslationsObjects(translationsObjectsList);
            try {
                listener.onTranslationsAvailable(workshopsObject);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            Log.e(TAG, "Not successful! Message: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<TranslationsAPIResponse> call, Throwable t) {
        Log.e(TAG, "onFailure - " + t.getMessage());
    }

    public interface TranslationsControllerListener {
        void onTranslationsAvailable(WorkshopsObject workshopsObject) throws SQLException;
    }
}
