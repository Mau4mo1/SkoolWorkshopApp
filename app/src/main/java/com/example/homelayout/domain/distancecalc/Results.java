package com.example.homelayout.domain.distancecalc;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("travelDistance")
    private double travelDistance;

    public Results(double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public double getTravelDistance() {
        return travelDistance;
    }
}
