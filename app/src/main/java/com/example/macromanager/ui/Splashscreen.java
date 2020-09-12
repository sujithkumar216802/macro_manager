package com.example.macromanager.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.macromanager.R;

public class Splashscreen extends Fragment {

    ImageView logo;
    TextView text;
    Animation logoanim, textanim;
    NavController nav;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splashscreen,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logo = view.findViewById(R.id.logo);
        text = view.findViewById(R.id.name);
        logoanim = AnimationUtils.loadAnimation(requireContext(), R.anim.logo);
        textanim = AnimationUtils.loadAnimation(requireContext(), R.anim.text);
        logo.setAnimation(logoanim);
        text.setAnimation(textanim);
        nav = Navigation.findNavController(view);
        new CountDownTimer(1750, 1750) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                nav.navigate(R.id.action_splashscreen_to_nav_homePage);
            }
        }.start();

    }
}
