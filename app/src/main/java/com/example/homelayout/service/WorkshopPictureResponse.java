package com.example.homelayout.service;

import com.example.homelayout.domain.WorkshopPictureObject;


import java.util.List;

public class WorkshopPictureResponse {
    private List<WorkshopPictureObject> result;

    public WorkshopPictureResponse(int page, List<WorkshopPictureObject> results) {
        this.result = results;
    }

    public  List<WorkshopPictureObject> getResults() {
        return result;
    }

    public void setResults(List<WorkshopPictureObject> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WorkshopPictureObject{" +
                ", results=" + result +
                '}';
    }
}
