package com.example.macromanager.constraint;

import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class Batterytempcheck {

    public int batterytemp(Intent intent) {

        return intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0) / 10;
        //BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        //batteryManager.get
        //return batteryManager.getIntProperty(BatteryManager.EXTRA_TEMPERATURE);
    }

}
