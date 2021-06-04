package com.example.homelayout.ui.Cultureday.Form;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class CulturedayFormFragment extends Fragment {
    private TextView mCulturedayFormTitle;
    private TextView mCulturedayFormDate;
    private ImageButton mCulturedayChooseDate;
    private TextView mCulturedayRounds;
    private EditText mCulturedayRoundsInput;
    private TextView mCulturedayWorkshopsPerRound;
    private EditText mCulturedayWorkshopsPerRoundInput;
    private TextView mCulturedayMinutesPerRound;
    private EditText mCulturedayMinutesPerRoundInput;
    private TextView mCulturedayWorkshopsDescription;
    private RecyclerView mCulturedayRecyclerViewAvailableWorkshops;
    private TextView mCulturedayTimeschemeDescription;
    private TextView mCulturedayTimeschemeSubscription;
    private EditText mCulturedayTimeschemeInput;
    private TextView mCulturedayParticipants;
    private EditText mCulturedayParticipantsInput;
    private TextView mCulturedayParticipantsGraffitiOrTshirt;
    private EditText mCulturedayParticipantsGraffitiOrTshirtInput;
    private TextView mCulturedayLearningLevel;
    private EditText mCulturedayLearningLevelInput;
    private TextView mCulturedayInlogSystem;
    private RadioButton mCulturedayInlogSystemYes;
    private RadioButton mCulturedayInlogSystemNo;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cultureday_form, container, false);

        this.mCulturedayFormTitle = (TextView) root.findViewById(R.id.tv_cultureday_form_title);
        this.mCulturedayFormDate = (TextView) root.findViewById(R.id.tv_cultureday_form_date);
        this.mCulturedayChooseDate = (ImageButton) root.findViewById(R.id.b_cultureday_form_choose_date);
        this.mCulturedayChooseDate.setClickable(true);
        this.mCulturedayRounds = (TextView) root.findViewById(R.id.tv_cultureday_form_rounds_description);
        this.mCulturedayRoundsInput = (EditText) root.findViewById(R.id.edn_cultureday_form_rounds_field);
        this.mCulturedayWorkshopsPerRound = (TextView) root.findViewById(R.id.tv_cultureday_form_workshops_per_round_description);
        this.mCulturedayWorkshopsPerRoundInput = (EditText) root.findViewById(R.id.edn_cultureday_form_workshops_per_round_field);
        this.mCulturedayMinutesPerRound = (TextView) root.findViewById(R.id.tv_cultureday_form_time_per_round_description);
        this.mCulturedayMinutesPerRoundInput = (EditText) root.findViewById(R.id.edn_cultureday_form_time_per_round_field);
        this.mCulturedayWorkshopsDescription = (TextView) root.findViewById(R.id.tv_cultureday_form_workshops_description);
        this.mCulturedayRecyclerViewAvailableWorkshops = (RecyclerView) root.findViewById(R.id.sv_cultureday_form_workshoplist);
        this.mCulturedayTimeschemeDescription = (TextView) root.findViewById(R.id.tv_cultureday_form_timescheme_description);
        this.mCulturedayTimeschemeSubscription = (TextView) root.findViewById(R.id.tv_cultureday_form_timescheme_subdescription);
        this.mCulturedayTimeschemeInput = (EditText) root.findViewById(R.id.edm_cultureday_form_timescheme_field);
        this.mCulturedayParticipants = (TextView) root.findViewById(R.id.tv_cultureday_form_participants_header);
        this.mCulturedayParticipantsInput = (EditText) root.findViewById(R.id.edn_cultureday_form_participants_field);
        this.mCulturedayParticipantsGraffitiOrTshirt = (TextView) root.findViewById(R.id.tv_cultureday_form_participants_shirt_and_drums_description);
        this.mCulturedayParticipantsGraffitiOrTshirtInput = (EditText) root.findViewById(R.id.edn_cultureday_form_participants_shirt_and_drums_field);
        this.mCulturedayLearningLevel = (TextView) root.findViewById(R.id.tv_cultureday_form_learninglevel_description);
        this.mCulturedayLearningLevelInput = (EditText) root.findViewById(R.id.edt_cultureday_form_learninglevel_field);
        this.mCulturedayInlogSystem = (TextView) root.findViewById(R.id.tv_cultureday_form_inlog_system);
        this.mCulturedayInlogSystemYes = (RadioButton) root.findViewById(R.id.rb_cultureday_form_inlogsystem_yes);
        this.mCulturedayInlogSystemYes.setClickable(true);
        this.mCulturedayInlogSystemYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        this.mCulturedayInlogSystemNo = (RadioButton) root.findViewById(R.id.rb_cultureday_form_inlogsystem_no);
        this.mCulturedayInlogSystemNo.setClickable(true);
        this.mCulturedayInlogSystemNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

        return root;
//        1255,5 minimaal
//        Subtotaal
//        Prijs workshops
//        Prijs extra (grafiti)
//        Datum
    }
}
