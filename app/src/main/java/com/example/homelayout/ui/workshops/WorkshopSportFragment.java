package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopSportFragment extends Fragment implements View.OnClickListener {

    LinearLayout llBootcamp;
    LinearLayout llCapoeira;
    LinearLayout llFreeRunning;
    LinearLayout llKickboxing;
    LinearLayout llPannaFootball;
    LinearLayout llSelfDefence;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_sport, container, false);

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
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_capoeira:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_freerunning:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_kickboxen:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_panna_football:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_selfdefence:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
        }
    }
}
