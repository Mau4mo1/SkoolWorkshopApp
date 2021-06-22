package com.example.homelayout.controller;

import android.net.sip.SipSession;
import android.util.Log;

import com.example.homelayout.domain.distancecalc.DistanceResult;
import com.example.homelayout.service.DistanceAPIResponse;
import com.example.homelayout.service.ShoppingCartAPI;
import com.example.homelayout.ui.shoppingcart.ShoppingCartFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShoppingCartController implements Callback<DistanceAPIResponse> {
    private final String TAG = this.getClass().getSimpleName();
    private final Retrofit retrofit;
    private final Gson gson;
    private DistanceListener listener;
    private static final String KEY = "AoiglpsMr0uBDMsl_11AhIMAh3_ddgeNurKpx5Yv5WRU0Zrt4zDgkjSPIWXE3LNw";
    private static final String BASE_URL = "https://dev.virtualearth.net/REST/v1/Routes/DistanceMatrix/";
    private ShoppingCartAPI shoppingCartAPI;

    public ShoppingCartController(DistanceListener listener) {
        this.listener = listener;
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        shoppingCartAPI = retrofit.create(ShoppingCartAPI.class);
    }

    public void loadDistance(String origin){
        Call<DistanceAPIResponse> call = shoppingCartAPI.loadDistance(origin, "45.5347,-122.6231", "driving", KEY);
        Log.d(TAG, "loadDistance called");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<DistanceAPIResponse> call, Response<DistanceAPIResponse> response) {
        Log.d(TAG, "onResponse() " + response.body());
        if(response.isSuccessful()) {
            Log.d(TAG, "response: " + response.body());
            // Deserialization
            DistanceResult responseObject = response.body().getResult();

            listener.onDistanceReady(responseObject);
        } else {
            Log.e(TAG, "Not successful! Message: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<DistanceAPIResponse> call, Throwable t) {
        Log.d(TAG, t.getMessage());
    }

    public interface DistanceListener {
        void onDistanceReady(DistanceResult result);
    }
}
