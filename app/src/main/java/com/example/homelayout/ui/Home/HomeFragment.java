package com.example.homelayout.ui.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.contact.ContactFragment;

public class HomeFragment extends Fragment {

    private Button btnBookWorkshop;
    private Button btnBookCultureDay;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnBookCultureDay = root.findViewById(R.id.register_button);
        btnBookCultureDay.setClickable(true);
        btnBookCultureDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new ContactFragment()).commit();
            }
        });
        return root;
    }
}