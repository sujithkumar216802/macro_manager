package com.example.macromanager.action;

import android.content.Context;
import android.widget.Toast;

public class Toastaction {

    public void toast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
