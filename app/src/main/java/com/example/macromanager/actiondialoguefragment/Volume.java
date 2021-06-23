package com.example.macromanager.actiondialoguefragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.R;
import com.example.macromanager.actionmodels.VolumeActionModel;
import com.example.macromanager.viewmodel;

public class Volume extends DialogFragment {

    viewmodel res;

    VolumeActionModel template;

    CheckBox voicecall, notification, alarm, media, ringer;
    TextView voicecallvalue, notificationvalue, alarmvalue, mediavalue, ringervalue;
    SeekBar voicecallseek, notificationseek, alarmseek, mediaseek, ringerseek;


    public Volume(VolumeActionModel temp) {
        template = temp;
    }

    public Volume() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);

        AudioManager audioManager = (AudioManager) requireActivity().getSystemService(Context.AUDIO_SERVICE);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.volumedialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        voicecall = v.findViewById(R.id.voicecallcheckbox);
        notification = v.findViewById(R.id.notificationcheckbox);
        alarm = v.findViewById(R.id.alarmcheckbox);
        media = v.findViewById(R.id.mediacheckbox);
        ringer = v.findViewById(R.id.ringercheckbox);


        voicecallvalue = v.findViewById(R.id.voicecallvalue);
        notificationvalue = v.findViewById(R.id.notificationvalue);
        alarmvalue = v.findViewById(R.id.alarmvalue);
        mediavalue = v.findViewById(R.id.mediavalue);
        ringervalue = v.findViewById(R.id.ringervalue);

        voicecallseek = v.findViewById(R.id.voicecallseekbar);
        notificationseek = v.findViewById(R.id.notificationseekbar);
        alarmseek = v.findViewById(R.id.alarmseekbar);
        mediaseek = v.findViewById(R.id.mediaseekbar);
        ringerseek = v.findViewById(R.id.ringerseekbar);


        voicecallseek.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
        notificationseek.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
        alarmseek.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
        mediaseek.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        ringerseek.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));

        if (template == null) {
            voicecallseek.setEnabled(false);
            notificationseek.setEnabled(false);
            alarmseek.setEnabled(false);
            mediaseek.setEnabled(false);
            ringerseek.setEnabled(false);
        } else {
            voicecall.setChecked(template.getVoicecall());
            notification.setChecked(template.getNotification());
            alarm.setChecked(template.getAlarm());
            media.setChecked(template.getMedia());
            ringer.setChecked(template.getRinger());

            if (template.getVoicecall()) {
                voicecallseek.setProgress(template.getVoicecallvalue());
                voicecallvalue.setText(template.getVoicecallvalue().toString());
            } else {
                voicecallseek.setEnabled(false);
            }

            if (template.getNotification()) {
                notificationseek.setProgress(template.getNotificationvalue());
                notificationvalue.setText(template.getNotificationvalue().toString());
            } else {
                notificationseek.setEnabled(false);
            }
            if (template.getAlarm()) {
                alarmseek.setProgress(template.getAlarmvalue());
                alarmvalue.setText(template.getAlarmvalue().toString());
            } else {
                alarmseek.setEnabled(false);
            }
            if (template.getMedia()) {
                mediaseek.setProgress(template.getMediavalue());
                mediavalue.setText(template.getMediavalue().toString());
            } else {
                mediaseek.setEnabled(false);
            }
            if (template.getRinger()) {
                ringerseek.setProgress(template.getRingervalue());
                ringervalue.setText(template.getRingervalue().toString());
            } else {
                ringerseek.setEnabled(false);
            }

        }


        voicecallseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                voicecallvalue.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                voicecallvalue.setText("" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                voicecallvalue.setText("" + seekBar.getProgress());
            }
        });

        notificationseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                notificationvalue.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                notificationvalue.setText("" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                notificationvalue.setText("" + seekBar.getProgress());
            }
        });

        alarmseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                alarmvalue.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                alarmvalue.setText("" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                alarmvalue.setText("" + seekBar.getProgress());
            }
        });

        mediaseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediavalue.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediavalue.setText("" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediavalue.setText("" + seekBar.getProgress());
            }
        });

        ringerseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ringervalue.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                ringervalue.setText("" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ringervalue.setText("" + seekBar.getProgress());
            }
        });


        voicecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voicecallseek.setEnabled(voicecall.isChecked());
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationseek.setEnabled(notification.isChecked());
            }
        });


        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmseek.setEnabled(alarm.isChecked());
            }
        });

        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaseek.setEnabled(media.isChecked());
            }
        });
        ringer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ringerseek.setEnabled(ringer.isChecked());
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {
                VolumeActionModel x = new VolumeActionModel();
                x.setVoicecall(voicecall.isChecked());
                x.setNotification(notification.isChecked());
                x.setAlarm(alarm.isChecked());
                x.setMedia(media.isChecked());
                x.setRinger(ringer.isChecked());
                x.setVoicecallvalue(voicecallseek.getProgress());
                x.setNotificationvalue(notificationseek.getProgress());
                x.setAlarmvalue(alarmseek.getProgress());
                x.setMediavalue(mediaseek.getProgress());
                x.setRingervalue(ringerseek.getProgress());

                for (int i = 0; i < res.getActionselected().size(); i++) {
                    if (res.getActionselected().get(i).equals("Volume")) {
                        res.getActionselected().remove(i);
                    }
                }
                res.getActionselected().add("Volume");

                res.setActionvolume(x);

                res.getActionupdate().setValue(!res.getActionupdate().getValue());
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Volume");


        return builder.create();
    }


}
