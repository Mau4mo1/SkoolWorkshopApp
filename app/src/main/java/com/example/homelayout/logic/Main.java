package com.example.homelayout.logic;

import com.example.homelayout.domain.Workshops;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CalculatePrices calculate = new CalculatePrices();
        Workshops workshop = null;
        HashMap<String, Integer> values = new HashMap<>();
        values.put("participants", 25);
        values.put("rounds", 3);
        values.put("minutes", 60);
        calculate.getWorkshopCalc(workshop.DanceFit, values);
    }
}
