package com.example.homelayout.service;

import com.example.homelayout.domain.distancecalc.DistanceResult;

public class DistanceAPIResponse {

    private DistanceResult result;

    public DistanceAPIResponse(int page, DistanceResult result) {
        this.result = result;
    }
    public  DistanceResult getResult() {
        return result;
    }
    @Override
    public String toString() {
        return null;
    }
}