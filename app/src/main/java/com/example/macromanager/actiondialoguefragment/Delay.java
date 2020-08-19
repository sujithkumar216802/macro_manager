package com.example.macromanager.actiondialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.R;
import com.example.macromanager.actionstorage.DelayactionModel;
import com.example.macromanager.viewmodel;

import java.util.ArrayList;

public class Delay extends DialogFragment {

    Integer hr, min, sec;
    viewmodel res;
    Spinner hour, minute, second;
    ArrayList<String> hourlist = new ArrayList<>();
    ArrayList<String> minuteandsecondlist = new ArrayList<>();

    public Delay() {

    }

    public Delay(DelayactionModel x) {
        hr = x.getHour();
        min = x.getMinutes();
        sec = x.getSeconds();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.delaydialogue, null);
        hour = v.findViewById(R.id.hours);
        minute = v.findViewById(R.id.minutes);
        second = v.findViewById(R.id.seconds);

        for (int i = 0; i < 10; i++) {
            hourlist.add("0" + i);
            minuteandsecondlist.add("0" + i);
        }

        for (int i = 10; i < 24; i++)
            hourlist.add("" + i);

        for (int i = 10; i <= 59; i++)
            minuteandsecondlist.add("" + i);

        ArrayAdapter<String> secondandminuteadapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, minuteandsecondlist);
        ArrayAdapter<String> houradapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, hourlist);

        secondandminuteadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        houradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        hour.setAdapter(houradapter);
        minute.setAdapter(secondandminuteadapter);
        second.setAdapter(secondandminuteadapter);

        hour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        if (hr != null) {
            hour.setSelection(hr);
            minute.setSelection(min);
            second.setSelection(sec);
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setTitle("Delay")
                .setView(v)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DelayactionModel x = new DelayactionModel();
                        x.setHour(hour.getSelectedItemPosition());
                        x.setMinutes(minute.getSelectedItemPosition());
                        x.setSeconds(second.getSelectedItemPosition());
                        int milisecond = second.getSelectedItemPosition() * 1000 + minute.getSelectedItemPosition() * 60000 + hour.getSelectedItemPosition() * 3600000;
                        x.setMiliseconds(milisecond);

                        res.getActiondelay().add(x);
                        res.getActionselected().add("Delay");
                        res.getActionupdate().setValue(!res.getActionupdate().getValue());
                    }
                });

        return builder.create();

    }
}
