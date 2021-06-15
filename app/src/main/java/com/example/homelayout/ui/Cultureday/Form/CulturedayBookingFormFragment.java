package com.example.homelayout.ui.Cultureday.Form;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.domain.CultureDayBooking;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CalculatePrices;
import com.example.homelayout.logic.CulturedayBookingInfo;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.home.HomeFragment;
import com.example.homelayout.ui.shoppingcart.ShoppingCartFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CulturedayBookingFormFragment extends Fragment {
    private String dateString;
    private ArrayList<Object> bookings;
    private TinyDB tinyDB;
    private Date date;
    private EditText time_scheme;
    private EditText learning_level;
    private double subtotal_amount = 0;
    private HashMap<String, Integer> values = new HashMap<>();
    private ArrayList<Workshops> workshops = new ArrayList<>();
    private Button btn_book_now_cdf;
    private TextView sub_total_cdf;
    private EditText extra_price_participants_amount;
    private EditText round_minutes;
    private Spinner dropdown_categories;
    private TextView extra_price_participants_amount_description;
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
    private DatePicker date_cultureday;
    private CalculatePrices calculatePrices = new CalculatePrices();
    private CulturedayBookingInfo culturedayBookingInfo = new CulturedayBookingInfo();
    private CheckBox cultureday_registration_box;
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
        tinyDB = new TinyDB(con);
        loadData();
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
        extra_price_participants_amount_description = root.findViewById(R.id.tv_cultureday_form_participants_shirt_and_drums_description);
        date_cultureday = (DatePicker)root.findViewById(R.id.tv_cultureday_form_date);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.date_cultureday.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Log.d("onDateChanged", "Nieuwe datum gekozen");
                    date = new Date(year, monthOfYear, dayOfMonth);
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/"+20+"YY");
                    dateString = dateFormat.format(date);
                    Log.d("WErktdit", dateString);
                }
            });
        }



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

        workshop_graffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Graffiti);
                    updateSubtotal();
                    extra_price_participants_amount.setVisibility(View.VISIBLE);
                    extra_price_participants_amount_description.setVisibility(View.VISIBLE);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Graffiti)){
                            workshops.remove(Workshops.Graffiti);
                        }
                    }
                    extra_price_participants_amount.setVisibility(View.GONE);
                    extra_price_participants_amount_description.setVisibility(View.GONE);
                    updateSubtotal();
                }
            }
        });
        workshop_bootcamp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Bootcamp);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Bootcamp)){
                            workshops.remove(Workshops.Bootcamp);
                        }
                    }
                }
            }
        });
        workshop_breakdance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Breakdance);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Breakdance)){
                            workshops.remove(Workshops.Breakdance);
                        }
                    }
                }
            }
        });
        workshop_capoeria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Capoeira);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Capoeira)){
                            workshops.remove(Workshops.Capoeira);
                        }
                    }
                }
            }
        });
        workshop_caribbeandrums.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.CaribbeanDrums);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.CaribbeanDrums)){
                            workshops.remove(Workshops.CaribbeanDrums);
                        }
                    }
                }
            }
        });
        workshop_dancefit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.DanceFit);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.DanceFit)){
                            workshops.remove(Workshops.DanceFit);
                        }
                    }
                }
            }
        });
        workshop_flashmob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Flashmob);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Flashmob)){
                            workshops.remove(Workshops.Flashmob);
                        }
                    }
                }
            }
        });
        workshop_freerunning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Freeruning);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Freeruning)){
                            workshops.remove(Workshops.Freeruning);
                        }
                    }
                }
            }
        });
        workshop_ghettodrums.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.GhettoDrums);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.GhettoDrums)){
                            workshops.remove(Workshops.GhettoDrums);
                        }
                    }
                }
            }
        });
        workshop_hiphop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Hiphop);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Hiphop)){
                            workshops.remove(Workshops.Hiphop);
                        }
                    }
                }
            }
        });
        workshop_kickboxing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Kickboksen);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Kickboksen)){
                            workshops.remove(Workshops.Kickboksen);
                        }
                    }
                }
            }
        });
        workshop_lightgraffiti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.LightGraffiti);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.LightGraffiti)){
                            workshops.remove(Workshops.LightGraffiti);
                        }
                    }
                }
            }
        });
        workshop_livelooping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.LiveLooping);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.LiveLooping)){
                            workshops.remove(Workshops.LiveLooping);
                        }
                    }
                }
            }
        });
        workshop_moderndance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.ModerneDans);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.ModerneDans)){
                            workshops.remove(Workshops.ModerneDans);
                        }
                    }
                }
            }
        });
        workshop_pannafootbal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Pannavoetbal);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Pannavoetbal)){
                            workshops.remove(Workshops.Pannavoetbal);
                        }
                    }
                }
            }
        });
        workshop_percussie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Percurssie);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Percurssie)){
                            workshops.remove(Workshops.Percurssie);
                        }
                    }
                }
            }
        });
        workshop_photoshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Photoshop);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Photoshop)){
                            workshops.remove(Workshops.Photoshop);
                        }
                    }
                }
            }
        });
        workshop_popstar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Popstar);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Popstar)){
                            workshops.remove(Workshops.Popstar);
                        }
                    }
                }
            }
        });
        workshop_rap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Rap);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Rap)){
                            workshops.remove(Workshops.Rap);
                        }
                    }
                }
            }
        });
        workshop_selfdefence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Zelfverdedeging);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Zelfverdedeging)){
                            workshops.remove(Workshops.Zelfverdedeging);
                        }
                    }
                }
            }
        });
        workshop_smartphonefoto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Fotografie);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Fotografie)){
                            workshops.remove(Workshops.Fotografie);
                        }
                    }
                }
            }
        });
        workshop_soap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.SoapActeren);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.SoapActeren)){
                            workshops.remove(Workshops.SoapActeren);
                        }
                    }
                }
            }
        });
        workshop_stagefight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.StageFighting);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.StageFighting)){
                            workshops.remove(Workshops.StageFighting);
                        }
                    }
                }
            }
        });
        workshop_stepping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Stepping);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Stepping)){
                            workshops.remove(Workshops.Stepping);
                        }
                    }
                }
            }
        });
        workshop_stopmotion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.StopMotion);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.StopMotion)){
                            workshops.remove(Workshops.StopMotion);
                        }
                    }
                }
            }
        });
        workshop_street.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Streetdance);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Streetdance)){
                            workshops.remove(Workshops.Streetdance);
                        }
                    }
                }
            }
        });
        workshop_theatersport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Theatersport);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.Theatersport)){
                            workshops.remove(Workshops.Theatersport);
                        }
                    }
                }
            }
        });
        workshop_tshirt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.TshirtOntwerpen);
                    updateSubtotal();
                    extra_price_participants_amount.setVisibility(View.VISIBLE);
                    extra_price_participants_amount_description.setVisibility(View.VISIBLE);
                } else {
                    for(Workshops i : workshops){
                        if(i.equals(Workshops.TshirtOntwerpen)){
                            workshops.remove(Workshops.TshirtOntwerpen);
                        }
                    }
                    updateSubtotal();
                    extra_price_participants_amount.setVisibility(View.GONE);
                    extra_price_participants_amount_description.setVisibility(View.GONE);
                }
            }
        });
        workshop_videoclip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Videoclip);
                }
            }
        });
        workshop_vlog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    workshops.add(Workshops.Vloggen);
                }
            }
        });


        cultureday_registration_box = root.findViewById(R.id.sv_cultureday_form_registration_box);
        btn_book_now_cdf = root.findViewById(R.id.button_book_now_cdf);
        btn_book_now_cdf.setClickable(true);
        time_scheme = root.findViewById(R.id.edm_cultureday_form_timescheme_field);
        learning_level = root.findViewById(R.id.edt_cultureday_form_learninglevel_field);

        btn_book_now_cdf.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onClick(View view) {
                    if(subtotal_amount < 1255.50) {
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
                    }else if (Integer.valueOf(round_minutes.getText().toString())<60) {
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
                    }else{
                        try {


                            System.out.println(date);
                            if (cultureday_registration_box.isChecked() == true){
                                culturedayBookingInfo.setRegistration(true);
                                System.out.println("Registration true");
                            } else {
                                culturedayBookingInfo.setRegistration(false);
                                System.out.println("Registration false");
                            }
                            culturedayBookingInfo.setLearninglevel(learning_level.getText().toString());
                            culturedayBookingInfo.setTimescheme(time_scheme.getText().toString());
                            culturedayBookingInfo.setParticepants(Integer.parseInt(workshop_particepents.getText().toString()));
                            culturedayBookingInfo.setRounds(Integer.parseInt(workshop_rounds.getText().toString()));
                            culturedayBookingInfo.setWorkshop_minutes(Integer.parseInt(round_minutes.getText().toString()));
                            culturedayBookingInfo.setWorkshops(workshops);
                            culturedayBookingInfo.setWorkshops_per_round(Integer.parseInt(workshop_per_round.getText().toString()));
                            culturedayBookingInfo.setPrice(calculatePrices.calculateCultureday(values, workshops));
                            culturedayBookingInfo.setDate(dateString);


                            // send to TinyDB
                            bookings.add(culturedayBookingInfo);
                            tinyDB.putListObject("CultureItems", bookings);
//                            Link to shopingcart
                            getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new ShoppingCartFragment()).commit();
                        }catch (Exception e){
                            System.out.println("Booking info invalet or incompelte");AlertDialog.Builder infopopup = new AlertDialog.Builder(con);
                            infopopup.setCancelable(true);
                            infopopup.setTitle("Niet alles ingevuld");
                            infopopup.setMessage("Niet alle velden ingevuld (Aantal deelnemers, Aantal rondes, Aantal workshops per ronde, Aantal minuten per workshop)");
                            infopopup.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            infopopup.show();
                        }
                    }
                }
        });
        return root;
    }

    public void updateSubtotal() {
        double subtotal = calculatePrices.calculateCultureday(values, workshops);
        this.subtotal_amount = subtotal;
        sub_total_cdf.setText("Subtotal: €" + subtotal + "0");
    }
    private void loadData(){
        bookings = tinyDB.getListObject("CultureItems", CulturedayBookingInfo.class);
        if (bookings == null){
            bookings = new ArrayList<>();
        }
    }
}
