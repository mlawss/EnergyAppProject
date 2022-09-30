package com.firstapp.energyappproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.widget.Button;

// THIS ACTIVITY (PAGE) DOES NOT FUNCTION.
// It was originally meant to be a functional part of the application.
// However, due to problems with file writing (explained in report) the user
// cannot add any appliances of their own. This means this page is now useless.

// It has been kept along with the "add appliance" button on the home page,
// because it is a good showcase of potential future design choices if the
// user can add their own appliances in the future, given more development time.
public class ApplianceInput extends AppCompatActivity {

    // create variable for button
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_input);

        // find button by ID, copy to nextButton variable
        nextButton = (Button)findViewById(R.id.button);

        // set OnClick method to goToMainNav()
        nextButton.setOnClickListener(v -> goToMainNav());
    }

    // Method to go back to the home page.
    public void goToMainNav() {
        // check everything is entered

        // add appliance to list

        // Open next activity (home page)
        Intent intent = new Intent(this, NavMain.class);
        startActivity(intent);
    }
}