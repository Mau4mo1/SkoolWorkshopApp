package com.example.homelayout.ui.shoppingcart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.controller.ShoppingCartController;
import com.example.homelayout.domain.CultureDayBooking;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.distancecalc.DistanceResult;
import com.example.homelayout.logic.CulturedayBookingInfo;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.service.ShoppingCartAPI;
import com.example.homelayout.ui.workshops.WorkshopsForm;
import com.example.homelayout.ui.workshops.WorkshopsFragment;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ShoppingCartFragment extends Fragment implements ShoppingCartController.DistanceListener {
    private WorkshopsForm mainActivity = new WorkshopsForm(Workshops.Flashmob);
    private Button mExtraWorkshopButton;
    private Button mGoToPaymentScreen;
    private DistanceResult distanceResult;
    private ImageButton mDeleteButton;
    private TextView mSubtotal;
    private Context thisContext;
    private TinyDB tinyDB;
    private LinearLayoutManager workshopLayoutManager;
    private LinearLayoutManager cultureDayLayoutManager;
    private RecyclerView workshopRecyclerView;
    private RecyclerView cultureDayRecyclerView;
    private ShoppingCartCultureDayAdapter shoppingCartCultureDayAdapter;
    private ShoppingCartWorkshopAdapter shoppingCartWorkshopAdapter;
    private ArrayList<Object> workshopBookings;
    private ArrayList<Object> cultureDayBookings;
    private ArrayList<String> workshops = new ArrayList<>();
    //private WorkshopBooking workshopDummyData = new WorkshopBooking("workshop rap", 2, 75, "voorbeeld", "voorbeeld", "3 Juni 2021", 300.00);
    //private CultureDayBooking cultureDayDummyData = new CultureDayBooking(3, 3, 60, 75, workshops, "voorbeeld", "HBO", "26 Juni 2022", 1500.00);

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        Log.d("ShoppingCartFragment", "Shoppingcart fragment aangemaakt!");

        ShoppingCartController shoppingCartController = new ShoppingCartController(this);
        shoppingCartController.loadDistance("51.55363487608391,4.787215559520832");

        thisContext = container.getContext();
        tinyDB = new TinyDB(thisContext);
        workshopLayoutManager = new LinearLayoutManager(thisContext);
        workshopRecyclerView = root.findViewById(R.id.shopping_cart_workshop_recycler);
        workshopRecyclerView.setLayoutManager(workshopLayoutManager);
        workshopRecyclerView.setHasFixedSize(true);

        workshopBookings = tinyDB.getListObject("Carditems", WorkshopBooking.class);
        shoppingCartWorkshopAdapter = new ShoppingCartWorkshopAdapter(workshopBookings, getFragmentManager());

        workshopRecyclerView.setAdapter(shoppingCartWorkshopAdapter);
        cultureDayLayoutManager = new LinearLayoutManager(thisContext);
        cultureDayRecyclerView = root.findViewById(R.id.shopping_cart_culture_day_recycler);
        cultureDayRecyclerView.setLayoutManager(cultureDayLayoutManager);
        cultureDayRecyclerView.setHasFixedSize(true);
        cultureDayBookings = tinyDB.getListObject("CultureItems", CulturedayBookingInfo.class);

        shoppingCartCultureDayAdapter = new ShoppingCartCultureDayAdapter(cultureDayBookings, getFragmentManager());
        cultureDayRecyclerView.setAdapter(shoppingCartCultureDayAdapter);

        mGoToPaymentScreen = root.findViewById(R.id.btn_checkout);
        mGoToPaymentScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new PaymentFragment(getSubTotal())).addToBackStack(null).commit();
            }
        });
        mSubtotal = root.findViewById(R.id.shopping_cart_subtotal);
        mSubtotal.setText("€" + getSubTotal());

        mExtraWorkshopButton = root.findViewById(R.id.btn_cart_extra_workshop);
        mExtraWorkshopButton.setClickable(true);
        mExtraWorkshopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsFragment()).addToBackStack(null).commit();

            }
        });
        return root;
    }

    public String getSubTotal() {
        double subtotal = 0;
        for (int i = 0; i < cultureDayBookings.size(); i++) {
            CulturedayBookingInfo cultureDayBooking = (CulturedayBookingInfo) cultureDayBookings.get(i);
            subtotal += cultureDayBooking.getPrice();
        }
        for (int i = 0; i < workshopBookings.size(); i++) {
            WorkshopBooking workshopBooking = (WorkshopBooking) workshopBookings.get(i);
            subtotal += workshopBooking.getPrice();
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(subtotal);
    }

    public void refresh() {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ShoppingCartFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onDistanceReady(DistanceResult result) {
        this.distanceResult = result;
    }
}
