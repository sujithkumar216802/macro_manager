package com.example.macromanager.actiondialoguefragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macromanager.R;
import com.example.macromanager.viewmodel;

public class Toastdialogue extends DialogFragment {


    EditText text;
    viewmodel res;
    String textt;
    Integer index;

    public Toastdialogue(String message, Integer index) {
        textt = message;
        this.index = index;
    }

    public Toastdialogue() {

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.toastdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        text = v.findViewById(R.id.clipboardtext);

        if (textt != null)
            text.setText(textt);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textt = text.getText().toString();

                if (textt.equals("")) {
                    Toast.makeText(requireContext(), "empty text", Toast.LENGTH_SHORT).show();
                } else {
                    res.getActionToast().add(textt);

                    res.getActionselected().add("Custom Toast");

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
                .setTitle("Toast");


        return builder.create();
    }


}
