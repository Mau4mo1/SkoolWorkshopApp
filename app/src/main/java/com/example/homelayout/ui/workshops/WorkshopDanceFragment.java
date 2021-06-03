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

public class WorkshopDanceFragment extends Fragment {
    private ImageButton mButtonBreakdance;
    private ImageButton mButtonDanceFit;
    private ImageButton mButtonFlashmob;
    private ImageButton mButtonHipHop;
    private ImageButton mButtonModernDance;
    private ImageButton mButtonStepping;
    private ImageButton mButtonStreetdance;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_dance, container, false);
        mButtonBreakdance = root.findViewById(R.id.breakdance_info);
        mButtonBreakdance.setClickable(true);
        mButtonDanceFit = root.findViewById(R.id.dance_fit_info);
        mButtonDanceFit.setClickable(true);
        mButtonFlashmob = root.findViewById(R.id.flashmob_info);
        mButtonFlashmob.setClickable(true);
        mButtonHipHop = root.findViewById(R.id.hiphop_info);
        mButtonHipHop.setClickable(true);
        mButtonModernDance = root.findViewById(R.id.modern_dance_info);
        mButtonModernDance.setClickable(true);
        mButtonStepping = root.findViewById(R.id.stepping_info);
        mButtonStepping.setClickable(true);
        mButtonStreetdance = root.findViewById(R.id.streetdance_info);
        mButtonStreetdance.setClickable(true);
        mButtonBreakdance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-breakdance/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonDanceFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-dance-fit/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonFlashmob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-flashmob/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonHipHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-hiphop/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonModernDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-moderne-dans/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonStepping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-stepping/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonStreetdance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-streetdance/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        return root;
    }

}
