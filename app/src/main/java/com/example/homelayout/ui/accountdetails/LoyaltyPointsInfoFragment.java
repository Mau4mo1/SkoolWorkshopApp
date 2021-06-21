package com.example.homelayout.ui.accountdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class LoyaltyPointsInfoFragment extends Fragment {

    private Button mBackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_loyalty_points_info, container, false);

        mBackButton = root.findViewById(R.id.btn_loyalty_points_info_back);
        mBackButton.setClickable(true);
        mBackButton.setOnClickListener(
                v -> getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new LoyaltyPointsFragment()).commit());
        return root;
    }
}
