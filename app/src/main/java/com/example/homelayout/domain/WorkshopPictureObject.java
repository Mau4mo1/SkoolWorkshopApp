package com.example.homelayout.domain;

import com.google.gson.annotations.SerializedName;

public class WorkshopPictureObject {
    @SerializedName("Id")
    private int id;
    @SerializedName("Rubric")
    private String rubric;
    @SerializedName("FileName")
    private String fileName;
    @SerializedName("ContentType")
    private String contentType;
    @SerializedName("Blob")
    private BlobObject blob;
    @SerializedName("ThumbNailName")
    private String thumbNailName;


    public WorkshopPictureObject(int id, String rubric, String fileName, String contentType, BlobObject blob, String thumbNailName) {
        this.id = id;
        this.rubric = rubric;
        this.fileName = fileName;
        this.contentType = contentType;
        this.blob = blob;
        this.thumbNailName = thumbNailName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRubric() {
        return rubric;
    }

    public void setRubric(String rubric) {
        this.rubric = rubric;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public BlobObject getBlob() {
        return blob;
    }

    public void setBlob(BlobObject blob) {
        this.blob = blob;
    }

    public String getThumbNailName() {
        return thumbNailName;
    }

    public void setThumbNailName(String thumbNailName) {
        this.thumbNailName = thumbNailName;
    }
}
