package com.example.macromanager.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.macromanager.R;
import com.example.macromanager.viewmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateMacros extends Fragment {

    viewmodel res;

    Observer<Boolean> temp;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.createmacros, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        res = new ViewModelProvider(requireActivity()).get(viewmodel.class);
        BottomNavigationView bottom = view.findViewById(R.id.navigation_drawer);

        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_action, R.id.nav_constraint, R.id.nav_action)
                .build();*/

        NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
        //NavigationUI.setupActionBarWithNavController((AppCompatActivity) requireActivity(), navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottom, navController);


        res.getTemporary().removeObservers(requireActivity());
        temp = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if (aBoolean != null) {
                    if (aBoolean)
                        Navigation.findNavController(requireView()).navigate(R.id.action_createMacros_to_nav_homePage);
                    else
                        Navigation.findNavController(requireView()).navigate(R.id.action_createMacros_to_nav_macros);
                    res.getTemporary().setValue(null);
                }
            }
        };
        res.getTemporary().observe(requireActivity(), temp);


    }

}
