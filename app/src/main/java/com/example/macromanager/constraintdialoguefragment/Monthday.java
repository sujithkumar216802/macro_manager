package com.example.macromanager.constraintdialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.R;
import com.example.macromanager.viewmodel;

import java.util.ArrayList;

public class Monthday extends DialogFragment {

    CharSequence[] day = new CharSequence[31];
    boolean[] monthdaylist = new boolean[31];
    ArrayList<Boolean> temp = new ArrayList<>();
    viewmodel res;

    public Monthday(ArrayList<Boolean> monthdaylist) {
        temp = monthdaylist;
        for (int i = 0; i < 31; i++) {
            this.monthdaylist[i] = monthdaylist.get(i);
        }
    }

    public Monthday() {
        for (int i = 0; i < 31; i++) {
            monthdaylist[i] = false;
            temp.add(false);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        for (int i = 1; i <= 31; i++) {
            day[i - 1] = "" + i;
        }

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setTitle("Month Day")
                .setMultiChoiceItems(day, monthdaylist, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        temp.set(i, b);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {


                        for (int i = 0; i < res.getConstraintselected().size(); i++) {
                            if (res.getConstraintselected().get(i).equals("Month Day")) {
                                res.getConstraintselected().remove(i);
                            }
                        }
                        res.getConstraintselected().add("Month Day");


                        res.setConstraintmonthday(temp);



                        res.getConstraintupdate().setValue(!res.getConstraintupdate().getValue());
                    }
                });


        return builder.create();
    }
}
