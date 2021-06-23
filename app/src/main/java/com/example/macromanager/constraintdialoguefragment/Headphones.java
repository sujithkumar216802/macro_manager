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

public class Headphones extends DialogFragment {


    viewmodel res;
    RadioButton connected, disconnected;
    Boolean isconnected;

    public Headphones() {
    }

    public Headphones(Boolean isconnected) {
        this.isconnected = isconnected;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.headphonesconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        connected = v.findViewById(R.id.connected);
        disconnected = v.findViewById(R.id.disconnected);

        if (isconnected == null) {
            isconnected = true;
            connected.setChecked(true);
        } else {
            if (isconnected) {
                connected.setChecked(true);
            } else {
                disconnected.setChecked(true);
            }
        }

        connected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isconnected = true;
            }
        });

        disconnected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isconnected = false;
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {
                for (int i = 0; i < res.getConstraintselected().size(); i++) {
                    if (res.getConstraintselected().get(i).equals("Headphones")) {
                        res.getConstraintselected().remove(i);
                    }
                }
                res.getConstraintselected().add("Headphones");

                res.setConstraintheadphones(isconnected);
                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Headphones");


        return builder.create();
    }


}
