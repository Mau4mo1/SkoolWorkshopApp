package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;

public class WorkshopTheatreFragment extends Fragment implements View.OnClickListener {

    private ImageButton mButtonSoapActing;
    private ImageButton mButtonStageFighting;
    private ImageButton mButtonTheatreSport;
    private LinearLayout llSoapActing;
    private LinearLayout llStageFighting;
    private LinearLayout llTheatreSport;

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

        llSoapActing = root.findViewById(R.id.layout_workshop_soap_acting);
        llStageFighting = root.findViewById(R.id.layout_workshop_stage_fighting);
        llTheatreSport = root.findViewById(R.id.layout_workshop_theatre_sport);

        llSoapActing.setOnClickListener(this);
        llStageFighting.setOnClickListener(this);
        llTheatreSport.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_soap_acting:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.SoapActeren)).commit();
                break;
            case R.id.layout_workshop_stage_fighting:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.StageFighting)).commit();
                break;
            case R.id.layout_workshop_theatre_sport:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Theatersport)).commit();
                break;
        }
    }
}
