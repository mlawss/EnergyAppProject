package com.firstapp.energyappproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variables for each element on landing page
    private Button loginB;
    private EditText unText,pwText;
    private TextView warningText;
    // login retry counter
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables to the elements by ID
        loginB = (Button)findViewById(R.id.loginButton);
        unText = (EditText)findViewById(R.id.unEntry);
        pwText = (EditText)findViewById(R.id.pwEntry);
        warningText = (TextView)findViewById(R.id.textView2);
        warningText.setVisibility(View.GONE);

        // set onclick method for login button to login()
        loginB.setOnClickListener(v -> login());
    }

    // Login function - activated when login button is pressed.
    public void login() {
        // if details correct
        if(unText.getText().toString().equals("admin") && (pwText.getText().toString().equals("1234"))){
            // Display logging in message to user
            Toast.makeText(getApplicationContext(),"Logging in...",Toast.LENGTH_SHORT).show();

            // Open next activity (page)
            Intent intent = new Intent(this, NavMain.class);
            startActivity(intent);
        }
        else{
            // display wrong credentials message to user
            Toast.makeText(getApplicationContext(),"Wrong credentials.",Toast.LENGTH_SHORT).show();

            // enable the warning text with how many attempts the user has left, counting down each time until 0
            warningText.setVisibility(View.VISIBLE);
            counter--;
            warningText.setText(String.format("Attempts left: %s", Integer.toString(counter)));

            // if no attempts left, disable the login button
            if(counter<=0){
                loginB.setEnabled(false);
            }
        }

    }
}