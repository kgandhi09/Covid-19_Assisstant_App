package com.example.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ar extends AppCompatActivity {
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAR1();
            }
        });
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAR2();
            }
        });
    }

    private void openAR2() {
        Intent i = new Intent(this, ARActivity2.class);
        startActivity(i);
    }

    private void openAR1() {
        Intent i = new Intent(this, ARActivity1.class);
        startActivity(i);
    }
}