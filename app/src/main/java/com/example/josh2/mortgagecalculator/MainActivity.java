package com.example.josh2.mortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calcButton;
    Button settingsButton;
    Button detailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent applyIntent = getIntent();
        final int applyVal = applyIntent.getIntExtra("applyIntent", 0);
        //setTextSettings(applyVal);

        calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("final Setting number: ", Integer.toString(applyVal));
                Intent summaryIntent = new Intent(getApplicationContext(), SummaryActivity.class);
                summaryIntent.putExtra("applyVal", applyVal);
                startActivity(summaryIntent);
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

    /*private void setTextSettings(int settingVal) {
        if(settingVal == 0000) {

        }
    }*/
}
