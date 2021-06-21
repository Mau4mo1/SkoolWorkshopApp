package com.example.homelayout.ui.account.reservation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.logic.MessageAdapter;
import com.example.homelayout.repositories.TinyDB;

import java.util.ArrayList;

public class MyReservationFragment extends Fragment {
    private TinyDB tinydb;
    private Context con;
    private ArrayList<Object> reservationCardList;
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context thisContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_reservation_detail, container, false);

//        con = container.getContext();
//        layoutManager = new LinearLayoutManager(getContext());
//        recyclerView = root.findViewById(R.id.my_reservation_recycler01);
//        recyclerView.setLayoutManager(layoutManager);
//        tinydb = new TinyDB(con);
//        loadData();

        return root;
    }

    private void loadData(){
        reservationCardList = tinydb.getListObject("Carditems", WorkshopBooking.class);
        if (reservationCardList == null){
            reservationCardList = new ArrayList<>();
        }
    }
}
