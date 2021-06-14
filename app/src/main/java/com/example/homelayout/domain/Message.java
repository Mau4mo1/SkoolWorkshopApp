package com.example.homelayout.domain;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Message implements Serializable {
    private int id;
    private String title;
    private String messageText;

    public Message(int id, String title, String messageText){
        this.id = id;
        this.title = title;
        this.messageText = messageText;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getMessageText(){
        return this.messageText;
    }

    public void setText(String text){
        this.title = text;
    }

    @NonNull
    @Override
    public String toString() {
        return "" + this.getId() + " " + this.getTitle() + " " + this.getMessageText();
    }
}
