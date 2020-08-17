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


    /*void ringer(Context context,Boolean voicecall, Boolean notification, Boolean alarm, Boolean media, Boolean ringer, Integer voicecallvalue, Integer notificationvalue, Integer alarmvalue, Integer mediavalue, Integer ringervalue){

        if(voicecall){

        }

        if(notification){

        }

        if(alarm){

        }

        if(media){

        }

        if(ringer){

        }*/



       /* audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, i, 0);
*/
}






