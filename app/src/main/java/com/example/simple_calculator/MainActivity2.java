package com.example.simple_calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    EditText resultTv , urlEditText ;
    Button btnBrowse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
      setContentView(R.layout.activity_main2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        Intent i = getIntent();
        int res = i.getIntExtra("result",000);

        resultTv= findViewById(R.id.resultSecondActivity);
        btnBrowse = findViewById(R.id.btnToBrowse);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                resultTv.setText(String.valueOf(res));


                // creating implicit intent

                urlEditText = findViewById(R.id.urlTextView);
                String url = urlEditText.getText().toString();
                Uri uri = Uri.parse(url);
                Intent i2 = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i2);

            }
        });


    }
}