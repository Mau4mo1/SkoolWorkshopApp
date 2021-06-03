package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopMediaFragment extends Fragment implements View.OnClickListener {

    LinearLayout llPhotoshop;
    LinearLayout llVlogging;
    LinearLayout llSmartphonePhotography;
    LinearLayout llVideoClip;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_media, container, false);

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