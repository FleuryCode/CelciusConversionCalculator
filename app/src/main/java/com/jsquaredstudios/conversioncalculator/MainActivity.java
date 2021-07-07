package com.jsquaredstudios.conversioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private TextView resultText;
    private Button calculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celciusString = tempEditText.getText().toString();
                if (celciusString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input a value", Toast.LENGTH_SHORT).show();
                } else {
                    double result = calculateFarhenheight(celciusString);
                    MainActivity.this.displayResult(result);
                }
            }
        });
    }


    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.calculate_button);
        tempEditText = findViewById(R.id.edit_text_temp);
    }

    private double calculateFarhenheight(String celsiusString) {
        int tempC = Integer.parseInt(celsiusString);
        return (tempC * 1.8) + 32;
    }

    private void displayResult(double result) {
        DecimalFormat myFormatter = new DecimalFormat("0");
        String resultString = myFormatter.format(result);
        resultText.setText(resultString + " F");
    }

}