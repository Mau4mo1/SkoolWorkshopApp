package com.example.homelayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

public class MainActivity extends AppCompatActivity {
    private Fragment shoppingCartFragment;
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
        shoppingCartFragment = null;
        Log.d("OncreateMainActivity", "Oncreate in the main activity aangeroepen");
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bt_shopping_cart) {
            if(shoppingCartFragment == null){
                shoppingCartFragment = new ShoppingCartFragment();
                Log.d("MainActivity", "Hij maakt een nieuwe shopping cart fragment aan!");
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,shoppingCartFragment).commit();
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
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,selectedFragment).commit();
                    return true;
                }
            };

}