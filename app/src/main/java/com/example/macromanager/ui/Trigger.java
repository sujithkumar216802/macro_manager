package com.example.macromanager.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macromanager.ClickerInterface;
import com.example.macromanager.R;
import com.example.macromanager.adapter.CreateMacroAdapter;
import com.example.macromanager.adapter.SelectedAdapter;
import com.example.macromanager.triggerdialoguefragments.Battery;
import com.example.macromanager.triggerdialoguefragments.DayoftheMonth;
import com.example.macromanager.triggerdialoguefragments.DayoftheWeek;
import com.example.macromanager.triggerdialoguefragments.Time;
import com.example.macromanager.viewmodel;

import java.util.Arrays;

public class Trigger extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    CreateMacroAdapter adapter;


    RecyclerView selectedrecyclerView;
    LinearLayoutManager selectedlayoutManager;
    SelectedAdapter selectedadapter;

    viewmodel res;

    Observer<Boolean> update;

    CardView temp;
    TextView notrigger;

    int instance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trigger, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        recyclerView = view.findViewById(R.id.recycle);
        temp = view.findViewById(R.id.temp);
        notrigger = view.findViewById(R.id.notrigger);
        temp.setCardBackgroundColor(Color.argb(255, 237, 0, 0));
        layoutManager = new LinearLayoutManager(requireContext());


        adapter = new CreateMacroAdapter(Arrays.asList(getResources().getStringArray(R.array.list_of_triggers)), new ClickerInterface() {
            @Override
            public void click(int pos, String name) {

                boolean temp = true;

                for (int i = 0; i < res.getTriggerselected().size(); i++) {
                    if (name.equals(res.getTriggerselected().get(i))) {
                        temp = false;
                        break;
                    }
                }

                switch (name) {
                    case "Battery":
                        DialogFragment battery = new Battery();
                        battery.show(requireActivity().getSupportFragmentManager(), "NoticeDialogFragment");
                        break;
                    case "Password Failed":
                        if (temp) {
                            res.getTriggerselected().add("Password Failed");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                    case "Charger Connected":
                        if (temp) {
                            res.getTriggerselected().add("Charger Connected");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                    case "Charger Disconnected":
                        if (temp) {
                            res.getTriggerselected().add("Charger Disconnected");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                    case "Screen Switched Off":
                        if (temp) {
                            res.getTriggerselected().add("Screen Switched Off");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                    case "Screen Switched On":
                        if (temp) {
                            res.getTriggerselected().add("Screen Switched On");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                    case "Time":
                        DialogFragment onlytime = new Time();
                        onlytime.show(requireActivity().getSupportFragmentManager(), "dk");
                        break;
                    case "Day Of The Week":
                        DialogFragment dayoftheweek = new DayoftheWeek();
                        dayoftheweek.show(requireActivity().getSupportFragmentManager(), "wsds");
                        break;
                    case "Day Of The Month":
                        DialogFragment dayofthemonth = new DayoftheMonth();
                        dayofthemonth.show(requireActivity().getSupportFragmentManager(), "wsds");
                        break;
                    /*case "sensor":
                        break;
                    case "new app installed":
                        break;
                    case "app deleted":
                        break;
                    case "app launched":
                        break;*/
                }

                if (res.getTriggerselected().size()>0)
                    notrigger.setVisibility(View.GONE);

            }
        }, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        selectedrecyclerView = view.findViewById(R.id.actiondisplay);
        selectedlayoutManager = new LinearLayoutManager(requireContext());


        selectedadapter = new SelectedAdapter(res.getTriggerselected(), new ClickerinterfaceSelected() {
            @Override
            public void click(int pos) {


                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getTriggerselected().get(i).equals(res.getTriggerselected().get(pos)))
                        instance++;
                }


                switch (res.getTriggerselected().get(pos)) {
                    case "Battery":
                        DialogFragment battery = new Battery(res.getTriggerbattery().get(instance), instance);
                        battery.show(requireActivity().getSupportFragmentManager(), "NoticeDialogFragment");
                        break;
                    case "Day Of The Month":
                        DialogFragment dayofthemonth = new DayoftheMonth(res.getTriggerdayofthemonth().get(instance), instance);
                        dayofthemonth.show(requireActivity().getSupportFragmentManager(), "wsds");
                        break;
                    case "Day Of The Week":
                        DialogFragment dayoftheweek = new DayoftheWeek(res.getTriggerdayoftheweek().get(instance), instance);
                        dayoftheweek.show(requireActivity().getSupportFragmentManager(), "wsds");
                        break;
                    case "Time":
                        DialogFragment onlytime = new Time(res.getTriggertime().get(instance), instance);
                        onlytime.show(requireActivity().getSupportFragmentManager(), "dk");
                        break;
                }

            }

            @Override
            public void delete(int pos) {


                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getTriggerselected().get(i).equals(res.getTriggerselected().get(pos)))
                        instance++;
                }

                switch (res.getTriggerselected().get(pos)) {
                    case "Battery":
                        res.getTriggerbattery().remove(instance);
                        break;
                    case "Day Of The Month":
                        res.getTriggerdayofthemonth().remove(instance);
                        break;
                    case "Day Of The Week":
                        res.getTriggerdayoftheweek().remove(instance);
                        break;
                    case "Time":
                        res.getTriggertime().remove(instance);
                        break;
                }

                res.getTriggerselected().remove(pos);
                selectedadapter.notifyDataSetChanged();

                if (res.getTriggerselected().size() == 0)
                    notrigger.setVisibility(View.VISIBLE);

            }
        },1);


        selectedrecyclerView.setLayoutManager(selectedlayoutManager);
        selectedrecyclerView.setAdapter(selectedadapter);


        res.getTriggerupdate().removeObservers((LifecycleOwner) requireContext());
        update = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if (res.getTriggerselected().size() != 0)
                    notrigger.setVisibility(View.GONE);
                else
                    notrigger.setVisibility(View.VISIBLE);

                if (selectedadapter != null)
                    selectedadapter.notifyDataSetChanged();
            }
        };
        res.getTriggerupdate().observe((LifecycleOwner) requireContext(), update);

    }


}