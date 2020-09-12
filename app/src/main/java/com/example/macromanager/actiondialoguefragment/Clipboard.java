package com.example.macromanager.actiondialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Clipboard extends DialogFragment {


    viewmodel res;
    String textt;
    EditText text;


    public Clipboard(String text) {
        this.textt = text;
    }

    public Clipboard() {

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.clipboarddialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        text = v.findViewById(R.id.clipboardtext);

        if (textt != null) {
            text.setText(textt);
        }


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int j) {
                textt = text.getText().toString();

                if (textt.equals("")) {
                    Toast.makeText(requireContext(), "empty text", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < res.getActionselected().size(); i++) {
                        if (res.getActionselected().get(i).equals("Clipboard")) {
                            res.getActionselected().remove(i);
                        }
                    }
                    res.getActionselected().add("Clipboard");

                    res.setActionClipboard(textt);

                    res.getActionupdate().setValue(!res.getActionupdate().getValue());

                }

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setView(v)
                .setTitle("Clipboard");


        return builder.create();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255,97,97,97)));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
