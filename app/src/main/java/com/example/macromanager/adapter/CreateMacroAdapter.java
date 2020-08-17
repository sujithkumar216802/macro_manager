package com.example.macromanager.adapter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macromanager.ClickerInterface;
import com.example.macromanager.R;

import java.util.ArrayList;
import java.util.List;

public class CreateMacroAdapter extends RecyclerView.Adapter<CreateMacroAdapter.viewholder> {

    List<String> list;
    ClickerInterface clickerInterface;


    public CreateMacroAdapter(List<String> x, ClickerInterface y) {
        list = new ArrayList<>(x);
        clickerInterface = y;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.createmacrotemplate, parent, false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {

        holder.name.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickerInterface.click(position, list.get(position));
            }
        });


        switch (list.get(position)) {
            case "Battery":
            case "Battery Level":
                holder.logo.setImageResource(R.drawable.ic_baseline_battery_full_24);
                break;
            case "Clipboard":
                holder.logo.setImageResource(R.drawable.ic_baseline_file_copy_24);
                break;
            case "Charger Connected":
                holder.logo.setImageResource(R.drawable.ic_baseline_power_24);
                break;
            case "Charger Disconnected":
                holder.logo.setImageResource(R.drawable.ic_baseline_power_off_24);
                break;
            case "Time":
                holder.logo.setImageResource(R.drawable.ic_baseline_access_time_24);
                break;
            case "Volume":
                holder.logo.setImageResource(R.drawable.ic_baseline_volume_up_24);
                break;
            case "Custom Toast":
            case "Custom Notification":
                holder.logo.setImageResource(R.drawable.ic_baseline_subtitles_24);
                break;
            case "Orientation":
                holder.logo.setImageResource(R.drawable.ic_baseline_screen_rotation_24);
                break;
            case "Autorotate":
                holder.logo.setImageResource(R.drawable.ic_baseline_autorenew_24);
                break;
            case "Charging State":
                holder.logo.setImageResource(R.drawable.ic_baseline_battery_charging_full_24);
                break;
            case "Launch Homescreen":
                holder.logo.setImageResource(R.drawable.ic_baseline_home_24);
                break;
            case "Vibrate/Ringer Mode":
                holder.logo.setImageResource(R.drawable.ic_baseline_notifications_active_24);
                break;
            case "Headphones":
                holder.logo.setImageResource(R.drawable.ic_baseline_headset_24);
                break;
            case "Vibrate":
                holder.logo.setImageResource(R.drawable.ic_baseline_vibration_24);
                break;
            case "Day Of The Week":
            case "Month Day":
            case "Day Of The Month":
                holder.logo.setImageResource(R.drawable.ic_baseline_today_24);
                break;
            case "Month":
                holder.logo.setImageResource(R.drawable.ic_baseline_date_range_24);
                break;
            case "Screen State":
            case "Screen Switched Off":
            case "Screen Switched On":
                holder.logo.setImageResource(R.drawable.ic_baseline_smartphone_24);
                break;
            case "Battery Temp":
                holder.logo.setImageResource(R.drawable.ic_baseline_ac_unit_24);
                break;
            default:holder.logo.setImageResource(R.drawable.ic_baseline_close_24);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView logo;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            logo = itemView.findViewById(R.id.logo);
        }
    }

}
