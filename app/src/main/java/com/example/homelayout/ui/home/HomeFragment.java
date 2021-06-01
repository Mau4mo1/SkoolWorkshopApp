package com.example.homelayout.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.homelayout.R;
import com.example.homelayout.ui.Cultureday.Form.culturedayFormFragment;
import com.example.homelayout.ui.Cultureday.MainPage.CulturedayMainFragment;
import com.example.homelayout.ui.contact.ContactFragment;
import com.example.homelayout.ui.workshops.WorkshopsFragment;

public class HomeFragment extends Fragment {

    private Button btnBookWorkshop;
    private Button btnBookCultureDay;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnBookWorkshop = root.findViewById(R.id.button_book_workshop);
        btnBookWorkshop.setClickable(true);
        btnBookCultureDay = root.findViewById(R.id.button_book_culture_day);
        btnBookCultureDay.setClickable(true);

        btnBookWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsFragment()).commit();
            }
        });

        btnBookCultureDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new culturedayFormFragment()).commit();
            }
        });
        return root;
    }
}