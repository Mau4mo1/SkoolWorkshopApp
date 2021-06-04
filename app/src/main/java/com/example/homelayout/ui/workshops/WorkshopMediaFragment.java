package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopMediaFragment extends Fragment implements View.OnClickListener {

    LinearLayout llPhotoshop;
    LinearLayout llVlogging;
    LinearLayout llSmartphonePhotography;
    LinearLayout llVideoClip;
    private ImageButton mButtonPhotoshop;
    private ImageButton mButtonVlogging;
    private ImageButton mButtonSmartphonePhotography;
    private ImageButton mButtonVideoclip;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_media, container, false);
        mButtonPhotoshop = root.findViewById(R.id.photoshop_info);
        mButtonPhotoshop.setClickable(true);
        mButtonVlogging = root.findViewById(R.id.vlogging_info);
        mButtonVlogging.setClickable(true);
        mButtonSmartphonePhotography = root.findViewById(R.id.smartphone_photography_info);
        mButtonSmartphonePhotography.setClickable(true);
        mButtonVideoclip = root.findViewById(R.id.videoclip_info);
        mButtonVideoclip.setClickable(true);
        mButtonPhotoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-photoshop/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonVlogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-vloggen/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonSmartphonePhotography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-smartphone-fotografie/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonVideoclip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-videoclip-maken/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        llPhotoshop = root.findViewById(R.id.layout_workshop_photoshop);
        llVlogging = root.findViewById(R.id.layout_workshop_vlogging);
        llSmartphonePhotography = root.findViewById(R.id.layout_workshop_smartphone_photography);
        llVideoClip = root.findViewById(R.id.layout_workshop_videoclip);

        llPhotoshop.setOnClickListener(this);
        llVlogging.setOnClickListener(this);
        llSmartphonePhotography.setOnClickListener(this);
        llVideoClip.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_photoshop:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_vlogging:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_smartphone_photography:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_videoclip:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
        }
    }
}