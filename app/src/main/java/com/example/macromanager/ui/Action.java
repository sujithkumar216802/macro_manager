package com.example.macromanager.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macromanager.AddMacroName;
import com.example.macromanager.ClickerInterface;
import com.example.macromanager.R;
import com.example.macromanager.actiondialoguefragment.Clipboard;
import com.example.macromanager.actiondialoguefragment.Flashlight;
import com.example.macromanager.actiondialoguefragment.Notification;
import com.example.macromanager.actiondialoguefragment.Ringer;
import com.example.macromanager.actiondialoguefragment.Toastdialogue;
import com.example.macromanager.actiondialoguefragment.Vibrate;
import com.example.macromanager.actiondialoguefragment.Volume;
import com.example.macromanager.actionstorage.Notificationactiontemplate;
import com.example.macromanager.actionstorage.VibrationActionTemplate;
import com.example.macromanager.actionstorage.VolumeActionTemplate;
import com.example.macromanager.adapter.CreateMacroAdapter;
import com.example.macromanager.adapter.SelectedAdapter;
import com.example.macromanager.ui.ClickerinterfaceSelected;
import com.example.macromanager.viewmodel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class Action extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    CreateMacroAdapter adapter;

    FloatingActionButton fab;

    RecyclerView selectedrecyclerView;
    LinearLayoutManager selectedlayoutManager;
    SelectedAdapter selectedadapter;
    //ArrayList<String> res.getActionselected().getValue() = new ArrayList<>();

    viewmodel res;

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
        layoutManager = new LinearLayoutManager(requireContext());

        ////////
/*
        if (res.getEdit()!=null &&res.getEdit() ) {
            res.getActionselected().getValue() = res.getActionselected();
        }*/


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
                    case "ringtonwerje":
                        break;
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
                    case "Flashlight ..... scratch it .. camera permission..":
                        DialogFragment flashlight = new Flashlight();
                        flashlight.show(requireActivity().getSupportFragmentManager(), "action_flashligght");
                        break;
                    /*case "screen(on/off) fk":
                        DialogFragment screen = new Screen();
                        screen.show(requireActivity().getSupportFragmentManager(), "action_screen");
                        break;
                    case "soft keyboard   fk":
                        DialogFragment keyboard = new Keyboard();
                        keyboard.show(requireActivity().getSupportFragmentManager(), "action_keyboard");
                        break;*/
                    case "Custom Notification":
                        DialogFragment notification = new Notification();
                        notification.show(requireActivity().getSupportFragmentManager(), "action_notification");
                        break;
                    case "Custom Toast":
                        DialogFragment toast = new Toastdialogue();
                        toast.show(requireActivity().getSupportFragmentManager(), "action_toast");
                        break;

                }


                //res.setActionselected(res.getActionselected());

            }
        });
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

                //res.setActionselected(res.getActionselected());
            }

            @Override
            public void delete(int pos) {


                instance = -1;
                for (int i = 0; i <= pos; i++) {
                    if (res.getActionselected().get(i).equals(res.getActionselected().get(pos)))
                        instance++;
                }

                switch (res.getActionselected().get(pos)) {
                    case "Clipboard":
                        res.getActionselected().remove(pos);
                        res.setActionClipboard(null);
                        break;
                    case "Custom Notification":
                        res.getActionselected().remove(pos);
                        //ArrayList<Notificationactiontemplate> y = new ArrayList<>(res.getActionnotification());
                        res.getActionnotification().remove(instance);
                        //res.getActionnotification().setValue(y);
                        break;
                    case "Vibrate/Ringer Mode":
                        res.getActionselected().remove(pos);
                        res.setActionringer(null);
                        break;
                    case "Custom Toast":
                        res.getActionselected().remove(pos);
                        //ArrayList<String> yy = new ArrayList<>(res.getActionToast());
                        res.getActionToast().remove(instance);
                        //res.getActionToast().setValue(yy);
                        break;
                    case "Vibrate":
                        res.getActionselected().remove(pos);
                        //ArrayList<VibrationActionTemplate> yyy = new ArrayList<>(res.getActionvibration());
                        res.getActionvibration().remove(instance);
                        //res.getActionvibration().setValue(yyy);
                        break;
                    case "Volume":
                        res.getActionselected().remove(pos);
                        res.setActionvolume(null);
                        break;
                }

                //res.setActionselected(res.getTriggerselected());
            }
        });

        selectedrecyclerView.setLayoutManager(selectedlayoutManager);
        selectedrecyclerView.setAdapter(selectedadapter);


      /*  res.getName().removeObservers(requireActivity());
        nameobserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s!=null && s.equals("")) {
                    //toast or something
                } else {
                    //add and get out after changing edit and studd
                    res.setEnabled(true);
                    res.viewmodeltomacrostorage();
                    //////////////////////Navigation.findNavController(view).popBackStack();
                    Navigation.findNavController(view).navigate(R.id.action_nav_action_to_mainActivity);
                }
            }
        };
        res.getName().observe(requireActivity(), nameobserver);

*/









/*

        res.getActionselected().removeObservers(requireActivity());
        selectednames = new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                selectedadapter.change(res.getActionselected().getValue());
            }
        };
        res.getActionselected().observe(requireActivity(),selectednames);



*/


res.getActionupdate().removeObservers(requireActivity());
update = new Observer<Boolean>() {
    @Override
    public void onChanged(Boolean aBoolean) {
        if(selectedadapter!=null)
            selectedadapter.notifyDataSetChanged();
    }
};
res.getActionupdate().observe(requireActivity(),update);



    }

}
