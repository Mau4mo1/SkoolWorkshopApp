package com.example.homelayout.domain.distancecalc;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class DistanceResult {
    @SerializedName("resourceSets")
    private ResourceSets[] resourceSets;

    public DistanceResult(ResourceSets[] resourceSets) {
        this.resourceSets = resourceSets;
    }

    public ResourceSets[] getResourceSets() {
        return resourceSets;
    }
}
