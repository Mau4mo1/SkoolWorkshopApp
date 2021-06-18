package com.example.homelayout.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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
import com.example.homelayout.ui.register.RegisterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

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
    private TextView phoneNumber;
    private TextView clickableEmail;
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
        phoneNumber = root.findViewById(R.id.tv_contact_phone);
        clickableEmail = root.findViewById(R.id.tv_contact_email);
        btnSend = root.findViewById(R.id.sendBtn);
        btnSend.setClickable(true);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        SpannableString st = new SpannableString(tvMaps.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=My+Location&daddr=Veilingkade+15+Breda"));
                startActivity(intent);
            }
        };
        st.setSpan(clickableSpan, 7, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvMaps.setText(st);
        tvMaps.setMovementMethod(LinkMovementMethod.getInstance());
        tvMaps.setHighlightColor(Color.TRANSPARENT);

        SpannableString ss= new SpannableString(phoneNumber.getText());
        ClickableSpan clickableSpan1= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0850653923"));
                startActivity(callIntent);
            }
        };
        ss.setSpan(clickableSpan1,10,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        phoneNumber.setText(ss);
        phoneNumber.setMovementMethod(LinkMovementMethod.getInstance());
        phoneNumber.setHighlightColor(Color.TRANSPARENT);

        SpannableString se = new SpannableString(clickableEmail.getText());
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@skoolworkshop.nl"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contact email");
                startActivity(Intent.createChooser(intent, ""));
            }
        };
        se.setSpan(clickableSpan2,8,29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickableEmail.setText(se);
        clickableEmail.setMovementMethod(LinkMovementMethod.getInstance());
        clickableEmail.setHighlightColor(Color.TRANSPARENT);

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