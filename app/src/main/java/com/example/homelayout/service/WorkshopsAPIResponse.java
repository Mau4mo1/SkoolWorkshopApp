package com.example.homelayout.service;

import com.example.homelayout.domain.WorkshopsObject;

import java.util.List;

public class WorkshopsAPIResponse {
    private List<WorkshopsObject> results;

    public WorkshopsAPIResponse(int page, List<WorkshopsObject> results) {
        this.results = results;
    }

    public  List<WorkshopsObject> getResults() {
        return results;
    }

    public void setResults(List<WorkshopsObject> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "WorkshopsApiResponse{" +
                ", results=" + results +
                '}';
    }

}
