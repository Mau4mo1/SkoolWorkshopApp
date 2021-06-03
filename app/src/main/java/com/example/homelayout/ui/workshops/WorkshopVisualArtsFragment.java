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

public class WorkshopVisualArtsFragment extends Fragment {
    private ImageButton mButtonGraffiti;
    private ImageButton mButtonGraffitiLight;
    private ImageButton mButtonStopMotion;
    private ImageButton mButtonTshirt;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_visual_arts, container, false);
        mButtonGraffiti = root.findViewById(R.id.graffiti_info);
        mButtonGraffiti.setClickable(true);
        mButtonGraffitiLight = root.findViewById(R.id.graffiti_light_info);
        mButtonGraffitiLight.setClickable(true);
        mButtonStopMotion = root.findViewById(R.id.stop_motion_info);
        mButtonStopMotion.setClickable(true);
        mButtonTshirt = root.findViewById(R.id.tshirt_design_info);
        mButtonTshirt.setClickable(true);
        mButtonGraffiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-graffiti/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonGraffitiLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-light-graffiti/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonStopMotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-stop-motion/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-t-shirt-ontwerpen/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return root;
    }
}
