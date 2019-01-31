package com.example.josh2.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    int settings;

    TextView amountTextView;
    TextView currencyTextView;
    TextView paymentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        amountTextView = findViewById(R.id.amountTextView);
        currencyTextView = findViewById(R.id.currencyTextView);
        paymentTextView = findViewById(R.id.paymentTextView);

        Intent settingIntent = getIntent();
        settings = settingIntent.getIntExtra("applyVal", 0);
        setTextSettings(settings);
    }

    private void setTextSettings(int settingVal) {
        if(settingVal == 0) {
            currencyTextView.setText("$ DOLLAR");
            paymentTextView.setText("biweekly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 1) {
            currencyTextView.setText("$ DOLLAR");
            paymentTextView.setText("weekly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 2) {
            currencyTextView.setText("$ DOLLAR");
            paymentTextView.setText("monthly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 3) {
            currencyTextView.setText("EURO");
            paymentTextView.setText("biweekly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 4) {
            currencyTextView.setText("EURO");
            paymentTextView.setText("weekly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 5) {
            currencyTextView.setText("EURO");
            paymentTextView.setText("monthly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 6) {
            currencyTextView.setText("POUND");
            paymentTextView.setText("biweekly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 7) {
            currencyTextView.setText("POUND");
            paymentTextView.setText("weekly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        } else if(settingVal == 8) {
            currencyTextView.setText("POUND");
            paymentTextView.setText("monthly payment");
            currencyTextView.setVisibility(View.VISIBLE);
            paymentTextView.setVisibility(View.VISIBLE);
        }
    }
}
