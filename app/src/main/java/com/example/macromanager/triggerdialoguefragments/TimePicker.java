package com.example.macromanager.triggerdialoguefragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePicker extends DialogFragment {

    TimePickerDialog time;
    TimePickerDialog.OnTimeSetListener temp;

    Integer hr, min;

    public TimePicker(TimePickerDialog.OnTimeSetListener y) {
        temp = y;
    }

    public TimePicker(TimePickerDialog.OnTimeSetListener y, Integer hour, Integer min) {
        temp = y;
        hr = hour;
        this.min = min;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (hr == null) {
            Calendar c = Calendar.getInstance();
            hr = c.get(Calendar.HOUR_OF_DAY);
            min = c.get(Calendar.MINUTE);
        }

        return new TimePickerDialog(getActivity(), temp, hr, min, true);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255,97,97,97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
