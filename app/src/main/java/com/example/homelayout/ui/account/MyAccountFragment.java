package com.example.homelayout.ui.account;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.account.data.MyDataFragment;
import com.example.homelayout.ui.account.invoice.MyInvoiceFragment;
import com.example.homelayout.ui.account.reservation.MyReservationFragment;
import com.example.homelayout.ui.accountdetails.LoyaltyPointsFragment;
import com.example.homelayout.ui.home.HomeFragment;

public class MyAccountFragment extends Fragment {
    private Button btn_my_data;
    private Button btn_my_invoice;
    private Button btn_my_credits;
    private Button btn_my_reservations;
    private TextView tv_log_out;
    public Context con;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_account, container, false);
        btn_my_data = root.findViewById(R.id.button_my_account_my_data);
        btn_my_invoice = root.findViewById(R.id.button_my_account_invoice_data);
        btn_my_credits = root.findViewById(R.id.button_my_account_credits);
        btn_my_reservations = root.findViewById(R.id.button_my_account_reservations);
        tv_log_out = root.findViewById(R.id.tv_my_account_log_out);
        con = getContext();

        btn_my_data.setClickable(true);
        btn_my_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MyDataFragment()).addToBackStack(null).commit();
            }
        });

        btn_my_invoice.setClickable(true);
        btn_my_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MyInvoiceFragment()).addToBackStack(null).commit();
            }
        });

        btn_my_credits.setClickable(true);
        btn_my_credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PLACE HOLDER NEEDS TO BE CREDIT SCHREEN
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new LoyaltyPointsFragment()).addToBackStack(null).commit();
            }
        });

        btn_my_reservations.setClickable(true);
        btn_my_reservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MyReservationFragment()).addToBackStack(null).commit();
            }
        });

        tv_log_out.setClickable(true);
        tv_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder logpopup = new AlertDialog.Builder(con);
                logpopup.setCancelable(true);
                logpopup.setTitle("Uitloggen");
                logpopup.setMessage("Weet je zeker dat je wilt uitloggen?");
                logpopup.setPositiveButton("ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();
                    }
                });
                logpopup.setNegativeButton("Nee", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                logpopup.show();
            }
        });

        return root;
    }
}
