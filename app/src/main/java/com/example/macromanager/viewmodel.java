package com.example.macromanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.macromanager.actionstorage.DelayactionModel;
import com.example.macromanager.actionstorage.NotificationactionModel;
import com.example.macromanager.actionstorage.VibrationActionModel;
import com.example.macromanager.actionstorage.VolumeActionModel;
import com.example.macromanager.constraintstorage.BatteryLevelTemplate;
import com.example.macromanager.constraintstorage.BatteryTempTemplate;
import com.example.macromanager.macrostorage.MacroStorage;
import com.example.macromanager.macrostorage.Repository;
import com.example.macromanager.triggerstorage.DayofthemonthTemplate;
import com.example.macromanager.triggerstorage.DayoftheweekTemplate;
import com.example.macromanager.triggerstorage.TimeTemplate;

import java.util.ArrayList;
import java.util.List;

public class viewmodel extends AndroidViewModel {


    Repository repository;

    LiveData<List<MacroStorage>> allmacros;

    MacroStorage currentmacro;

    public MacroStorage getCurrentmacro() {
        return currentmacro;
    }

    public void setCurrentmacro(MacroStorage currentmacro) {
        this.currentmacro = currentmacro;
    }

    public viewmodel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allmacros = repository.getAllmacros();
    }

    public void insertmacro(MacroStorage obj) {
        repository.insert(obj);
    }

    public void deletemacro(MacroStorage obj) {
        repository.delete(obj);
    }

    public void updatemacro(MacroStorage obj) {
        repository.update(obj);
    }


    public LiveData<List<MacroStorage>> getallmacros() {
        return allmacros;
    }


    String name;

    Boolean edit, enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }


    public void viewmodeltomacrostorage() {
        if (currentmacro == null) {
            currentmacro = new MacroStorage(name, enabled, actiondelay,ActionClipboard, actionnotification, actionringer,  actionToast, actionvibration, actionvolume, constraintautorotate, constraintbatterylevel, constraintbatterytemp, constraintcharging, constraintheadphones, constraintmonth, constraintmonthday, constraintorientation, constraintscreenstate, constraintweekday, triggerbattery, triggerdayofthemonth, triggerdayoftheweek, triggertime, actionselected, constraintselected, triggerselected);
            insertmacro(currentmacro);
        } else {
            int id = currentmacro.getId();
            currentmacro = new MacroStorage(name, enabled, actiondelay,ActionClipboard, actionnotification, actionringer,  actionToast, actionvibration, actionvolume, constraintautorotate, constraintbatterylevel, constraintbatterytemp, constraintcharging, constraintheadphones, constraintmonth, constraintmonthday, constraintorientation, constraintscreenstate, constraintweekday, triggerbattery, triggerdayofthemonth, triggerdayoftheweek, triggertime, actionselected, constraintselected, triggerselected);
            currentmacro.setId(id);
            updatemacro(currentmacro);
        }
    }


    public void startedit() {


        name = currentmacro.getName();
        enabled = currentmacro.getEnabled();
        actiondelay = currentmacro.getActiondelay();
        ActionClipboard = currentmacro.getActionclipboard();
        //Flashlighton = currentmacro.getAc);
        actionnotification = currentmacro.getActionnotification();
        actionringer = currentmacro.getActionringer();
       // actionscreen = currentmacro.getActionscreen();
        actionToast = currentmacro.getActionToast();
        actionvibration = currentmacro.getActionvibration();
        actionvolume = currentmacro.getActionvolume();
        constraintautorotate = currentmacro.getConstraintautorotate();
        constraintbatterylevel = currentmacro.getConstraintbatterylevel();
        constraintbatterytemp = currentmacro.getConstraintbatterytemp();
        constraintcharging = currentmacro.getConstraintcharging();
        constraintheadphones = currentmacro.getConstraintheadphones();
        constraintmonth = currentmacro.getConstraintmonth();
        constraintorientation = currentmacro.getConstraintorientation();
        constraintscreenstate = currentmacro.getConstraintscreenstate();
        constraintweekday = currentmacro.getConstraintweekday();
        constraintmonthday = currentmacro.getConstraintmonthday();
        triggerbattery = currentmacro.getTriggerbattery();
        triggerdayofthemonth = currentmacro.getTriggerdayofthemonth();
        triggerdayoftheweek = currentmacro.getTriggerdayoftheweek();
        triggertime = currentmacro.getTriggertime();
        actionselected = currentmacro.getActionselected();
        constraintselected = currentmacro.getConstraintselected();
        triggerselected = currentmacro.getTriggerselected();


    }


//
//
    //

    //
    //
    //
    //
    //
    //
    //
    //

    //
    //
    //
    //

    //
    //
    //
    ////
    //

    ////

    private String ActionClipboard = null;

//    private Boolean Flashlighton = null;

    private ArrayList<NotificationactionModel> actionnotification = null;

    private Boolean actionringer = null;

    //private Boolean actionscreen = null;

    private ArrayList<String> actionToast = null;

    private ArrayList<VibrationActionModel> actionvibration = null;

    private VolumeActionModel actionvolume = null;

    private ArrayList<DelayactionModel> actiondelay = null;


    //
    ///
    //
    //
    //
    //
    //
    //
    //


    private Boolean constraintautorotate = null;

    private ArrayList<BatteryLevelTemplate> constraintbatterylevel = null;

    private ArrayList<BatteryTempTemplate> constraintbatterytemp = null;

    private Boolean constraintcharging = null;

    private Boolean constraintheadphones = null;

    private ArrayList<Boolean> constraintmonth = null;

    private Boolean constraintorientation = null;

    private Boolean constraintscreenstate = null;

    private ArrayList<Boolean> constraintweekday = null;

    private ArrayList<Boolean> constraintmonthday = null;


    //
    //
    //
    //
    //
    //
    //
    //
    //

    private ArrayList<Integer> triggerbattery = null;

    private ArrayList<DayofthemonthTemplate> triggerdayofthemonth = null;

    private ArrayList<DayoftheweekTemplate> triggerdayoftheweek = null;

    private ArrayList<TimeTemplate> triggertime = null;


    //
    //
    //
    //
    ///
    //
    //
    //
    //


    private ArrayList<String> actionselected = new ArrayList<>();

    private ArrayList<String> constraintselected = new ArrayList<>();

    private ArrayList<String> triggerselected = new ArrayList<>();


    //
    //
    //
    //
    //
    //
    ///
    //


    public void clear() {
        currentmacro = null;
        edit = null;
        name = null;
        enabled = null;
        actiondelay=null;
        ActionClipboard = null;
        //Flashlighton = null;
        actionnotification = null;
        actionringer = null;
       // actionscreen = null;
        actionToast = null;
        actionvibration = null;
        actionvolume = null;
        constraintautorotate = null;
        constraintbatterylevel = null;
        constraintbatterytemp = null;
        constraintcharging = null;
        constraintheadphones = null;
        constraintmonth = null;
        constraintorientation = null;
        constraintscreenstate = null;
        constraintweekday = null;
        constraintmonthday = null;
        triggerbattery = null;
        triggerdayofthemonth = null;
        triggerdayoftheweek = null;
        triggertime = null;
        actionselected = new ArrayList<>();
        constraintselected = new ArrayList<>();
        triggerselected = new ArrayList<>();

    }


    /*
    //
    //
    //
    /
    /
    //

    /
    /
    /
    /
    /

    /
    /
    /

    /
    /
    /
    /
    /
    /
/

/*/
    public LiveData<List<MacroStorage>> getAllmacros() {
        return allmacros;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionClipboard() {
        return ActionClipboard;
    }

    public void setActionClipboard(String actionClipboard) {
        ActionClipboard = actionClipboard;
    }

   /* public Boolean getFlashlighton() {
        return Flashlighton;
    }

    public void setFlashlighton(Boolean flashlighton) {
        Flashlighton = flashlighton;
    }*/

    public ArrayList<NotificationactionModel> getActionnotification() {
        if (actionnotification == null)
            actionnotification = new ArrayList<>();
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
    }
*/
    public ArrayList<String> getActionToast() {
        if(actionToast==null)
            actionToast=new ArrayList<>();

        return actionToast;
    }

    public void setActionToast(ArrayList<String> actionToast) {
        this.actionToast = actionToast;
    }

    public ArrayList<VibrationActionModel> getActionvibration() {
        if(actionvibration==null)
            actionvibration=new ArrayList<>();

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


    public ArrayList<DelayactionModel> getActiondelay() {
        if(actiondelay==null)
            actiondelay=new ArrayList<>();
        return actiondelay;
    }

    public void setActiondelay(ArrayList<DelayactionModel> actiondelay) {
        this.actiondelay = actiondelay;
    }

    public Boolean getConstraintautorotate() {
        return constraintautorotate;
    }

    public void setConstraintautorotate(Boolean constraintautorotate) {
        this.constraintautorotate = constraintautorotate;
    }

    public ArrayList<BatteryLevelTemplate> getConstraintbatterylevel() {
        if(constraintbatterylevel==null)
            constraintbatterylevel=new ArrayList<>();

        return constraintbatterylevel;
    }

    public void setConstraintbatterylevel(ArrayList<BatteryLevelTemplate> constraintbatterylevel) {
        this.constraintbatterylevel = constraintbatterylevel;
    }

    public ArrayList<BatteryTempTemplate> getConstraintbatterytemp() {
        if(constraintbatterytemp==null)
            constraintbatterytemp=new ArrayList<>();
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
        if(triggerbattery==null)
            triggerbattery=new ArrayList<>();

        return triggerbattery;
    }

    public void setTriggerbattery(ArrayList<Integer> triggerbattery) {
        this.triggerbattery = triggerbattery;
    }

    public ArrayList<DayofthemonthTemplate> getTriggerdayofthemonth() {
        if(triggerdayofthemonth==null)
            triggerdayofthemonth=new ArrayList<>();

        return triggerdayofthemonth;
    }

    public void setTriggerdayofthemonth(ArrayList<DayofthemonthTemplate> triggerdayofthemonth) {
        this.triggerdayofthemonth = triggerdayofthemonth;
    }

    public ArrayList<DayoftheweekTemplate> getTriggerdayoftheweek() {
        if(triggerdayoftheweek==null)
            triggerdayoftheweek=new ArrayList<>();

        return triggerdayoftheweek;
    }

    public void setTriggerdayoftheweek(ArrayList<DayoftheweekTemplate> triggerdayoftheweek) {
        this.triggerdayoftheweek = triggerdayoftheweek;
    }

    public ArrayList<TimeTemplate> getTriggertime() {
        if(triggertime==null)
            triggertime=new ArrayList<>();

        return triggertime;
    }

    public void setTriggertime(ArrayList<TimeTemplate> triggertime) {
        this.triggertime = triggertime;
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




/*
    //
    //
    /
    /
    /
    /
    /
    /
    /

    /
    /
    /
    */

    public MutableLiveData<Boolean> getTemporary() {
        if (temporary == null)
            temporary = new MutableLiveData<>();

        return temporary;
    }

    private MutableLiveData<Boolean> temporary;
    private MutableLiveData<Boolean> actionupdate;

    public MutableLiveData<Boolean> getActionupdate() {
        if (actionupdate == null) {
            actionupdate = new MutableLiveData<>();
            actionupdate.setValue(false);
        }
        return actionupdate;
    }

    public MutableLiveData<Boolean> getConstraintupdate() {
        if (constraintupdate == null) {
            constraintupdate = new MutableLiveData<>();
            constraintupdate.setValue(false);
        }
        return constraintupdate;
    }

    public MutableLiveData<Boolean> getTriggerupdate() {
        if (triggerupdate == null) {
            triggerupdate = new MutableLiveData<>();
            triggerupdate.setValue(false);
        }
        return triggerupdate;
    }

    private MutableLiveData<Boolean> constraintupdate;
    private MutableLiveData<Boolean> triggerupdate;


}
