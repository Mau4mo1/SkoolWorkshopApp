package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_music, container, false);

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