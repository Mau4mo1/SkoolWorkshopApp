package com.example.homelayout.ui.accountdetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.controller.WorkshopController;
import com.example.homelayout.domain.CultureDayBooking;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;
import com.example.homelayout.logic.CulturedayBookingInfo;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.home.HomeFragment;
import com.example.homelayout.ui.shoppingcart.ShoppingCartCultureDayAdapter;
import com.example.homelayout.ui.shoppingcart.ShoppingCartFragment;
import com.example.homelayout.ui.shoppingcart.ShoppingCartWorkshopAdapter;
import com.example.homelayout.ui.workshops.WorkshopsForm;
import com.example.homelayout.ui.workshops.WorkshopsFragment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyPointsFragment extends Fragment {
    private WorkshopsForm mainActivity = new WorkshopsForm(Workshops.Flashmob);
    private Button mExtraWorkshopButton;
    private ImageButton mDeleteButton;
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
    private WorkshopBooking workshopDummyData = new WorkshopBooking("workshop rap", 2, 75, "voorbeeld", "voorbeeld", "3 Juni 2021", 300.00);
    private CultureDayBooking cultureDayDummyData = new CultureDayBooking(3,3,60,75, workshops, "voorbeeld", "HBO", "26 Juni 2022",1500.00);

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_loyalty_points, container, false);
        Log.d("LoyaltyPointsFragment", "LoyaltyPoints fragment made!");
        thisContext = container.getContext();
        tinyDB = new TinyDB(thisContext);
        workshopLayoutManager = new LinearLayoutManager(thisContext);
        workshopRecyclerView = root.findViewById(R.id.shopping_cart_workshop_recycler);
        workshopRecyclerView.setLayoutManager(workshopLayoutManager);
        workshopRecyclerView.setHasFixedSize(true);

        workshopBookings = tinyDB.getListObject("Carditems", WorkshopBooking.class);
        shoppingCartWorkshopAdapter = new ShoppingCartWorkshopAdapter(workshopBookings);

        workshopRecyclerView.setAdapter(shoppingCartWorkshopAdapter);
        cultureDayLayoutManager = new LinearLayoutManager(thisContext);
        cultureDayRecyclerView = root.findViewById(R.id.shopping_cart_culture_day_recycler);
        cultureDayRecyclerView.setLayoutManager(cultureDayLayoutManager);
        cultureDayRecyclerView.setHasFixedSize(true);
        cultureDayBookings = tinyDB.getListObject("CultureItems", CulturedayBookingInfo.class);

        shoppingCartCultureDayAdapter = new ShoppingCartCultureDayAdapter(cultureDayBookings);
        cultureDayRecyclerView.setAdapter(shoppingCartCultureDayAdapter);


        mExtraWorkshopButton = root.findViewById(R.id.btn_loyalty_points_back);
        mExtraWorkshopButton.setClickable(true);
        mExtraWorkshopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsFragment()).commit();
            }
        });





        return root;
    }

    public void refresh(){
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ShoppingCartFragment()).commit();
    }
}
