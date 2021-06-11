package com.example.homelayout.logic;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class FireBaseLogic extends FirebaseMessagingService {
    private LocalBroadcastManager broadcaster = null;

    @Override
    public void onNewToken(@NonNull String s) {
        Log.d("TAG", "The token is refreshed" + s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(remoteMessage.getData().size() > 0){
            handleMessage(remoteMessage);
        }


    }
    @Override
    public void onCreate() {
        broadcaster = LocalBroadcastManager.getInstance(this);
        super.onCreate();
    }
    private void handleMessage(RemoteMessage remoteMessage){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
                         @Override
                         public void run() {
                             Toast.makeText(getBaseContext(), getString(R.string.handle_notifaction_now), Toast.LENGTH_LONG).show();
                             Intent intent = new Intent("MyData");
                             intent.putExtra("body", remoteMessage.getData().get("body"));
                             intent.putExtra("title", remoteMessage.getData().get("title"));
                             broadcaster.sendBroadcast(intent);
                         }
        });
    }
}
