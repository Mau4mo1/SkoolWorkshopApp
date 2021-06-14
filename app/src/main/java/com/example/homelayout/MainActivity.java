package com.example.homelayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.homelayout.controller.WorkshopController;
import com.example.homelayout.controller.WorkshopPictureController;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;
import com.example.homelayout.ui.Cultureday.MainPage.CulturedayMainFragment;
import com.example.homelayout.ui.home.HomeFragment;
import com.example.homelayout.ui.contact.ContactFragment;
import com.example.homelayout.ui.shoppingcart.ShoppingCartFragment;
import com.example.homelayout.ui.workshops.WorkshopsForm;
import com.example.homelayout.ui.workshops.WorkshopsFragment;
import com.example.homelayout.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WorkshopController.WorkshopsControllerListener, WorkshopPictureController.WorkshopPictureControllerListener {
    private BottomNavigationView bottomNav;
    private WorkshopController workshopController;
    private WorkshopPictureController workshopPictureController;
    private List<WorkshopsObject> workshopsObjectList;
    private WorkshopsObject workshopObject;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // voor de verandering

        bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        workshopController = new WorkshopController(this);
        workshopPictureController = new WorkshopPictureController(this);
        workshopPictureController.loadPictureWorkshops(2);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.bt_shopping_cart) {
            Fragment selectedFragment = new ShoppingCartFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,selectedFragment).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_workshops:
                            selectedFragment = new WorkshopsFragment();
                            break;
                        case R.id.navigation_culture_day:
                            selectedFragment = new CulturedayMainFragment();
                            break;
                        case R.id.navigation_contact:
                            selectedFragment = new ContactFragment();
                            break;
                        case R.id.navigation_more:
                            selectedFragment = new HomeFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,selectedFragment).addToBackStack(null).commit();
                    return true;
                }
            };


    @Override
    public void onWorkshopsAvailable(List<WorkshopsObject> workshopsObjectList) {
       this.workshopsObjectList = workshopsObjectList;
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onWorkshopPicturesAvailable(List<WorkshopPictureObject> workshopPictureObjectList) {

    }
}