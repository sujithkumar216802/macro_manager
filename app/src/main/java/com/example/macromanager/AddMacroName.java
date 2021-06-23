package com.example.macromanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

public class AddMacroName extends DialogFragment {

    viewmodel res;
    String textt;
    EditText text;

    AlertDialog.Builder builder;
    AlertDialog dialog;


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
                    Toast.makeText(requireContext(), "empty text", Toast.LENGTH_SHORT).show();
                } else {
                    res.setName(textt);
                    res.setEnabled(true);
                    res.viewmodeltomacrostorage();

                    if (res.getEdit() != null && res.getEdit())
                        res.getTemporary().setValue(false);
                    else res.getTemporary().setValue(true);
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
