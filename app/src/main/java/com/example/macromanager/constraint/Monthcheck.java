package com.example.macromanager.constraint;

import android.content.Context;

import java.util.Calendar;

public class Monthcheck {


    public int monthcheck() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH);
    }

}
