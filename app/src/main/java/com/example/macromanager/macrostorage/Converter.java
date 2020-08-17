package com.example.macromanager.macrostorage;

import androidx.room.TypeConverter;

import com.example.macromanager.actionstorage.Notificationactiontemplate;
import com.example.macromanager.actionstorage.VibrationActionTemplate;
import com.example.macromanager.actionstorage.VolumeActionTemplate;
import com.example.macromanager.constraintstorage.BatteryLevelTemplate;
import com.example.macromanager.constraintstorage.BatteryTempTemplate;
import com.example.macromanager.triggerstorage.DayofthemonthTemplate;
import com.example.macromanager.triggerstorage.DayoftheweekTemplate;
import com.example.macromanager.triggerstorage.TimeTemplate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converter {

    @TypeConverter
    public static String notificationactiontostring(ArrayList<Notificationactiontemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<Notificationactiontemplate> stringtonotificationaction(String string) {
        Type type = new TypeToken<ArrayList<Notificationactiontemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String arrayliststringtostring(ArrayList<String> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<String> stringtoarrayliststring(String string) {
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static ArrayList<VibrationActionTemplate> stringtovibrationaction(String string) {
        Type type = new TypeToken<ArrayList<VibrationActionTemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }

    @TypeConverter
    public static String vibrationactionstringto(ArrayList<VibrationActionTemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }


    @TypeConverter
    public static String volumeactiontostring(VolumeActionTemplate x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static VolumeActionTemplate stringtovolumeaction(String string) {
        Type type = new TypeToken<VolumeActionTemplate>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String batterylevelconstrainttostring(ArrayList<BatteryLevelTemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<BatteryLevelTemplate> stringtobatterylevelconstraint(String string) {
        Type type = new TypeToken<ArrayList<BatteryLevelTemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String batterytempconstrainttostring(ArrayList<BatteryTempTemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<BatteryTempTemplate> stringtobatterytempconstraint(String string) {
        Type type = new TypeToken<ArrayList<BatteryTempTemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String arraylistbooleantostring(ArrayList<Boolean> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<Boolean> stringtoarraylistboolean(String string) {
        Type type = new TypeToken<ArrayList<Boolean>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String arraylistintegertostring(ArrayList<Integer> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<Integer> stringtoarraylistinteger(String string) {
        Type type = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String arraylistdayofthemonthtriggertostring(ArrayList<DayofthemonthTemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<DayofthemonthTemplate> stringtoarraylistdayofthemonthtrigger(String string) {
        Type type = new TypeToken<ArrayList<DayofthemonthTemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String arraylistdayoftheweektriggertostring(ArrayList<DayoftheweekTemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<DayoftheweekTemplate> stringtoarraylistdayoftheweektrigger(String string) {
        Type type = new TypeToken<ArrayList<DayoftheweekTemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


    @TypeConverter
    public static String arraylisttimetriggertriggertostring(ArrayList<TimeTemplate> x) {
        Gson gson = new Gson();
        return gson.toJson(x);
    }

    @TypeConverter
    public static ArrayList<TimeTemplate> stringtoarraylisttimetrigger(String string) {
        Type type = new TypeToken<ArrayList<TimeTemplate>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }


}