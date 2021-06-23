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

public class Orientation extends DialogFragment {

    viewmodel res;
    RadioButton portrait, landscape;
    Boolean portraitt;

    public Orientation() {
    }

    public Orientation(Boolean portraitt) {
        this.portraitt = portraitt;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.orientationconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        portrait = v.findViewById(R.id.portrait);
        landscape = v.findViewById(R.id.landscappe);


        if (portraitt == null) {
            portraitt = true;
            portrait.setChecked(true);
        } else {
            if (portraitt) {
                portrait.setChecked(true);
            } else {
                landscape.setChecked(true);
            }
        }

        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portraitt = true;
            }
        });

        landscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portraitt = false;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {

                for (int i = 0; i < res.getConstraintselected().size(); i++) {
                    if (res.getConstraintselected().get(i).equals("Orientation")) {
                        res.getConstraintselected().remove(i);
                    }
                }
                res.getConstraintselected().add("Orientation");

                res.setConstraintorientation(portraitt);

                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Orientation");


        return builder.create();
    }


}
