package com.example.homelayout.ui.shoppingcart;

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

import com.example.homelayout.R;
import com.example.homelayout.ui.workshops.WorkshopsFragment;

import org.jetbrains.annotations.NotNull;

public class ShoppingCartFragment extends Fragment {

    private Button mExtraWorkshopButton;
    private ImageButton mDeleteButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        mExtraWorkshopButton = root.findViewById(R.id.btn_cart_extra_workshop);
        mExtraWorkshopButton.setClickable(true);
        mDeleteButton = root.findViewById(R.id.btn_delete_booking1);
        mExtraWorkshopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsFragment()).commit();
            }
        });
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "ITEM PRESSED", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
