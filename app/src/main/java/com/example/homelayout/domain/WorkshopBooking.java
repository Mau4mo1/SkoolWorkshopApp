package com.example.homelayout.domain;

public class WorkshopBooking {
    private String service;
    private int rounds;
    private int minutes;
    private int totalMinutes;
    private String timeTable;
    private String learningLevel;
    private String date;
    private double price;

    public WorkshopBooking(String service, int rounds, int minutes, String timeTable, String learningLevel, String date, double price) {
        this.service = service;
        this.rounds = rounds;
        this.minutes = minutes;
        this.totalMinutes = rounds * minutes;
        this.timeTable = timeTable;
        this.learningLevel = learningLevel;
        this.date = date;
        this.price = price;
    }
    public void setPositon(){

    }
    public int getPositon()
    {
       return 0;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public String getLearningLevel() {
        return learningLevel;
    }

    public void setLearningLevel(String learningLevel) {
        this.learningLevel = learningLevel;
    }

    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
