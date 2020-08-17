package com.example.macromanager.actiondialoguefragment;

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

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;

public class Flashlight extends DialogFragment {


    /*ActionInterface actionInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ActionInterface) {
            actionInterface = (ActionInterface) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        actionInterface = null;
    }*/


    viewmodel res;
    Boolean onoroff = true;
    
    
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.onoroff, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        RadioButton on, off;
        


        on = v.findViewById(R.id.onbutton);
        off = v.findViewById(R.id.offbutton);

        on.setChecked(true);

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
            public void onClick(DialogInterface dialogInterface, int i) {
                /*actionInterface.flashlight(onoroff);*/

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Flashlight");


        return builder.create();

    }
}
