package com.example.macromanager.action;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;


public class Clipboardaction {


    public void clipboardedit(String text,Context context){
        ClipboardManager clipboard = (ClipboardManager)  context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("copy data",text);
        clipboard.setPrimaryClip(clip);
    }

}
