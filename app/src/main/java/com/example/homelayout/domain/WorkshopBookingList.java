package com.example.homelayout.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WorkshopBookingList {
    public ArrayList bookings;
    public WorkshopBookingList(){
        bookings = new ArrayList();

    }
    public void addWorkshop(WorkshopBooking workshop){
        bookings.add(workshop);
        Log.d("De array bestaat wel", workshop.getDienst());

    }
    public ArrayList getWorkshops(){
        return bookings;
    }
}
