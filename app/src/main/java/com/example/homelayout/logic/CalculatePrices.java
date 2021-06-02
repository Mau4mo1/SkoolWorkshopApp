package com.example.homelayout.logic;

import android.util.Log;

import com.example.homelayout.domain.Workshops;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CalculatePrices {
    private static final String TAG = CalculatePrices.class.getSimpleName();
    private static final int START_FEE = 25;
    private static final double COST_PER_MINUTE = 2.5;
    private static final double MATERIAL_COST = 7.5;
    private int participants = 0;
    private int rounds = 0;
    private int minutes = 0;

    public void getWorkshop(Workshops workshop, HashMap<String, Integer> values) {
        switch (workshop) {
            case Graffiti:
                materialCostsIncluded(values);
            case TshirtOntwerpen:
                materialCostsIncluded(values);
            case Photoshop:
                minimalNinetyMinutes(values);
            case Vloggen:
                minimalNinetyMinutes(values);
            case Videoclip:
                minimalNinetyMinutes(values);
            default:
                normalCalculation(values);
        }
    }

    private int normalCalculation(HashMap values) {
        int totalAmount = 0;
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("rounds")){
                this.rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                this.minutes = (int) pair.getValue();
            }
        }
        totalAmount = (int) (START_FEE + rounds * (minutes * COST_PER_MINUTE));
        System.out.println(totalAmount);
        return totalAmount;
    }

    private int minimalNinetyMinutes(HashMap values) {
        int totalAmount = 0;
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("rounds")){
                this.rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                this.minutes = (int) pair.getValue();
            }
        }
        totalAmount = (int) (START_FEE + this.rounds * (this.minutes * COST_PER_MINUTE) + this.participants * MATERIAL_COST);
        System.out.println(totalAmount);
        return totalAmount;
    }

    private int materialCostsIncluded(HashMap values) {
        int totalAmount = 0;
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("participants")){
                this.participants = (int) pair.getValue();
            }
            if(pair.getKey().equals("rounds")){
                this.rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                this.minutes = (int) pair.getValue();
            }
        }
        totalAmount = (int) (START_FEE + this.rounds * (this.minutes * COST_PER_MINUTE) + this.participants * MATERIAL_COST);
        System.out.println(totalAmount);
        if(checkIfTotalAmountIsAboveMinimalOneHundredSeventyFive(totalAmount)){
            Log.d(TAG, "The total amount is above 175");
        }
        return totalAmount;
    }

    private boolean checkIfTotalAmountIsAboveMinimalOneHundredSeventyFive(int totalAmount){
        if(totalAmount >= 175){
            return true;
        }
        Log.d(TAG, "The total amount should be at least 175");
        return false;
    }
    private boolean checkIfTotalAmountIsAboveMinimalTwoHundredFifty(int totalAmount){
        if(totalAmount >= 250){
            return true;
        }
        Log.d(TAG, "The total amount should be at least 250");
        return false;
    }
}
