package com.example.homelayout.ui.contact;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;


import com.example.homelayout.JavaMailAPI;
import com.example.homelayout.R;

public class ContactFragment extends Fragment {


    private final String STATE_EDIT_EMAIL = "edit_email";
    private final String STATE_EDIT_SUJECT = "edit_subject";
    private final String STATE_EDIT_MESSAGE = "edit_message";

    public EditText mEmail;
    public EditText mSubject;
    public EditText mMessage;
    public Button btnSend;
    public Context thiscontext;
//changes

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        thiscontext = container.getContext();
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
        return root;
    }

    //this is a test
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(STATE_EDIT_EMAIL,String.valueOf(mEmail.getText()));
        outState.putString(STATE_EDIT_SUJECT,String.valueOf(mSubject.getText()));
        outState.putString(STATE_EDIT_MESSAGE,String.valueOf(mMessage.getText()));

        super.onSaveInstanceState(outState);
    }



    private void sendMail(){
        String mail = mEmail.getText().toString().trim();
        String message = mMessage.getText().toString();
        String subject = mSubject.getText().toString().trim();

        //Sending mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(thiscontext,mail,subject,message);
        javaMailAPI.execute();

    }

}