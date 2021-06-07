package com.example.homelayout.ui.Cultureday.MainPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.Cultureday.Form.CulturedayFormFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CulturedayMainFragment extends Fragment {
    private Button btn_meer_informatie_cd;
    private Button btn_boek_nu_cd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday, container, false);

        btn_meer_informatie_cd = root.findViewById(R.id.b_cultureday_more_info);
        btn_meer_informatie_cd.setClickable(true);
        btn_meer_informatie_cd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.skoolworkshop.nl/workshops/cultuurdag/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_boek_nu_cd = root.findViewById(R.id.b_cultureday_book_day);
        btn_boek_nu_cd.setClickable(true);
        btn_boek_nu_cd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new CulturedayFormFragment()).commit();
            }
        });


        return root;
    }
}
