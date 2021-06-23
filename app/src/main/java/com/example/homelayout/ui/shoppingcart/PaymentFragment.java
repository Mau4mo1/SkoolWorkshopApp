package com.example.homelayout.ui.shoppingcart;

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
import com.example.homelayout.logic.MollieAPI;

import java.util.concurrent.ExecutionException;

public class PaymentFragment extends Fragment {

    private String payment;
    private Button sendPaymentButton;
    private String link;
    private String description;
    public PaymentFragment(String payment) {
        this.payment = payment;
        description = "Is ie betaald";

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_payment_screen, container, false);
        sendPaymentButton = root.findViewById(R.id.btn_payment);
        sendPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    link = new MollieAPI(payment,description).execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                startActivity(i);
            }
        });


        return root;
    }
}
