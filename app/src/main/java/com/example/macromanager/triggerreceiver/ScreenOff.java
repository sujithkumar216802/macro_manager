package com.example.macromanager.triggerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.action.Clipboardaction;
import com.example.macromanager.action.Homescreenaction;
import com.example.macromanager.action.Notificationaction;
import com.example.macromanager.action.Ringeraction;
import com.example.macromanager.action.Volumeaction;
import com.example.macromanager.actionstorage.NotificationactionModel;
import com.example.macromanager.actionstorage.VibrationActionModel;
import com.example.macromanager.actionstorage.VolumeActionModel;
import com.example.macromanager.constraint.Autorotatecheck;
import com.example.macromanager.constraint.Batterylevelcheck;
import com.example.macromanager.constraint.Batterytempcheck;
import com.example.macromanager.constraint.Chargingcheck;
import com.example.macromanager.constraint.Headphonescheck;
import com.example.macromanager.constraint.Monthcheck;
import com.example.macromanager.constraint.Orientationcheck;
import com.example.macromanager.constraint.Screenstatecheck;
import com.example.macromanager.constraint.Weekdaycheck;
import com.example.macromanager.constraintstorage.BatteryLevelTemplate;
import com.example.macromanager.constraintstorage.BatteryTempTemplate;
import com.example.macromanager.macrostorage.MacroStorage;
import com.example.macromanager.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class ScreenOff extends BroadcastReceiver {


    viewmodel res;
    List<MacroStorage> temp;
    Context context;
    Intent intent;


    @Override
    public void onReceive(Context context, Intent intent) {


        this.context = context;
        this.intent = intent;
        res = new ViewModelProvider((AppCompatActivity) context).get(viewmodel.class);
        res.getallmacros().observe((AppCompatActivity) context, new Observer<List<MacroStorage>>() {
            @Override
            public void onChanged(List<MacroStorage> macroStorages) {
                temp = macroStorages;
                for (int i = 0; i < macroStorages.size(); i++) {
                    if(macroStorages.get(i).getEnabled()){
                    for (String s : macroStorages.get(i).getTriggerselected()) {
                        if (s.equals("Screen Switched Off")) {
                            try {
                                constraintcheck(i);
                            } catch (Settings.SettingNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }}
                }

            }
        });


    }


    void constraintcheck(int index) throws Settings.SettingNotFoundException {
        //boolean constraint = true;

        Boolean autorotate = temp.get(index).getConstraintautorotate();
        if (autorotate != null) {
            Autorotatecheck autorotatecheck = new Autorotatecheck();
            if (autorotatecheck.autorotate(context) != autorotate) {
                return;
            }
        }

        ArrayList<BatteryLevelTemplate> batteryLevelTemplates = temp.get(index).getConstraintbatterylevel();
        if (batteryLevelTemplates != null) {
            Batterylevelcheck batterylevelcheck = new Batterylevelcheck();
            int percentage = batterylevelcheck.batterylevel(context);
            for (int i = 0; i < batteryLevelTemplates.size(); i++) {
                switch (batteryLevelTemplates.get(i).getSelected()) {
                    case 0:
                        if (percentage != batteryLevelTemplates.get(i).getPercentage()) {
                            return;
                        }
                        break;
                    case 1:
                        if (percentage <= batteryLevelTemplates.get(i).getPercentage()) {
                            return;
                        }
                        break;
                    case -1:
                        if (percentage >= batteryLevelTemplates.get(i).getPercentage()) {
                            return;
                        }
                        break;
                }
            }
        }

        ArrayList<BatteryTempTemplate> batteryTempTemplates = temp.get(index).getConstraintbatterytemp();
        if (batteryTempTemplates != null) {
            Batterytempcheck batterytempcheck = new Batterytempcheck();
            int temperature = batterytempcheck.batterytemp(intent);
            for (int i = 0; i < batteryTempTemplates.size(); i++) {
                switch (batteryTempTemplates.get(i).getSelected()) {
                    case 0:
                        if (batteryTempTemplates.get(i).getTemp() != temperature) {
                            return;
                        }
                        break;
                    case 1:
                        if (batteryTempTemplates.get(i).getTemp() <= temperature) {
                            return;
                        }
                        break;
                    case -1:
                        if (batteryTempTemplates.get(i).getTemp() >= temperature) {
                            return;
                        }
                        break;
                }
            }
        }

        Boolean charging = temp.get(index).getConstraintcharging();
        if (charging != null) {
            Chargingcheck chargingcheck = new Chargingcheck();
            if (charging != chargingcheck.chargingcheck(context)) {
                return;
            }
        }

        Boolean headphones = temp.get(index).getConstraintheadphones();
        if (headphones != null) {
            Headphonescheck headphonescheck = new Headphonescheck();
            if (headphones != headphonescheck.headphonescheck(context)) {
                return;
            }
        }

        ArrayList<Boolean> months = temp.get(index).getConstraintmonth();
        if (months != null) {
            Monthcheck monthcheck = new Monthcheck();
            if (!months.get(monthcheck.monthcheck())) {
                return;
            }
        }

        Boolean portrait = temp.get(index).getConstraintorientation();
        if (portrait != null) {
            Orientationcheck orientationcheck = new Orientationcheck();
            if (portrait != orientationcheck.portrait(context)) {
                return;
            }
        }

        Boolean screenon = temp.get(index).getConstraintscreenstate();
        if (screenon != null) {
            Screenstatecheck screenstatecheck = new Screenstatecheck();
            if (screenstatecheck.on(context) != screenon) {
                return;
            }
        }

        ArrayList<Boolean> weekday = temp.get(index).getConstraintweekday();
        if (weekday != null) {
            Weekdaycheck weekdaycheck = new Weekdaycheck();
            if (!weekday.get(weekdaycheck.weekdaycheck())) {
                return;
            }
        }


        action(index);

    }


    void action(int index) {

        String clipboard = temp.get(index).getActionclipboard();
        if (clipboard != null) {
            Clipboardaction clipboardaction = new Clipboardaction();
            clipboardaction.clipboardedit(clipboard, context);
        }

        //if(temp.get(index).getactio)


        for (String s : temp.get(index).getActionselected()) {
            if (s.equals("Launch Homescreen")) {
                Homescreenaction homescreenaction = new Homescreenaction();
                homescreenaction.launch(context);
            }
        }


        ArrayList<NotificationactionModel> notificationactionModels = temp.get(index).getActionnotification();
        if (notificationactionModels != null) {
            Notificationaction notificationaction = new Notificationaction();
            for (int i = 0; i < notificationactionModels.size(); i++) {
                notificationaction.createNotificationChannel(context, notificationactionModels.get(i).getTitle(), notificationactionModels.get(i).getMessage());
            }
        }

        Boolean vibrate = temp.get(index).getActionringer();
        if (vibrate != null) {
            Ringeraction ringeraction = new Ringeraction();
            ringeraction.ringer(context, vibrate);
        }

        ArrayList<String> toastmessages = temp.get(index).getActionToast();
        if (toastmessages != null) {

        }

        ArrayList<VibrationActionModel> vibrationActionModels = temp.get(index).getActionvibration();
        if (vibrationActionModels != null) {

        }

        VolumeActionModel volumeActionModel = temp.get(index).getActionvolume();
        if (volumeActionModel != null) {
            Volumeaction volumeaction = new Volumeaction();
            volumeaction.volume(volumeActionModel, context);

        }

    }


}
