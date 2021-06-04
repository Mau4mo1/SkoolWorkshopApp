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
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.ui.Cultureday.Form.culturedayFormFragment;

public class WorkshopVisualArtsFragment extends Fragment implements View.OnClickListener {
    private ImageButton mButtonGraffiti;
    private ImageButton mButtonGraffitiLight;
    private ImageButton mButtonStopMotion;
    private ImageButton mButtonTshirt;

    LinearLayout llGraffiti;
    LinearLayout llLightGraffiti;
    LinearLayout llStopMotion;
    LinearLayout llTShirt;

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

        llGraffiti = root.findViewById(R.id.layout_workshop_graffiti);
        llLightGraffiti = root.findViewById(R.id.layout_workshop_tshirt_design);
        llStopMotion = root.findViewById(R.id.layout_workshop_stop_motion);
        llTShirt = root.findViewById(R.id.layout_workshop_tshirt_design);

        llGraffiti.setOnClickListener(this);
        llLightGraffiti.setOnClickListener(this);
        llStopMotion.setOnClickListener(this);
        llTShirt.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_graffiti:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Graffiti)).commit();
                break;
            case R.id.layout_workshop_light_graffiti:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.LightGraffiti)).commit();
                break;
            case R.id.layout_workshop_stop_motion:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.StopMotion)).commit();
                break;
            case R.id.layout_workshop_tshirt_design:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.TshirtOntwerpen)).commit();
                break;
        }

    }
}
