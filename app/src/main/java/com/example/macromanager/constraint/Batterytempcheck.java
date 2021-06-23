package com.example.macromanager.constraint;

import android.content.Intent;
import android.os.BatteryManager;

public class Batterytempcheck {

    public int batterytemp(Intent intent) {

        return intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0) / 10;

    }

}
