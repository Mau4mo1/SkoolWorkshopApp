package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class WorkshopVisualArtsFragment extends Fragment {
private ImageButton mButtonGraffiti;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_visual_arts, container, false);
        mButtonGraffiti = root.findViewById(R.id.graffiti_Info);
        mButtonGraffiti.setClickable(true);
        mButtonGraffiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-hiphop/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return root;
    }
}
