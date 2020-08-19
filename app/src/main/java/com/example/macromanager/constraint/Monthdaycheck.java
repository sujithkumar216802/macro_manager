package com.example.macromanager.constraint;

import java.util.Calendar;

public class Monthdaycheck {


    public int monthday() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_MONTH);
    }

}
