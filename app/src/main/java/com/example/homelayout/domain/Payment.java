package com.example.homelayout.domain;

import java.util.Date;

public class Payment {
    private String dienst;
    private int rondes;
    private int minuten;
    private int totaleMinuten;
    private String tijdschema;
    private String leerniveau;
    private String datum;
    private double prijs;

    public Payment(String dienst, int rondes, int minuten, String tijdschema, String leerniveau, String datum, double prijs) {
        this.dienst = dienst;
        this.rondes = rondes;
        this.minuten = minuten;
        this.totaleMinuten = rondes * minuten;
        this.tijdschema = tijdschema;
        this.leerniveau = leerniveau;
        this.datum = datum;
        this.prijs = prijs;
    }

    public int getTotaleMinuten() {
        return totaleMinuten;
    }

    public void setTotaleMinuten(int totaleMinuten) {
        this.totaleMinuten = totaleMinuten;
    }

    public String getDienst() {
        return dienst;
    }

    public void setDienst(String dienst) {
        this.dienst = dienst;
    }

    public int getRondes() {
        return rondes;
    }

    public void setRondes(int rondes) {
        this.rondes = rondes;
    }

    public int getMinuten() {
        return minuten;
    }

    public void setMinuten(int minuten) {
        this.minuten = minuten;
    }

    public String getTijdschema() {
        return tijdschema;
    }

    public void setTijdschema(String tijdschema) {
        this.tijdschema = tijdschema;
    }

    public String getLeerniveau() {
        return leerniveau;
    }

    public void setLeerniveau(String leerniveau) {
        this.leerniveau = leerniveau;
    }

    public String getDatum() { return datum; }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
