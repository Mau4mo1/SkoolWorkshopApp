package com.example.homelayout.ui.account.invoice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.home.HomeFragment;

public class MyInvoiceFragment extends Fragment {
    private TextView tv_invoice_edit;
    private TextView tv_workshop_edit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_invoice, container, false);
        tv_invoice_edit = root.findViewById(R.id.tv_my_invoice_edit_invoice_data);
        tv_workshop_edit = root.findViewById(R.id.tv_my_invoice_edit_workshopinfo_data);

        tv_invoice_edit.setClickable(true);
        tv_invoice_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new InvoiceDataEditFragment()).commit();
            }
        });

        tv_workshop_edit.setClickable(true);
        tv_workshop_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new BookedWorkshopDataEditFragment()).commit();
            }
        });

        return root;
    }
}
