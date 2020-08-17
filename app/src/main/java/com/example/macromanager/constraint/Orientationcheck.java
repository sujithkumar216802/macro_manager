package com.example.macromanager.constraint;

import android.content.Context;
import android.content.res.Configuration;

public class Orientationcheck {
    public boolean portrait(Context context) {
        int orientation = context.getResources().getConfiguration().orientation;
        return orientation != Configuration.ORIENTATION_LANDSCAPE;
    }
}