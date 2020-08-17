package com.example.macromanager.constraintdialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.constraintstorage.BatteryLevelTemplate;
import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.example.macromanager.constraintstorage.BatteryTempTemplate;

import java.util.ArrayList;

public class BatteryTemp extends DialogFragment {


    viewmodel res;
    TextView tempvalue;
    RadioButton greater, less, equal;
    SeekBar temp;
    Integer tempvaluee;
    Integer selected;
    Integer index;

    public BatteryTemp(BatteryTempTemplate x, Integer index) {
        tempvaluee = x.getTemp();
        selected = x.getSelected();
        this.index = index;
    }

    public BatteryTemp() {
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.batterytempconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        greater = v.findViewById(R.id.greaterthan);
        less = v.findViewById(R.id.lessthan);
        equal = v.findViewById(R.id.equalto);
        temp = v.findViewById(R.id.temp);
        tempvalue = v.findViewById(R.id.value);

        if (tempvaluee == null) {
            tempvaluee = 30;
            selected = 1;
            greater.setChecked(true);
        } else {
            if (selected == 1) {
                greater.setChecked(true);
            } else if (selected == -1) {
                less.setChecked(true);
            } else {
                equal.setChecked(true);
            }
        }


        temp.setProgress(tempvaluee);
        tempvalue.setText(tempvaluee + "c");


        greater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = 1;
            }
        });

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = -1;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = 0;
            }
        });


        temp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tempvalue.setText(i + "c");
                tempvaluee = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tempvalue.setText(seekBar.getProgress() + "c");
                tempvaluee = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tempvalue.setText(seekBar.getProgress() + "c");
                tempvaluee = seekBar.getProgress();
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                BatteryTempTemplate x = new BatteryTempTemplate();
                x.setSelected(selected);
                x.setTemp(tempvaluee);





                //if (res.getConstraintbatterytemp() != null) {
                    res.getConstraintbatterytemp().add(x);
                /*} else {
                    ArrayList<BatteryTempTemplate> batterytemp = new ArrayList<>();
                    batterytemp.add(x);
                    res.setConstraintbatterytemp(batterytemp);
                }*/
                res.getConstraintselected().add("Battery Temp");



                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());


            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Battery Temp");


        return builder.create();
    }
}
