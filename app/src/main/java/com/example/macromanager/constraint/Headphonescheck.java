package com.example.macromanager.constraint;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;

public class Headphonescheck {


    ////////////wirewrless stfudsf


    public boolean headphonescheck(Context context) {

        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        AudioDeviceInfo[] temp = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS);
        return temp.length != 0;
    }

}
