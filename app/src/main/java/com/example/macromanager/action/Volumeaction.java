package com.example.macromanager.action;

import android.content.Context;
import android.media.AudioManager;

import com.example.macromanager.actionstorage.Notificationactiontemplate;
import com.example.macromanager.actionstorage.VolumeActionTemplate;

public class Volumeaction {

    AudioManager audioManager;

    public void volume(VolumeActionTemplate x, Context context) {

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        //audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, i, 0);


        if (x.getAlarm())
            audioManager.setStreamVolume(AudioManager.STREAM_ALARM, x.getAlarmvalue(), 0);

        if (x.getMedia())
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, x.getMediavalue(), 0);

        if (x.getRinger())
            audioManager.setStreamVolume(AudioManager.STREAM_RING, x.getRingervalue(), 0);

        if (x.getVoicecall())
            audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, x.getVoicecallvalue(), 0);

        if (x.getNotification())
            audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, x.getNotificationvalue(), 0);

    }


}