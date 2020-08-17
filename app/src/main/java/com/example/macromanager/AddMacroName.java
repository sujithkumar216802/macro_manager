package com.example.macromanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

public class AddMacroName extends DialogFragment {

    viewmodel res;
    String textt;
    EditText text;

    AlertDialog.Builder builder;
    AlertDialog dialog;

    /*public AddMacroName(String name) {
        this.textt = name;
    }

    public AddMacroName() {
    }*/


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        final View v = inflater.inflate(R.layout.clipboarddialogue, null);
        builder = new AlertDialog.Builder(requireContext());
        text = v.findViewById(R.id.clipboardtext);

        if (res.getName() != null) {
            text.setText(res.getName());
        }


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                textt = text.getText().toString();
                if (textt.equals("")) {
                    //Snackbar.make(requireView(), "empty text", Snackbar.LENGTH_SHORT).show();
                } else {
                    res.setName(textt);
                    res.setEnabled(true);
                    res.viewmodeltomacrostorage();

                    if (res.getEdit() != null && res.getEdit())
                        res.getTemporary().setValue(false);
                    else res.getTemporary().setValue(true);
                    //Navigation.findNavController(vv).navigate(R.id.action_addMacroName_to_mainActivity);
                    /*Intent intent = new Intent(requireContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);*/
                }
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Name");

        dialog = builder.create();
        return dialog;
    }


    public AlertDialog getalertdialogue() {
        return dialog;
    }
}
