package com.example.macromanager.action;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.macromanager.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Notificationaction {


//FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFffff
    //iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


    /*

            public void notification(Context context,String title,String message){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context,);

                //otificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)

                //builder.setSmallIcon(R.drawable.notification_small_icon);
                //Bitmap bitmap = BitmapFactory.decodeResource(mResources, R.drawable.notification_large_icon);
                //builder.setLargeIcon(bitmap);
                builder.setContentTitle("Notification Title");
                builder.setContentText("Hello! Notification service.");
                int notificationId = 001;
                NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                manager.notify(notificationId, builder.build());
            }
    */
    private static final String CHANNEL_ID = "Macronotification";

    int notificationId = 32;

    public void createNotificationChannel(Context context, String title, String message) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "macroname";
            String description = "why";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(message))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            notificationId++;
// notificationId is a unique int for each notification that you must define
//            int notificationId = 32;
            notificationManager.notify(notificationId, builder.build());
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(message))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);


            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationId++;
// notificationId is a unique int for each notification that you must define
            notificationManager.notify(notificationId, builder.build());
        }
    }

}