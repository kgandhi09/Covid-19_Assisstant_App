package com.example.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class report extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    String markerText;
    Integer riskScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        riskScore = getIntent().getIntExtra("tag", -1);
        markerText = getIntent().getStringExtra("title");
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler();
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler();
            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler();
            }
        });

    }

    public void handler(){
//        Intent i = new Intent();
//        i.putExtra("title", markerText);
//        i.putExtra("riskscore", riskScore);


    }
}