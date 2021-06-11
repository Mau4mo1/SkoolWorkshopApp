package com.example.homelayout.ui.workshops;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CalculatePrices;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.shoppingcart.ShoppingCartFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class WorkshopsForm extends Fragment {


    private ArrayList<Object> workshopCardList;
    private HashMap<String, Integer> values = new HashMap<>();
    private CalculatePrices calculatePrices = new CalculatePrices();
    private Workshops workshop;
    private Context thisContext;
    private TinyDB tinydb;
    private int rounds = 1;
    private int minutes;
    private Date date;
    private TextView mTextViewWorkshopTotalMinutes;
    private TextView mTextViewWorkshopFormTitle;
    private DatePicker mDatePickerWorkshopForm;
    private TextView mTextViewWorkshopsParticipants;
    private EditText mEditTextWorkshopParticipants;
    private TextView mTextViewWorkshopRounds;
    private EditText mEditTextWorkshopRounds;
    private TextView mTextViewWorkshopMinutes;
    private EditText mEditTextWorkshopMinutes;
    private TextView mTextViewWorkshopTimetable;
    private EditText mEditTextWorkshopTimetable;
    private TextView mTextViewWorkshopLearningLevel;
    private EditText mEditTextWorkshopLearningLevel;
    private TextView mTextViewWorkshopSubtotal;
    private Button mButtonWorkshopsBook;
    private SharedPreferences sharedPreferences;

    public WorkshopsForm(Workshops workshop) {
        this.workshop = workshop;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//
        // Inflate the layout for this fragment
        // pls werk
        View root = inflater.inflate(R.layout.fragment_workshops_form, container, false);
        thisContext = container.getContext();
       tinydb = new TinyDB(thisContext);
       loadData();
        mTextViewWorkshopsParticipants = (TextView) root.findViewById(R.id.tv_workshops_participants);
        mTextViewWorkshopFormTitle = (TextView) root.findViewById(R.id.tv_workshops_form_title);
        mTextViewWorkshopFormTitle.setText("Workshop " + this.workshop);

        switch (workshop){
            case Graffiti:
            case TshirtOntwerpen:
                mTextViewWorkshopsParticipants.setText("Totale aantal deelnemers * (+€7,50)");
                break;
            default:
                mTextViewWorkshopsParticipants.setText("Totale aantal deelnemers ");
        }

        this.mDatePickerWorkshopForm = (DatePicker) root.findViewById(R.id.dp_workshop_form);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.mDatePickerWorkshopForm.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {

                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Log.d("onDateChanged", "Nieuwe datum gekozen");
                    date = new Date(year, monthOfYear, dayOfMonth);
                }
            });
        }
        this.mEditTextWorkshopParticipants = (EditText) root.findViewById(R.id.et_workshop_participants);
        this.mEditTextWorkshopParticipants.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0){
                    values.put("participants", Integer.valueOf(String.valueOf(mEditTextWorkshopParticipants.getText())));
                    updateSubtotal();
                }
            }
        });

        this.mEditTextWorkshopRounds = (EditText) root.findViewById(R.id.et_workshop_rounds);
        this.mEditTextWorkshopRounds.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0){
                    rounds = Integer.parseInt(String.valueOf(mEditTextWorkshopRounds.getText()));
                    values.put("rounds", rounds);
                    updateSubtotal();
                }
            }
        });

        this.mTextViewWorkshopTotalMinutes = (TextView) root.findViewById(R.id.tv_total_minutes);
        this.mEditTextWorkshopMinutes = (EditText) root.findViewById(R.id.et_workshop_minutes);
        this.mEditTextWorkshopMinutes.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0){
                    minutes = Integer.valueOf(String.valueOf(mEditTextWorkshopMinutes.getText()));
                    values.put("minutes", minutes);
                    mTextViewWorkshopTotalMinutes.setText("Totaal aantal minuten: " + rounds * minutes);
                    updateSubtotal();
                }
            }
        });

        this.mTextViewWorkshopTimetable = (TextView) root.findViewById(R.id.tv_workshops_timetable);
        this.mEditTextWorkshopTimetable = (EditText) root.findViewById(R.id.et_workshop_timetable);
        this.mTextViewWorkshopLearningLevel = (TextView) root.findViewById(R.id.tv_workshops_learning_level);
        this.mEditTextWorkshopLearningLevel = (EditText) root.findViewById(R.id.et_workshop_learning_level);
        this.mTextViewWorkshopSubtotal = (TextView) root.findViewById(R.id.tv_subtotal);
        this.mButtonWorkshopsBook = (Button) root.findViewById(R.id.btn_workshop_form_book);


        this.mButtonWorkshopsBook.setClickable(true);
        this.mButtonWorkshopsBook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String dienst = mTextViewWorkshopFormTitle.getText().toString();
                int minuten = minutes;
                int rondes = rounds;
                String tijdschema = mEditTextWorkshopTimetable.getText().toString();
                String leerniveau = mEditTextWorkshopLearningLevel.getText().toString();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/"+20+"YY");
                String datum = dateFormat.format(date);
                Log.d("test", datum);
                double prijs = calculatePrices.getWorkshopCalc(workshop, values);
                WorkshopBooking workshops = new WorkshopBooking(dienst, rondes, minuten,tijdschema,leerniveau,datum,prijs);

                workshopCardList.add(workshops);
                tinydb.putListObject("Carditems", workshopCardList);
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ShoppingCartFragment()).commit();

                //s.addWorkshops(workshops);
                Log.d("Boeken", "Boeking is gelukt hier");
            }
        });

        return root;
    }

    public void updateSubtotal() {
            String subtotal = "Subtotaal: €" + calculatePrices.getWorkshopCalc(workshop, values) + "0";
            mTextViewWorkshopSubtotal.setText(subtotal);
        }
//        private void saveData(){
//            Gson gson = new Gson();
//            String json = gson.toJson(workshopCardList);
//            requireActivity().getSharedPreferences("shopping_card", Context.MODE_PRIVATE).edit().putString("card_item_title", json).apply();
//        }
        private void loadData(){

               workshopCardList = tinydb.getListObject("Carditems",WorkshopBooking.class);
               if (workshopCardList == null){
                   workshopCardList = new ArrayList<>();
               }
        }


}