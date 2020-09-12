package com.example.macromanager.action;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class Vibrateaction {

    Vibrator v;

    public void vibrate(Integer duration, Integer delay, Integer repeat, Context context) {

        v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratee(duration, delay, repeat);

        //v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));


    }


    void vibratee(final int duration, final int delay, final int repeat) {
        if (repeat <= 0) {
            v.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
            new CountDownTimer(duration, 1) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    delay(duration, delay, repeat);
                }
            }.start();
        }
    }

    void delay(final int duration, final int delay, final int repeat) {
        new CountDownTimer(delay, 1) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                vibratee(duration, delay, repeat - 1);
            }
        }.start();
    }


}
