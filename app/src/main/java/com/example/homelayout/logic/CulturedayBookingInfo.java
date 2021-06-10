package com.example.homelayout.logic;

import com.example.homelayout.domain.Workshops;

import java.util.ArrayList;

public class CulturedayBookingInfo {
    private int rounds;
    private int workshops_per_round;
    private int workshop_minutes;
    private int particepants;
    private ArrayList<Workshops> workshops;

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
}
