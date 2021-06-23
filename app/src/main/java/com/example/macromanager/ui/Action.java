package com.example.macromanager.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macromanager.ClickerInterface;
import com.example.macromanager.R;
import com.example.macromanager.actiondialoguefragment.Clipboard;
import com.example.macromanager.actiondialoguefragment.Delay;
import com.example.macromanager.actiondialoguefragment.Notification;
import com.example.macromanager.actiondialoguefragment.Ringer;
import com.example.macromanager.actiondialoguefragment.Toastdialogue;
import com.example.macromanager.actiondialoguefragment.Vibrate;
import com.example.macromanager.actiondialoguefragment.Volume;
import com.example.macromanager.adapter.CreateMacroAdapter;
import com.example.macromanager.adapter.SelectedAdapter;
import com.example.macromanager.viewmodel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

public class Action extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    CreateMacroAdapter adapter;

    FloatingActionButton fab;

    RecyclerView selectedrecyclerView;
    LinearLayoutManager selectedlayoutManager;
    SelectedAdapter selectedadapter;

    viewmodel res;

    CardView temp;
    TextView notrigger;

    int instance;

    Observer<Boolean> update;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.action, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        recyclerView = view.findViewById(R.id.recycle);
        temp = view.findViewById(R.id.temp);
        notrigger = view.findViewById(R.id.notrigger);
        temp.setCardBackgroundColor(Color.argb(255, 0, 0, 237));
        layoutManager = new LinearLayoutManager(requireContext());


        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (res.getActionselected().size() == 0 || res.getActionselected().size() == 0) {
                    Toast.makeText(requireContext(), "0 Trigger/Action", Toast.LENGTH_LONG).show();
                } else {

                    Navigation.findNavController(requireView()).navigate(R.id.action_nav_action_to_addMacroName);

                }
            }
        });

        adapter = new CreateMacroAdapter(Arrays.asList(getResources().getStringArray(R.array.list_of_actions)), new ClickerInterface() {
            @Override
            public void click(int pos, String name) {

                boolean temp = true;

                for (int i = 0; i < res.getActionselected().size(); i++) {
                    if (name.equals(res.getActionselected().get(i))) {
                        temp = false;
                        break;
                    }
                }

                switch (name) {
                    case "Delay":
                        DialogFragment delay = new Delay();
                        delay.show(requireActivity().getSupportFragmentManager(), "action_delay");
                        break;
                    case "Vibrate":
                        DialogFragment vibrate = new Vibrate();
                        vibrate.show(requireActivity().getSupportFragmentManager(), "action_vibrate");
                        break;
                    case "Clipboard":
                        DialogFragment clipboard = new Clipboard();
                        clipboard.show(requireActivity().getSupportFragmentManager(), "action_clipboard");
                        break;
                    case "Launch Homescreen":
                        if (temp) {
                            res.getActionselected().add("Launch Homescreen");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                   /* case "ringtonwerje":
                        break;*/
                    case "Volume":
                        DialogFragment volume = new Volume();
                        volume.show(requireActivity().getSupportFragmentManager(), "action_volume");
                        break;
                    case "Vibrate/Ringer Mode":
                        DialogFragment ringer = new Ringer();
                        ringer.show(requireActivity().getSupportFragmentManager(), "action_ringer");
                        break;
                    case "kill background apps":
                        if (temp) {
                            res.getActionselected().add("kill background apps");
                            selectedadapter.notifyDataSetChanged();
                        }
                        break;
                    case "Custom Notification":
                        DialogFragment notification = new Notification();
                        notification.show(requireActivity().getSupportFragmentManager(), "action_notification");
                        break;
                    case "Custom Toast":
                        DialogFragment toast = new Toastdialogue();
                        toast.show(requireActivity().getSupportFragmentManager(), "action_toast");
                        break;

                }

                if (res.getActionselected().size()>0)
                    notrigger.setVisibility(View.GONE);


            }
        },3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        selectedrecyclerView = view.findViewById(R.id.actiondisplay);
        selectedlayoutManager = new LinearLayoutManager(requireContext());

        selectedadapter = new SelectedAdapter(res.getActionselected(), new ClickerinterfaceSelected() {
            @Override
            public void click(int pos) {

                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getActionselected().get(i).equals(res.getActionselected().get(pos)))
                        instance++;
                }

                switch (res.getActionselected().get(pos)) {
                    case "Delay":
                        DialogFragment delay = new Delay(res.getActiondelay().get(instance));
                        delay.show(requireActivity().getSupportFragmentManager(), "action_delay");
                        break;
                    case "Clipboard":
                        DialogFragment clipboard = new Clipboard(res.getActionClipboard());
                        clipboard.show(requireActivity().getSupportFragmentManager(), "action_clibbpard");
                        break;
                    case "Custom Notification":
                        DialogFragment notification = new Notification(res.getActionnotification().get(instance).getTitle(), res.getActionnotification().get(instance).getMessage(), instance);
                        notification.show(requireActivity().getSupportFragmentManager(), "action notiification");
                        break;
                    case "Vibrate/Ringer Mode":
                        DialogFragment ringer = new Ringer(res.getActionringer());
                        ringer.show(requireActivity().getSupportFragmentManager(), "action_ringer");
                        break;
                    case "Custom Toast":
                        DialogFragment toast = new Toastdialogue(res.getActionToast().get(instance), instance);
                        toast.show(requireActivity().getSupportFragmentManager(), "action toast");
                        break;
                    case "Vibrate":
                        DialogFragment vibreate = new Vibrate(res.getActionvibration().get(instance).getDuration(), res.getActionvibration().get(instance).getRepeat(), res.getActionvibration().get(instance).getDelay(), instance);
                        vibreate.show(requireActivity().getSupportFragmentManager(), "action vibrate");
                        break;
                    case "Volume":
                        DialogFragment volume = new Volume(res.getActionvolume());
                        volume.show(requireActivity().getSupportFragmentManager(), "action volume");
                        break;
                }

            }

            @Override
            public void delete(int pos) {


                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getActionselected().get(i).equals(res.getActionselected().get(pos)))
                        instance++;
                }

                switch (res.getActionselected().get(pos)) {

                    case "Delay":
                        res.getActiondelay().remove(instance);
                        break;
                    case "Clipboard":
                        res.setActionClipboard(null);
                        break;
                    case "Custom Notification":
                        res.getActionnotification().remove(instance);
                        break;
                    case "Vibrate/Ringer Mode":
                        res.setActionringer(null);
                        break;
                    case "Custom Toast":
                        res.getActionToast().remove(instance);
                        break;
                    case "Vibrate":
                        res.getActionvibration().remove(instance);
                        break;
                    case "Volume":
                        res.setActionvolume(null);
                        break;
                }
                res.getActionselected().remove(pos);
                selectedadapter.notifyDataSetChanged();
                if (res.getActionselected().size() == 0)
                    notrigger.setVisibility(View.VISIBLE);
            }
        },3);

        selectedrecyclerView.setLayoutManager(selectedlayoutManager);
        selectedrecyclerView.setAdapter(selectedadapter);


        res.getActionupdate().removeObservers((LifecycleOwner) requireContext());
        update = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (selectedadapter != null)
                    selectedadapter.notifyDataSetChanged();

                if (res.getActionselected().size() != 0)
                    notrigger.setVisibility(View.GONE);
                else
                    notrigger.setVisibility(View.VISIBLE);
            }
        };
        res.getActionupdate().observe((LifecycleOwner) requireContext(), update);


    }

}
