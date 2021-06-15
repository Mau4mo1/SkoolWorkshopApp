package com.example.homelayout.logic;

import android.util.Log;

import com.example.homelayout.domain.Workshops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CalculatePrices {
    private static final String TAG = CalculatePrices.class.getSimpleName();
    private static final int START_FEE = 25;
    private static final double COST_PER_MINUTE_WORKSHOPS = 2.5;
    private static final double COST_PER_MINUTE_CULTUREDAY = 2.325;
    private static final double MATERIAL_COST = 7.5;
    private int participants = 0;
    private int rounds = 0;
    private int minutes = 0;
    private int amountOfWorkshops = 0;
    private int participantsGraffitiOrTshirtDesign = 0;

    public CalculatePrices() {

    }
    public double getWorkshopCalc(Workshops workshop, HashMap<String, Integer> values) {
        switch (workshop) {
            case Graffiti:
            case TshirtOntwerpen:
                return materialCostsIncluded(values);
            case Photoshop:
            case Videoclip:
            case Vloggen:
                return minimalNinetyMinutes(values);
            default:
                return normalCalculation(values);
        }
    }

    public double normalCalculation(HashMap values) {
        double totalAmount = 0;

        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("rounds")){
                rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                minutes = (int) pair.getValue();
            }
        }
        totalAmount = (double) (START_FEE + rounds * (minutes * COST_PER_MINUTE_WORKSHOPS));
        Log.d(TAG, "The total amount is: " + totalAmount);
        return totalAmount;
    }

    public double minimalNinetyMinutes(HashMap values) {
        double totalAmount = 0;
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("rounds")){
                rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                minutes = (int) pair.getValue();
            }
        }
        totalAmount = (double) (START_FEE + rounds * (minutes * COST_PER_MINUTE_WORKSHOPS));
        System.out.println(totalAmount);
        return totalAmount;
    }

    public double materialCostsIncluded(HashMap values) {
        double totalAmount = 0;
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("participants")){
                participants = (int) pair.getValue();
            }
            if(pair.getKey().equals("rounds")){
                rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                minutes = (int) pair.getValue();
            }
        }
        totalAmount = (double) (START_FEE + rounds * (minutes * COST_PER_MINUTE_WORKSHOPS) + participants * MATERIAL_COST);
        System.out.println(totalAmount);
        return totalAmount;
    }

    public double calculateCultureday(HashMap values, ArrayList<Workshops> workshops){
        double totalAmount = 0;

        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getKey().equals("participants")){
                participants = (int) pair.getValue();
            }
            if(pair.getKey().equals("workshops")){
                amountOfWorkshops = (int) pair.getValue();
            }
            if(pair.getKey().equals("participantsGraffitiOrTshirtDesign")){
                participantsGraffitiOrTshirtDesign = (int) pair.getValue();
            }
            if(pair.getKey().equals("rounds")){
                rounds = (int) pair.getValue();
            }
            if(pair.getKey().equals("minutes")){
                minutes = (int) pair.getValue();
            }
        }
        totalAmount = (double) (amountOfWorkshops * rounds * (minutes * COST_PER_MINUTE_CULTUREDAY));

        for(Workshops i : workshops){
            if(i.equals(Workshops.Graffiti)){
                    totalAmount = totalAmount + (participantsGraffitiOrTshirtDesign * MATERIAL_COST);
                }else if(i.equals(Workshops.TshirtOntwerpen)){
                if(participantsGraffitiOrTshirtDesign != 0) {
                    totalAmount = totalAmount + (participantsGraffitiOrTshirtDesign * MATERIAL_COST);
                }
            }
        }
        return totalAmount;
    }

    public boolean checkIfTotalAmountIsAboveMinimalOneHundredSeventyFive(double totalAmount){
        if(totalAmount >= 175.0){
            return true;
        }
         Log.d(TAG, "The total amount should be at least 175");
        return false;
    }
    public boolean checkIfTotalAmountIsAboveMinimalTwoHundredFifty(double totalAmount){
        if(totalAmount >= 250.0){
            return true;
        }
         Log.d(TAG, "The total amount should be at least 250");
        return false;
    }
}
