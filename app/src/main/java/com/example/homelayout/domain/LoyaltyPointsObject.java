package com.example.homelayout.domain;

public class LoyaltyPointsObject {
    private String date;
    private String action;
    private int orderNumber;
    private int loyaltyPoints;

    public LoyaltyPointsObject(String date, String action, int orderNumber, int loyaltyPoints) {
        this.date = date;
        this.action = action;
        this.orderNumber = orderNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getDate() {
        return date;
    }

    public String getAction() {
        return action;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}
