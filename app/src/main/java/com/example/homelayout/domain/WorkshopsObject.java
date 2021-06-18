package com.example.homelayout.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WorkshopsObject implements Serializable {
    @SerializedName("Id")
    private int id;
    @SerializedName("Category")
    private String category;
    @SerializedName("CodeName")
    private String codeName;
    @SerializedName("ShortDesc")
    private String shortDesc;
    @SerializedName("NeedsApp")
    private boolean needsApp;
    @SerializedName("__Pictures__")
    private WorkshopPictureObject[] pictureObject;
    private List<TranslationsObject> translationsObjects;
    private Workshops workshops;
    private String formattedName;

    public WorkshopsObject(int id, String category, String codeName, String shortDesc, boolean needsApp, WorkshopPictureObject[] pictureObject) {
        this.id = id;
        this.category = category;
        this.codeName = codeName;
        this.shortDesc = shortDesc;
        this.needsApp = needsApp;
        this.pictureObject = pictureObject;
    }

    public Workshops getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Workshops workshops) {
        this.workshops = workshops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public WorkshopPictureObject[] getPictureObject() {
        return pictureObject;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public void setPictureObject(WorkshopPictureObject[] pictureObject) {
        this.pictureObject = pictureObject;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public boolean isNeedsApp() {
        return needsApp;
    }

    public void setNeedsApp(boolean needsApp) {
        this.needsApp = needsApp;
    }

    public List<TranslationsObject> getTranslationsObjects() {
        return translationsObjects;
    }

    public void setTranslationsObjects(List<TranslationsObject> translationsObjects) {
        this.translationsObjects = translationsObjects;
    }
}
