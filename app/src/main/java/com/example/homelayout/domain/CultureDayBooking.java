package com.example.homelayout.domain;

import java.util.List;

public class CultureDayBooking {

    private int rounds;
    private int workshopsPerRound;
    private int minutesPerRound;
    private int totalMinutes;
    private int participants;
    private List<String> workshops;
    private String timeTable;
    private String learningLevel;
    private String date;
    private double price;

    public CultureDayBooking(int rondes, int workshopsPerRound, int minutesPerRound, int participants, List<String> workshops, String timeTable, String learningLevel, String date, double price) {
        this.rounds = rondes;
        this.workshopsPerRound = workshopsPerRound;
        this.minutesPerRound = minutesPerRound;
        this.totalMinutes = rondes * minutesPerRound;
        this.participants = participants;
        this.workshops = workshops;
        this.timeTable = timeTable;
        this.learningLevel = learningLevel;
        this.date = date;
        this.price = price;
    }

    public int getRondes() { return rounds; }

    public void setRondes(int rondes) { this.rounds = rondes; }

    public int getWorkshopsPerRound() { return workshopsPerRound; }

    public void setWorkshopsPerRound(int workshopsPerRound) { this.workshopsPerRound = workshopsPerRound; }

    public int getMinutesPerRound() { return minutesPerRound; }

    public void setMinutesPerRound(int minutesPerRound) { this.minutesPerRound = minutesPerRound; }

    public int getTotalMinutes() { return totalMinutes; }

    public void setTotalMinutes(int totalMinutes) { this.totalMinutes = totalMinutes; }

    public int getParticipants() { return participants; }

    public void setParticipants(int participants) { this.participants = participants; }

    public List<String> getWorkshops() { return workshops; }

    public void setWorkshops(List<String> workshops) { this.workshops = workshops; }

    public String getTimeTable() { return timeTable; }

    public void setTimeTable(String timeTable) { this.timeTable = timeTable; }

    public String getLearningLevel() { return learningLevel; }

    public void setLearningLevel(String learningLevel) { this.learningLevel = learningLevel; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
