package com.example.homelayout.logic;

import com.example.homelayout.domain.Workshops;

import java.util.ArrayList;
import java.util.Date;

public class CulturedayBookingInfo {
    private int rounds;
    private int workshops_per_round;
    private int workshop_minutes;
    private int particepants;
    private String learning_level;
    private ArrayList<Workshops> workshops;
    private int price;
    private String time_scheme;
    private Date date;
    private boolean registration_system;

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
    public int getRounds() {
        return this.rounds;
    }

    public void setWorkshops_per_round(int workshops_per_round) {
        this.workshops_per_round = workshops_per_round;
    }
    public int getWorkshops_per_round() {
        return this.workshops_per_round;
    }

    public void setWorkshop_minutes(int workshop_minutes) {
        this.workshop_minutes = workshop_minutes;
    }
    public int getWorkshop_minutes() {
        return this.workshop_minutes;
    }

    public void setParticepants(int particepants) {
        this.particepants = particepants;
    }
    public int getParticepants() {
        return this.particepants;
    }

    public void setWorkshops(ArrayList<Workshops> workshops) {
        this.workshops = workshops;
    }
    public ArrayList<Workshops> getWorkshops() {
        return this.workshops;
    }

    public void setRegistration(boolean registration) {
        this.registration_system = registration;
    }
    public boolean getRegistration() {
        return this.registration_system;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }

    public void setTimescheme(String scheme){
        this.time_scheme = scheme;
    }
    public String getTimescheme(){
        return this.time_scheme;
    }

    public void setLearninglevel(String level){
        this.learning_level = level;
    }
    public String getLearninglevel(){
        return learning_level;
    }
}
