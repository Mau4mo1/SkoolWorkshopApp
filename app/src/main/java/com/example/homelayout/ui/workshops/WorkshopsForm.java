package com.example.homelayout.ui.workshops;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CalculatePrices;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class WorkshopsForm extends Fragment {
    private HashMap<String, Integer> values = new HashMap<>();
    private CalculatePrices calculatePrices = new CalculatePrices();
    private Workshops workshop;
    private Context thisContext;
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

    public WorkshopsForm(Workshops workshop) {
        this.workshop = workshop;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_workshops_form, container, false);
        thisContext = container.getContext();
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

            }
        });

        return root;
    }

    public void updateSubtotal() {
            String subtotal = "Subtotaal: €" + calculatePrices.getWorkshopCalc(workshop, values) + "0";
            mTextViewWorkshopSubtotal.setText(subtotal);
        }
}