package com.example.homelayout.ui.Cultureday.Form;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
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
    private GridLayout workshop_check_dance;
    private GridLayout workshop_check_sport;
    private GridLayout workshop_check_media;
    private GridLayout workshop_check_art;
    private GridLayout workshop_check_music;
    private GridLayout workshop_check_theater;
    private EditText workshop_per_round;
    private EditText workshop_rounds;
    private TextView prijs_summery;
    private CheckBox workshop_graffiti;
    private CheckBox workshop_lightgraffiti;
    private CheckBox workshop_stopmotion;
    private CheckBox workshop_tshirt;
    private CheckBox workshop_breakdance;
    private CheckBox workshop_flashmob;
    private CheckBox workshop_dancefit;
    private CheckBox workshop_hiphop;
    private CheckBox workshop_moderndance;
    private CheckBox workshop_stepping;
    private CheckBox workshop_street;
    private CheckBox workshop_photoshop;
    private CheckBox workshop_vlog;
    private CheckBox workshop_smartphonefoto;
    private CheckBox workshop_videoclip;
    private CheckBox workshop_caribbeandrums;
    private CheckBox workshop_livelooping;
    private CheckBox workshop_percussie;
    private CheckBox workshop_popstar;
    private CheckBox workshop_rap;
    private CheckBox workshop_bootcamp;
    private CheckBox workshop_capoeria;
    private CheckBox workshop_freerunning;
    private CheckBox workshop_kickboxing;
    private CheckBox workshop_ghettodrums;
    private CheckBox workshop_pannafootbal;
    private CheckBox workshop_selfdefence;
    private CheckBox workshop_soap;
    private CheckBox workshop_stagefight;
    private CheckBox workshop_theatersport;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday_form, container, false);
        con = container.getContext();

        dropdown_categories = root.findViewById(R.id.sv_cultureday_form_catagorie_dropdown);
        workshop_check_dance = root.findViewById(R.id.sv_cultureday_form_workshoplist_dance);
        workshop_check_sport = root.findViewById(R.id.sv_cultureday_form_workshoplist_sport);
        workshop_check_media = root.findViewById(R.id.sv_cultureday_form_workshoplist_media);
        workshop_check_music = root.findViewById(R.id.sv_cultureday_form_workshoplist_music);
        workshop_check_art = root.findViewById(R.id.sv_cultureday_form_workshoplist_visualarts);
        workshop_check_theater = root.findViewById(R.id.sv_cultureday_form_workshoplist_theater);
        List<String> categories = new ArrayList<>();
        categories.add("Dans");
        categories.add("Sport");
        categories.add("Beeldende kunst");
        categories.add("Media");
        categories.add("Muziek");
        categories.add("Theater");

        ArrayAdapter<String> catagorie_dd = new ArrayAdapter<>(con, android.R.layout.simple_list_item_1, categories);
        catagorie_dd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown_categories.setAdapter(catagorie_dd);

        dropdown_categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                if(dropdown_categories.getSelectedItemPosition() == 0) {
                    workshop_check_dance.setVisibility(View.VISIBLE);
                    workshop_check_sport.setVisibility(View.GONE);
                    workshop_check_media.setVisibility(View.GONE);
                    workshop_check_music.setVisibility(View.GONE);
                    workshop_check_art.setVisibility(View.GONE);
                    workshop_check_theater.setVisibility(View.GONE);
                }else if(dropdown_categories.getSelectedItemPosition() == 1){
                    workshop_check_dance.setVisibility(View.GONE);
                    workshop_check_sport.setVisibility(View.VISIBLE);
                    workshop_check_media.setVisibility(View.GONE);
                    workshop_check_music.setVisibility(View.GONE);
                    workshop_check_art.setVisibility(View.GONE);
                    workshop_check_theater.setVisibility(View.GONE);
                }else if(dropdown_categories.getSelectedItemPosition() == 2){
                    workshop_check_dance.setVisibility(View.GONE);
                    workshop_check_sport.setVisibility(View.GONE);
                    workshop_check_media.setVisibility(View.GONE);
                    workshop_check_music.setVisibility(View.GONE);
                    workshop_check_art.setVisibility(View.VISIBLE);
                    workshop_check_theater.setVisibility(View.GONE);
                }else if(dropdown_categories.getSelectedItemPosition() == 3){
                    workshop_check_dance.setVisibility(View.GONE);
                    workshop_check_sport.setVisibility(View.GONE);
                    workshop_check_media.setVisibility(View.VISIBLE);
                    workshop_check_music.setVisibility(View.GONE);
                    workshop_check_art.setVisibility(View.GONE);
                    workshop_check_theater.setVisibility(View.GONE);
                }else if(dropdown_categories.getSelectedItemPosition() == 4){
                    workshop_check_dance.setVisibility(View.GONE);
                    workshop_check_sport.setVisibility(View.GONE);
                    workshop_check_media.setVisibility(View.GONE);
                    workshop_check_music.setVisibility(View.VISIBLE);
                    workshop_check_art.setVisibility(View.GONE);
                    workshop_check_theater.setVisibility(View.GONE);
                }else if(dropdown_categories.getSelectedItemPosition() == 5){
                    workshop_check_dance.setVisibility(View.GONE);
                    workshop_check_sport.setVisibility(View.GONE);
                    workshop_check_media.setVisibility(View.GONE);
                    workshop_check_music.setVisibility(View.GONE);
                    workshop_check_art.setVisibility(View.GONE);
                    workshop_check_theater.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                workshop_check_dance.setVisibility(View.GONE);
                workshop_check_sport.setVisibility(View.GONE);
                workshop_check_media.setVisibility(View.GONE);
                workshop_check_music.setVisibility(View.GONE);
                workshop_check_art.setVisibility(View.GONE);
                workshop_check_theater.setVisibility(View.GONE);
            }
        });

        workshop_graffiti = root.findViewById(R.id.sv_cultureday_form_workshoplist_graffiti);
        workshop_lightgraffiti = root.findViewById(R.id.sv_cultureday_form_workshoplist_lightgraffiti);
        workshop_stopmotion = root.findViewById(R.id.sv_cultureday_form_workshoplist_stopmotion);
        workshop_tshirt = root.findViewById(R.id.sv_cultureday_form_workshoplist_designtshirt);
        workshop_breakdance = root.findViewById(R.id.sv_cultureday_form_workshoplist_breakdance);
        workshop_flashmob = root.findViewById(R.id.sv_cultureday_form_workshoplist_flashmob);
        workshop_dancefit = root.findViewById(R.id.sv_cultureday_form_workshoplist_dancefit);
        workshop_hiphop = root.findViewById(R.id.sv_cultureday_form_workshoplist_hiphop);
        workshop_moderndance = root.findViewById(R.id.sv_cultureday_form_workshoplist_moderndance);
        workshop_stepping = root.findViewById(R.id.sv_cultureday_form_workshoplist_stepping);
        workshop_street = root.findViewById(R.id.sv_cultureday_form_workshoplist_street);
        workshop_photoshop = root.findViewById(R.id.sv_cultureday_form_workshoplist_photoshop);
        workshop_vlog = root.findViewById(R.id.sv_cultureday_form_workshoplist_vlog);
        workshop_smartphonefoto = root.findViewById(R.id.sv_cultureday_form_workshoplist_smartphone);
        workshop_videoclip = root.findViewById(R.id.sv_cultureday_form_workshoplist_video);
        workshop_caribbeandrums = root.findViewById(R.id.sv_cultureday_form_workshoplist_caribbean);
        workshop_livelooping = root.findViewById(R.id.sv_cultureday_form_workshoplist_livelooping);
        workshop_percussie = root.findViewById(R.id.sv_cultureday_form_workshoplist_percussie);
        workshop_popstar = root.findViewById(R.id.sv_cultureday_form_workshoplist_popstar);
        workshop_rap = root.findViewById(R.id.sv_cultureday_form_workshoplist_rap);
        workshop_bootcamp = root.findViewById(R.id.sv_cultureday_form_workshoplist_bootcamp);
        workshop_capoeria = root.findViewById(R.id.sv_cultureday_form_workshoplist_capoeira);
        workshop_freerunning = root.findViewById(R.id.sv_cultureday_form_workshoplist_freerunning);
        workshop_kickboxing = root.findViewById(R.id.sv_cultureday_form_workshoplist_kickboxing);
        workshop_ghettodrums = root.findViewById(R.id.sv_cultureday_form_workshoplist_ghettodrums);
        workshop_pannafootbal = root.findViewById(R.id.sv_cultureday_form_workshoplist_pannafootbal);
        workshop_selfdefence = root.findViewById(R.id.sv_cultureday_form_workshoplist_selfdefence);
        workshop_soap = root.findViewById(R.id.sv_cultureday_form_workshoplist_soap);
        workshop_stagefight = root.findViewById(R.id.sv_cultureday_form_workshoplist_stagefighting);
        workshop_theatersport = root.findViewById(R.id.sv_cultureday_form_workshoplist_Theatersport);

        sub_total_cdf = root.findViewById(R.id.tv_cultureday_form_subtotal_amount);
        extra_price_participants_amount = root.findViewById(R.id.edn_cultureday_form_participants_shirt_and_drums_field);
        round_minutes = root.findViewById(R.id.edn_cultureday_form_time_per_round_field);
        workshop_per_round = root.findViewById(R.id.edn_cultureday_form_workshops_per_round_field);
        workshop_rounds = root.findViewById(R.id.edn_cultureday_form_rounds_field);
        prijs_summery = root.findViewById(R.id.tv_cultureday_form_kost);

        workshop_per_round.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    workshop_graffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked == true){
                                double min = Integer.valueOf(round_minutes.getText().toString());
                                double rounds = Integer.valueOf(workshop_rounds.getText().toString());
                                sub_total_cdf.setText(String.valueOf(min*rounds*2.325+25));
                                prijs_summery.setText(prijs_summery.getText()+"/nGraffiti: €"+String.valueOf(min*rounds*2.325+25));
                            }
                        }
                    });
                } catch (Exception e){
                    AlertDialog.Builder extrapopup_error = new AlertDialog.Builder(con);
                    extrapopup_error.setCancelable(true);
                    extrapopup_error.setTitle("Workshops per ronden");
                    extrapopup_error.setMessage("Workshops per ronden is geen nummer");
                    extrapopup_error.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    extrapopup_error.show();
                }
            }
        });
        workshop_rounds.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    workshop_graffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked == true){
                                double min = Integer.valueOf(round_minutes.getText().toString());
                                double rounds = Integer.valueOf(workshop_rounds.getText().toString());
                                sub_total_cdf.setText(String.valueOf(min*rounds*2.325+25));
                                prijs_summery.setText(prijs_summery.getText()+"/nGraffiti: €"+String.valueOf(min*rounds*2.325+25));
                            }
                        }
                    });
                } catch (Exception e){
                    AlertDialog.Builder extrapopup_error = new AlertDialog.Builder(con);
                    extrapopup_error.setCancelable(true);
                    extrapopup_error.setTitle("Rondes");
                    extrapopup_error.setMessage("Rondes is geen nummer");
                    extrapopup_error.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    extrapopup_error.show();
                }
            }
        });
        extra_price_participants_amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    double extra = Integer.valueOf(extra_price_participants_amount.getText().toString())*7.50;
                    sub_total_cdf.setText(String.valueOf(Integer.valueOf(sub_total_cdf.getText().toString())+extra));
                    prijs_summery.setText(prijs_summery.getText()+"/nExtra kosten: €"+String.valueOf(extra));
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
            }
        });
        round_minutes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Integer.valueOf(round_minutes.getText().toString())<60){
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
                    workshop_graffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked == true){
                                double min = Integer.valueOf(round_minutes.getText().toString());
                                double rounds = Integer.valueOf(workshop_rounds.getText().toString());
                                sub_total_cdf.setText(String.valueOf(min*rounds*2.325+25));
                                prijs_summery.setText(prijs_summery.getText()+"/nGraffiti: €"+String.valueOf(min*rounds*2.325+25));
                            }
                        }
                    });
                } catch (Exception e){
                    AlertDialog.Builder extrapopup_error = new AlertDialog.Builder(con);
                    extrapopup_error.setCancelable(true);
                    extrapopup_error.setTitle("Aantal minuten per workshop ronden");
                    extrapopup_error.setMessage("Aantal minuten per workshop ronden is geen nummer");
                    extrapopup_error.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    extrapopup_error.show();
                }
            }
        });

        workshop_graffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    double min = Integer.valueOf(round_minutes.getText().toString());
                    double rounds = Integer.valueOf(workshop_rounds.getText().toString());
                    sub_total_cdf.setText(String.valueOf(min*rounds*2.325+25));
                    prijs_summery.setText(prijs_summery.getText()+"/nGraffiti: €"+String.valueOf(min*rounds*2.325+25));
                }
            }
        });

        btn_book_now_cdf = root.findViewById(R.id.button_book_now_cdf);
        btn_book_now_cdf.setClickable(true);

        btn_book_now_cdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
                    }
                }
        });
        return root;
    }
}
