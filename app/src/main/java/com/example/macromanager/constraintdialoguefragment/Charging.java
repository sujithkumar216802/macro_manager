package com.example.macromanager.constraintdialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.R;
import com.example.macromanager.viewmodel;

public class Charging extends DialogFragment {


    Boolean ischarging;
    viewmodel res;
    RadioButton charging, discharging;

    public Charging(Boolean charging) {
        ischarging = charging;
    }

    public Charging() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.chargingconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        charging = v.findViewById(R.id.charging);
        discharging = v.findViewById(R.id.notcharging);

        if (ischarging == null) {
            ischarging = true;
            charging.setChecked(true);
        } else {
            if (ischarging) {
                charging.setChecked(true);
            } else {
                discharging.setChecked(true);
            }
        }

        charging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischarging = true;
            }
        });

        discharging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ischarging = false;
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {

                for (int i = 0; i < res.getConstraintselected().size(); i++) {
                    if (res.getConstraintselected().get(i).equals("Charging State")) {
                        res.getConstraintselected().remove(i);
                    }
                }
                res.getConstraintselected().add("Charging State");

                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());

                res.setConstraintcharging(ischarging);
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Charging");


        return builder.create();
    }


}
