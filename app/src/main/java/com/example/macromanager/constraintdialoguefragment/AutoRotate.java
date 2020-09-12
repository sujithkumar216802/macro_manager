package com.example.macromanager.constraintdialoguefragment;

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

public class AutoRotate extends DialogFragment {


    viewmodel res;
    Boolean onoroff;
    RadioButton on, off;


    public AutoRotate(Boolean on) {
        onoroff = on;
    }

    public AutoRotate() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.onoroff, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        on = v.findViewById(R.id.onbutton);
        off = v.findViewById(R.id.offbutton);

        if (onoroff == null) {
            onoroff = true;
            on.setChecked(true);
        } else {
            if (onoroff) {
                on.setChecked(true);
            } else {
                off.setChecked(true);
            }
        }


        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onoroff = true;
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onoroff = false;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {




                    for (int i = 0; i < res.getConstraintselected().size(); i++) {
                        if (res.getConstraintselected().get(i).equals("Autorotate")) {
                            res.getConstraintselected().remove(i);
                        }
                    }
                    res.getConstraintselected().add("Autorotate");


                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());


                res.setConstraintautorotate(onoroff);
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("AutoRotate");


        return builder.create();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255,97,97,97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
