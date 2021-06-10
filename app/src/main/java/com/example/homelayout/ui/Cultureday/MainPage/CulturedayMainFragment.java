package com.example.homelayout.ui.Cultureday.MainPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.Cultureday.Form.CulturedayBookingFormFragment;


public class CulturedayMainFragment extends Fragment {
    public Button btn_more_info_cd;
    public Button btn_book_now_cd;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday, container, false);
        btn_more_info_cd = root.findViewById(R.id.button_more_info_cd);
        btn_more_info_cd.setClickable(true);
        btn_more_info_cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.skoolworkshop.nl/workshops/cultuurdag/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_book_now_cd = root.findViewById(R.id.button_book_now_cd);
        btn_book_now_cd.setClickable(true);
        btn_book_now_cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CulturedayBookingFormFragment()).commit();
            }
        });
        return root;
    }
}
