package com.example.homelayout.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.domain.Message;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.logic.CulturedayBookingInfo;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.Cultureday.Form.CulturedayBookingFormFragment;
import com.example.homelayout.ui.accountdetails.LoyaltyPointsFragment;
import com.example.homelayout.ui.login.LoginFragment;
import com.example.homelayout.ui.register.RegisterFragment;
import com.example.homelayout.ui.messagebox.MessageBoxFragment;
import com.example.homelayout.ui.workshops.WorkshopCategoryRecyclerView;
import com.example.homelayout.ui.workshops.WorkshopsFragment;
import com.example.homelayout.ui.workshops.WorkshopsPopular;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btnBookWorkshop;
    private Button btnBookCultureDay;
    private Button btnRegister;
    private Button btnLogin;
    private Button btnLogout;
    private ConstraintLayout clPopularWorkshops;
    private Bitmap bmp;
    private ImageView mImageViewSpaarPunten;
    private ImageView ivBell;
    private ConstraintLayout loyaltyPoints;
    private TextView greetings;
    private TextView ivBellCounter;
    private ConstraintLayout contraintLayoutCounter;
    private CardView counterCardView;
    private TinyDB tinyDB;
    private Context thisContext;

    private ArrayList<Object> messageList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        thisContext = container.getContext();
        tinyDB = new TinyDB(thisContext);
        this.messageList = tinyDB.getListObject("MessageBox", Message.class);
        if (messageList == null){
            this.messageList = new ArrayList<>();
        }

        View root = inflater.inflate(R.layout.fragment_home, container, false);

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
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MessageBoxFragment()).addToBackStack(null).commit();
            }
        });
        ivBellCounter = root.findViewById(R.id.notification_counter_number);
        ivBellCounter.setVisibility(View.VISIBLE);
        ivBellCounter.setText(String.valueOf(messageList.size()));
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
                  ((MainActivity) getActivity()).setLoggedIn(false);
                  getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).addToBackStack(null).commit();
              }
          });

          ConstraintLayout cons = root.findViewById(R.id.cl_home_background);
          ConstraintSet constraintSet = new ConstraintSet();
          constraintSet.clone(cons);
          constraintSet.connect(greetings.getId(), ConstraintSet.RIGHT, btnLogout.getId(), ConstraintSet.LEFT, 0);
          //constraintSet.connect(greetings.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
          constraintSet.applyTo(cons);
        }


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
}