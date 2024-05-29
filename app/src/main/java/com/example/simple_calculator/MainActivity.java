package com.example.simple_calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextNumber2);
        result = findViewById(R.id.editTextNumber3);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // Read values when button is clicked
//                int var1 = Integer.parseInt(e1.getText().toString());
//                int var2 = Integer.parseInt(e2.getText().toString());
//
//                // Perform addition
//                int sum = var1 + var2;
//
//                // Set result as string
//                result.setText(String.valueOf(sum));
//
//                // hiding the keyboard after result
//
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(v.getWindowToken(),0);

                // sending to the new activity usign intent

                try {
                    int var1 = Integer.parseInt(e1.getText().toString());
                    int var2 = Integer.parseInt(e2.getText().toString());
                    int sum = var1 + var2;
                    result.setText(String.valueOf(sum));
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("result", sum);
                    startActivity(i);
                } catch (NumberFormatException e) {
                    // Handle the error, e.g., show a Toast or set error on EditText
                    e1.setError("Invalid input");
                    e2.setError("Invalid input");
                }


            }
        });
    }
}
