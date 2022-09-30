package com.firstapp.energyappproject.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.firstapp.energyappproject.R;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;

    // variables for elements on fragment page
    private Switch nightMode;
    public boolean nightModeEnabled = false;
    private Button appInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s){
                // set bool to true if night mode enabled, false if not
                nightModeEnabled = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
                if(nightModeEnabled){
                    // make sure the night mode switch is on if night mode is already on
                    nightMode.setChecked(true);
                }
                else{
                    // and vice versa
                    nightMode.setChecked(false);
                }
            }

        });

        // assign elements to variables via ID
        nightMode = (Switch)root.findViewById(R.id.darkTheme);
        appInfo = (Button)root.findViewById(R.id.infoButton);

        // set onclick method for dark mode switch to toggleDark()
        nightMode.setOnClickListener(v -> toggleDark());

        // similar process for info button
        appInfo.setOnClickListener(v -> openAppInfo());

        return root;
    }

    // Method to display to the user some app information and credits
    private void openAppInfo() {
        // Display a small message to the user showing information about the app and credits
        Toast.makeText(requireContext(),"Created using Android Studio 4.0, Java and XML. Created by Matthew Laws, 2021.",Toast.LENGTH_LONG).show();
    }

    // Method to toggle dark mode globally on the application
    public void toggleDark() {
        if(!nightModeEnabled){
            // if not enabled, turn on
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            // if enabled, turn off
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}