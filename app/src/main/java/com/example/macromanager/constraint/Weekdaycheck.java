package com.example.macromanager.constraint;

import java.util.Calendar;

public class Weekdaycheck {

    public int weekdaycheck(){

        Calendar c = Calendar.getInstance();
        int temp = c.get(Calendar.DAY_OF_WEEK) - 2;
        if(temp ==-1)
            temp=6;
        return temp;
    }
}
