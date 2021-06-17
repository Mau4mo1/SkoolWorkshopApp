package com.example.homelayout.domain.distancecalc;

import com.google.gson.annotations.SerializedName;

public class Resources {

    @SerializedName("results")
    private Results[] results;

    public Resources(Results[] results) {
        this.results = results;
    }
    public Results[] getResults() {
        return results;
    }
}
