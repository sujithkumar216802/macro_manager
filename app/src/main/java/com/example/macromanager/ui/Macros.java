package com.example.macromanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macromanager.ClickerInterface;
import com.example.macromanager.R;
import com.example.macromanager.adapter.ShowMacroAdapter;
import com.example.macromanager.macrostorage.MacroStorage;
import com.example.macromanager.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Macros extends Fragment {

    RecyclerView recyclerview;
    LinearLayoutManager layoutManager;
    ShowMacroAdapter adapter;
    viewmodel res;
    ArrayList<MacroStorage> macroStorageArrayList;
    TextView noMacros;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.macros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        res.clear();
        recyclerview = view.findViewById(R.id.recycler);
        noMacros = view.findViewById(R.id.nomacros);
        layoutManager = new LinearLayoutManager(requireContext());
        adapter = new ShowMacroAdapter(new ArrayList<MacroStorage>(), new ClickerInterface() {
            @Override
            public void click(int pos, String name) {
                res.setEdit(true);
                res.setCurrentmacro(macroStorageArrayList.get(pos));
                res.startedit();
                Navigation.findNavController(view).navigate(R.id.action_nav_macros_to_createMacros);
//edit
            }
        }, new ClickerInterface() {
            @Override
            public void click(int pos, String name) {
                res.updatemacro(macroStorageArrayList.get(pos));
                //enable/disable
            }
        }, new ClickerInterface() {
            @Override
            public void click(int pos, String name) {
                ///delete
                res.deletemacro(macroStorageArrayList.get(pos));
                if (macroStorageArrayList.size() == 1) {
                    noMacros.setVisibility(View.VISIBLE);
                }
            }
        });

        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);
        res.getallmacros().removeObservers((LifecycleOwner) requireContext());
        res.getallmacros().observe((LifecycleOwner) requireContext(), new Observer<List<MacroStorage>>() {
            @Override
            public void onChanged(List<MacroStorage> macroStorages) {
                macroStorageArrayList = new ArrayList<>(macroStorages);
                //address is sent...
                adapter.change(macroStorageArrayList);
                adapter.notifyDataSetChanged();
                if (macroStorageArrayList.size() == 0) {
                    noMacros.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}
