package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopTheatreFragment extends Fragment implements View.OnClickListener {

    LinearLayout llSoapActing;
    LinearLayout llStageFighting;
    LinearLayout llFreeRunning;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_theatre, container, false);

        llSoapActing = root.findViewById(R.id.layout_workshop_soap_acting);
        llStageFighting = root.findViewById(R.id.layout_workshop_stage_fighting);
        llFreeRunning = root.findViewById(R.id.layout_workshop_freerunning);

        llSoapActing.setOnClickListener(this);
        llStageFighting.setOnClickListener(this);
        llFreeRunning.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_workshop_soap_acting:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_stage_fighting:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_freerunning:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
        }
    }
}
