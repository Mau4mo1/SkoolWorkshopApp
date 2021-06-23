package com.example.homelayout.logic;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MollieAPI extends AsyncTask<String, Void, String> {
    private String price;
    private String description;
    private String jsonLink;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public MollieAPI(String price, String description) {
        this.price = price;
        this.description = description;
    }

    public String activateAPI(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://skool-workshop.herokuapp.com/api/v1/payment/create").post(RequestBody.create(JSON, getJsonString(price,description))).build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            Headers responseHeaders = response.headers();
            for(int i = 0; i < responseHeaders.size(); i++){
                Log.d("tag",  responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getJsonString(String price, String description){
        String jsonInputString = null;
        try{
            jsonInputString = new JSONObject()
                    .put("money", price)
                    .put("description", description)
                    .toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonInputString;
    }

    private String convertJson(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            String link = jsonObject.getJSONObject("message").getString("href");
            return link;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected String doInBackground(String... strings) {
        return convertJson(activateAPI());
    }
}
