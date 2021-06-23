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
import com.example.macromanager.constraintdialoguefragment.AutoRotate;
import com.example.macromanager.constraintdialoguefragment.BatteryLevel;
import com.example.macromanager.constraintdialoguefragment.BatteryTemp;
import com.example.macromanager.constraintdialoguefragment.Charging;
import com.example.macromanager.constraintdialoguefragment.Headphones;
import com.example.macromanager.constraintdialoguefragment.Month;
import com.example.macromanager.constraintdialoguefragment.Monthday;
import com.example.macromanager.constraintdialoguefragment.Orientation;
import com.example.macromanager.constraintdialoguefragment.ScreenState;
import com.example.macromanager.constraintdialoguefragment.Weekday;
import com.example.macromanager.viewmodel;

import java.util.Arrays;

public class Constraint extends Fragment {
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
        return inflater.inflate(R.layout.constraint, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        recyclerView = view.findViewById(R.id.recycle);
        temp = view.findViewById(R.id.temp);
        notrigger = view.findViewById(R.id.notrigger);
        temp.setCardBackgroundColor(Color.argb(255, 0, 180, 0));
        layoutManager = new LinearLayoutManager(requireContext());

        adapter = new CreateMacroAdapter(Arrays.asList(getResources().getStringArray(R.array.list_of_constraints)), new ClickerInterface() {
            @Override
            public void click(int pos, String name) {


                switch (name) {
                    case "Battery Level":
                        DialogFragment batterylevel = new BatteryLevel();
                        batterylevel.show(requireActivity().getSupportFragmentManager(), "constraint_batterylevel");
                        break;
                    case "Charging State":
                        DialogFragment charging = new Charging();
                        charging.show(requireActivity().getSupportFragmentManager(), "constraint_charging");
                        break;
                    case "Battery Temp":
                        DialogFragment batterytemp = new BatteryTemp();
                        batterytemp.show(requireActivity().getSupportFragmentManager(), "constraint_batterytemp");
                        break;
                    case "Month":
                        DialogFragment month = new Month();
                        month.show(requireActivity().getSupportFragmentManager(), "constraint_month");
                        break;
                    case "Month Day":
                        DialogFragment monthday = new Monthday();
                        monthday.show(requireActivity().getSupportFragmentManager(), "constraint_monthday");
                        break;
                    case "Day Of The Week":
                        DialogFragment weekday = new Weekday();
                        weekday.show(requireActivity().getSupportFragmentManager(), "constraint_weekdday");
                        break;
                    case "Autorotate":
                        DialogFragment autorotate = new AutoRotate();
                        autorotate.show(requireActivity().getSupportFragmentManager(), "constraint_autorotate");
                        break;
                    case "Headphones":
                        DialogFragment headphones = new Headphones();
                        headphones.show(requireActivity().getSupportFragmentManager(), "constraint_headphone");
                        break;
                    case "Screen State":
                        DialogFragment screenstate = new ScreenState();
                        screenstate.show(requireActivity().getSupportFragmentManager(), "constraint_screenstate");
                        break;
                    case "Orientation":
                        DialogFragment orientation = new Orientation();
                        orientation.show(requireActivity().getSupportFragmentManager(), "constraint_orientation");
                        break;
                }

                if (res.getConstraintselected().size()>0)
                    notrigger.setVisibility(View.GONE);

            }
        },2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        selectedrecyclerView = view.findViewById(R.id.actiondisplay);
        selectedlayoutManager = new LinearLayoutManager(requireContext());

        selectedadapter = new SelectedAdapter(res.getConstraintselected(), new ClickerinterfaceSelected() {
            @Override
            public void click(int pos) {

                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getConstraintselected().get(i).equals(res.getConstraintselected().get(pos)))
                        instance++;
                }

                switch (res.getConstraintselected().get(pos)) {
                    case "Autorotate":
                        DialogFragment autorotate = new AutoRotate(res.getConstraintautorotate());
                        autorotate.show(requireActivity().getSupportFragmentManager(), "constraint_autorotate");
                        break;
                    case "Charging State":
                        DialogFragment charging = new Charging(res.getConstraintcharging());
                        charging.show(requireActivity().getSupportFragmentManager(), "constraint_charging");
                        break;
                    case "Headphones":
                        DialogFragment headphones = new Headphones(res.getConstraintheadphones());
                        headphones.show(requireActivity().getSupportFragmentManager(), "constraint_headphone");
                        break;
                    case "Orientation":
                        DialogFragment orientation = new Orientation(res.getConstraintorientation());
                        orientation.show(requireActivity().getSupportFragmentManager(), "constraint_orientation");
                        break;
                    case "Screen State":
                        DialogFragment screenstate = new ScreenState(res.getConstraintscreenstate());
                        screenstate.show(requireActivity().getSupportFragmentManager(), "constraint_screenstate");
                        break;
                    case "Battery Level":
                        DialogFragment batterylevel = new BatteryLevel(res.getConstraintbatterylevel().get(instance), instance);
                        batterylevel.show(requireActivity().getSupportFragmentManager(), "constraint_batterylevel");
                        break;
                    case "Battery Temp":
                        DialogFragment batterytemp = new BatteryTemp(res.getConstraintbatterytemp().get(instance), instance);
                        batterytemp.show(requireActivity().getSupportFragmentManager(), "constraint_batterytemp");
                        break;
                    case "Month":
                        DialogFragment month = new Month(res.getConstraintmonth());
                        month.show(requireActivity().getSupportFragmentManager(), "constraint month");
                        break;
                    case "Month Day":
                        DialogFragment monthday = new Monthday(res.getConstraintmonthday());
                        monthday.show(requireActivity().getSupportFragmentManager(), "constraint_monthday");
                        break;
                    case "Day Of The Week":
                        DialogFragment weekday = new Weekday(res.getConstraintweekday());
                        weekday.show(requireActivity().getSupportFragmentManager(), "constraint_weekdday");
                        break;

                }

            }

            @Override
            public void delete(int pos) {


                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getConstraintselected().get(i).equals(res.getConstraintselected().get(pos)))
                        instance++;
                }


                switch (res.getConstraintselected().get(pos)) {
                    case "Autorotate":
                        res.setConstraintautorotate(null);
                        break;
                    case "Charging State":
                        res.setConstraintcharging(null);
                        break;
                    case "Headphones":
                        res.setConstraintheadphones(null);
                        break;
                    case "Orientation":
                        res.setConstraintorientation(null);
                        break;
                    case "Screen State":
                        res.setConstraintscreenstate(null);
                        break;
                    case "Battery Level":
                        res.getConstraintbatterylevel().remove(instance);
                        break;
                    case "Battery Temp":
                        res.getConstraintbatterytemp().remove(instance);
                        break;
                    case "Month":
                        res.setConstraintmonth(null);
                        break;
                    case "Day Of The Week":
                        res.setConstraintweekday(null);
                        break;
                    case "Month Day":
                        res.setConstraintmonthday(null);
                        break;

                }
                res.getConstraintselected().remove(pos);
                selectedadapter.notifyDataSetChanged();
                if (res.getConstraintselected().size() == 0)
                    notrigger.setVisibility(View.VISIBLE);
            }
        },2);

        selectedrecyclerView.setLayoutManager(selectedlayoutManager);
        selectedrecyclerView.setAdapter(selectedadapter);


        res.getConstraintupdate().removeObservers((LifecycleOwner) requireContext());
        update = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (selectedadapter != null)
                    selectedadapter.notifyDataSetChanged();

                if (res.getConstraintselected().size() != 0)
                    notrigger.setVisibility(View.GONE);
                else
                    notrigger.setVisibility(View.VISIBLE);
            }
        };
        res.getConstraintupdate().observe((LifecycleOwner) requireContext(), update);


    }

}
