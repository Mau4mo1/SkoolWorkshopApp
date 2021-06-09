package com.example.homelayout.ui.shoppingcart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.Payment;
import com.example.homelayout.ui.workshops.WorkshopsFragment;
import com.example.homelayout.ui.shoppingcart.RecyclerAdapter;


import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCartFragment extends Fragment {

    private Button mExtraWorkshopButton;
    private ImageButton mDeleteButton;
    private Context thisContext;
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<Payment> paymentData = new ArrayList<>();
    private Payment dummyData = new Payment("workshop rap", 2, 75, "voorbeeld", "voorbeeld", "3 Juni 2021", 300.00);


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        thisContext = container.getContext();
        layoutManager = new LinearLayoutManager(thisContext);
        recyclerView = root.findViewById(R.id.shopping_cart_recycler);
        recyclerView.setLayoutManager(layoutManager);
        paymentData.add(dummyData);
        recyclerAdapter = new RecyclerAdapter(paymentData);
        recyclerView.setAdapter(recyclerAdapter);

        mExtraWorkshopButton = root.findViewById(R.id.btn_cart_extra_workshop);
        mExtraWorkshopButton.setClickable(true);
        mExtraWorkshopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsFragment()).commit();
            }
        });

        return root;
    }
}
