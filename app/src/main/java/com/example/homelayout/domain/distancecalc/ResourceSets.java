package com.example.homelayout.domain.distancecalc;

import com.google.gson.annotations.SerializedName;

import javax.mail.Quota;

public class ResourceSets {
    @SerializedName("resources")
    private Resources[] resources;

    public ResourceSets(Resources[] resources) {
        this.resources = resources;
    }

    public Resources[] getResources() {
        return resources;
    }
}
