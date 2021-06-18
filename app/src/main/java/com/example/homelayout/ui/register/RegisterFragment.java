package com.example.homelayout.ui.register;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.logic.Validation;
import com.example.homelayout.ui.home.HomeFragment;

public class RegisterFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        Context thiscontext = container.getContext();
        TextView txtView = (TextView)root.findViewById(R.id.tv_register_policy);
        EditText email = (EditText)root.findViewById(R.id.email_register);
        EditText password = (EditText)root.findViewById(R.id.password_register);
        Button sendButton = (Button)root.findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(new Validation().validateEmail(email.getText().toString()) && new Validation().validatePassword(password.getText().toString())){
                    ((MainActivity)getActivity()).setLoggedIn(true);
                    Toast.makeText(thiscontext, "Username: " + email.getText().toString() + " & Password: "+ password.getText().toString(), Toast.LENGTH_SHORT).show();
                    getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).addToBackStack(null).commit();
                }else{
                    Toast.makeText(thiscontext,  "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });
        String text = "Je persoonlijke gegevens worden gebruikt om je ervaringen op deze site te ondersteunen, om toegang tot je account te beheren en voor andere doeleinden zoals omschreven in ons privacybeleid";
        SpannableString ss= new SpannableString(text);
        ClickableSpan clickableSpan1= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://skoolworkshop.nl/privacybeleid/"));
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan1,175,188, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtView.setText(ss);
        txtView.setMovementMethod(LinkMovementMethod.getInstance());
        return root;

    }
//    private String getColoredSpanned(String text, String color) {
//        String input = "<font color=" + color + ">" + text + "</font>";
//        return input;
//    }
}
