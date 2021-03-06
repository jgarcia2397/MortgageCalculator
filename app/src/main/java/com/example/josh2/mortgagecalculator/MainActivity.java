package com.example.josh2.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calcButton;
    Button settingsButton;
    Button detailsButton;

    EditText mortPrinET;
    EditText interestET;
    EditText amortET;

    TextView defaultSettingTV;

    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent applyIntent = getIntent();
        final int applyVal = applyIntent.getIntExtra("applyIntent", 0);
        //setTextSettings(applyVal);

        mortPrinET = findViewById(R.id.mortPrinET);
        interestET = findViewById(R.id.interestET);
        amortET = findViewById(R.id.amortET);

        defaultSettingTV = findViewById(R.id.defaultSettingTV);
        setTextSettings(applyVal);

        calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final double prinDouble = getPrinAmt();
                final double interestDouble = getIntRateAmt() / determinePayFreq(applyVal);
                final double numPayments = getPaymentsAmt() * determinePayFreq(applyVal);
                if((prinDouble == 0.0) || (interestDouble == 0.0) || (numPayments == 0.0) || (prinDouble < 0.0) || (interestDouble < 0.0) || (numPayments < 0.0)) {
                    Toast.makeText(MainActivity.this, "Please enter valid values.", Toast.LENGTH_LONG).show();
                } else {
                    double mortgage = calcMortgage(prinDouble, interestDouble, numPayments);
                    Intent summaryIntent = new Intent(getApplicationContext(), SummaryActivity.class);
                    summaryIntent.putExtra("applyVal", applyVal);
                    summaryIntent.putExtra("mortgageIntent", mortgage);
                    startActivity(summaryIntent);
                    clearEditTexts();
                }
            }
        });

        detailsButton = findViewById(R.id.detailsButton);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailsIntent = new Intent(getApplicationContext(), DetailsActivity.class);
                startActivity(detailsIntent);
            }
        });

        settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
    }

    private void clearEditTexts() {
        mortPrinET.setText("");
        interestET.setText("");
        amortET.setText("");
    }

    private double getPrinAmt() {
        String principalAmt = mortPrinET.getText().toString();
        double prinDouble = getPrinValue(principalAmt);
        return prinDouble;
    }

    private double getIntRateAmt() {
        String intRate = interestET.getText().toString();
        double interestDouble = getIntRateAndPayments(intRate);
        return interestDouble/100;
    }

    private double getPaymentsAmt() {
        String amortAmt = amortET.getText().toString();
        double numPayments = getIntRateAndPayments(amortAmt);
        return numPayments;
    }

    private double determinePayFreq(int val) {
        if((val == 0) || (val == 3) || (val == 6)) {
            // bi-weekly
            num = 24;
        } else if((val == 1) || (val == 4) || (val == 7)) {
            // weekly
            num = 48;
        } else if((val == 2) || (val == 5) || (val == 8)) {
            // monthly
            num = 12;
        }
        return num;
    }

    private double getPrinValue(String string) {
        try {
            return Double.valueOf(string);
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    private double getIntRateAndPayments(String string) {
        try {
            return Double.valueOf(string);
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    private double calcMortgage(double principalAmt, double intRate, double amortPeriod) {
        double mortgageAmt;
        mortgageAmt = principalAmt * (((intRate * (Math.pow((1 + intRate), amortPeriod)))) / (Math.pow((1 + intRate), amortPeriod) - 1));
        return mortgageAmt;
    }

    private void setTextSettings(int settingVal) {
        if(settingVal == 0) {
            defaultSettingTV.setText("Your mortgage will be calculated with Dollars ($) and bi-weekly payments. This can be changed in the settings.");
        } else if(settingVal == 1) {
            defaultSettingTV.setText("Your mortgage will be calculated with Dollars ($) and weekly payments. This can be changed in the settings.");
        } else if(settingVal == 2) {
            defaultSettingTV.setText("Your mortgage will be calculated with Dollars ($) and monthly payments. This can be changed in the settings.");
        } else if(settingVal == 3) {
            defaultSettingTV.setText("Your mortgage will be calculated with Euros (€) and bi-weekly payments. This can be changed in the settings.");
        } else if(settingVal == 4) {
            defaultSettingTV.setText("Your mortgage will be calculated with Euros (€) and weekly payments. This can be changed in the settings.");
        } else if(settingVal == 5) {
            defaultSettingTV.setText("Your mortgage will be calculated with Euros (€) and monthly payments. This can be changed in the settings.");
        } else if(settingVal == 6) {
            defaultSettingTV.setText("Your mortgage will be calculated with Pounds (£) and bi-weekly payments. This can be changed in the settings.");
        } else if(settingVal == 7) {
            defaultSettingTV.setText("Your mortgage will be calculated with Pounds (£) and weekly payments. This can be changed in the settings.");
        } else if(settingVal == 8) {
            defaultSettingTV.setText("Your mortgage will be calculated with Pounds (£) and monthly payments. This can be changed in the settings.");
        }
    }
}
