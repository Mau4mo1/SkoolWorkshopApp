package com.example.homelayout.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.homelayout.JavaMailAPI;
import com.example.homelayout.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactFragment extends Fragment {
    private final String LOG_ACTIVITY = "Contact Fragment";
    private final String STATE_TOTAL = "save_state";
    private final String STATE_EDIT_EMAIL = "edit_email";
    private final String STATE_EDIT_SUJECT = "edit_subject";
    private final String STATE_EDIT_MESSAGE = "edit_message";
    private SharedPreferences savedValues;
    private SharedPreferences.Editor editor;
    public EditText mEmail;
    public EditText mSubject;
    public EditText mMessage;
    public Button btnSend;
    public Context thiscontext;
    private TextView tvMaps;
//changes

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_ACTIVITY, "onCreateView is called");
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        thiscontext = container.getContext();
        tvMaps = root.findViewById(R.id.mapsID);
        tvMaps.setClickable(true);
        mEmail = root.findViewById(R.id.mailID);
        mSubject = root.findViewById(R.id.subjectID);
        mMessage = root.findViewById(R.id.messageID);
        btnSend = root.findViewById(R.id.sendBtn);
        btnSend.setClickable(true);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        tvMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps?saddr=My+Location&daddr=Veilingkade+15+Breda"));
                startActivity(intent);
            }
        });
        savedValues = getActivity().getSharedPreferences(STATE_TOTAL, Context.MODE_PRIVATE);
        editor = savedValues.edit();
        return root;
    }

    @Override
    public void onPause() {
        Log.d(LOG_ACTIVITY, "onPause is called");
        editor.putString(STATE_EDIT_EMAIL, mEmail.getText().toString());
        editor.putString(STATE_EDIT_SUJECT, mSubject.getText().toString());
        editor.putString(STATE_EDIT_MESSAGE, mMessage.getText().toString());
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.d(LOG_ACTIVITY, "onResume is called");
        String email = savedValues.getString(STATE_EDIT_EMAIL,mEmail.getText().toString());
        String subject = savedValues.getString(STATE_EDIT_SUJECT, mSubject.getText().toString());
        String message = savedValues.getString(STATE_EDIT_MESSAGE, mSubject.getText().toString());
        mEmail.setText(email);
        mSubject.setText(subject);
        mMessage.setText(message);
        super.onResume();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_ACTIVITY, "onDestroy is called");
        editor.putString(STATE_EDIT_EMAIL, mEmail.getText().toString());
        editor.putString(STATE_EDIT_SUJECT, mSubject.getText().toString());
        editor.putString(STATE_EDIT_MESSAGE, mMessage.getText().toString());
        super.onDestroy();
    }

    private void sendMail(){
        String mail = mEmail.getText().toString().trim();
        String message = mMessage.getText().toString();
        String subject = mSubject.getText().toString().trim();

        //Sending mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(thiscontext,mail,subject,message);
        javaMailAPI.execute();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.nav_view);
        navigation.getMenu().getItem(3).setChecked(true);
    }

}