package com.example.macromanager.action;

import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

import com.example.macromanager.R;

import static com.example.macromanager.App.CHANNEL_ID;

public class Notificationaction {


    static int notificationId = 2;

    public void createNotificationChannel(Context context, String title, String message) {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(message))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationId++;
        context.getSystemService(NotificationManager.class).notify(notificationId, builder.build());

    }

}
