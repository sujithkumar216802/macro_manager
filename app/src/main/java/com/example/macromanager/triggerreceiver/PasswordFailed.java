package com.example.macromanager.triggerreceiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.Settings;

import androidx.lifecycle.Observer;

import com.example.macromanager.action.Clipboardaction;
import com.example.macromanager.action.Homescreenaction;
import com.example.macromanager.action.Notificationaction;
import com.example.macromanager.action.Ringeraction;
import com.example.macromanager.action.Toastaction;
import com.example.macromanager.action.Vibrateaction;
import com.example.macromanager.action.Volumeaction;
import com.example.macromanager.actionmodels.NotificationactionModel;
import com.example.macromanager.actionmodels.VibrationActionModel;
import com.example.macromanager.actionmodels.VolumeActionModel;
import com.example.macromanager.constraint.Autorotatecheck;
import com.example.macromanager.constraint.Batterylevelcheck;
import com.example.macromanager.constraint.Batterytempcheck;
import com.example.macromanager.constraint.Chargingcheck;
import com.example.macromanager.constraint.Headphonescheck;
import com.example.macromanager.constraint.Monthcheck;
import com.example.macromanager.constraint.Monthdaycheck;
import com.example.macromanager.constraint.Orientationcheck;
import com.example.macromanager.constraint.Screenstatecheck;
import com.example.macromanager.constraint.Weekdaycheck;
import com.example.macromanager.constraintmodels.BatteryLevelTemplate;
import com.example.macromanager.constraintmodels.BatteryTempTemplate;
import com.example.macromanager.macrostorage.MacroStorage;
import com.example.macromanager.macrostorage.Repository;

import java.util.ArrayList;
import java.util.List;

public class PasswordFailed extends BroadcastReceiver {


    Repository repository;
    List<MacroStorage> temp;
    Context context;
    Intent intent;


    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
        repository = new Repository((Application) context.getApplicationContext());
        repository.getAllmacros().observeForever(new Observer<List<MacroStorage>>() {
            @Override
            public void onChanged(List<MacroStorage> macroStorages) {
                temp = macroStorages;
                for (int i = 0; i < macroStorages.size(); i++) {
                    if (macroStorages.get(i).getEnabled()) {
                        for (String s : macroStorages.get(i).getTriggerselected()) {
                            if (s.equals("Password Failed")) {
                                try {
                                    constraintcheck(i);
                                } catch (Settings.SettingNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }

            }
        });

    }


    void constraintcheck(final int index) throws Settings.SettingNotFoundException {
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

        ArrayList<Boolean> monthdday = temp.get(index).getConstraintmonthday();
        if (monthdday != null) {
            Monthdaycheck monthdaycheck = new Monthdaycheck();
            if (!monthdday.get(monthdaycheck.monthday() - 1)) {
                return;
            }
        }

        if (temp.get(index).getActiondelay() == null || temp.get(index).getActiondelay().size() == 0)
            action(index);
        else {
            new CountDownTimer(temp.get(index).getActiondelay().get(0).getMiliseconds(), 1) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    action(index);
                }
            }.start();
        }

    }


    void action(final int index) {


        String clipboard = temp.get(index).getActionclipboard();
        if (clipboard != null) {
            Clipboardaction clipboardaction = new Clipboardaction();
            clipboardaction.clipboardedit(clipboard, context);
        }


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
            toast(toastmessages, 0);
        }


        ArrayList<VibrationActionModel> vibrationActionModels = temp.get(index).getActionvibration();
        if (vibrationActionModels != null) {
            vibrate(vibrationActionModels, 0);
        }


        VolumeActionModel volumeActionModel = temp.get(index).getActionvolume();
        if (volumeActionModel != null) {
            Volumeaction volumeaction = new Volumeaction();
            volumeaction.volume(volumeActionModel, context);
        }


    }


    private void toast(final ArrayList<String> messages, final int index) {

        Toastaction toastaction = new Toastaction();

        if (index < messages.size())
            toastaction.toast(messages.get(index), context);

        if (index < messages.size() - 1) {
            new CountDownTimer(3500, 500) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    toast(messages, index + 1);
                }
            }.start();
        }


    }

    private void vibrate(final ArrayList<VibrationActionModel> vibration, final int index) {

        Vibrateaction vibrateaction = new Vibrateaction();

        if (index < vibration.size())
            vibrateaction.vibrate(vibration.get(index).getDuration(), vibration.get(index).getDelay(), vibration.get(index).getRepeat(), context);

        if (index < vibration.size() - 1) {

            int time = (vibration.get(index).getDuration() * vibration.get(index).getRepeat()) + (vibration.get(index).getDelay() * (vibration.get(index).getRepeat() - 1));

            new CountDownTimer(time, 1) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    vibrate(vibration, index - 1);
                }
            }.start();


        }

    }

}
