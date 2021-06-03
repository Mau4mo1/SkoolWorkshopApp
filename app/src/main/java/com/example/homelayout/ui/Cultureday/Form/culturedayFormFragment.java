package com.example.homelayout.ui.Cultureday.Form;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;

public class culturedayFormFragment extends Fragment {
    private Button btn_book_now_cdf;
    private TextView sub_total_cdf;
    private EditText extra_price;
    private EditText round_minutes;
    public Context con;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday, container, false);
        con = container.getContext();
        btn_book_now_cdf = root.findViewById(R.id.button_boek_nu_cdf);
        btn_book_now_cdf.setClickable(true);

        sub_total_cdf = root.findViewById(R.id.tv_cultureday_form_subtotal);
        extra_price = root.findViewById(R.id.edn_cultureday_form_participants_shirt_and_drums_field);

        round_minutes = root.findViewById(R.id.edn_cultureday_form_time_per_round_field);

        int minutes = Integer.valueOf(String.valueOf(round_minutes.getText()));

        int extra = Integer.valueOf(String.valueOf(extra_price.getText()));

        sub_total_cdf.setText("subtotaal € van alle workshops");

        int sub = Integer.valueOf(String.valueOf(sub_total_cdf.getText()));

        btn_book_now_cdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(sub < 1255.50) {
                        new AlertDialog.Builder(con)
                                .setMessage("Minimaal bedraf voor een cultuurdag is €1255,50, boek meer workshops of boek deze los")

                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                    }else if (minutes < 60) {
                        new AlertDialog.Builder(con)
                                .setMessage("De workshops moeten 60 minuten of langer duren")

                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                    }
                }
//           else boek cultuurdag
        });

        return root;
//        Subtotaal
//        Prijs workshops
//        Prijs extra (grafiti)
    }
}
