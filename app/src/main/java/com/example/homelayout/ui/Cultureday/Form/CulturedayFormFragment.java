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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CulturedayFormFragment extends Fragment {
    private Button btn_book_now_cdf;
    private TextView sub_total_cdf;
    private EditText extra_price_participants_amount;
    private EditText round_minutes;
    private Spinner dropdown_categories;
    public Context con;
    private CheckBox workshop_check_dans;
    private EditText workshop_per_round;
    private ArrayList items;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday_form, container, false);
        con = container.getContext();
        btn_book_now_cdf = root.findViewById(R.id.button_book_now_cdf);
        btn_book_now_cdf.setClickable(true);

        sub_total_cdf = root.findViewById(R.id.tv_cultureday_form_subtotal_amount);
        extra_price_participants_amount = root.findViewById(R.id.edn_cultureday_form_participants_shirt_and_drums_field);
        round_minutes = root.findViewById(R.id.edn_cultureday_form_time_per_round_field);
        workshop_per_round = root.findViewById(R.id.edn_cultureday_form_workshops_per_round_field);

        dropdown_categories = root.findViewById(R.id.sv_cultureday_form_catagorie_dropdown);
        workshop_check_dans = root.findViewById(R.id.sv_cultureday_form_workshoplist_dans);
        List<String> categories = new ArrayList<>();
        categories.add("Dans");
        categories.add("Sport");

        ArrayAdapter<String> catagorie_dd = new ArrayAdapter<>(con, android.R.layout.simple_list_item_1, categories);
        catagorie_dd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown_categories.setAdapter(catagorie_dd);

        dropdown_categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                if(dropdown_categories.getSelectedItemPosition() == 0) {
                    workshop_check_dans.setVisibility(View.VISIBLE);
                } else if(dropdown_categories.getSelectedItemPosition() == 1){
                    workshop_check_dans.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        try {
            double extra = Integer.valueOf(extra_price_participants_amount.getText().toString())*7.50;
        } catch (Exception e){
            AlertDialog.Builder extrapopup_error = new AlertDialog.Builder(con);
            extrapopup_error.setCancelable(true);
            extrapopup_error.setTitle("Deelnemers Graffiti/T-shirt ontwerpen");
            extrapopup_error.setMessage("Deelnemers voor Graffiti/T-shirt ontwerpen is geen nummer");
            extrapopup_error.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            extrapopup_error.show();
        }
        try {
            int work_per_round = Integer.valueOf(workshop_per_round.getText().toString());
        } catch (Exception e){
            AlertDialog.Builder minpopup_error = new AlertDialog.Builder(con);
            minpopup_error.setCancelable(true);
            minpopup_error.setTitle("Aantal rondes");
            minpopup_error.setMessage("Aantal rondes is geen nummer");
            minpopup_error.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            minpopup_error.show();
        }


        btn_book_now_cdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        int minutes = Integer.valueOf(round_minutes.getText().toString());
                    } catch (Exception e){
                        AlertDialog.Builder minpopup_error = new AlertDialog.Builder(con);
                        minpopup_error.setCancelable(true);
                        minpopup_error.setTitle("Aantal rondes");
                        minpopup_error.setMessage("Aantal rondes is geen nummer");
                        minpopup_error.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        minpopup_error.show();
                    }
                    if(Integer.valueOf(sub_total_cdf.getText().toString()) < 1255.50) {
                        AlertDialog.Builder subpopup = new AlertDialog.Builder(con);
                        subpopup.setCancelable(true);
                        subpopup.setTitle("Subtotaal niet genoeg");
                        subpopup.setMessage("Minimaal bedrag voor een cultuurdag is €1255,50, boek meer workshops of boek deze los");
                        subpopup.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        subpopup.show();
                    }else if (Integer.valueOf(round_minutes.getText().toString()) < 60) {
                        AlertDialog.Builder minpopup = new AlertDialog.Builder(con);
                        minpopup.setCancelable(true);
                        minpopup.setTitle("Workshops te kort");
                        minpopup.setMessage("De workshops moeten 60 minuten of langer duren");
                        minpopup.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        minpopup.show();
                    }
                }
        });
        return root;
    }
}
