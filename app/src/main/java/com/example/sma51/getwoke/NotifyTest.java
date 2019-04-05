package com.example.sma51.getwoke;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.sma51.getwoke.App.CHANNEL_ID_1;
import static com.example.sma51.getwoke.App.CHANNEL_ID_2;

public class NotifyTest extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;
    //private Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_test);

        notificationManager = NotificationManagerCompat.from(this);
        editTextTitle = (EditText) findViewById(R.id.edit_alarm_title);
        editTextMessage = (EditText) findViewById(R.id.edit_alarm_message);
    }

    public void sendOnChannel1(View view){
        //get the title and message from the edit texts
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_1)
                    .setSmallIcon(R.drawable.ic_exclaim) //sets icon for notification
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_ALARM)
                    //.setLights or .setVibrate
                    .build();

        //if showing multiple notifications at the same time, give them multiple IDs
        //to update or cancel a notification, give the same ID
        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View view){
        //get the title and message from the edit texts
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_arrow) //sets icon for notification
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                //.setLights or .setVibrate
                .build();

        //if showing multiple notifications at the same time, give them multiple IDs
        //to update or cancel a notification, give the same ID
        notificationManager.notify(2, notification);
    }
}
