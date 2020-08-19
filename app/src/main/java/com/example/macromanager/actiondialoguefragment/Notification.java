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

import com.example.macromanager.viewmodel;
import com.example.macromanager.R;
import com.example.macromanager.actionstorage.NotificationactionModel;

public class Notification extends DialogFragment {

    EditText title, message;
    String titlee;
    String messagee;
    viewmodel res;
    Integer index;


    public Notification(String title, String message, Integer index) {
        this.titlee = title;
        this.messagee = message;
        this.index = index;
    }

    public Notification() {

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.notificationdialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        title = v.findViewById(R.id.title);
        message = v.findViewById(R.id.message);


        if (titlee != null)
            title.setText(titlee);
        if (messagee != null)
            message.setText(messagee);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                titlee = title.getText().toString();
                messagee = message.getText().toString();

                if (titlee.equals("") || messagee.equals("")) {
                    Toast.makeText(requireContext(), "empty text", Toast.LENGTH_SHORT).show();
                } else {
                    NotificationactionModel x = new NotificationactionModel();
                    x.setMessage(messagee);
                    x.setTitle(titlee);

                    /*if (res.getActionnotification() != null) {

                    } else {
                        ArrayList<Notificationactiontemplate> notificationactiontemplates = new ArrayList<>();
                        notificationactiontemplates.add(x);
                        res.setActionnotification(notificationactiontemplates);
                    }*/

                    res.getActionnotification().add(x);

                    res.getActionselected().add("Custom Notification");

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
                .setTitle("Notification");


        return builder.create();
    }


}
