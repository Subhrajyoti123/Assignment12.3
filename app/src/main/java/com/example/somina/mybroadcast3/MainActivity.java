package com.example.somina.mybroadcast3;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    Notification.InboxStyle inboxStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendInboxStyleNotification(View view) {
        PendingIntent pi = getPendingIntent();
        Builder builder = new Notification.Builder(this)
                .setContentTitle("Event Details")
                .setContentText("Inbox Style notification!!")
                .setSmallIcon(R.drawable.ic_launcher)
                ;

        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = new Notification.InboxStyle(builder)
                    .addLine("Hello")
                    .addLine("Whats up ?")
                    .addLine("I am fine")
                    .build();
        }

        // Put the auto cancel notification flag
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = getNotificationManager();
        notificationManager.notify(0, notification);
    }

    public PendingIntent getPendingIntent() {
        return PendingIntent.getActivity(this, 0, new Intent(this,
                HandleNotification.class), 0);
    }

    public NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}
