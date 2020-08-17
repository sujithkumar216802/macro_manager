package com.example.macromanager.constraint;

import android.content.Context;
import android.os.BatteryManager;

public class Batterylevelcheck {

    public Integer batterylevel(Context context){
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
    }

}
