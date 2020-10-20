package com.example.macromanager.triggerdialoguefragments;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.example.macromanager.triggermodel.DayofthemonthTemplate;

import java.util.ArrayList;

public class DayoftheMonth extends DialogFragment {

    viewmodel res;
    TextView time;
    Integer hour, minutes, day, index;

    public DayoftheMonth(DayofthemonthTemplate x, Integer index) {
        this.hour = x.getHour();
        this.minutes = x.getMinute();
        this.day = x.getDay();
        this.index = index;
    }

    public DayoftheMonth() {
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View v = inflater.inflate(R.layout.dayofthemonthdialogue, null);
        Spinner spinner = v.findViewById(R.id.monthspinner);
        time = v.findViewById(R.id.time);


        if (hour != null) {
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
                settime();
            }
        };

        ArrayList<String> monthday = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            monthday.add("" + i);
        }






        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                day = i + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, monthday);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (day != null) {
            spinner.setSelection(day - 1);
        }







        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (day == null) {
                    DialogFragment timePicker = new TimePicker(temp1);
                    timePicker.show(requireActivity().getSupportFragmentManager(), "wtfhbfdsdfs");
                } else {
                    DialogFragment timePicker = new TimePicker(temp1, hour, minutes);
                    timePicker.show(requireActivity().getSupportFragmentManager(), "wtfhbfdsdfs");
                }
            }
        });


        builder.setTitle("Day of the Month")
                .setView(v)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DayofthemonthTemplate x = new DayofthemonthTemplate();
                        x.setHour(hour);
                        x.setMinute(minutes);
                        x.setDay(day);


                        res.getTriggerdayofthemonth().add(x);

                        res.getTriggerselected().add("Day Of The Month");
                        res.getTriggerupdate().setValue(!res.getTriggerupdate().getValue());

                    }
                });


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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255,97,97,97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}



