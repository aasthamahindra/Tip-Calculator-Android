package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount;
    private SeekBar tipPercentage;
    private Button calculateTip;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billAmount = (EditText) findViewById(R.id.billAmountID);
        tipPercentage = (SeekBar) findViewById(R.id.tipSeekBarID);
        calculateTip = (Button) findViewById(R.id.calculateTipID);
        result = (TextView) findViewById(R.id.resultID);

        
    }
}