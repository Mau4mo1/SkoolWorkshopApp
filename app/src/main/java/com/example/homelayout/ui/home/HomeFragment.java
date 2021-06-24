package com.example.homelayout.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.domain.Message;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.cultureday.Form.CulturedayBookingFormFragment;
import com.example.homelayout.ui.accountdetails.LoyaltyPointsFragment;
import com.example.homelayout.ui.login.LoginFragment;
import com.example.homelayout.ui.register.RegisterFragment;
import com.example.homelayout.ui.messagebox.MessageBoxFragment;
import com.example.homelayout.ui.workshops.WorkshopCategoryRecyclerView;
import com.example.homelayout.ui.workshops.WorkshopsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static Context thisContext;
    private static TinyDB tinyDB;
    private static ArrayList<Object> messageList;
    private static TextView ivBellCounter;
    private Button btnBookWorkshop;
    private Button btnBookCultureDay;
    private Button btnRegister;
    private Button btnLogin;
    private Button btnLogout;
    private ConstraintLayout clPopularWorkshops;
    private ConstraintLayout mHomeItem;
    private Bitmap bmp;
    private ImageView mImageViewSpaarPunten;
    private ImageView ivBell;
    private ConstraintLayout loyaltyPoints;
    private TextView greetings;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        thisContext = container.getContext();
        btnRegister = root.findViewById(R.id.register_button);
        btnRegister.setClickable(true);
        btnLogin = root.findViewById(R.id.login_button);
        btnLogin.setClickable(true);
        btnLogout = root.findViewById(R.id.logout_button);
        btnLogout.setClickable(true);
        btnBookWorkshop = root.findViewById(R.id.button_book_workshop);
        btnBookWorkshop.setClickable(true);
        btnBookCultureDay = root.findViewById(R.id.button_book_culture_day);
        btnBookCultureDay.setClickable(true);
        clPopularWorkshops = root.findViewById(R.id.home_item_popular_workshops);
        clPopularWorkshops.setClickable(true);
        ivBell = root.findViewById(R.id.notificationIcon);
        ivBell.setClickable(true);
        ivBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MessageBoxFragment())
                        .commit();
            }
        });
        mHomeItem = root.findViewById(R.id.home_item_newsletter);
        mHomeItem.setClickable(true);
        mHomeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://preview.mailerlite.com/e6p1b6");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        mImageViewSpaarPunten = root.findViewById(R.id.home_item_loyalty_points_image);
        loyaltyPoints = root.findViewById(R.id.home_item_loyalty_points);
        loyaltyPoints.setClickable(true);
        greetings = root.findViewById(R.id.text_view_greeting);
        btnBookWorkshop.setOnClickListener(this);
        btnBookCultureDay.setOnClickListener(this);
        clPopularWorkshops.setOnClickListener(this);
        loyaltyPoints.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        if(((MainActivity) getActivity()).getIsTheUserLoggedIn() == true){

          btnLogin.setVisibility(View.GONE);
          btnRegister.setVisibility(View.GONE);
          btnLogout.setVisibility(View.VISIBLE);
          loyaltyPoints.setVisibility(View.VISIBLE);
          greetings.setText("Welkom, Clinten");
          btnLogout = root.findViewById(R.id.logout_button);
          btnLogout.setClickable(true);
          btnLogout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  AlertDialog.Builder logpopup = new AlertDialog.Builder(getContext());
                  logpopup.setCancelable(true);
                  logpopup.setTitle("Uitloggen");
                  logpopup.setMessage("Weet je zeker dat je wilt uitloggen?");
                  logpopup.setPositiveButton("ja", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          ((MainActivity) getActivity()).setLoggedIn(false);
                          dialogInterface.cancel();
                          getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).addToBackStack(null).commit();
                      }
                  });
                  logpopup.setNegativeButton("Nee", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          dialogInterface.cancel();
                      }
                  });
                  logpopup.show();
              }
          });

          ConstraintLayout cons = root.findViewById(R.id.cl_home_background);
          ConstraintSet constraintSet = new ConstraintSet();
          constraintSet.clone(cons);
          constraintSet.connect(greetings.getId(), ConstraintSet.RIGHT, btnLogout.getId(), ConstraintSet.LEFT, 0);
          constraintSet.applyTo(cons);
        }
        updateNotificationCounter(thisContext);
        return root;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_book_workshop:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_book_culture_day:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CulturedayBookingFormFragment()).addToBackStack(null).commit();
                break;
            case R.id.home_item_popular_workshops:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopCategoryRecyclerView()).addToBackStack(null).commit();
                break;
            case R.id.home_item_loyalty_points:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new LoyaltyPointsFragment()).addToBackStack(null).commit();
                break;
            case R.id.register_button:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new RegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.login_button:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new LoginFragment()).addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.nav_view);
        navigation.getMenu().getItem(0).setChecked(true);
    }

    public void updateNotificationCounter(Context context){
        TinyDB tinyDB = new TinyDB(context);
        ivBellCounter = root.findViewById(R.id.notification_counter_number);
        ivBellCounter.setVisibility(View.VISIBLE);
        messageList = tinyDB.getListObject("MessageBox", Message.class);

        if (messageList == null){
            messageList = new ArrayList<>();
        }

        MainActivity activity = (MainActivity) getActivity();

        ivBellCounter.setText(String.valueOf(messageList.size() + activity.counter));
        getActivity().getSupportFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }
}