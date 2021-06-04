package com.example.homelayout.ui.workshops;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;

import java.util.zip.CheckedOutputStream;

public class WorkshopsPopular extends Fragment implements View.OnClickListener{

    ConstraintLayout clGraffiti;
    ConstraintLayout clRap;
    ConstraintLayout clVloggen;
    ConstraintLayout clHiphop;
    ConstraintLayout clGhettoDrums;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_workshops_popular, container, false);

        clGraffiti = root.findViewById(R.id.cl_popular_workshop_graffiti);
        clRap = root.findViewById(R.id.cl_popular_workshop_rap);
        clVloggen = root.findViewById(R.id.cl_popular_workshop_vlogging);
        clHiphop = root.findViewById(R.id.cl_popular_workshop_hiphop);
        clGhettoDrums = root.findViewById(R.id.cl_popular_workshop_ghetto_drums);

        clGraffiti.setOnClickListener(this);
        clRap.setOnClickListener(this);
        clVloggen.setOnClickListener(this);
        clHiphop.setOnClickListener(this);
        clGhettoDrums.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cl_popular_workshop_graffiti:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Graffiti)).commit();
                break;
            case R.id.cl_popular_workshop_rap:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Rap)).commit();
                break;
            case R.id.cl_popular_workshop_vlogging:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Vloggen)).commit();
                break;
            case R.id.cl_popular_workshop_hiphop:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Hiphop)).commit();
                break;
            case R.id.cl_popular_workshop_ghetto_drums:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.GhettoDrums)).commit();
                break;
        }
    }
}