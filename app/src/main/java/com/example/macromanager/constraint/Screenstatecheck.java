package com.example.macromanager.constraint;

import android.content.Context;
import android.os.PowerManager;

public class Screenstatecheck {

    public boolean on(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        return pm.isInteractive();
    }

}
