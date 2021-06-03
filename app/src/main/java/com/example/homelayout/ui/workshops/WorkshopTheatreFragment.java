package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopTheatreFragment extends Fragment {

    private ImageButton mButtonSoapActing;
    private ImageButton mButtonStageFighting;
    private ImageButton mButtonTheatreSport;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_theatre, container, false);
        mButtonSoapActing = root.findViewById(R.id.soap_acting_info);
        mButtonSoapActing.setClickable(true);
        mButtonStageFighting = root.findViewById(R.id.stage_fighting_info);
        mButtonStageFighting.setClickable(true);
        mButtonTheatreSport = root.findViewById(R.id.theatre_sport_info);
        mButtonTheatreSport.setClickable(true);
        mButtonSoapActing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-soap-acteren/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonStageFighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-stage-fighting/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonTheatreSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-theatersport/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return root;
    }
}
