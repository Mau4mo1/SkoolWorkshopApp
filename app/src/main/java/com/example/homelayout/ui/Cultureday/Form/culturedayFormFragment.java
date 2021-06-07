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

public class culturedayFormFragment extends Fragment {
    private Button btn_book_now_cdf;
    private TextView sub_total_cdf;
    private EditText extra_price;
    private EditText round_minutes;
    private Spinner dropdown_categories;
    public Context con;
    private CheckBox workshop_check_dans;
    private ArrayList items;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday_form, container, false);
        con = container.getContext();
        btn_book_now_cdf = root.findViewById(R.id.button_book_now_cdf);
        btn_book_now_cdf.setClickable(true);

        sub_total_cdf = root.findViewById(R.id.tv_cultureday_form_subtotal);
        extra_price = root.findViewById(R.id.edn_cultureday_form_participants_shirt_and_drums_field);

        round_minutes = root.findViewById(R.id.edn_cultureday_form_time_per_round_field);

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

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        sub_total_cdf.setText("subtotaal € van alle workshops");
        btn_book_now_cdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int minutes = 0;
                    int sub = 0;
                    int extra = 0;
                    extra = Integer.valueOf(String.valueOf(extra_price.getText()));
                    minutes = Integer.valueOf(String.valueOf(round_minutes.getText()));
                    sub = Integer.valueOf(String.valueOf(sub_total_cdf.getText()));
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
        });

        return root;
    }
}
