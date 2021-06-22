package com.example.homelayout.controller;

import android.util.Log;

import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;
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

    public void loadWorkshopsByCategory(String category){
        Call<WorkshopsAPIResponse> call = workshopAPI.loadWorkshopsByCategory(category);
        Log.d(TAG, "loadAllWorkshops called");
        call.enqueue(this);
    }

    public void loadPopularWorkshops(){
        Call<WorkshopsAPIResponse> call = workshopAPI.loadPopularWorkshops();
        Log.d(TAG, "loadPopulairWorkshops called");
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<WorkshopsAPIResponse> call, Response<WorkshopsAPIResponse> response) {
        Log.d(TAG, "onResponse() - statuscode: " + response.code());

        if(response.isSuccessful()) {
            Log.d(TAG, "response: " + response.body());

            // Deserialization
                ArrayList<WorkshopsObject> workshopsObjectList = new ArrayList<>();
                ArrayList<WorkshopsObject> responseObjects =
                        (ArrayList<WorkshopsObject>) response.body().getResults();

                    for(WorkshopsObject i : responseObjects){
                        if(i.getPictureObject().length !=0){
                            workshopsObjectList.add(i);
                        }
                    }
            try {
                setWorkshopEnumAndSetRightName(workshopsObjectList);
                listener.onWorkshopsAvailable(workshopsObjectList);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            Log.e(TAG, "Not successful! Message: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<WorkshopsAPIResponse> call, Throwable t) {
        Log.e(TAG, "onFailure - " + t.getMessage());
    }

    private void setWorkshopEnumAndSetRightName(ArrayList<WorkshopsObject> workshopsObjectList){
        for(WorkshopsObject i : workshopsObjectList){
            switch (i.getCodeName()){
                case "SkoolHiphop":
                    i.setWorkshops(Workshops.Hiphop);
                    i.setFormattedName("Hiphop");
                    break;
                case "SkoolModerneDans":
                    i.setWorkshops(Workshops.ModerneDans);
                    i.setFormattedName("Moderne Dans");
                    break;
                case "SkoolSoapActeren":
                    i.setWorkshops(Workshops.SoapActeren);
                    i.setFormattedName("Soap Acteren");
                    break;
                case "SkoolStageFighting":
                    i.setWorkshops(Workshops.StageFighting);
                    i.setFormattedName("Stage Fighting");
                    break;
                case "SkoolGraffiti":
                    i.setWorkshops(Workshops.Graffiti);
                    i.setFormattedName("Graffiti");
                    break;
                case "SkoolLightGraffiti":
                    i.setWorkshops(Workshops.LightGraffiti);
                    i.setFormattedName("Light Graffiti");
                    break;
                case "SkoolStopMotion":
                    i.setWorkshops(Workshops.StopMotion);
                    i.setFormattedName("Stop Motion");
                    break;
                case "SkoolTshirtOntwerpen":
                    i.setWorkshops(Workshops.TshirtOntwerpen);
                    i.setFormattedName("T-shirt Ontwerpen");
                    break;
                case "SkoolBreakdance":
                    i.setWorkshops(Workshops.Breakdance);
                    i.setFormattedName("Breakdance");
                    break;
                case "SkoolDance-Fit":
                    i.setWorkshops(Workshops.DanceFit);
                    i.setFormattedName("Dance-Fit");
                    break;
                case "SkoolFlashmob":
                    i.setWorkshops(Workshops.Flashmob);
                    i.setFormattedName("Flashmob");
                    break;
                case "SkoolStepping":
                    i.setWorkshops(Workshops.Flashmob);
                    i.setFormattedName("Flashmob");
                    break;
                case "SkoolStreetdance":
                    i.setWorkshops(Workshops.Streetdance);
                    i.setFormattedName("Streetdance");
                    break;
                case "SkoolPhotoshop":
                    i.setWorkshops(Workshops.Photoshop);
                    i.setFormattedName("Photoshop");
                    break;
                case "SkoolVloggen":
                    i.setWorkshops(Workshops.Vloggen);
                    i.setFormattedName("Vloggen");
                    break;
                case "SkoolSmartphoneFotografie":
                    i.setWorkshops(Workshops.Fotografie);
                    i.setFormattedName("Smartphone Fotografie");
                    break;
                case "SkoolVideoclipMaken":
                    i.setWorkshops(Workshops.Videoclip);
                    i.setFormattedName("Videoclip Maken");
                    break;
                case "SkoolGhettoDrums":
                    i.setWorkshops(Workshops.GhettoDrums);
                    i.setFormattedName("Ghetto Drums");
                    break;
                case "SkoolLiveLooping":
                    i.setWorkshops(Workshops.LiveLooping);
                    i.setFormattedName("Live Looping");
                    break;
                case "SkoolPercussie":
                    i.setWorkshops(Workshops.Percurssie);
                    i.setFormattedName("Percurssie");
                    break;
                case "SkoolPopstar":
                    i.setWorkshops(Workshops.Popstar);
                    i.setFormattedName("Popstar");
                    break;
                case "SkoolRap":
                    i.setWorkshops(Workshops.Rap);
                    i.setFormattedName("Rap");
                    break;
                case "SkoolBootcamp":
                    i.setWorkshops(Workshops.Bootcamp);
                    i.setFormattedName("Bootcamp");
                    break;
                case "SkoolCapoeira":
                    i.setWorkshops(Workshops.Capoeira);
                    i.setFormattedName("Capoeira");
                    break;
                case "SkoolFreerunning":
                    i.setWorkshops(Workshops.Freeruning);
                    i.setFormattedName("Freeruning");
                    break;
                case "SkoolKickboksen":
                    i.setWorkshops(Workshops.Kickboksen);
                    i.setFormattedName("Kickboksen");
                    break;
                case "SkoolPannavoetbal":
                    i.setWorkshops(Workshops.Pannavoetbal);
                    i.setFormattedName("");
                    break;
                case "SkoolZelfverdediging":
                    i.setWorkshops(Workshops.Zelfverdedeging);
                    i.setFormattedName("Zelfverdedeging");
                    break;
                case "SkoolTheatersport":
                    i.setWorkshops(Workshops.Theatersport);
                    i.setFormattedName("Theatersport");
                    break;
            }
        }
    }

    public interface WorkshopsControllerListener {
        void onWorkshopsAvailable(List<WorkshopsObject> workshopsObjectList) throws SQLException;
    }
}
