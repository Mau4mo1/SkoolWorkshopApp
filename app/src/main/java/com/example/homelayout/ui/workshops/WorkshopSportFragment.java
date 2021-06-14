package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.controller.WorkshopController;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;

import java.sql.SQLException;
import java.util.List;

public class WorkshopSportFragment extends Fragment implements View.OnClickListener, WorkshopController.WorkshopsControllerListener {

    private LinearLayout llBootcamp;
    private LinearLayout llCapoeira;
    private LinearLayout llFreeRunning;
    private LinearLayout llKickboxing;
    private LinearLayout llPannaFootball;
    private LinearLayout llSelfDefence;
    private ImageButton mButtonBootcamp;
    private ImageButton mButtonCapoeira;
    private ImageButton mButtonFreerunning;
    private ImageButton mButtonKickboxen;
    private ImageButton mButtonPannaFootball;
    private ImageButton mButtonSelfDefence;
    private List<WorkshopsObject> workshopsObjectList;
    private ImageView mImageViewBootcamp;
    private ImageView mImageViewCapoeira;
    private ImageView mImageViewFreerunning;
    private ImageView mImageViewKickBoxen;
    private ImageView mImageViewPannaVoetbal;
    private ImageView mImageViewSelfDefence;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_sport, container, false);

        mImageViewBootcamp = root.findViewById(R.id.iv_workshop_bootcamp);
        mImageViewCapoeira = root.findViewById(R.id.iv_workshop_capoeira);
        mImageViewFreerunning = root.findViewById(R.id.iv_workshop_freerunning);
        mImageViewKickBoxen = root.findViewById(R.id.iv_workshop_kickboxen);
        mImageViewPannaVoetbal = root.findViewById(R.id.iv_workshop_panna_football);
        mImageViewSelfDefence = root.findViewById(R.id.iv_workshop_selfdefence);

        new WorkshopController(this).loadWorkshopsByCategory("Sport");

        mButtonBootcamp = root.findViewById(R.id.bootcamp_info);
        mButtonBootcamp.setClickable(true);
        mButtonCapoeira = root.findViewById(R.id.capoeira_info);
        mButtonCapoeira.setClickable(true);
        mButtonFreerunning = root.findViewById(R.id.freerunning_info);
        mButtonFreerunning.setClickable(true);
        mButtonKickboxen = root.findViewById(R.id.kickboxen_info);
        mButtonKickboxen.setClickable(true);
        mButtonPannaFootball = root.findViewById(R.id.panna_football_info);
        mButtonPannaFootball.setClickable(true);
        mButtonSelfDefence = root.findViewById(R.id.selfdefence_info);
        mButtonSelfDefence.setClickable(true);
        mButtonBootcamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-bootcamp/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonCapoeira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-capoeira/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonFreerunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-freerunning/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonKickboxen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-kickboksen/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonPannaFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-pannavoetbal/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonSelfDefence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-zelfverdediging/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

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
        switch (v.getId()) {
            case R.id.layout_workshop_bootcamp:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Bootcamp)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_capoeira:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Capoeira)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_freerunning:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Freeruning)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_kickboxen:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Kickboksen)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_panna_football:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Pannavoetbal)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_selfdefence:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Zelfverdedeging)).addToBackStack(null).commit();
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
            case "SkoolBootcamp":
                mImageViewBootcamp
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolCapoeira":
                mImageViewCapoeira
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolFreerunning":
                mImageViewFreerunning
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolKickboksen":
                mImageViewKickBoxen
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolPannavoetbal":
                mImageViewPannaVoetbal
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolZelfverdediging":
                mImageViewSelfDefence
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
        }
    }
}
