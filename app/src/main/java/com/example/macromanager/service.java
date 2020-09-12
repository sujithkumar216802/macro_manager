package com.example.macromanager;

import android.app.ActivityOptions;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.macromanager.triggerreceiver.BatteryLevelChanged;
import com.example.macromanager.triggerreceiver.ChargerConnected;
import com.example.macromanager.triggerreceiver.ChargerDisconnected;
import com.example.macromanager.triggerreceiver.PasswordFailed;
import com.example.macromanager.triggerreceiver.ScreenOff;
import com.example.macromanager.triggerreceiver.ScreenOn;
import com.example.macromanager.triggerreceiver.Timetick;
import com.example.macromanager.ui.Action;

import static com.example.macromanager.App.CHANNEL_ID;

public class service extends Service {


    BatteryLevelChanged batteryLevelChanged = new BatteryLevelChanged();
    ChargerConnected chargerConnected = new ChargerConnected();
    ChargerDisconnected chargerDisconnected = new ChargerDisconnected();
    PasswordFailed passwordFailed = new PasswordFailed();
    ScreenOff screenOff = new ScreenOff();
    ScreenOn screenOn = new ScreenOn();
    Timetick timetick = new Timetick();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground();

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelChanged, filter);

        IntentFilter filter1 = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(chargerConnected, filter1);

        IntentFilter filter2 = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(chargerDisconnected, filter2);

        IntentFilter filter3 = new IntentFilter(Intent.ACTION_SCREEN_ON);
        registerReceiver(screenOn, filter3);

        IntentFilter filter4 = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenOff, filter4);

        IntentFilter filter5 = new IntentFilter(Intent.ACTION_TIME_TICK);
        registerReceiver(timetick, filter5);


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryLevelChanged);
        unregisterReceiver(chargerConnected);
        unregisterReceiver(chargerDisconnected);
        unregisterReceiver(screenOn);
        unregisterReceiver(screenOff);
        unregisterReceiver(timetick);
    }


    private void startForeground() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification =
                new Notification.Builder(this, CHANNEL_ID)
                        .setContentTitle("Macro manager")
                        .setContentText("Running")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentIntent(pendingIntent)
                        .build();

        startForeground(1, notification);
    }

}
