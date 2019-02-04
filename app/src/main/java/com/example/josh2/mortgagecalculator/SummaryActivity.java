package com.example.josh2.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    int settings;
    double mortgage;

    TextView amountTextView;
    //TextView currencyTextView;
    //TextView paymentTextView;
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        messageTextView = findViewById(R.id.messageTextView);
        amountTextView = findViewById(R.id.amountTextView);
        //currencyTextView = findViewById(R.id.currencyTextView);
        //paymentTextView = findViewById(R.id.paymentTextView);

        Intent settingIntent = getIntent();
        settings = settingIntent.getIntExtra("applyVal", 0);
        mortgage = settingIntent.getDoubleExtra("mortgageIntent", 0);
        //setTextSettings(settings);

        if((settings == 0) || (settings == 3) || (settings == 6)) {
            // bi-weekly
            messageTextView.setText("To pay your mortgage, you should make bi-weekly payments of:");
            messageTextView.setVisibility(View.VISIBLE);
        } else if((settings == 1) || (settings == 4) || (settings == 7)) {
            // weekly
            messageTextView.setText("To pay your mortgage, you should make weekly payments of:");
            messageTextView.setVisibility(View.VISIBLE);
        } else if((settings == 2) || (settings == 5) || (settings == 8)) {
            // monthly
            messageTextView.setText("To pay your mortgage, you should make monthly payments of:");
            messageTextView.setVisibility(View.VISIBLE);
        }

        if((settings == 0) || (settings == 1) || (settings == 2)) {
            // dollar
            amountTextView.setText("$" + String.format("%.2f", mortgage));
            amountTextView.setVisibility(View.VISIBLE);
        } else if((settings == 3) || (settings == 4) || (settings == 5)) {
            // euro
            amountTextView.setText("€" + String.format("%.2f", mortgage));
            amountTextView.setVisibility(View.VISIBLE);
        } else if((settings == 6) || (settings == 7) || (settings == 8)) {
            // pound
            amountTextView.setText("£" + String.format("%.2f", mortgage));
            amountTextView.setVisibility(View.VISIBLE);
        }
    }

    /*private void setTextSettings(int settingVal) {
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
    }*/
}
