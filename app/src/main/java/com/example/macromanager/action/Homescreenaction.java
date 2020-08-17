package com.example.macromanager.action;

import android.content.Context;
import android.content.Intent;

public class Homescreenaction {

    public void launch(Context context) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
    }

}
