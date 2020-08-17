package com.example.macromanager.constraintdialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Weekday extends DialogFragment {

    CheckBox mon, tue, wed, thu, fri, sat, sun;

    Boolean[] weekday = {false, false, false, false, false, false, false};

    viewmodel res;

    public Weekday(ArrayList<Boolean> value) {
        weekday = value.toArray(weekday);
    }

    public Weekday() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.weekdayconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        mon = v.findViewById(R.id.mon);
        tue = v.findViewById(R.id.tue);
        wed = v.findViewById(R.id.wed);
        thu = v.findViewById(R.id.thu);
        fri = v.findViewById(R.id.fri);
        sat = v.findViewById(R.id.sat);
        sun = v.findViewById(R.id.sun);

        mon.setChecked(weekday[0]);
        tue.setChecked(weekday[1]);
        wed.setChecked(weekday[2]);
        thu.setChecked(weekday[3]);
        fri.setChecked(weekday[4]);
        sat.setChecked(weekday[5]);
        sun.setChecked(weekday[6]);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {


                weekday[0] = mon.isChecked();
                weekday[1] = tue.isChecked();
                weekday[2] = wed.isChecked();
                weekday[3] = thu.isChecked();
                weekday[4] = fri.isChecked();
                weekday[5] = sat.isChecked();
                weekday[6] = sun.isChecked();


                ArrayList<Boolean> y = new ArrayList<>();
                y.addAll(Arrays.asList(weekday));




                for (int i = 0; i < res.getConstraintselected().size(); i++) {
                    if (res.getConstraintselected().get(i).equals("Day Of The Week")) {
                        res.getConstraintselected().remove(i);
                    }
                }
                res.getConstraintselected().add("Day Of The Week");



                res.setConstraintweekday(y);



                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Weekday");


        return builder.create();
    }
}
