package com.example.homelayout.ui.workshops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.Cultureday.MainPage.CulturedayMainFragment;

public class WorkshopsFragment extends Fragment {

    private ConstraintLayout mConstraintLayoutVisualArts;
    private ConstraintLayout mConstraintLayoutDance;
    private ConstraintLayout mConstraintLayoutMedia;
    private ConstraintLayout mConstraintLayoutMusic;
    private ConstraintLayout mConstraintLayoutSport;
    private ConstraintLayout mConstraintLayoutTheatre;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_category_workshops,container, false);
        mConstraintLayoutVisualArts = root.findViewById(R.id.item_visual_arts);
        mConstraintLayoutVisualArts.setClickable(true);
        mConstraintLayoutVisualArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopVisualArtsFragment()).commit();
            }
        });

        mConstraintLayoutDance = root.findViewById(R.id.item_dance);
        mConstraintLayoutDance.setClickable(true);
        mConstraintLayoutDance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopDanceFragment()).commit();
            }
        });

        mConstraintLayoutMedia = root.findViewById(R.id.item_media);
        mConstraintLayoutMedia.setClickable(true);
        mConstraintLayoutMedia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopMediaFragment()).commit();
            }
        });

        mConstraintLayoutMusic = root.findViewById(R.id.item_music);
        mConstraintLayoutMusic.setClickable(true);
        mConstraintLayoutMusic.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopMusicFragment()).commit();
            }
        });

        mConstraintLayoutSport = root.findViewById(R.id.item_sport);
        mConstraintLayoutSport.setClickable(true);
        mConstraintLayoutSport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopSportFragment()).commit();
            }
        });

        mConstraintLayoutTheatre = root.findViewById(R.id.item_theater);
        mConstraintLayoutTheatre.setClickable(true);
        mConstraintLayoutTheatre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopTheatreFragment()).commit();
            }
        });
        return root;
    }
}