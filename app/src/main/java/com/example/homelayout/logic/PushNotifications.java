package com.example.homelayout.logic;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PushNotifications extends FirebaseMessagingService {
    private static final String TAG = "PushNotifications";
    private MainActivity mainActivity;


    /**
     * There are two scenarios when onNewToken is called:
     * 1) When a new token is generated on initial app startup
     * 2) Whenever an existing token is changed
     * Under #2, there are three scenarios when the existing token is changed:
     * A) App is restored to a new device
     * B) User uninstalls/reinstalls the app
     * C) User clears app data
     */

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d(TAG, "Refreshed token: " + token);
    }

//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        String title = remoteMessage.getNotification().getTitle();
//        String content = remoteMessage.getNotification().getBody();
//        Log.d(TAG, "onMessageReceived: Message Received! \n" + "Title: " + title + "\n" + "Content: " + content);
//        sendNotification(title, content);
//    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages
        // are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data
        // messages are the type
        // traditionally used with GCM. Notification messages are only received here in
        // onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated
        // notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages
        // containing both notification
        // and data payloads are treated as notification messages. The Firebase console always
        // sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

//            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use WorkManager.
//                scheduleJob();
//            } else {
//                // Handle message within 10 seconds
//                handleNow();
//            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]


    // [START on_new_token]


    /**
     * Schedule async work using WorkManager.
     */
//    private void scheduleJob() {
//        // [START dispatch_job]
//        OneTimeWorkRequest work = new OneTimeWorkRequest.Builder(MyWorker.class)
//                .build();
//        WorkManager.getInstance().beginWith(work).enqueue();
//        // [END dispatch_job]
//    }
//
//    /**
//     * Handle time allotted to BroadcastReceivers.
//     */
//    private void handleNow() {
//        Log.d(TAG, "Short lived task is done.");
//    }

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM registration token with any
     * server-side account maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */

    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    public interface NotificationListener {
        void updateNotificationCounter(Map data);
    }
}

// METHODES DIE IK AAN HET TESTEN WAS IN EEN TESTOMGEVING

//package com.example.myapplication;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.util.Log;
//
//import androidx.annotation.RequiresApi;
//import androidx.core.app.NotificationCompat;
//import androidx.core.app.NotificationManagerCompat;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//public class PushNotifications extends FirebaseMessagingService {
//    private static final String TAG = "PushNotifications";
//    private static final String NOTIFICATION_CHANNEL_ID = "fcm_default_channel";
//    private static final String ADMIN_CHANNEL_ID = "fcm_default_admin_channel";
//    private MainActivity mainActivity = new MainActivity();
//    private NotificationManager notificationManager;
//    private NotificationManagerCompat managerCompat;
//    /**
//     * There are two scenarios when onNewToken is called:
//     * 1) When a new token is generated on initial app startup
//     * 2) Whenever an existing token is changed
//     * Under #2, there are three scenarios when the existing token is changed:
//     * A) App is restored to a new device
//     * B) User uninstalls/reinstalls the app
//     * C) User clears app data
//     */
//
//    @Override
//    public void onNewToken(String token) {
//        super.onNewToken(token);
//        Log.d(TAG, "Refreshed token: " + token);
//    }
//
////    @Override
////    public void onMessageReceived(RemoteMessage remoteMessage) {
////        String title = remoteMessage.getNotification().getTitle();
////        String content = remoteMessage.getNotification().getBody();
////        Log.d(TAG, "onMessageReceived: Message Received! \n" + "Title: " + title + "\n" + "Content: " + content);
////        sendNotification(title, content);
////    }
//
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            setupChannels();
//        }
//        Intent intent = new Intent("myFunction");
//        // add data
//        intent.putExtra("value1", remoteMessage.getNotification().getTitle());
//        intent.putExtra("value2", remoteMessage.getNotification().getBody());
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private void setupChannels(){
//        CharSequence adminChannelName = "NAME";
//        String adminChannelDescription = "DESCRIPTON";
//
//        NotificationChannel adminChannel;
//        adminChannel = new NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_LOW);
//        adminChannel.setDescription(adminChannelDescription);
//        adminChannel.enableLights(true);
//        adminChannel.enableVibration(true);
//        if (notificationManager != null) {
//            notificationManager.createNotificationChannel(adminChannel);
//        }
//    }
//
//    private void showNotification(String title, String messageBody) {
//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        String channelId = getString(R.string.default_notification_channel_id);
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder =
//                new NotificationCompat.Builder(this, channelId)
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setContentTitle(title)
//                        .setContentText(messageBody)
//                        .setAutoCancel(true)
//                        .setSound(defaultSoundUri)
//                        .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // Since android Oreo notification channel is needed.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(channelId,
//                    "Channel human readable title",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            notificationManager.createNotificationChannel(channel);
//        }
//        notificationBuilder.build();
//    }
//
//    public interface NotificationListener {
//        void updateNotificationCounter(Map data);
//    }
//}


// MAIN ACTIVITY

//package com.example.myapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//import android.annotation.SuppressLint;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.messaging.FirebaseMessaging;
//
//import org.w3c.dom.Text;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//public class MainActivity extends AppCompatActivity implements PushNotifications.NotificationListener {
//    private static final String TAG = "MainActivity";
//    private TextView testTextView;
//    // creating a variable for
//    // our Firebase Database.
//    private FirebaseDatabase firebaseDatabase;
//
//    // creating a variable for our
//    // Database Reference for Firebase.
//    private DatabaseReference databaseReference;
//
//    // variable for Text view.
//    private TextView retrieveTV;
//    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            // Extract data included in the Intent
//            Map<String, String> map = new HashMap<>();
//            String t = intent.getStringExtra("value1");
//            String t1 = intent.getStringExtra("value2");
//            map.put("title", t);
//            map.put("content", t1);
//            updateNotificationCounter(map);
//            //alert data here
//        }
//    };
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
//                new IntentFilter("myFunction"));
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        this.testTextView = findViewById(R.id.test_textview);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("Data");
//        retrieveTV = findViewById(R.id.test_textview);
//        getdata();
//
//        FirebaseApp.initializeApp(this);
//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
//                            return;
//                        }
//
//                        // Get new FCM registration token
//                        String token = task.getResult();
//
//                        // Log and toast
//                        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String msg = getString(R.string.msg_token_fmt, token);
//                        Log.d(TAG, msg);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void getdata() {
//        // calling add value event listener method
//        // for getting the values from database.
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // this method is call to get the realtime
//                // updates in the data.
//                // this method is called when the data is
//                // changed in our Firebase console.
//                // below line is for getting the data from
//                // snapshot of our database.
//                String value = snapshot.getValue(String.class);
//
//                // after getting the value we are setting
//                // our value to our text view in below line.
//                retrieveTV.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void updateNotificationCounter(Map data) {
//        setContentView(R.layout.activity_main);
//        this.testTextView = findViewById(R.id.test_textview);
//        String title = "";
//        String content = "";
//        Iterator it = data.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            if (pair.getKey().equals("title")) {
//                title = (String) pair.getValue();
//            }
//            if (pair.getKey().equals("content")) {
//                content = (String) pair.getValue();
//            }
//            testTextView.setText(title);
//        }
//    }
//}