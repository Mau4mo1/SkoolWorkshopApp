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

public class WorkshopMediaFragment extends Fragment implements View.OnClickListener, WorkshopController.WorkshopsControllerListener {

    private LinearLayout llPhotoshop;
    private LinearLayout llVlogging;
    private LinearLayout llSmartphonePhotography;
    private LinearLayout llVideoClip;
    private ImageButton mButtonPhotoshop;
    private ImageButton mButtonVlogging;
    private ImageButton mButtonSmartphonePhotography;
    private ImageButton mButtonVideoclip;
    private ImageView mImageViewPhotoshop;
    private ImageView mImageViewVlogging;
    private ImageView mImageViewPhotography;
    private ImageView mImageViewVideoclip;
    private List<WorkshopsObject> workshopsObjectList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_media, container, false);

        new WorkshopController(this).loadWorkshopsByCategory("Media");

        mImageViewPhotoshop = root.findViewById(R.id.iv_workshop_photoshop);
        mImageViewVlogging = root.findViewById(R.id.iv_workshop_vlogging);
        mImageViewPhotography = root.findViewById(R.id.iv_workshop_smartphone_photography);
        mImageViewVideoclip = root.findViewById(R.id.iv_workshop_videoclip);

        mButtonPhotoshop = root.findViewById(R.id.photoshop_info);
        mButtonPhotoshop.setClickable(true);
        mButtonVlogging = root.findViewById(R.id.vlogging_info);
        mButtonVlogging.setClickable(true);
        mButtonSmartphonePhotography = root.findViewById(R.id.smartphone_photography_info);
        mButtonSmartphonePhotography.setClickable(true);
        mButtonVideoclip = root.findViewById(R.id.videoclip_info);
        mButtonVideoclip.setClickable(true);
        mButtonPhotoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-photoshop/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonVlogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-vloggen/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonSmartphonePhotography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-smartphone-fotografie/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });mButtonVideoclip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-videoclip-maken/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

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
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Photoshop)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_vlogging:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Vloggen)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_smartphone_photography:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Fotografie)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_videoclip:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsForm(Workshops.Videoclip)).addToBackStack(null).commit();
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
            case "SkoolPhotoshop":
                mImageViewPhotoshop
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolVloggen":
                mImageViewVlogging
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolSmartphoneFotografie":
                mImageViewPhotography
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolVideoclipMaken":
                mImageViewVideoclip
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
        }
    }
}