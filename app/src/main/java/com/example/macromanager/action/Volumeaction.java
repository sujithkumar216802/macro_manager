package com.example.macromanager.action;

import android.content.Context;
import android.media.AudioManager;

import com.example.macromanager.actionmodels.VolumeActionModel;

public class Volumeaction {

    AudioManager audioManager;

    public void volume(VolumeActionModel x, Context context) {

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

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
