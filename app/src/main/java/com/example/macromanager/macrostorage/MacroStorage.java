package com.example.macromanager.macrostorage;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.macromanager.actionmodels.DelayactionModel;
import com.example.macromanager.actionmodels.NotificationactionModel;
import com.example.macromanager.actionmodels.VibrationActionModel;
import com.example.macromanager.actionmodels.VolumeActionModel;
import com.example.macromanager.constraintmodels.BatteryLevelTemplate;
import com.example.macromanager.constraintmodels.BatteryTempTemplate;
import com.example.macromanager.triggermodel.DayofthemonthTemplate;
import com.example.macromanager.triggermodel.DayoftheweekTemplate;
import com.example.macromanager.triggermodel.TimeTemplate;

import java.util.ArrayList;

@Entity(tableName = "macros")
public class MacroStorage {



    @PrimaryKey(autoGenerate = true)
    Integer id;

    String name;

    Boolean enabled;

    String actionclipboard;

   // Boolean flashlighton;

    ArrayList<NotificationactionModel> actionnotification;

    Boolean actionringer;

    //Boolean actionscreen;

    ArrayList<String> actionToast;

    ArrayList<VibrationActionModel> actionvibration;

    VolumeActionModel actionvolume;

    ArrayList<DelayactionModel> actiondelay;

    Boolean constraintautorotate;

    ArrayList<BatteryLevelTemplate> constraintbatterylevel;

    ArrayList<BatteryTempTemplate> constraintbatterytemp;

    Boolean constraintcharging;

    Boolean constraintheadphones;

    ArrayList<Boolean> constraintmonth;

    ArrayList<Boolean> constraintmonthday;

    Boolean constraintorientation;

    Boolean constraintscreenstate;

    ArrayList<Boolean> constraintweekday;

    ArrayList<Integer> triggerbattery;

    ArrayList<DayofthemonthTemplate> triggerdayofthemonth;

    ArrayList<DayoftheweekTemplate> triggerdayoftheweek;

    ArrayList<TimeTemplate> triggertime;

    ArrayList<String> actionselected;

    ArrayList<String> constraintselected;

    ArrayList<String> triggerselected;








    public ArrayList<DelayactionModel> getActiondelay() {
        return actiondelay;
    }

    public void setActiondelay(ArrayList<DelayactionModel> actiondelay) {
        this.actiondelay = actiondelay;
    }




    public String getActionclipboard() {
        return actionclipboard;
    }

    public void setActionclipboard(String actionclipboard) {
        this.actionclipboard = actionclipboard;
    }

    public ArrayList<String> getActionselected() {
        return actionselected;
    }

    public void setActionselected(ArrayList<String> actionselected) {
        this.actionselected = actionselected;
    }

    public ArrayList<String> getConstraintselected() {
        return constraintselected;
    }

    public void setConstraintselected(ArrayList<String> constraintselected) {
        this.constraintselected = constraintselected;
    }

    public ArrayList<String> getTriggerselected() {
        return triggerselected;
    }

    public void setTriggerselected(ArrayList<String> triggerselected) {
        this.triggerselected = triggerselected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

   /* public Boolean getFlashlighton() {
        return flashlighton;
    }

    public void setFlashlighton(Boolean flashlighton) {
        this.flashlighton = flashlighton;
    }*/

    public ArrayList<NotificationactionModel> getActionnotification() {
        return actionnotification;
    }

    public void setActionnotification(ArrayList<NotificationactionModel> actionnotification) {
        this.actionnotification = actionnotification;
    }

    public Boolean getActionringer() {
        return actionringer;
    }

    public void setActionringer(Boolean actionringer) {
        this.actionringer = actionringer;
    }

    /*public Boolean getActionscreen() {
        return actionscreen;
    }

    public void setActionscreen(Boolean actionscreen) {
        this.actionscreen = actionscreen;
    }*/

    public ArrayList<String> getActionToast() {
        return actionToast;
    }

    public void setActionToast(ArrayList<String> actionToast) {
        this.actionToast = actionToast;
    }

    public ArrayList<VibrationActionModel> getActionvibration() {
        return actionvibration;
    }

    public void setActionvibration(ArrayList<VibrationActionModel> actionvibration) {
        this.actionvibration = actionvibration;
    }

    public VolumeActionModel getActionvolume() {
        return actionvolume;
    }

    public void setActionvolume(VolumeActionModel actionvolume) {
        this.actionvolume = actionvolume;
    }

    public Boolean getConstraintautorotate() {
        return constraintautorotate;
    }

    public void setConstraintautorotate(Boolean constraintautorotate) {
        this.constraintautorotate = constraintautorotate;
    }

    public ArrayList<BatteryLevelTemplate> getConstraintbatterylevel() {
        return constraintbatterylevel;
    }

    public void setConstraintbatterylevel(ArrayList<BatteryLevelTemplate> constraintbatterylevel) {
        this.constraintbatterylevel = constraintbatterylevel;
    }

    public ArrayList<BatteryTempTemplate> getConstraintbatterytemp() {
        return constraintbatterytemp;
    }

    public void setConstraintbatterytemp(ArrayList<BatteryTempTemplate> constraintbatterytemp) {
        this.constraintbatterytemp = constraintbatterytemp;
    }

    public Boolean getConstraintcharging() {
        return constraintcharging;
    }

    public void setConstraintcharging(Boolean constraintcharging) {
        this.constraintcharging = constraintcharging;
    }

    public Boolean getConstraintheadphones() {
        return constraintheadphones;
    }

    public void setConstraintheadphones(Boolean constraintheadphones) {
        this.constraintheadphones = constraintheadphones;
    }

    public ArrayList<Boolean> getConstraintmonth() {
        return constraintmonth;
    }

    public void setConstraintmonth(ArrayList<Boolean> constraintmonth) {
        this.constraintmonth = constraintmonth;
    }

    public Boolean getConstraintorientation() {
        return constraintorientation;
    }

    public void setConstraintorientation(Boolean constraintorientation) {
        this.constraintorientation = constraintorientation;
    }

    public Boolean getConstraintscreenstate() {
        return constraintscreenstate;
    }

    public void setConstraintscreenstate(Boolean constraintscreenstate) {
        this.constraintscreenstate = constraintscreenstate;
    }

    public ArrayList<Boolean> getConstraintweekday() {
        return constraintweekday;
    }

    public void setConstraintweekday(ArrayList<Boolean> constraintweekday) {
        this.constraintweekday = constraintweekday;
    }


    public ArrayList<Boolean> getConstraintmonthday() {
        return constraintmonthday;
    }

    public void setConstraintmonthday(ArrayList<Boolean> constraintmonthday) {
        this.constraintmonthday = constraintmonthday;
    }


    public ArrayList<Integer> getTriggerbattery() {
        return triggerbattery;
    }

    public void setTriggerbattery(ArrayList<Integer> triggerbattery) {
        this.triggerbattery = triggerbattery;
    }

    public ArrayList<DayofthemonthTemplate> getTriggerdayofthemonth() {
        return triggerdayofthemonth;
    }

    public void setTriggerdayofthemonth(ArrayList<DayofthemonthTemplate> triggerdayofthemonth) {
        this.triggerdayofthemonth = triggerdayofthemonth;
    }

    public ArrayList<DayoftheweekTemplate> getTriggerdayoftheweek() {
        return triggerdayoftheweek;
    }

    public void setTriggerdayoftheweek(ArrayList<DayoftheweekTemplate> triggerdayoftheweek) {
        this.triggerdayoftheweek = triggerdayoftheweek;
    }

    public ArrayList<TimeTemplate> getTriggertime() {
        return triggertime;
    }

    public void setTriggertime(ArrayList<TimeTemplate> triggertime) {
        this.triggertime = triggertime;
    }





    public MacroStorage(String name, Boolean enabled,@Nullable ArrayList<DelayactionModel> actiondelay, @Nullable String actionclipboard, @Nullable ArrayList<NotificationactionModel> actionnotification, @Nullable Boolean actionringer, @Nullable ArrayList<String> actionToast, @Nullable ArrayList<VibrationActionModel> actionvibration, @Nullable VolumeActionModel actionvolume, @Nullable Boolean constraintautorotate, @Nullable ArrayList<BatteryLevelTemplate> constraintbatterylevel, @Nullable ArrayList<BatteryTempTemplate> constraintbatterytemp, @Nullable Boolean constraintcharging, @Nullable Boolean constraintheadphones, @Nullable ArrayList<Boolean> constraintmonth, @Nullable ArrayList<Boolean> constraintmonthday, @Nullable Boolean constraintorientation, @Nullable Boolean constraintscreenstate, @Nullable ArrayList<Boolean> constraintweekday, @Nullable ArrayList<Integer> triggerbattery, @Nullable ArrayList<DayofthemonthTemplate> triggerdayofthemonth, @Nullable ArrayList<DayoftheweekTemplate> triggerdayoftheweek, @Nullable ArrayList<TimeTemplate> triggertime, @Nullable ArrayList<String> actionselected, @Nullable ArrayList<String> constraintselected, @Nullable ArrayList<String> triggerselected) {
        this.actiondelay=actiondelay;
        this.name = name;
        this.enabled = enabled;
        this.actionclipboard = actionclipboard;
        this.actionnotification = actionnotification;
        this.actionringer = actionringer;
        this.actionToast = actionToast;
        this.actionvibration = actionvibration;
        this.actionvolume = actionvolume;
        this.constraintautorotate = constraintautorotate;
        this.constraintbatterylevel = constraintbatterylevel;
        this.constraintbatterytemp = constraintbatterytemp;
        this.constraintcharging = constraintcharging;
        this.constraintheadphones = constraintheadphones;
        this.constraintmonth = constraintmonth;
        this.constraintmonthday = constraintmonthday;
        this.constraintorientation = constraintorientation;
        this.constraintscreenstate = constraintscreenstate;
        this.constraintweekday = constraintweekday;
        this.triggerbattery = triggerbattery;
        this.triggerdayofthemonth = triggerdayofthemonth;
        this.triggerdayoftheweek = triggerdayoftheweek;
        this.triggertime = triggertime;
        this.actionselected = actionselected;
        this.constraintselected = constraintselected;
        this.triggerselected = triggerselected;
    }
}
