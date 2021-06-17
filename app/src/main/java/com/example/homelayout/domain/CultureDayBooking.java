package com.example.homelayout.domain;

import java.util.Date;
import java.util.List;

public class CultureDayBooking {

    private int rondes;
    private int workshopsPerRonde;
    private int minutenPerRonde;
    private int totaleMinuten;
    private int deelnemers;
    private List<String> workshops;
    private String tijdschema;
    private String leerniveau;
    private String datum;
    private double prijs;

    public CultureDayBooking(int rondes, int workshopsPerRonde, int minutenPerRonde, int deelnemers, List<String> workshops, String tijdschema, String leerniveau, String datum, double prijs) {
        this.rondes = rondes;
        this.workshopsPerRonde = workshopsPerRonde;
        this.minutenPerRonde = minutenPerRonde;
        this.totaleMinuten = rondes * minutenPerRonde;
        this.deelnemers = deelnemers;
        this.workshops = workshops;
        this.tijdschema = tijdschema;
        this.leerniveau = leerniveau;
        this.datum = datum;
        this.prijs = prijs;
    }

    public int getRondes() { return rondes; }

    public void setRondes(int rondes) { this.rondes = rondes; }

    public int getWorkshopsPerRonde() { return workshopsPerRonde; }

    public void setWorkshopsPerRonde(int workshopsPerRonde) { this.workshopsPerRonde = workshopsPerRonde; }

    public int getMinutenPerRonde() { return minutenPerRonde; }

    public void setMinutenPerRonde(int minutenPerRonde) { this.minutenPerRonde = minutenPerRonde; }

    public int getTotaleMinuten() { return totaleMinuten; }

    public void setTotaleMinuten(int totaleMinuten) { this.totaleMinuten = totaleMinuten; }

    public int getDeelnemers() { return deelnemers; }

    public void setDeelnemers(int deelnemers) { this.deelnemers = deelnemers; }

    public List<String> getWorkshops() { return workshops; }

    public void setWorkshops(List<String> workshops) { this.workshops = workshops; }

    public String getTijdschema() { return tijdschema; }

    public void setTijdschema(String tijdschema) { this.tijdschema = tijdschema; }

    public String getLeerniveau() { return leerniveau; }

    public void setLeerniveau(String leerniveau) { this.leerniveau = leerniveau; }

    public String getDatum() { return datum; }

    public void setDatum(String datum) { this.datum = datum; }

    public double getPrijs() { return prijs; }

    public void setPrijs(double prijs) { this.prijs = prijs; }
}
