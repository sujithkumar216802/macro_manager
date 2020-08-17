package com.example.macromanager.constraint;


import android.content.Context;
import android.provider.Settings;

public class Autorotatecheck {

    public Boolean autorotate(Context context) throws Settings.SettingNotFoundException {

        int result;

        result = Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION);

        return result == 1;
    }

}


