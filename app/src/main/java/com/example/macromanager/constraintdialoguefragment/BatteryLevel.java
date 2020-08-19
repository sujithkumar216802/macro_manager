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

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.example.macromanager.constraintstorage.BatteryLevelTemplate;

public class BatteryLevel extends DialogFragment {


    viewmodel res;
    Integer index;
    RadioButton greater, less, equal;
    SeekBar percent;
    TextView percentvalue;
    Integer selected;
    Integer percentagevaluee;


    public BatteryLevel(BatteryLevelTemplate x, Integer index) {
        selected = x.getSelected();
        percentagevaluee = x.getPercentage();
        this.index = index;
    }

    public BatteryLevel() {
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.batteryconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        percent = v.findViewById(R.id.percent);
        percentvalue = v.findViewById(R.id.value);
        greater = v.findViewById(R.id.greaterthan);
        less = v.findViewById(R.id.lessthan);
        equal = v.findViewById(R.id.equalto);

        if (selected == null) {
            selected = 1;
            percentagevaluee = 50;
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

        percent.setProgress(percentagevaluee);
        percentvalue.setText(percentagevaluee + "%");


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


        percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentagevaluee = i;
                percentvalue.setText("" + i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                percentagevaluee = seekBar.getProgress();
                percentvalue.setText("" + seekBar.getProgress() + "%");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percentagevaluee = seekBar.getProgress();
                percentvalue.setText("" + seekBar.getProgress() + "%");

            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                BatteryLevelTemplate x = new BatteryLevelTemplate();
                x.setPercentage(percentagevaluee);
                x.setSelected(selected);



                //if (res.getConstraintbatterylevel() != null) {
                    res.getConstraintbatterylevel().add(x);
                /*} else {
                    ArrayList<BatteryLevelTemplate> batterylevel = new ArrayList<>();
                    batterylevel.add(x);
                    res.setConstraintbatterylevel(batterylevel);
                }*/
                res.getConstraintselected().add("Battery Level");




                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());


            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Battery Level");


        return builder.create();
    }
}
