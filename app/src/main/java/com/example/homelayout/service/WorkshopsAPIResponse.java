package com.example.homelayout.service;

import android.util.Log;

import com.example.homelayout.domain.WorkshopsObject;

import java.util.List;

public class WorkshopsAPIResponse {
    private List<WorkshopsObject> result;

    public WorkshopsAPIResponse(int page, List<WorkshopsObject> results) {
        this.result = results;
    }

    public  List<WorkshopsObject> getResults() {
        Log.d("WorkshopsAPIResponse", "HELLLLL YEAAAAHHHHHHHHHHHHHHHHHHHHHHHHH");
        return result;
    }

    public void setResults(List<WorkshopsObject> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WorkshopsApiResponse{" +
                ", results=" + result +
                '}';
    }
}
