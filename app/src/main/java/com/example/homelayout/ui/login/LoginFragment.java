package com.example.homelayout.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.ui.home.HomeFragment;
import com.example.homelayout.ui.register.RegisterFragment;
import com.example.homelayout.ui.workshops.WorkshopsFragment;

public class LoginFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        TextView txtView = (TextView)root.findViewById(R.id.tv_login_link);
        Button send = (Button) root.findViewById(R.id.sendBtn);
        String text = "Nog geen acount? Klik hier om je aan te melden";
        SpannableString ss= new SpannableString(text);
        ClickableSpan clickableSpan1= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new RegisterFragment()).addToBackStack(null).commit();
            }
        };
        ss.setSpan(clickableSpan1,22,26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtView.setText(ss);
        txtView.setMovementMethod(LinkMovementMethod.getInstance());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO WERKEND MAKEN LOGIN
                ((MainActivity) getActivity()).setLoggedIn(true);
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).addToBackStack(null).commit();
            }
        });

        return root;
    }


}
