package com.example.josh2.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    Button dollarButton;
    Button euroButton;
    Button poundButton;
    Button biweeklyButton;
    Button weeklyButton;
    Button monthlyButton;
    Button applyButton;

    int currencyVal;
    int paymentVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        applyButton = findViewById(R.id.applyButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("Currency and payment: ", Integer.toString(currencyVal) + ", " + Integer.toString(paymentVal));
                int settings = createSettings();
                //Log.i("Setting num: ", Integer.toString(settings));
                Intent applyIntent = new Intent(getApplicationContext(), MainActivity.class);
                applyIntent.putExtra("applyIntent", settings);
                startActivity(applyIntent);
            }
        });

        dollarButton = findViewById(R.id.dollarButton);
        dollarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyVal = 0;
            }
        });

        euroButton = findViewById(R.id.euroButton);
        euroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyVal = 1;
            }
        });

        poundButton = findViewById(R.id.poundButton);
        poundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyVal = 2;
            }
        });

        biweeklyButton = findViewById(R.id.biweeklyButton);
        biweeklyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentVal = 0;
            }
        });

        weeklyButton = findViewById(R.id.weeklyButton);
        weeklyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentVal = 1;
            }
        });

        monthlyButton = findViewById(R.id.monthlyButton);
        monthlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentVal = 2;
            }
        });
    }

    private int createSettings() {
        int settingsVal = 0;
        if(currencyVal == 0 && paymentVal == 0) {
            settingsVal = 0;
        } else if(currencyVal == 0 && paymentVal == 1) {
            settingsVal = 1;
        } else if(currencyVal == 0 && paymentVal == 2) {
            settingsVal = 2;
        } else if(currencyVal == 1 && paymentVal == 0) {
            settingsVal = 3;
        } else if(currencyVal == 1 && paymentVal == 1) {
            settingsVal = 4;
        } else if(currencyVal == 1 && paymentVal == 2) {
            settingsVal = 5;
        } else if(currencyVal == 2 && paymentVal == 0) {
            settingsVal = 6;
        } else if(currencyVal == 2 && paymentVal == 1) {
            settingsVal = 7;
        } else if(currencyVal == 2 && paymentVal == 2) {
            settingsVal = 8;
        }
        return settingsVal;
    }
}
