package com.example.macromanager.actiondialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;

import java.util.ArrayList;

public class Ringer extends DialogFragment {


    viewmodel res;
    Boolean vibratee;

    public Ringer(Boolean vibrate) {
        vibratee = vibrate;
    }

    public Ringer() {

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.ringerdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        RadioButton vibrate, ring;
        vibrate = v.findViewById(R.id.vibrate);
        ring = v.findViewById(R.id.ring);

        if (vibratee == null) {
            vibratee = true;
            vibrate.setChecked(true);
        } else {
            if (vibratee)
                vibrate.setChecked(true);
            else
                ring.setChecked(true);
        }


        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibratee = true;
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibratee = false;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {



                    for (int i = 0; i < res.getActionselected().size(); i++) {
                        if (res.getActionselected().get(i).equals("Vibrate/Ringer Mode")) {
                            res.getActionselected().remove(i);
                        }
                    }
                    res.getActionselected().add("Vibrate/Ringer Mode");

                res.getActionupdate().setValue(!res.getActionupdate().getValue());

                res.setActionringer(vibratee);
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Ringer");


        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255,97,97,97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
