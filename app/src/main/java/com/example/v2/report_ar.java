package com.example.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class report_ar extends AppCompatActivity {
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_ar);
        b1 = findViewById(R.id.report_ar_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                report_place_handler();
            }
        });
        b2 = findViewById(R.id.report_ar_b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scan_place_handler();
            }
        });
    }

    private void scan_place_handler() {
        Intent i = new Intent(this, ar.class);
        startActivity(i);
    }

    private void report_place_handler() {
        Intent i = new Intent(this, capture.class);
        startActivity(i);
    }
}