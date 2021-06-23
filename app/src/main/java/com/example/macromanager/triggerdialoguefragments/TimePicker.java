package com.example.macromanager.triggerdialoguefragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePicker extends DialogFragment {

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


}
