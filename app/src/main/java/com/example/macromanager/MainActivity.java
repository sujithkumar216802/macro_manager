package com.example.macromanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.macromanager.triggerreceiver.BatteryLevelChanged;
import com.example.macromanager.triggerreceiver.ChargerConnected;
import com.example.macromanager.triggerreceiver.ChargerDisconnected;
import com.example.macromanager.triggerreceiver.PasswordFailed;
import com.example.macromanager.triggerreceiver.ScreenOff;
import com.example.macromanager.triggerreceiver.ScreenOn;
import com.example.macromanager.triggerreceiver.Timetick;

public class MainActivity extends AppCompatActivity {

    BatteryLevelChanged batteryLevelChanged = new BatteryLevelChanged();
    ChargerConnected chargerConnected = new ChargerConnected();
    ChargerDisconnected chargerDisconnected = new ChargerDisconnected();
    PasswordFailed passwordFailed = new PasswordFailed();
    ScreenOff screenOff = new ScreenOff();
    ScreenOn screenOn = new ScreenOn();
    Timetick timetick = new Timetick();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryLevelChanged);
        unregisterReceiver(chargerConnected);
        unregisterReceiver(chargerDisconnected);
        unregisterReceiver(screenOn);
        unregisterReceiver(screenOff);
        unregisterReceiver(timetick);
    }
}