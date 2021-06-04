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

public class WorkshopSportFragment extends Fragment implements View.OnClickListener {

    LinearLayout llBootcamp;
    LinearLayout llCapoeira;
    LinearLayout llFreeRunning;
    LinearLayout llKickboxing;
    LinearLayout llPannaFootball;
    LinearLayout llSelfDefence;
    private ImageButton mButtonBootcamp;
    private ImageButton mButtonCapoeira;
    private ImageButton mButtonFreerunning;
    private ImageButton mButtonKickboxen;
    private ImageButton mButtonPannaFootball;
    private ImageButton mButtonSelfDefence;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_sport, container, false);
        mButtonBootcamp = root.findViewById(R.id.bootcamp_info);
        mButtonBootcamp.setClickable(true);
        mButtonCapoeira = root.findViewById(R.id.capoeira_info);
        mButtonCapoeira.setClickable(true);
        mButtonFreerunning = root.findViewById(R.id.freerunning_info);
        mButtonFreerunning.setClickable(true);
        mButtonKickboxen = root.findViewById(R.id.kickboxen_info);
        mButtonKickboxen.setClickable(true);
        mButtonPannaFootball = root.findViewById(R.id.panna_football_info);
        mButtonPannaFootball.setClickable(true);
        mButtonSelfDefence = root.findViewById(R.id.selfdefence_info);
        mButtonSelfDefence.setClickable(true);
        mButtonBootcamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-bootcamp/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonCapoeira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-capoeira/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonFreerunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-freerunning/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonKickboxen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-kickboksen/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonPannaFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-pannavoetbal/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonSelfDefence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-zelfverdediging/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        llBootcamp = root.findViewById(R.id.layout_workshop_bootcamp);
        llCapoeira = root.findViewById(R.id.layout_workshop_capoeira);
        llFreeRunning = root.findViewById(R.id.layout_workshop_freerunning);
        llKickboxing = root.findViewById(R.id.layout_workshop_kickboxen);
        llPannaFootball = root.findViewById(R.id.layout_workshop_panna_football);
        llSelfDefence = root.findViewById(R.id.layout_workshop_selfdefence);

        llBootcamp.setOnClickListener(this);
        llCapoeira.setOnClickListener(this);
        llFreeRunning.setOnClickListener(this);
        llKickboxing.setOnClickListener(this);
        llPannaFootball.setOnClickListener(this);
        llSelfDefence.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_bootcamp:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Bootcamp)).commit();
                break;
            case R.id.layout_workshop_capoeira:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Capoeira)).commit();
                break;
            case R.id.layout_workshop_freerunning:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Freeruning)).commit();
                break;
            case R.id.layout_workshop_kickboxen:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Kickboksen)).commit();
                break;
            case R.id.layout_workshop_panna_football:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Pannavoetbal)).commit();
                break;
            case R.id.layout_workshop_selfdefence:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Zelfverdedeging)).commit();
                break;
        }
    }
}
