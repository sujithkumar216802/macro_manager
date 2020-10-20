package com.example.macromanager.action;

import android.content.Context;
import android.media.AudioManager;

public class Ringeraction {

    AudioManager audioManager;


    public void ringer(Context context, Boolean vibrate) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        if (vibrate) {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        } else {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }
    }
}
