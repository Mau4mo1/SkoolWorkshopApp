package com.example.homelayout.logic;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class NewsletterAPI extends AsyncTask<String,Void,String> {
    public NewsletterAPI() throws IOException {

    }

    @Override
    protected String doInBackground(String... strings) {
        String send = null;
        try {
            send = APICall();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return send;
    }


    private String APICall() throws IOException {
        String recovered = null;
        try{
            URL url = new URL("https://api.covid19api.com/summary");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if(responsecode != 200){
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            }else{
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                while(scanner.hasNext()){
                    inline += scanner.nextLine();
                }
                scanner.close();
                JSONObject obj = new JSONObject(inline);
                recovered = obj.getJSONObject("Global").getString("TotalRecovered");
                Log.d("NewsletterAPI","Total Recovered: " + recovered);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return recovered;
    }

}
