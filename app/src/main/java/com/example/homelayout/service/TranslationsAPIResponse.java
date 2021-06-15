package com.example.homelayout.service;

import com.example.homelayout.domain.TranslationsObject;
import com.example.homelayout.domain.WorkshopsObject;

import java.util.List;

public class TranslationsAPIResponse {
    private List<TranslationsObject> result;

    public TranslationsAPIResponse(int page, List<TranslationsObject> results) {
        this.result = results;
    }

    public  List<TranslationsObject> getResults() {
        return result;
    }

    public void setResults(List<TranslationsObject> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TranslationsAPIResponse{" +
                ", results=" + result +
                '}';
    }

}
