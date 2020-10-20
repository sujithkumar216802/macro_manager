package com.example.macromanager.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macromanager.ClickerInterface;
import com.example.macromanager.R;
import com.example.macromanager.macrostorage.MacroStorage;
import com.google.android.material.switchmaterial.SwitchMaterial;


import java.util.ArrayList;

public class ShowMacroAdapter extends RecyclerView.Adapter<ShowMacroAdapter.viewholder> {


    ClickerInterface editt, enabledisable, delete;
    ArrayList<MacroStorage> macroStorageArrayList;

    public ShowMacroAdapter(ArrayList<MacroStorage> macroStorageArrayList, ClickerInterface editt, ClickerInterface enabledisable, ClickerInterface delete) {
        this.macroStorageArrayList = macroStorageArrayList;
        this.editt = editt;
        this.enabledisable = enabledisable;
        this.delete = delete;
    }

    public void change(ArrayList<MacroStorage> macroStorageArrayList) {
        this.macroStorageArrayList = macroStorageArrayList;
        Log.i("fml", "fml");
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.showmacrotemplate, parent, false);
        x.setBackgroundColor(Color.argb(100,142,142,142));
        return new viewholder(x);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {
        holder.name.setText(macroStorageArrayList.get(position).getName());
        holder.enabled.setChecked(macroStorageArrayList.get(position).getEnabled());
        holder.enabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                macroStorageArrayList.get(position).setEnabled(b);
                enabledisable.click(position, macroStorageArrayList.get(position).getName());
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editt.click(position, macroStorageArrayList.get(position).getName());
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete.click(position, macroStorageArrayList.get(position).getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return macroStorageArrayList.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        SwitchMaterial enabled;
        ImageView edit, delete;
        TextView name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            delete = itemView.findViewById(R.id.delete);
            enabled = itemView.findViewById(R.id.switchMaterial);
            name = itemView.findViewById(R.id.name);
            edit = itemView.findViewById(R.id.edit);
        }
    }

}
