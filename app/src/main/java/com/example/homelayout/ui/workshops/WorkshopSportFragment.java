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

public class WorkshopSportFragment extends Fragment {
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

        return root;
    }

}
