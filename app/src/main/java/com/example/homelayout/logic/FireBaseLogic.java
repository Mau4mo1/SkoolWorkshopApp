package com.example.homelayout.logic;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class FireBaseLogic extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) {
        Log.d("TAG", "The token is refreshed" + s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    
}
