package com.example.homelayout.domain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.Base64;

public class BlobObject {
    @SerializedName("type")
    private String type;
    @SerializedName("data")
    private byte[] data;


    public BlobObject(String type, byte[] data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Bitmap convertBlobIntoImage() throws SQLException {
        Bitmap bmp = BitmapFactory.decodeByteArray(data,0, data.length);
        return bmp;
    }
}
