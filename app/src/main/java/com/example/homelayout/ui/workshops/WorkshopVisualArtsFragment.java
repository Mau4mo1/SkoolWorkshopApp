package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.controller.WorkshopController;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;

import java.sql.SQLException;
import java.util.List;

public class WorkshopVisualArtsFragment extends Fragment implements View.OnClickListener, WorkshopController.WorkshopsControllerListener {
    private ImageButton mButtonGraffiti;
    private ImageButton mButtonGraffitiLight;
    private ImageButton mButtonStopMotion;
    private ImageButton mButtonTshirt;
    private LinearLayout llGraffiti;
    private LinearLayout llLightGraffiti;
    private LinearLayout llStopMotion;
    private LinearLayout llTShirt;
    private List<WorkshopsObject> workshopsObjectList;
    private ImageView mImageViewGraffiti;
    private ImageView mImageViewLightGraffiti;
    private ImageView mImageViewStopMotion;
    private ImageView mImageViewTshirtDesign;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_visual_arts, container, false);
        mImageViewGraffiti = root.findViewById(R.id.iv_workshop_graffiti);
        mImageViewLightGraffiti = root.findViewById(R.id.iv_workshop_light_graffiti);
        mImageViewStopMotion = root.findViewById(R.id.iv_workshop_stop_motion);
        mImageViewTshirtDesign = root.findViewById(R.id.iv_workshop_tshirt_design);

        new WorkshopController(this).loadWorkshopsByCategory("BeeldendeKunst");

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
        llLightGraffiti = root.findViewById(R.id.layout_workshop_light_graffiti);
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
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Graffiti)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_light_graffiti:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.LightGraffiti)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_stop_motion:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.StopMotion)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_tshirt_design:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.TshirtOntwerpen)).addToBackStack(null).commit();
                break;
        }

    }

    @Override
    public void onWorkshopsAvailable(List<WorkshopsObject> workshopsObjectList) throws SQLException {
        this.workshopsObjectList = workshopsObjectList;
        for (WorkshopsObject i : workshopsObjectList) {
            fillImages(i);
        }
    }

    public void fillImages(WorkshopsObject workshopsObject) throws SQLException {
        WorkshopPictureObject[] workshopPictureObject = workshopsObject.getPictureObject();
        switch (workshopsObject.getCodeName()) {
            case "SkoolGraffiti":
                mImageViewGraffiti
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolLightGraffiti":
                mImageViewLightGraffiti
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolStopMotion":
                mImageViewStopMotion
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolTshirtOntwerpen":
                mImageViewTshirtDesign
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
        }
    }
}
