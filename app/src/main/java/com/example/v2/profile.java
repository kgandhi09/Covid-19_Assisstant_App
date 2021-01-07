package com.example.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;

public class profile extends AppCompatActivity {
    TextView markertxt;
    TextView riskScoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        markertxt = findViewById(R.id.marker_profile);
        String title = getIntent().getStringExtra("title");
        markertxt.setText(title);
        riskScoreText = findViewById(R.id.riskscore);
        Integer riskScore = getIntent().getIntExtra("tag", -1);
        riskScoreText.setText(riskScore.toString()+"%");

    }
}