package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText billAmount;
    private SeekBar tipPercentage;
    private Button calculateTip;
    private TextView resultTotal;
    private TextView textViewSeekBar;
    private int seekbarPercentage;
    private float enteredBillFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billAmount = (EditText) findViewById(R.id.billAmountID);
        tipPercentage = (SeekBar) findViewById(R.id.tipSeekBarID);
        calculateTip = (Button) findViewById(R.id.calculateTipID);
        resultTotal = (TextView) findViewById(R.id.resultID);
        textViewSeekBar = (TextView) findViewById(R.id.textViewSeekBar);

        calculateTip.setOnClickListener(this);

        tipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewSeekBar.setText(String.valueOf(tipPercentage.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = tipPercentage.getProgress();
            }
        });
    }
    @Override
    public void onClick(View v) {
        calculate();
    }
    public void calculate(){
        float result = 0.0f;
        float total = 0.0f;
        if(billAmount.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please enter the bill amount!", Toast.LENGTH_LONG).show();
        }else{
            enteredBillFloat = Float.parseFloat(billAmount.getText().toString());
            result = enteredBillFloat * seekbarPercentage/100;
            total = enteredBillFloat + result;
            resultTotal.setText("Your tip will be: Rs." + String.valueOf(result) + "\nThe total bill amount will be: Rs." +String.valueOf(total));
        }
    }
}