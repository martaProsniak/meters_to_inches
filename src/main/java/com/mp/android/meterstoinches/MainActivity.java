package com.mp.android.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enteredMeters;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredMeters = (EditText) findViewById(R.id.inputInMetersId);
        resultTextView = (TextView) findViewById(R.id.outputInInchesId);
        convertButton = (Button) findViewById(R.id.convertButtonId);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double multipler = 39.37;
                double result = 0.0;

                if (enteredMeters.getText().toString().equals("")){
                    resultTextView.setText(R.string.error_message);
                    resultTextView.setTextColor(Color.RED);
                } else {
                    // gets user input, converts it to String and then parse it to double
                    double metersInput = Double.parseDouble(enteredMeters.getText().toString());
                    result = metersInput * multipler;
                    resultTextView.setTextColor(Color.DKGRAY);
                    resultTextView.setText(String.format("%.2f",  result) + " inches");
                }

            }
        });
    }
}
