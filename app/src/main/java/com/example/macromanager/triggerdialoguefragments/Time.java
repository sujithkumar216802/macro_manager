package com.example.macromanager.triggerdialoguefragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.triggerstorage.DayofthemonthTemplate;
import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.example.macromanager.triggerstorage.TimeTemplate;

import java.util.ArrayList;

public class Time extends DialogFragment {

    viewmodel res;
    Integer hour, minutes;
    TextView time;
    Integer index;

    public Time(TimeTemplate x, Integer index) {
        this.hour = x.getHour();
        this.minutes = x.getMinutes();
        this.index = index;
    }

    public Time() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.timedialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        time = v.findViewById(R.id.fromTime);
        if (hour != null) {
            //time.setText(hour + ":" + minutes);
            settime();
        } else {
            hour = 0;
            minutes = 0;
        }


        final TimePickerDialog.OnTimeSetListener temp1 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker timePicker, int i, int i1) {
                hour = i;
                minutes = i1;
                //time.setText(hour + ":" + minutes);
                settime();
            }
        };


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hour == null) {
                    DialogFragment timePicker = new TimePicker(temp1);
                    timePicker.show(requireActivity().getSupportFragmentManager(), "wtfhbfdsdfs");
                } else {
                    DialogFragment timePicker = new TimePicker(temp1, hour, minutes);
                    timePicker.show(requireActivity().getSupportFragmentManager(), "wtfhbfdsdfs");
                }
            }
        });


        builder.setTitle("Time")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TimeTemplate x = new TimeTemplate();
                        x.setHour(hour);
                        x.setMinutes(minutes);

                        //if (res.getTriggertime() != null) {
                        res.getTriggertime().add(x);
                        /*} else {
                            ArrayList<TimeTemplate> timeTemplates = new ArrayList<>();
                            timeTemplates.add(x);
                            res.setTriggertime(timeTemplates);
                        }*/
                        res.getTriggerselected().add("Time");


                        res.getTriggerupdate().setValue(!res.getTriggerupdate().getValue());

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v);

        return builder.create();
    }


    private void settime() {
        String timestring = "";

        if (hour < 10) {
            timestring += "0" + hour;
        } else {
            timestring += hour + "";
        }

        timestring += ":";


        if (minutes < 10) {
            timestring += "0" + minutes;
        } else {
            timestring += minutes + "";
        }
        time.setText(timestring);

    }


}
