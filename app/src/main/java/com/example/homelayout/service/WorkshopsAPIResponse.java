package com.example.homelayout.service;

import com.example.homelayout.domain.WorkshopsObject;

import java.util.List;

public class WorkshopsAPIResponse {
    private int page;
    private List<WorkshopsObject> results;

    public WorkshopsAPIResponse(int page, List<WorkshopsObject> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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
                "page=" + page +
                ", results=" + results +
                '}';
    }

}
