package com.example.homelayout.ui.workshops;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CalculatePrices;

import java.util.HashMap;

public class WorkshopsForm extends Fragment {
    private HashMap<String, Integer> values = new HashMap<>();
    private CalculatePrices calculatePrices;
    private Context thisContext;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_workshops_form, container, false);
        thisContext = container.getContext();

        this.mTextViewWorkshopFormTitle = (TextView) root.findViewById(R.id.tv_workshops_form_title);
        this.mDatePickerWorkshopForm = (DatePicker) root.findViewById(R.id.dp_workshop_form);
        this.mTextViewWorkshopsParticipants = (TextView) root.findViewById(R.id.tv_workshops_participants);
        this.mEditTextWorkshopParticipants = (EditText) root.findViewById(R.id.et_workshop_participants);
        this.mTextViewWorkshopRounds = (TextView) root.findViewById(R.id.tv_workshops_rounds);
        this.mEditTextWorkshopRounds = (EditText) root.findViewById(R.id.et_workshop_rounds);
        this.mTextViewWorkshopMinutes = (TextView) root.findViewById(R.id.tv_workshops_minutes);
        this.mEditTextWorkshopMinutes = (EditText) root.findViewById(R.id.et_workshop_minutes);
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
                values.put("participants", Integer.valueOf(String.valueOf(mEditTextWorkshopParticipants.getText())));
                values.put("rounds", Integer.valueOf(String.valueOf(mEditTextWorkshopRounds.getText())));
                values.put("minutes", Integer.valueOf(String.valueOf(mEditTextWorkshopMinutes.getText())));
                calculatePrices = new CalculatePrices();
                String subtotal = "Subtotaal: €" + calculatePrices.getWorkshopCalc(Workshops.Breakdance, values);
                mTextViewWorkshopSubtotal.setText(subtotal);
            }
        });

        return root;

    }
}