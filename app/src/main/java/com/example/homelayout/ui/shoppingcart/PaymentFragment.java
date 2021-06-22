package com.example.homelayout.ui.shoppingcart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;

public class PaymentFragment extends Fragment {

    private String payment;
    private Button sendPaymentButton;

    public PaymentFragment(String payment) {
        this.payment = payment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_payment_screen, container, false);
        sendPaymentButton = root.findViewById(R.id.btn_payment);



        return root;
    }
}
