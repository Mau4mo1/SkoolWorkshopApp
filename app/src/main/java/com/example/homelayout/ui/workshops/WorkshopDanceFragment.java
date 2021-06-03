package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopDanceFragment extends Fragment implements View.OnClickListener {

    LinearLayout llBreakdance;
    LinearLayout llDanceFit;
    LinearLayout llFlashmob;
    LinearLayout llHiphop;
    LinearLayout llModernDance;
    LinearLayout llStepping;
    LinearLayout llStreetDance;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_dance, container, false);

        llBreakdance = root.findViewById(R.id.layout_workshop_breakdance);
        llDanceFit = root.findViewById(R.id.layout_workshop_dance_fit);
        llFlashmob = root.findViewById(R.id.layout_workshop_flashmob);
        llHiphop = root.findViewById(R.id.layout_workshop_hiphop);
        llModernDance = root.findViewById(R.id.layout_workshop_modern_dance);
        llStepping = root.findViewById(R.id.layout_workshop_stepping);
        llStreetDance = root.findViewById(R.id.layout_workshop_streetdance);

        llBreakdance.setOnClickListener(this);
        llDanceFit.setOnClickListener(this);
        llFlashmob.setOnClickListener(this);
        llHiphop.setOnClickListener(this);
        llModernDance.setOnClickListener(this);
        llStepping.setOnClickListener(this);
        llStreetDance.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_breakdance:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_dance_fit:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_flashmob:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_hiphop:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_modern_dance:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_stepping:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_streetdance:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
        }
    }
}