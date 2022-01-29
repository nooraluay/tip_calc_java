package com.twayesh.time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.text.NumberFormat;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private Button calculate;
    private RadioGroup radioGroup;
    private Double tipPercentage = 0.0;
    private TextView textViewResult;
    private Switch roundUpSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the reference view by using findviewbyid
        radioGroup= findViewById(R.id.tip_options);
        calculate = findViewById(R.id.calculate_button);
        textViewResult = findViewById(R.id.tip_result);
        roundUpSwitch = findViewById(R.id.round_up_switch);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // here will check with radio button we have selected
                int selectedRadioButton = radioGroup.getCheckedRadioButtonId();
                switch (selectedRadioButton) {
                    case R.id.option_twenty_percent:
                        tipPercentage  = 0.20;
                        break;
                    case R.id.option_eighteen_percent:
                        tipPercentage = 0.18;
                        break;
                    case R.id.option_fifteen_percent:
                        tipPercentage = 0.15;
                        break;
                }
                // get the value of the textfiled
                EditText editTextCost = findViewById(R.id.cost_of_service);
                String costStr = editTextCost.getText().toString();
                double costValue = Double.parseDouble(costStr);

                Double tip = tipPercentage * costValue;

                // round up is the switch is checked
                if(roundUpSwitch.isChecked()){
                    tip = Math.ceil(tip);
                    // convert tip to currency in dollar efter round it the tip
                    textViewResult.setText(NumberFormat.getCurrencyInstance().format(tip).toString());


                }else {
                    textViewResult.setText(NumberFormat.getCurrencyInstance().format(tip).toString());

                }
            }
        });

    }


    }