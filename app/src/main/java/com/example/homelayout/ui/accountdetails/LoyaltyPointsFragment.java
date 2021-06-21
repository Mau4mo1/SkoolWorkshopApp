package com.example.homelayout.ui.accountdetails;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.homelayout.R;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.home.HomeFragment;
import com.example.homelayout.domain.LoyaltyPointsObject;
import java.util.ArrayList;

public class LoyaltyPointsFragment extends Fragment {
    private Button mBackButton;
    private Button mInfoButton;
    private Context thisContext;
    private TinyDB tinyDB;
    private LinearLayoutManager loyaltyPointsLayoutManager;
    private RecyclerView loyaltyPointsRecyclerView;
    private LoyaltyPointsAdapter LoyaltyPointsAdapter;
    private ArrayList<Object> loyaltyPointsObjects;
    private ArrayList<Object> loyaltyPoints;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_loyalty_points, container, false);
        Log.d("LoyaltyPointsFragment", "LoyaltyPoints fragment made!");
        loyaltyPoints = new ArrayList<>();
        loyaltyPoints.add(new LoyaltyPointsObject("25 mei 2021", "Extra ivm achterlaten recensie", 0, 7200));
        loyaltyPoints.add(new LoyaltyPointsObject("3 juni 2021", "Workshop geboekt", 1234, 100));
        loyaltyPoints.add(new LoyaltyPointsObject("5 juni 2021", "Account aangemaakt op de website nadat hij/zij de workshop al heeft gehad", 0, 100));
        thisContext = container.getContext();
        tinyDB = new TinyDB(thisContext);
        loyaltyPointsLayoutManager = new LinearLayoutManager(thisContext);
        loyaltyPointsRecyclerView = root.findViewById(R.id.loyalty_points_item_recycler);
        loyaltyPointsRecyclerView.setLayoutManager(loyaltyPointsLayoutManager);
        loyaltyPointsRecyclerView.setHasFixedSize(true);

        loyaltyPointsObjects = tinyDB.getListObject("Carditems", LoyaltyPointsObject.class);
        LoyaltyPointsAdapter = new LoyaltyPointsAdapter(loyaltyPoints);
        loyaltyPointsRecyclerView.setAdapter(LoyaltyPointsAdapter);

        mBackButton = root.findViewById(R.id.btn_loyalty_points_back);
        mBackButton.setClickable(true);
        mBackButton.setOnClickListener(
                v -> getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit());

        mInfoButton = root.findViewById(R.id.btn_loyalty_points_info);
        mInfoButton.setClickable(true);
        mInfoButton.setOnClickListener(
                v -> getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new LoyaltyPointsInfoFragment()).commit());

        return root;
    }

}
