package com.example.macromanager.constraintdialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Month extends DialogFragment {


    Boolean[] months = {false, false, false, false, false, false, false, false, false, false, false, false};
    CheckBox jan, feb, mar, apr, may, jun, jul, aug, sept, oct, nov, dec;
    viewmodel res;

    public Month(ArrayList<Boolean> constraintmonth) {
        months = constraintmonth.toArray(months);
    }

    public Month() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.monthconstraintdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        jan = v.findViewById(R.id.jan);
        feb = v.findViewById(R.id.feb);
        mar = v.findViewById(R.id.mar);
        apr = v.findViewById(R.id.apr);
        may = v.findViewById(R.id.may);
        jun = v.findViewById(R.id.jun);
        jul = v.findViewById(R.id.jul);
        aug = v.findViewById(R.id.aug);
        sept = v.findViewById(R.id.sept);
        oct = v.findViewById(R.id.oct);
        nov = v.findViewById(R.id.nov);
        dec = v.findViewById(R.id.dec);

        jan.setChecked(months[0]);
        feb.setChecked(months[1]);
        mar.setChecked(months[2]);
        apr.setChecked(months[3]);
        may.setChecked(months[4]);
        jun.setChecked(months[5]);
        jul.setChecked(months[6]);
        aug.setChecked(months[7]);
        sept.setChecked(months[8]);
        oct.setChecked(months[9]);
        nov.setChecked(months[10]);
        dec.setChecked(months[11]);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {

                months[0] = jan.isChecked();
                months[1] = feb.isChecked();
                months[2] = mar.isChecked();
                months[3] = apr.isChecked();
                months[4] = may.isChecked();
                months[5] = jun.isChecked();
                months[6] = jul.isChecked();
                months[7] = aug.isChecked();
                months[8] = sept.isChecked();
                months[9] = oct.isChecked();
                months[10] = nov.isChecked();
                months[11] = dec.isChecked();


                ArrayList<Boolean> y = new ArrayList<>();
                y.addAll(Arrays.asList(months));



                for (int i = 0; i < res.getConstraintselected().size(); i++) {
                    if (res.getConstraintselected().get(i).equals("Month")) {
                        res.getConstraintselected().remove(i);
                    }
                }
                res.getConstraintselected().add("Month");



                res.setConstraintmonth(y);


                res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Month");


        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255,97,97,97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
