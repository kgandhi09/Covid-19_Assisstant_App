package com.example.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class DetailsActivity extends AppCompatActivity {

    TextView markertxt;
    Integer riskScore;
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        markertxt = findViewById(R.id.marker);
        String title = getIntent().getStringExtra("title");
        riskScore = getIntent().getIntExtra("tag", -1);
        markertxt.setText(title);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitystatus(view);
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityReport();
            }
        });
    }
    public void openActivitystatus(View view){
        Intent i = new Intent(this, profile.class);
        i.putExtra("title", markertxt.getText());
        i.putExtra("tag", riskScore);
        startActivity(i);

    }
    public void openActivityReport() {
        Intent i = new Intent(this, report.class);
        riskScore = riskScore + 10;
        if(riskScore>=20){
            Intent j = new Intent(this, newMapActivity.class);
            startActivity(j);
        }
        i.putExtra("title", markertxt.getText());
        i.putExtra("tag", riskScore);
        startActivity(i);
    }
}