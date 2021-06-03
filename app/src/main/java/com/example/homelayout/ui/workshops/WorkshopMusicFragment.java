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

public class WorkshopMusicFragment extends Fragment implements View.OnClickListener {

    LinearLayout llCaribeanDrums;
    LinearLayout llGhettoDrums;
    LinearLayout llLiveLooping;
    LinearLayout llPercussie;
    LinearLayout llPopstar;
    LinearLayout llRap;
    private ImageButton mButtonCaribbeanDrums;
    private ImageButton mButtonGhettoDrums;
    private ImageButton mButtonLiveLooping;
    private ImageButton mButtonPercussion;
    private ImageButton mButtonPopstar;
    private ImageButton mButtonRap;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_music, container, false);
        mButtonCaribbeanDrums = root.findViewById(R.id.caribbean_drums_info);
        mButtonCaribbeanDrums.setClickable(true);
        mButtonGhettoDrums = root.findViewById(R.id.ghetto_drums_info);
        mButtonGhettoDrums.setClickable(true);
        mButtonLiveLooping = root.findViewById(R.id.live_looping_info);
        mButtonLiveLooping.setClickable(true);
        mButtonPercussion = root.findViewById(R.id.percussion_info);
        mButtonPercussion.setClickable(true);
        mButtonPopstar = root.findViewById(R.id.popstar_info);
        mButtonPopstar.setClickable(true);
        mButtonRap = root.findViewById(R.id.rap_info);
        mButtonRap.setClickable(true);
        mButtonCaribbeanDrums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-caribbean-drums/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonGhettoDrums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-ghetto-drums/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonLiveLooping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-live-looping/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonPercussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-percussie/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonPopstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-popstar/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonRap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-rap/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        llCaribeanDrums = root.findViewById(R.id.layout_workshop_caribbean_drums);
        llGhettoDrums = root.findViewById(R.id.layout_workshop_ghetto_drums);
        llLiveLooping = root.findViewById(R.id.layout_workshop_live_looping);
        llPercussie = root.findViewById(R.id.layout_workshop_percussie);
        llPopstar = root.findViewById(R.id.layout_workshop_popstar);
        llRap = root.findViewById(R.id.layout_workshop_rap);

        llCaribeanDrums.setOnClickListener(this);
        llGhettoDrums.setOnClickListener(this);
        llLiveLooping.setOnClickListener(this);
        llPercussie.setOnClickListener(this);
        llPopstar.setOnClickListener(this);
        llRap.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_caribbean_drums:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_ghetto_drums:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_live_looping:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_percussie:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_popstar:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_rap:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
        }
    }
}