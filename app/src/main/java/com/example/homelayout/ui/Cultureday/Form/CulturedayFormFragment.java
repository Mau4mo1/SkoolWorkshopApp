package com.example.homelayout.ui.Cultureday.Form;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CalculatePrices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CulturedayFormFragment extends Fragment {
    private HashMap<String, Integer> values = new HashMap<>();
    private ArrayList<Workshops> workshops = new ArrayList<>();
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
    private CalculatePrices calculatePrices = new CalculatePrices();
    private EditText workshop_particepents;
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
        workshop_particepents = root.findViewById(R.id.edn_cultureday_form_participants_field);

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
                    values.put("workshops", Integer.valueOf(workshop_per_round.getText().toString()));
                    updateSubtotal();
                } catch (Exception e){
                    System.out.println("Workshops per round is not a nummber");
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
                    values.put("rounds", Integer.valueOf(workshop_rounds.getText().toString()));
                    updateSubtotal();
                } catch (Exception e){
                    System.out.println("Rounds is not a nummber");
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
                    values.put("participantsGraffitiOrTshirtDesign", Integer.valueOf(extra_price_participants_amount.getText().toString()));
                    updateSubtotal();
                } catch (Exception e){
                    System.out.println("Particepants extra kost is not a nummber");
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
                    values.put("minutes", Integer.valueOf(round_minutes.getText().toString()));
                    updateSubtotal();
                } catch (Exception e){
                    System.out.println("Minutes is not a nummber");
                }
            }
        });

        final String[] kosten = {"Aantal workshoprondes - " + workshop_rounds.getText().toString() + "\nAantalworkshops per ronde - " + workshop_per_round.getText().toString() + "\nAantalminuten per workshopronde - " + round_minutes.getText().toString() + "\nWokrshops:"};
        ArrayList<Workshops> workshops = new ArrayList<>();
        workshop_graffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Graffiti);
                }
            }
        });
        workshop_bootcamp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Bootcamp);
                    kosten[0] = kosten[0] +"\n  Bootcamp";
                }
            }
        });
        workshop_breakdance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Breakdance);
                    kosten[0] = kosten[0] +"\n  Breakdance";
                }
            }
        });
        workshop_capoeria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Capoeira);
                    kosten[0] = kosten[0] +"\n  Capoeria";
                }
            }
        });
        workshop_caribbeandrums.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.CaribbeanDrums);
                    kosten[0] = kosten[0] +"\n  Caribbean drums";
                }
            }
        });
        workshop_dancefit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.DanceFit);
                    kosten[0] = kosten[0] +"\n  Dance fit";
                }
            }
        });
        workshop_flashmob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Flashmob);
                    kosten[0] = kosten[0] +"\n  Flashmob";
                }
            }
        });
        workshop_freerunning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Freeruning);
                    kosten[0] = kosten[0] +"\n  Freerunning";
                }
            }
        });
        workshop_ghettodrums.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.GhettoDrums);
                    kosten[0] = kosten[0] +"\n  Ghetto drums";
                }
            }
        });
        workshop_hiphop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Hiphop);
                    kosten[0] = kosten[0] +"\n  Hiphop";
                }
            }
        });
        workshop_kickboxing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Kickboksen);
                    kosten[0] = kosten[0] +"\n  Kickboksen";
                }
            }
        });
        workshop_lightgraffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.LightGraffiti);
                    kosten[0] = kosten[0] +"\n  Light graffiti";
                }
            }
        });
        workshop_livelooping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.LiveLooping);
                    kosten[0] = kosten[0] +"\n  Live looping";
                }
            }
        });
        workshop_moderndance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.ModerneDans);
                    kosten[0] = kosten[0] +"\n  Moderne dans";
                }
            }
        });
        workshop_pannafootbal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Pannavoetbal);
                    kosten[0] = kosten[0] +"\n  Pannavoetbal";
                }
            }
        });
        workshop_percussie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Percurssie);
                    kosten[0] = kosten[0] +"\n  Percurssie";
                }
            }
        });
        workshop_photoshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Photoshop);
                    kosten[0] = kosten[0] +"\n  Photoshop";
                }
            }
        });
        workshop_popstar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Popstar);
                    kosten[0] = kosten[0] +"\n  Popstar";
                }
            }
        });
        workshop_rap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Rap);
                    kosten[0] = kosten[0] +"\n  Rap";
                }
            }
        });
        workshop_selfdefence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Zelfverdedeging);
                    kosten[0] = kosten[0] +"\n  Zelfverdedeging";
                }
            }
        });
        workshop_smartphonefoto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Fotografie);
                    kosten[0] = kosten[0] +"\n  Smartphone fotografie";
                }
            }
        });
        workshop_soap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.SoapActeren);
                    kosten[0] = kosten[0] +"\n  Soap acteren";
                }
            }
        });
        workshop_stagefight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.StageFighting);
                    kosten[0] = kosten[0] +"\n  Stage fighting";
                }
            }
        });
        workshop_stepping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Stepping);
                    kosten[0] = kosten[0] +"\n  Stepping";
                }
            }
        });
        workshop_stopmotion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.StopMotion);
                    kosten[0] = kosten[0] +"\n  Stop motion";
                }
            }
        });
        workshop_street.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Streetdance);
                    kosten[0] = kosten[0] +"\n  Streetdance";
                }
            }
        });
        workshop_theatersport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Theatersport);
                    kosten[0] = kosten[0] +"\n  Theatersport";
                }
            }
        });
        workshop_tshirt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.TshirtOntwerpen);
                    kosten[0] = "\n  T-shirt ontwerpen";
                }
            }
        });
        workshop_videoclip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Videoclip);
                    kosten[0] = kosten[0] +"\n  Videoclip maken";
                }
            }
        });
        workshop_vlog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Vloggen);
                    kosten[0] = kosten[0] +"\n  Vloggen";
                }
            }
        });

        btn_book_now_cdf = root.findViewById(R.id.button_book_now_cdf);
        btn_book_now_cdf.setClickable(true);

        btn_book_now_cdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Double.valueOf(sub_total_cdf.getText().toString()) < 1255.50) {
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
                    if (Integer.valueOf(round_minutes.getText().toString())<60) {
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

    public void updateSubtotal() {
        double subtotal = calculatePrices.calculateCultureday(values, workshops);
        sub_total_cdf.setText(String.valueOf(subtotal));
    }
}
