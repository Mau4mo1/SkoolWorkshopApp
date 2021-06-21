package com.example.homelayout.ui.workshops;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class WorkshopsFragment extends Fragment {
    private ConstraintLayout mConstraintLayoutVisualArts;
    private ConstraintLayout mConstraintLayoutDance;
    private ConstraintLayout mConstraintLayoutMedia;
    private ConstraintLayout mConstraintLayoutMusic;
    private ConstraintLayout mConstraintLayoutSport;
    private ConstraintLayout mConstraintLayoutTheatre;
    private ImageView mImageViewMedia;
    private ImageView mImageViewMusic;
    private ImageView mImageViewSport;
    private ImageView mImageViewTheater;
    private ImageView mImageViewVisualArts;
    private ImageView mImageViewDance;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_category_workshops, container, false);

        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(0)
                .cornerRadiusDp(15)
                .scaleType(ImageView.ScaleType.CENTER_CROP)
                .oval(false)
                .build();

        mImageViewMedia = root.findViewById(R.id.iv_media);
        Picasso.get()
                .load("https://cdn-bnege.nitrocdn.com/MVgfApSlnIZMEMtTrPfeVWWDRvGvEHus/assets/static/source/rev-23fdb00/wp-content/uploads/2019/12/Media-Website-1024x683.jpg")
                .fit()
                .transform(transformation)
                .into(mImageViewMedia);
        mImageViewMusic = root.findViewById(R.id.iv_music);
        Picasso.get()
                .load("https://cdn-bnege.nitrocdn.com/MVgfApSlnIZMEMtTrPfeVWWDRvGvEHus/assets/static/optimized/rev-23fdb00/wp-content/uploads/2021/01/Naamloos-1.jpg")
                .fit()
                .transform(transformation)
                .into(mImageViewMusic);
        mImageViewSport = root.findViewById(R.id.iv_sport);
        Picasso.get()
                .load("https://cdn-bnege.nitrocdn.com/MVgfApSlnIZMEMtTrPfeVWWDRvGvEHus/assets/static/optimized/rev-23fdb00/wp-content/uploads/2019/12/Sport.jpg")
                .fit()
                .transform(transformation)
                .into(mImageViewSport);
        mImageViewTheater = root.findViewById(R.id.iv_theater);
        Picasso.get()
                .load("https://cdn-bnege.nitrocdn.com/MVgfApSlnIZMEMtTrPfeVWWDRvGvEHus/assets/static/optimized/rev-23fdb00/wp-content/uploads/2019/12/Theater.jpg")
                .fit()
                .transform(transformation)
                .into(mImageViewTheater);
        mImageViewVisualArts = root.findViewById(R.id.iv_visual_arts);
        Picasso.get()
                .load("https://cdn-bnege.nitrocdn.com/MVgfApSlnIZMEMtTrPfeVWWDRvGvEHus/assets/static/source/rev-23fdb00/wp-content/uploads/2020/01/Beeldende-Kunst.jpg")
                .fit()
                .transform(transformation)
                .into(mImageViewVisualArts);
        mImageViewDance = root.findViewById(R.id.iv_dance);
        Picasso.get()
                .load("https://cdn-bnege.nitrocdn.com/MVgfApSlnIZMEMtTrPfeVWWDRvGvEHus/assets/static/source/rev-23fdb00/wp-content/uploads/2019/12/Dans-Website-1024x683.jpg")
                .fit()
                .transform(transformation)
                .into(mImageViewDance);

        mConstraintLayoutVisualArts = root.findViewById(R.id.item_visual_arts);
        mConstraintLayoutVisualArts.setClickable(true);
        mConstraintLayoutVisualArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView("BeeldendeKunst")).addToBackStack(null).commit();
            }
        });

        mConstraintLayoutDance = root.findViewById(R.id.item_dance);
        mConstraintLayoutDance.setClickable(true);
        mConstraintLayoutDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView("Dans")).addToBackStack(null).commit();
            }
        });

        mConstraintLayoutMedia = root.findViewById(R.id.item_media);
        mConstraintLayoutMedia.setClickable(true);
        mConstraintLayoutMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView("Media")).addToBackStack(null).commit();
            }
        });

        mConstraintLayoutMusic = root.findViewById(R.id.item_music);
        mConstraintLayoutMusic.setClickable(true);
        mConstraintLayoutMusic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView("Muziek")).addToBackStack(null).commit();
            }
        });

        mConstraintLayoutSport = root.findViewById(R.id.item_sport);
        mConstraintLayoutSport.setClickable(true);
        mConstraintLayoutSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView("Sport")).addToBackStack(null).commit();
            }
        });

        mConstraintLayoutTheatre = root.findViewById(R.id.item_theater);
        mConstraintLayoutTheatre.setClickable(true);
        mConstraintLayoutTheatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView("Theater")).addToBackStack(null).commit();
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.nav_view);
        navigation.getMenu().getItem(1).setChecked(true);
    }
}