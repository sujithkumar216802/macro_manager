package com.example.macromanager.actiondialoguefragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.example.macromanager.actionmodels.VibrationActionModel;

public class Vibrate extends DialogFragment {


    viewmodel res;

    Integer durationn;
    Integer repeatt;
    Integer durbetrep;
    Integer index;

    SeekBar seekBar;
    EditText durationbetweenrepeat;
    EditText repeat;
    TextView duration;

    public Vibrate(Integer duration, Integer repeat, Integer delay, Integer index) {
        durationn = duration;
        repeatt = repeat;
        durbetrep = delay;
        this.index = index;
    }

    public Vibrate() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.vibratedialogue, null);
        duration = v.findViewById(R.id.durationvalue);
        seekBar = v.findViewById(R.id.duration);
        repeat = v.findViewById(R.id.repeat);
        durationbetweenrepeat = v.findViewById(R.id.durationbetweenrepeat);

        //function
        if (durationn != null) {
            duration.setText(durationn.toString());
            durationbetweenrepeat.setText(durbetrep.toString());
            repeat.setText(repeatt.toString());
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                duration.setText("" + i);
                durationn = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                duration.setText("" + seekBar.getProgress());
                durationn = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                duration.setText("" + seekBar.getProgress());
                durationn = seekBar.getProgress();
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        builder.setTitle("Vibrate")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        VibrationActionModel x = new VibrationActionModel();

                        x.setDelay(Integer.parseInt(durationbetweenrepeat.getText().toString()));
                        x.setDuration(Integer.parseInt(duration.getText().toString()));
                        x.setRepeat(Integer.parseInt(repeat.getText().toString()));


                        res.getActionvibration().add(x);

                        res.getActionselected().add("Vibrate");
                        res.getActionupdate().setValue(!res.getActionupdate().getValue());

                    }
                })
                .setView(v);


        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255, 97, 97, 97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
