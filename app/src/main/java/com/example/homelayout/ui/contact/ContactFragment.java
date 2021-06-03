package com.example.homelayout.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;


import com.example.homelayout.JavaMailAPI;
import com.example.homelayout.R;

public class ContactFragment extends Fragment {
public EditText mEmail;
public EditText mSubject;
public EditText mMessage;
public Button btnSend;
public TextView mMaps;

public Context thiscontext;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        thiscontext = container.getContext();
        mMaps = root.findViewById(R.id.mapsID);
       mEmail = root.findViewById(R.id.mailID);
        mSubject = root.findViewById(R.id.subjectID);
        mMessage = root.findViewById(R.id.messageID);
        btnSend = root.findViewById(R.id.sendBtn);
        mMaps.setClickable(true);
        btnSend.setClickable(true);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        mMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps?saddr=My+Location&daddr=Veilingkade+15+Breda&dirflg=d"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return root;
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