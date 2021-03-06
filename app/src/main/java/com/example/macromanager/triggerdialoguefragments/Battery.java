package com.example.macromanager.triggerdialoguefragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.R;
import com.example.macromanager.viewmodel;

public class Battery extends DialogFragment {

    viewmodel res;
    SeekBar bar;
    TextView value;
    Integer percentage, index;


    public Battery(Integer percentage, Integer index) {
        this.percentage = percentage;
        this.index = index;
    }

    public Battery() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.batterydialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        bar = v.findViewById(R.id.batteryseek);
        value = v.findViewById(R.id.value);


        if (percentage == null) {
            percentage = 0;
        }
        value.setText(percentage + "%");
        bar.setProgress(percentage);


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                value.setText(i + "%");
                percentage = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                value.setText(seekBar.getProgress() + "%");
                percentage = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                value.setText(seekBar.getProgress() + "%");
                percentage = seekBar.getProgress();
            }
        });


        builder.setTitle("Battery")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        res.getTriggerbattery().add(bar.getProgress());

                        res.getTriggerselected().add("Battery");

                        res.getTriggerupdate().setValue(!res.getTriggerupdate().getValue());


                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v);

        return builder.create();
    }


}
