package com.example.homelayout.ui.Cultureday.Form;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CalculatePrices;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class CulturedayBookingFormFragment extends Fragment {
    private TextView mCulturedayFormTitle;
    private TextView mCulturedayFormDate;
    private ImageButton mCulturedayChooseDate;
    private EditText mCulturedayTimeschemeInput;
    private EditText mCulturedayRoundsInput;
    private EditText mCulturedayWorkshopsPerRoundInput;
    private EditText mCulturedayMinutesPerRoundInput;
    private RecyclerView mCulturedayRecyclerViewAvailableWorkshops;
    private EditText mCulturedayParticipantsInput;
    private TextView mCulturedayParticipantsGraffitiOrTshirt;
    private EditText mCulturedayParticipantsGraffitiOrTshirtInput;
    private EditText mCulturedayLearningLevelInput;
    private TextView mTextViewCulturedaySubtotal;
    private RadioButton mCulturedayInlogSystemYes;
    private RadioButton mCulturedayInlogSystemNo;
    private Context thisContext;
    private CalculatePrices calculatePrices = new CalculatePrices();
    private HashMap<String, Integer> values = new HashMap<>();
    private ArrayList<Workshops> workshops = new ArrayList<>();
    private BottomNavigationView bottomNav;
    private MenuItem cultureItem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cultureday_form, container, false);
        thisContext = container.getContext();


        this.mCulturedayFormTitle = (TextView) root.findViewById(R.id.tv_cultureday_form_title);
        this.mCulturedayFormDate = (TextView) root.findViewById(R.id.tv_cultureday_form_date);
        this.mCulturedayChooseDate = (ImageButton) root.findViewById(R.id.b_cultureday_form_choose_date);
        this.mCulturedayChooseDate.setClickable(true);
        this.mCulturedayRecyclerViewAvailableWorkshops = (RecyclerView) root.findViewById(R.id.sv_cultureday_form_workshoplist);
        this.mCulturedayParticipantsGraffitiOrTshirt = (TextView) root.findViewById(R.id.tv_cultureday_form_participants_shirt_and_drums_description);
        this.mTextViewCulturedaySubtotal = (TextView) root.findViewById(R.id.tv_cultureday_form_subtotal);
        this.mCulturedayRoundsInput = (EditText) root.findViewById(R.id.edn_cultureday_form_rounds_field);
        mCulturedayRoundsInput.addTextChangedListener(new TextWatcher() {

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
                    values.put("rounds", Integer.valueOf(String.valueOf(mCulturedayRoundsInput.getText())));
                    updateSubtotal();
                }
            }
        });
        this.mCulturedayWorkshopsPerRoundInput = (EditText) root.findViewById(R.id.edn_cultureday_form_workshops_per_round_field);
        mCulturedayWorkshopsPerRoundInput.addTextChangedListener(new TextWatcher() {

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
                    values.put("workshops", Integer.valueOf(String.valueOf(mCulturedayWorkshopsPerRoundInput.getText())));
                    updateSubtotal();
                }
            }
        });

        this.mCulturedayMinutesPerRoundInput = (EditText) root.findViewById(R.id.edn_cultureday_form_time_per_round_field);
        mCulturedayMinutesPerRoundInput.addTextChangedListener(new TextWatcher() {

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
                    values.put("minutes", Integer.valueOf(String.valueOf(mCulturedayMinutesPerRoundInput.getText())));
                    updateSubtotal();
                }
            }
        });

        this.mCulturedayTimeschemeInput = (EditText) root.findViewById(R.id.edm_cultureday_form_timescheme_field);
        this.mCulturedayParticipantsInput = (EditText) root.findViewById(R.id.edn_cultureday_form_participants_field);
        mCulturedayParticipantsInput.addTextChangedListener(new TextWatcher() {

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
                    values.put("participants", Integer.valueOf(String.valueOf(mCulturedayParticipantsInput.getText())));
                    updateSubtotal();
                }
            }
        });
        this.mCulturedayParticipantsGraffitiOrTshirtInput = (EditText) root.findViewById(R.id.edn_cultureday_form_participants_shirt_and_drums_field);
        this.mCulturedayLearningLevelInput = (EditText) root.findViewById(R.id.edt_cultureday_form_learninglevel_field);
        this.mCulturedayInlogSystemYes = (RadioButton) root.findViewById(R.id.rb_cultureday_form_inlogsystem_yes);
        this.mCulturedayInlogSystemYes.setClickable(true);

        // Check if person wants to use the inlog system
        //        mCulturedayInlogSystemYes.isChecked();

        this.mCulturedayInlogSystemNo = (RadioButton) root.findViewById(R.id.rb_cultureday_form_inlogsystem_no);
        this.mCulturedayInlogSystemNo.setClickable(true);
        return root;
    }

    public void updateSubtotal() {
        String subtotal = "Subtotaal: €" + calculatePrices.calculateCultureday(values, workshops) + "0";
        mTextViewCulturedaySubtotal.setText(subtotal);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.nav_view);
        navigation.getMenu().getItem(2).setChecked(true);
    }
}


//        btn_boek_nu_cdf = root.findViewById(R.id.button_meer_informatie_cd);
//        btn_boek_nu_cdf.setClickable(true);
//        btn_boek_nu_cdf.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                new AlertDialog.Builder(container.getContext())
//                        .setMessage("Minimaal bedraf voor een cultuurdag is €1255,50, boek meer workshops of boek deze los")
//
////                         Specifying a listener allows you to take an action before dismissing the dialog.
////                         The dialog is automatically dismissed when a dialog button is clicked.
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Continue with delete operation
//                            }
//                        });
//              }
//        });


