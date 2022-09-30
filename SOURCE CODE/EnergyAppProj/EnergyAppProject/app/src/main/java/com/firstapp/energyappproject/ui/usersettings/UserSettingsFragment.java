package com.firstapp.energyappproject.ui.usersettings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.firstapp.energyappproject.R;

// TEXT FILE IMPORTS
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class UserSettingsFragment extends Fragment {

    private UserSettingsViewModel dashboardViewModel;

    // initialise name TextView and an InputStream for reading from text file.
    private TextView name;
    private InputStream nameFile;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(UserSettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_usersettings, container, false);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // OPEN .TXT FILE
                try {
                    nameFile = requireContext().getAssets().open("data/userdata/name.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // GET TEXT IN .TXT FILE
                Scanner scan = new Scanner(nameFile).useDelimiter("\\A");
                String userName = scan.hasNext() ? scan.next() : "";

                // set text of the TextView to the name found in the text file
                name.setText(userName);
                // close the file
                try {
                    nameFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // set the name variable to the TextView element via ID
        name = (TextView)root.findViewById(R.id.nameTxt);

        return root;
    }
}