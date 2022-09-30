package com.firstapp.energyappproject.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.firstapp.energyappproject.ApplianceInput;
import com.firstapp.energyappproject.R;

// TEXT FILE-RELATED IMPORTS
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private Button addApplianceButton;
    private String bestTime;

    // APPLIANCE TYPES
    private TextView ap1Type, ap2Type, ap3Type, ap4Type, ap5Type, ap6Type, ap7Type, ap8Type, ap9Type, ap10Type;
    private InputStream inAp1Type, inAp2Type, inAp3Type, inAp4Type, inAp5Type, inAp6Type, inAp7Type, inAp8Type, inAp9Type, inAp10Type;

    // RESULT TEXTS
    private TextView RESULT1, RESULT2, RESULT3, RESULT4, RESULT5, RESULT6, RESULT7, RESULT8, RESULT9, RESULT10;

    // APPLIANCE BUTTONS
    private Button apButton1, apButton2, apButton3, apButton4, apButton5, apButton6, apButton7, apButton8, apButton9, apButton10;

    // TIMEFRAME ENTRY
    private EditText timeEntry1, timeEntry2, timeEntry3, timeEntry4, timeEntry5, timeEntry6, timeEntry7, timeEntry8, timeEntry9, timeEntry10;

    // HOUR ENTRY
    private EditText hourEntry1, hourEntry2, hourEntry3, hourEntry4, hourEntry5, hourEntry6, hourEntry7, hourEntry8, hourEntry9, hourEntry10;

    // INPUTSTREAMS FOR DATA FILES
    private InputStream costFile, energy1, energy2, energy3, energy4, energy5, energy6;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // OPEN .TXT FILES
                try { inAp1Type = requireContext().getAssets().open("data/appliances/1/type.txt");
                    inAp2Type = requireContext().getAssets().open("data/appliances/2/type.txt");
                    inAp3Type = requireContext().getAssets().open("data/appliances/3/type.txt");
                    inAp4Type = requireContext().getAssets().open("data/appliances/4/type.txt");
                    inAp5Type = requireContext().getAssets().open("data/appliances/5/type.txt");
                    inAp6Type = requireContext().getAssets().open("data/appliances/6/type.txt");
                    inAp7Type = requireContext().getAssets().open("data/appliances/7/type.txt");
                    inAp8Type = requireContext().getAssets().open("data/appliances/8/type.txt");
                    inAp9Type = requireContext().getAssets().open("data/appliances/9/type.txt");
                    inAp10Type = requireContext().getAssets().open("data/appliances/10/type.txt"); } catch (IOException e) { e.printStackTrace(); }

                // GET TEXT IN .TXT FILES
                Scanner scan1 = new Scanner(inAp1Type).useDelimiter("\\A");
                String ap1TypeText = scan1.hasNext() ? scan1.next() : "";
                Scanner scan2 = new Scanner(inAp2Type).useDelimiter("\\A");
                String ap2TypeText = scan2.hasNext() ? scan2.next() : "";
                Scanner scan3 = new Scanner(inAp3Type).useDelimiter("\\A");
                String ap3TypeText = scan3.hasNext() ? scan3.next() : "";
                Scanner scan4 = new Scanner(inAp4Type).useDelimiter("\\A");
                String ap4TypeText = scan4.hasNext() ? scan4.next() : "";
                Scanner scan5 = new Scanner(inAp5Type).useDelimiter("\\A");
                String ap5TypeText = scan5.hasNext() ? scan5.next() : "";
                Scanner scan6 = new Scanner(inAp6Type).useDelimiter("\\A");
                String ap6TypeText = scan6.hasNext() ? scan6.next() : "";
                Scanner scan7 = new Scanner(inAp7Type).useDelimiter("\\A");
                String ap7TypeText = scan7.hasNext() ? scan7.next() : "";
                Scanner scan8 = new Scanner(inAp8Type).useDelimiter("\\A");
                String ap8TypeText = scan8.hasNext() ? scan8.next() : "";
                Scanner scan9 = new Scanner(inAp9Type).useDelimiter("\\A");
                String ap9TypeText = scan9.hasNext() ? scan9.next() : "";
                Scanner scan10 = new Scanner(inAp10Type).useDelimiter("\\A");
                String ap10TypeText = scan10.hasNext() ? scan10.next() : "";
                // SET TEXT OF TYPES
                ap1Type.setText(ap1TypeText);
                ap2Type.setText(ap2TypeText);
                ap3Type.setText(ap3TypeText);
                ap4Type.setText(ap4TypeText);
                ap5Type.setText(ap5TypeText);
                ap6Type.setText(ap6TypeText);
                ap7Type.setText(ap7TypeText);
                ap8Type.setText(ap8TypeText);
                ap9Type.setText(ap9TypeText);
                ap10Type.setText(ap10TypeText);
                // SET TEXT OF RESULTS
                RESULT1.setText("");
                RESULT2.setText("");
                RESULT3.setText("");
                RESULT4.setText("");
                RESULT5.setText("");
                RESULT6.setText("");
                RESULT7.setText("");
                RESULT8.setText("");
                RESULT9.setText("");
                RESULT10.setText("");
            }
        });

        addApplianceButton = (Button)root.findViewById(R.id.addApplianceButton);
        addApplianceButton.setOnClickListener(v -> goToApplianceInput());

        // SETUP ID REFERENCES
        ap1Type = (TextView)root.findViewById(R.id.ap1Type);
        ap2Type = (TextView)root.findViewById(R.id.ap2Type);
        ap3Type = (TextView)root.findViewById(R.id.ap3Type);
        ap4Type = (TextView)root.findViewById(R.id.ap4Type);
        ap5Type = (TextView)root.findViewById(R.id.ap5Type);
        ap6Type = (TextView)root.findViewById(R.id.ap6Type);
        ap7Type = (TextView)root.findViewById(R.id.ap7Type);
        ap8Type = (TextView)root.findViewById(R.id.ap8Type);
        ap9Type = (TextView)root.findViewById(R.id.ap9Type);
        ap10Type = (TextView)root.findViewById(R.id.ap10Type);
        RESULT1 = (TextView)root.findViewById(R.id.RESULT1);
        RESULT2 = (TextView)root.findViewById(R.id.RESULT2);
        RESULT3 = (TextView)root.findViewById(R.id.RESULT3);
        RESULT4 = (TextView)root.findViewById(R.id.RESULT4);
        RESULT5 = (TextView)root.findViewById(R.id.RESULT5);
        RESULT6 = (TextView)root.findViewById(R.id.RESULT6);
        RESULT7 = (TextView)root.findViewById(R.id.RESULT7);
        RESULT8 = (TextView)root.findViewById(R.id.RESULT8);
        RESULT9 = (TextView)root.findViewById(R.id.RESULT9);
        RESULT10 = (TextView)root.findViewById(R.id.RESULT10);
        apButton1 = (Button)root.findViewById(R.id.ap1Button);
        apButton2 = (Button)root.findViewById(R.id.ap2Button);
        apButton3 = (Button)root.findViewById(R.id.ap3Button);
        apButton4 = (Button)root.findViewById(R.id.ap4Button);
        apButton5 = (Button)root.findViewById(R.id.ap5Button);
        apButton6 = (Button)root.findViewById(R.id.ap6Button);
        apButton7 = (Button)root.findViewById(R.id.ap7Button);
        apButton8 = (Button)root.findViewById(R.id.ap8Button);
        apButton9 = (Button)root.findViewById(R.id.ap9Button);
        apButton10 = (Button)root.findViewById(R.id.ap10Button);
        timeEntry1 = (EditText)root.findViewById(R.id.ap1TimeEntry);
        hourEntry1 = (EditText)root.findViewById(R.id.ap1HourEntry);
        timeEntry2 = (EditText)root.findViewById(R.id.ap2TimeEntry);
        hourEntry2 = (EditText)root.findViewById(R.id.ap2HourEntry);
        timeEntry3 = (EditText)root.findViewById(R.id.ap3TimeEntry);
        hourEntry3 = (EditText)root.findViewById(R.id.ap3HourEntry);
        timeEntry4 = (EditText)root.findViewById(R.id.ap4TimeEntry);
        hourEntry4 = (EditText)root.findViewById(R.id.ap4HourEntry);
        timeEntry5 = (EditText)root.findViewById(R.id.ap5TimeEntry);
        hourEntry5 = (EditText)root.findViewById(R.id.ap5HourEntry);
        timeEntry6 = (EditText)root.findViewById(R.id.ap6TimeEntry);
        hourEntry6 = (EditText)root.findViewById(R.id.ap6HourEntry);
        timeEntry7 = (EditText)root.findViewById(R.id.ap7TimeEntry);
        hourEntry7 = (EditText)root.findViewById(R.id.ap7HourEntry);
        timeEntry8 = (EditText)root.findViewById(R.id.ap8TimeEntry);
        hourEntry8 = (EditText)root.findViewById(R.id.ap8HourEntry);
        timeEntry9 = (EditText)root.findViewById(R.id.ap9TimeEntry);
        hourEntry9 = (EditText)root.findViewById(R.id.ap9HourEntry);
        timeEntry10 = (EditText)root.findViewById(R.id.ap10TimeEntry);
        hourEntry10 = (EditText)root.findViewById(R.id.ap10HourEntry);

        // SET ONCLICK METHODS FOR BUTTONS
        apButton1.setOnClickListener(v -> startAlgAp1());
        apButton2.setOnClickListener(v -> startAlgAp2());
        apButton3.setOnClickListener(v -> startAlgAp3());
        apButton4.setOnClickListener(v -> startAlgAp4());
        apButton5.setOnClickListener(v -> startAlgAp5());
        apButton6.setOnClickListener(v -> startAlgAp6());
        apButton7.setOnClickListener(v -> startAlgAp7());
        apButton8.setOnClickListener(v -> startAlgAp8());
        apButton9.setOnClickListener(v -> startAlgAp9());
        apButton10.setOnClickListener(v -> startAlgAp10());

        return root;
    }

    // Uses the energy data to calculate the best time in the user-given time frame
    // for the user to use the device, returning this to the user
    public String calculateBestTime(int type, @NotNull String timeframe, String hour) {
        String returnVal = "";

        if(timeframe.equals("1")){
                if(hour.equals("1")){
                    // open energy data files (correct appliance type according to type parameter) & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/5-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/5-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/5-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/5-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/5-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/5-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/5-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/5-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/5-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/5-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);
                    Scanner scan6 = new Scanner(energy6).useDelimiter("\\A");
                    String e6Str = scan6.hasNext() ? scan6.next() : "";
                    float e6 = Float.parseFloat(e6Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5, e6};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "0:00-1:00";
                    }
                    else if(lowest==e2){
                        bestTime = "1:00-2:00";
                    }
                    else if(lowest==e3){
                        bestTime = "2:00-3:00";
                    }
                    else if(lowest==e4){
                        bestTime = "3:00-4:00";
                    }
                    else if(lowest==e5){
                        bestTime = "4:00-5:00";
                    }
                    else if(lowest==e6){
                        bestTime = "5:00-6:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else if(hour.equals("2")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/0-6/2hr/4-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/0-6/2hr/4-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/0-6/2hr/4-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/0-6/2hr/4-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/0-6/2hr/4-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/0-6/2hr/4-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/0-6/2hr/4-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/0-6/2hr/4-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/0-6/2hr/4-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/0-6/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/0-6/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/0-6/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/0-6/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/0-6/2hr/4-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "0:00-2:00";
                    }
                    else if(lowest==e2){
                        bestTime = "1:00-3:00";
                    }
                    else if(lowest==e3){
                        bestTime = "2:00-4:00";
                    }
                    else if(lowest==e4){
                        bestTime = "3:00-5:00";
                    }
                    else if(lowest==e5){
                        bestTime = "4:00-6:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("3")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/0-6/3hr/3-6.txt");
                        }
                        else if (type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/0-6/3hr/3-6.txt");
                        }
                        else if (type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/0-6/3hr/3-6.txt");
                        }
                        else if (type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/0-6/3hr/3-6.txt");
                        }
                        else if (type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/0-6/3hr/3-6.txt");
                        }
                        else if (type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/0-6/3hr/3-6.txt");
                        }
                        else if (type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/0-6/3hr/3-6.txt");
                        }
                        else if (type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/0-6/3hr/3-6.txt");
                        }
                        else if (type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/0-6/3hr/3-6.txt");
                        }
                        else if (type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/0-6/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/0-6/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/0-6/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/0-6/3hr/3-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "0:00-3:00";
                    }
                    else if(lowest==e2){
                        bestTime = "1:00-4:00";
                    }
                    else if(lowest==e3){
                        bestTime = "2:00-5:00";
                    }
                    else if(lowest==e4){
                        bestTime = "3:00-6:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("4")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/0-6/4hr/2-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/0-6/4hr/2-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/0-6/4hr/2-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/0-6/4hr/2-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/0-6/4hr/2-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/0-6/4hr/2-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/0-6/4hr/2-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/0-6/4hr/2-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/0-6/4hr/2-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/0-6/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/0-6/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/0-6/4hr/2-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "0:00-4:00";
                    }
                    else if(lowest==e2){
                        bestTime = "1:00-5:00";
                    }
                    else if(lowest==e3){
                        bestTime = "2:00-6:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("5")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/0-6/1hr/1-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/0-6/1hr/1-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/0-6/1hr/1-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/0-6/1hr/1-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/0-6/1hr/1-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/0-6/1hr/1-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/0-6/1hr/1-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/0-6/1hr/1-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/0-6/1hr/1-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/0-6/1hr/1-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "0:00-5:00";
                    }
                    else if(lowest==e2){
                        bestTime = "1:00-6:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else{
                    if(type==1) {
                        RESULT1.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==2){
                        RESULT2.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==3){
                        RESULT3.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==4){
                        RESULT4.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==5){
                        RESULT5.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==6){
                        RESULT6.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==7){
                        RESULT7.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==8){
                        RESULT8.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==9){
                        RESULT9.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==10){
                        RESULT10.setText("You have not selected an hour.\nPlease try again.");
                    }
                    // error code
                    returnVal = "9999";
                }
            }
        else if(timeframe.equals("2")){
                if(hour.equals("1")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/5-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/5-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/5-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/5-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/5-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/5-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/5-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/5-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/5-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/5-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);
                    Scanner scan6 = new Scanner(energy6).useDelimiter("\\A");
                    String e6Str = scan6.hasNext() ? scan6.next() : "";
                    float e6 = Float.parseFloat(e6Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5, e6};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "6:00-7:00";
                    }
                    else if(lowest==e2){
                        bestTime = "7:00-8:00";
                    }
                    else if(lowest==e3){
                        bestTime = "8:00-9:00";
                    }
                    else if(lowest==e4){
                        bestTime = "9:00-10:00";
                    }
                    else if(lowest==e5){
                        bestTime = "10:00-11:00";
                    }
                    else if(lowest==e6){
                        bestTime = "11:00-12:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else if(hour.equals("2")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/6-12/2hr/4-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/6-12/2hr/4-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/6-12/2hr/4-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/6-12/2hr/4-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/6-12/2hr/4-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/6-12/2hr/4-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/6-12/2hr/4-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/6-12/2hr/4-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/6-12/2hr/4-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/6-12/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/6-12/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/6-12/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/6-12/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/6-12/2hr/4-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "6:00-8:00";
                    }
                    else if(lowest==e2){
                        bestTime = "7:00-9:00";
                    }
                    else if(lowest==e3){
                        bestTime = "8:00-10:00";
                    }
                    else if(lowest==e4){
                        bestTime = "9:00-11:00";
                    }
                    else if(lowest==e5){
                        bestTime = "10:00-12:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("3")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/6-12/3hr/3-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/6-12/3hr/3-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/6-12/3hr/3-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/6-12/3hr/3-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/6-12/3hr/3-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/6-12/3hr/3-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/6-12/3hr/3-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/6-12/3hr/3-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/6-12/3hr/3-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/6-12/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/6-12/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/6-12/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/6-12/3hr/3-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "6:00-9:00";
                    }
                    else if(lowest==e2){
                        bestTime = "7:00-10:00";
                    }
                    else if(lowest==e3){
                        bestTime = "8:00-11:00";
                    }
                    else if(lowest==e4){
                        bestTime = "9:00-12:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("4")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/6-12/4hr/2-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/6-12/4hr/2-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/6-12/4hr/2-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/6-12/4hr/2-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/6-12/4hr/2-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/6-12/4hr/2-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/6-12/4hr/2-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/6-12/4hr/2-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/6-12/4hr/2-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/6-12/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/6-12/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/6-12/4hr/2-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "6:00-10:00";
                    }
                    else if(lowest==e2){
                        bestTime = "7:00-11:00";
                    }
                    else if(lowest==e3){
                        bestTime = "8:00-12:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("5")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/6-12/1hr/1-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/6-12/1hr/1-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/6-12/1hr/1-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/6-12/1hr/1-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/6-12/1hr/1-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/6-12/1hr/1-6.txt");
                        }
                        else if(type==7) {
                            energy1 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/6-12/1hr/1-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/6-12/1hr/1-6.txt");
                        }
                        else if(type==9) {
                            energy1 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/6-12/1hr/1-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/6-12/1hr/1-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "6:00-11:00";
                    }
                    else if(lowest==e2){
                        bestTime = "7:00-12:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else{
                    if(type==1) {
                        RESULT1.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==2){
                        RESULT2.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==3){
                        RESULT3.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==4){
                        RESULT4.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==5){
                        RESULT5.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==6){
                        RESULT6.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==7){
                        RESULT7.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==8){
                        RESULT8.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==9){
                        RESULT9.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==10){
                        RESULT10.setText("You have not selected an hour.\nPlease try again.");
                    }
                    // error code
                    returnVal = "9999";
                }
            }
        else if(timeframe.equals("3")){
                if(hour.equals("1")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/5-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/5-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/5-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/5-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/5-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/5-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/5-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/5-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/5-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/5-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);
                    Scanner scan6 = new Scanner(energy6).useDelimiter("\\A");
                    String e6Str = scan6.hasNext() ? scan6.next() : "";
                    float e6 = Float.parseFloat(e6Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5, e6};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "12:00-13:00";
                    }
                    else if(lowest==e2){
                        bestTime = "13:00-14:00";
                    }
                    else if(lowest==e3){
                        bestTime = "14:00-15:00";
                    }
                    else if(lowest==e4){
                        bestTime = "15:00-16:00";
                    }
                    else if(lowest==e5){
                        bestTime = "16:00-17:00";
                    }
                    else if(lowest==e6){
                        bestTime = "17:00-18:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else if(hour.equals("2")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/12-18/2hr/4-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/12-18/2hr/4-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/12-18/2hr/4-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/12-18/2hr/4-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/12-18/2hr/4-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/12-18/2hr/4-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/12-18/2hr/4-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/12-18/2hr/4-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/12-18/2hr/4-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/12-18/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/12-18/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/12-18/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/12-18/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/12-18/2hr/4-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "12:00-14:00";
                    }
                    else if(lowest==e2){
                        bestTime = "13:00-15:00";
                    }
                    else if(lowest==e3){
                        bestTime = "14:00-16:00";
                    }
                    else if(lowest==e4){
                        bestTime = "15:00-17:00";
                    }
                    else if(lowest==e5){
                        bestTime = "16:00-18:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("3")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/12-18/3hr/3-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/12-18/3hr/3-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/12-18/3hr/3-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/12-18/3hr/3-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/12-18/3hr/3-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/12-18/3hr/3-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/12-18/3hr/3-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/12-18/3hr/3-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/12-18/3hr/3-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/12-18/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/12-18/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/12-18/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/12-18/3hr/3-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "12:00-15:00";
                    }
                    else if(lowest==e2){
                        bestTime = "13:00-16:00";
                    }
                    else if(lowest==e3){
                        bestTime = "14:00-17:00";
                    }
                    else if(lowest==e4){
                        bestTime = "15:00-18:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("4")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/12-18/4hr/2-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/12-18/4hr/2-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/12-18/4hr/2-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/12-18/4hr/2-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/12-18/4hr/2-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/12-18/4hr/2-6.txt");
                        }
                        else if(type==7) {
                            energy1 = requireContext().getAssets().open("data/energydata/7/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/12-18/4hr/2-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/12-18/4hr/2-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/12-18/4hr/2-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/12-18/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/12-18/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/12-18/4hr/2-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "12:00-16:00";
                    }
                    else if(lowest==e2){
                        bestTime = "13:00-17:00";
                    }
                    else if(lowest==e3){
                        bestTime = "14:00-18:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("5")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/12-18/1hr/1-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/12-18/1hr/1-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/12-18/1hr/1-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/12-18/1hr/1-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/12-18/1hr/1-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/12-18/1hr/1-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/12-18/1hr/1-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/12-18/1hr/1-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/12-18/1hr/1-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/12-18/1hr/1-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "12:00-17:00";
                    }
                    else if(lowest==e2){
                        bestTime = "13:00-18:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else{
                    if(type==1) {
                        RESULT1.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==2){
                        RESULT2.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==3){
                        RESULT3.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==4){
                        RESULT4.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==5){
                        RESULT5.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==6){
                        RESULT6.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==7){
                        RESULT7.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==8){
                        RESULT8.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==9){
                        RESULT9.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==10){
                        RESULT10.setText("You have not selected an hour.\nPlease try again.");
                    }
                    // error code
                    returnVal = "9999";
                }
            }
        else if(timeframe.equals("4")){
                if(hour.equals("1")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/5-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/5-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/5-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/5-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/5-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/5-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/5-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/5-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/5-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/0-1.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/1-2.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/2-3.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/3-4.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/4-5.txt");
                            energy6 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/5-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);
                    Scanner scan6 = new Scanner(energy6).useDelimiter("\\A");
                    String e6Str = scan6.hasNext() ? scan6.next() : "";
                    float e6 = Float.parseFloat(e6Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5, e6};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "18:00-19:00";
                    }
                    else if(lowest==e2){
                        bestTime = "19:00-20:00";
                    }
                    else if(lowest==e3){
                        bestTime = "20:00-21:00";
                    }
                    else if(lowest==e4){
                        bestTime = "21:00-22:00";
                    }
                    else if(lowest==e5){
                        bestTime = "22:00-23:00";
                    }
                    else if(lowest==e6){
                        bestTime = "23:00-0:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else if(hour.equals("2")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1) {
                            energy1 = requireContext().getAssets().open("data/energydata/1/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/1/18-24/2hr/4-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/2/18-24/2hr/4-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/3/18-24/2hr/4-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/4/18-24/2hr/4-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/5/18-24/2hr/4-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/6/18-24/2hr/4-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/7/18-24/2hr/4-6.txt");
                        }
                        else if(type==8) {
                            energy1 = requireContext().getAssets().open("data/energydata/8/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/8/18-24/2hr/4-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/9/18-24/2hr/4-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/18-24/2hr/0-2.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/18-24/2hr/1-3.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/18-24/2hr/2-4.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/18-24/2hr/3-5.txt");
                            energy5 = requireContext().getAssets().open("data/energydata/10/18-24/2hr/4-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);
                    Scanner scan5 = new Scanner(energy5).useDelimiter("\\A");
                    String e5Str = scan5.hasNext() ? scan5.next() : "";
                    float e5 = Float.parseFloat(e5Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4, e5};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "18:00-20:00";
                    }
                    else if(lowest==e2){
                        bestTime = "19:00-21:00";
                    }
                    else if(lowest==e3){
                        bestTime = "20:00-22:00";
                    }
                    else if(lowest==e4){
                        bestTime = "21:00-23:00";
                    }
                    else if(lowest==e5){
                        bestTime = "22:00-0:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("3")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/1/18-24/3hr/3-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/2/18-24/3hr/3-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/3/18-24/3hr/3-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/4/18-24/3hr/3-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/5/18-24/3hr/3-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/6/18-24/3hr/3-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/7/18-24/3hr/3-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/8/18-24/3hr/3-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/9/18-24/3hr/3-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/18-24/3hr/0-3.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/18-24/3hr/1-4.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/18-24/3hr/2-5.txt");
                            energy4 = requireContext().getAssets().open("data/energydata/10/18-24/3hr/3-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);
                    Scanner scan4 = new Scanner(energy4).useDelimiter("\\A");
                    String e4Str = scan4.hasNext() ? scan4.next() : "";
                    float e4 = Float.parseFloat(e4Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3, e4};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "18:00-21:00";
                    }
                    else if(lowest==e2){
                        bestTime = "19:00-22:00";
                    }
                    else if(lowest==e3){
                        bestTime = "20:00-23:00";
                    }
                    else if(lowest==e4){
                        bestTime = "21:00-0:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("4")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/1/18-24/4hr/2-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/2/18-24/4hr/2-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/3/18-24/4hr/2-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/4/18-24/4hr/2-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/5/18-24/4hr/2-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/6/18-24/4hr/2-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/7/18-24/4hr/2-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/8/18-24/4hr/2-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/9/18-24/4hr/2-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/18-24/4hr/0-4.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/18-24/4hr/1-5.txt");
                            energy3 = requireContext().getAssets().open("data/energydata/10/18-24/4hr/2-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);
                    Scanner scan3 = new Scanner(energy3).useDelimiter("\\A");
                    String e3Str = scan3.hasNext() ? scan3.next() : "";
                    float e3 = Float.parseFloat(e3Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2, e3};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "18:00-22:00";
                    }
                    else if(lowest==e2){
                        bestTime = "19:00-23:00";
                    }
                    else if(lowest==e3){
                        bestTime = "20:00-0:00";
                    }

                    returnVal = Float.toString(lowest);

                }
                else if(hour.equals("5")){
                    // open energy data files & pass into floats
                    try {
                        if(type==1){
                            energy1 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/1/18-24/1hr/1-6.txt");
                        }
                        else if(type==2){
                            energy1 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/2/18-24/1hr/1-6.txt");
                        }
                        else if(type==3){
                            energy1 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/3/18-24/1hr/1-6.txt");
                        }
                        else if(type==4){
                            energy1 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/4/18-24/1hr/1-6.txt");
                        }
                        else if(type==5){
                            energy1 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/5/18-24/1hr/1-6.txt");
                        }
                        else if(type==6){
                            energy1 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/6/18-24/1hr/1-6.txt");
                        }
                        else if(type==7){
                            energy1 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/7/18-24/1hr/1-6.txt");
                        }
                        else if(type==8){
                            energy1 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/8/18-24/1hr/1-6.txt");
                        }
                        else if(type==9){
                            energy1 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/9/18-24/1hr/1-6.txt");
                        }
                        else if(type==10){
                            energy1 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/0-5.txt");
                            energy2 = requireContext().getAssets().open("data/energydata/10/18-24/1hr/1-6.txt");
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                    Scanner scan1 = new Scanner(energy1).useDelimiter("\\A");
                    String e1Str = scan1.hasNext() ? scan1.next() : "";
                    float e1 = Float.parseFloat(e1Str);
                    Scanner scan2 = new Scanner(energy2).useDelimiter("\\A");
                    String e2Str = scan2.hasNext() ? scan2.next() : "";
                    float e2 = Float.parseFloat(e2Str);

                    // find lowest energy usage
                    float lowest = 0;
                    float[] list = new float[]{e1, e2};
                    float currentLowest = 9999;

                    for(int i=0; i<list.length; i++){
                        if(list[i]<currentLowest){
                            lowest = list[i];
                            currentLowest = list[i];
                        }
                    }

                    // return and set bestTime string
                    if(lowest==e1){
                        bestTime = "18:00-23:00";
                    }
                    else if(lowest==e2){
                        bestTime = "19:00-0:00";
                    }

                    returnVal = Float.toString(lowest);
                }
                else{
                    if(type==1) {
                        RESULT1.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==2){
                        RESULT2.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==3){
                        RESULT3.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==4){
                        RESULT4.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==5){
                        RESULT5.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==6){
                        RESULT6.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==7){
                        RESULT7.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==8){
                        RESULT8.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==9){
                        RESULT9.setText("You have not selected an hour.\nPlease try again.");
                    }
                    else if(type==10){
                        RESULT10.setText("You have not selected an hour.\nPlease try again.");
                    }
                    // error code
                    returnVal = "9999";
                }
            }
        else{
            if(type==1){
                RESULT1.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==2){
                RESULT2.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==3){
                RESULT3.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==4){
                RESULT4.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==5){
                RESULT5.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==6){
                RESULT6.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==7){
                RESULT7.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==8){
                RESULT8.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==9){
                RESULT9.setText("You have not selected a timeframe.\nPlease try again.");
            }
            else if(type==10){
                RESULT10.setText("You have not selected a timeframe.\nPlease try again.");
            }
            // error code
            returnVal = "9999";
        }

        return returnVal;
    }

    // Uses the cost data and energy data from calculateBestTime() to calculate the
    // cost per minute to use the appliance.
    public String calculateCost(float result) {
        // get cost value from text file
        try {
            costFile = requireContext().getAssets().open("data/costdata/cost-£-per-kwh.txt");
        } catch (IOException e) { e.printStackTrace(); }

        // scan and convert to float
        Scanner scan1 = new Scanner(costFile).useDelimiter("\\A");
        String costStr = scan1.hasNext() ? scan1.next() : "";
        float cost = Float.parseFloat(costStr);

        // result from energy data is in kWh, so can just multiply by cost to get the cost per hour of use
        float costPerHour = result * cost;

        // convert back to string to return
        return Float.toString(costPerHour);
    }

    // OnClick methods for each "more info" button on each appliance
    // Starts the process and calls the two methods needed to perform the algorithm.
    @SuppressLint("SetTextI18n")
    public void startAlgAp1() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry1.getText().toString();
        hr = hourEntry1.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(1, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT1.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp2() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry2.getText().toString();
        hr = hourEntry2.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(2, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT2.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp3() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry3.getText().toString();
        hr = hourEntry3.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(3, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT3.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp4() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry4.getText().toString();
        hr = hourEntry4.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(4, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT4.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp5() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry5.getText().toString();
        hr = hourEntry5.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(5, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT5.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp6() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry6.getText().toString();
        hr = hourEntry6.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(6, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT6.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp7() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry7.getText().toString();
        hr = hourEntry7.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(7, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT7.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp8() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry8.getText().toString();
        hr = hourEntry8.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(8, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT8.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp9() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry9.getText().toString();
        hr = hourEntry9.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(9, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT9.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void startAlgAp10() {
        // get parameters from text fields
        String time, hr;
        time = timeEntry10.getText().toString();
        hr = hourEntry10.getText().toString();

        // run algorithm with retrieved variables
        String resultStr = calculateBestTime(10, time, hr);
        float result = Float.parseFloat(resultStr);

        // get cost per hour
        String cost = calculateCost(result);

        if(result!=9999){
            RESULT10.setText(bestTime + " is the best time to use this\ndevice. " +
                    "Energy usage is " + resultStr + " kWh.\n\n" +
                    "The cost per hour to use this device\nat this time is " + cost + " GBP.");
        }
    }

    // Method that takes the user to the (unused) appliance input page.
    // This page is just to showcase potential design decisions in future development
    // of this application, if the user could add their own appliances.
    public void goToApplianceInput() {
        // Open next activity
        Intent intent = new Intent(getView().getContext(), ApplianceInput.class);
        startActivity(intent);
    }
}