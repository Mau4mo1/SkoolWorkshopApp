package com.example.homelayout.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TranslationsObject  implements Serializable {
    @SerializedName("Translation")
    private String translation;
    @SerializedName("Culture")
    private String culture;

    public TranslationsObject(String translation, String culture) {
        this.translation = translation;
        this.culture = culture;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }
}
