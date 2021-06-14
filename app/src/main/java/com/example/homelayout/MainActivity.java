package com.example.homelayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.app.ActionBar;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.homelayout.domain.Message;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.ui.Cultureday.MainPage.CulturedayMainFragment;
import com.example.homelayout.ui.home.HomeFragment;
import com.example.homelayout.ui.contact.ContactFragment;
import com.example.homelayout.ui.shoppingcart.ShoppingCartFragment;
import com.example.homelayout.ui.workshops.WorkshopsForm;
import com.example.homelayout.ui.workshops.WorkshopsFragment;
import com.example.homelayout.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private Message m = null;
    private ArrayList<Message> aTestForTim;
    private int countdown;

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
        aTestForTim = new ArrayList<>();
        countdown = 2;
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TAG", "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();
                        Log.d("TimsMethode", "" + task.getResult());
                        // Log and toast
                        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String msg = getString(R.string.msg_token_fmt, token);
                        Log.d("TAG", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            countdown += 1;
            Message m = new Message(countdown, intent.getExtras().getString("title"), intent.getExtras().getString("body"));
            aTestForTim.add(m);
            Log.d("TAG", m.toString());
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, new IntentFilter("MyData"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(messageReceiver);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bt_shopping_cart) {
            Fragment selectedFragment = new ShoppingCartFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
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
                            showStatusPopup(MainActivity.this);
                            selectedFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).addToBackStack(null).commit();
                    return true;
                }
            };

    private NavigationView.OnNavigationItemSelectedListener navSideBarListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_shopping_cart:
                            break;
                        case R.id.navigation_about_us:
                            break;
                        case R.id.navigation_quiz:
                            Log.d("test", "hallo");
                            Uri uri = Uri.parse("https://www.tryinteract.com/share/quiz/60bf53f3749e3400170c19df");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                            break;
                    }
                    return true;
                }
            };
    private void showStatusPopup(final Activity context) {


            // Inflate the popup_layout.xml
            ConstraintLayout viewGroup = (ConstraintLayout) context.findViewById(R.id.container_sideView);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = layoutInflater.inflate(R.layout.activity_more, null);
            PopupWindow changeStatusPopUp = new PopupWindow(context);
            changeStatusPopUp.setContentView(layout);
            changeStatusPopUp.setWidth(ConstraintLayout.LayoutParams.WRAP_CONTENT);
            changeStatusPopUp.setHeight(ConstraintLayout.LayoutParams.WRAP_CONTENT);
            changeStatusPopUp.setFocusable(true);

            int OFFSET_X = 0;
            int OFFSET_Y = -400;
            int[] location = new int[2];
            findViewById(R.id.navigation_more).getLocationOnScreen(location);
            OFFSET_X = OFFSET_X + location[0];
            OFFSET_Y = OFFSET_Y + location[1];

            changeStatusPopUp.setBackgroundDrawable(new BitmapDrawable());
            NavigationView sideBarView = layout.findViewById(R.id.nav_side_view);
            sideBarView.setNavigationItemSelectedListener(navSideBarListener);
            changeStatusPopUp.showAtLocation(layout, Gravity.TOP, OFFSET_X, OFFSET_Y);
        }

        public ArrayList<Message> getMessage(){
            return this.aTestForTim;
        }
}