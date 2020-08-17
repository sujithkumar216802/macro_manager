package com.example.macromanager.constraint;

import android.content.Context;
import android.os.BatteryManager;

public class Chargingcheck {


    public boolean chargingcheck(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        return batteryManager.isCharging();

    }


}
