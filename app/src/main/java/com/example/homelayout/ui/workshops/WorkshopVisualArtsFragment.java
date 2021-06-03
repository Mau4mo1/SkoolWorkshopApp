package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.Cultureday.Form.culturedayFormFragment;

public class WorkshopVisualArtsFragment extends Fragment implements View.OnClickListener {

    LinearLayout llGraffiti;
    LinearLayout llLightGraffiti;
    LinearLayout llStopMotion;
    LinearLayout llTShirt;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_visual_arts, container, false);

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
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_light_graffiti:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_stop_motion:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
            case R.id.layout_workshop_tshirt_design:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm()).commit();
                break;
        }

    }
}
