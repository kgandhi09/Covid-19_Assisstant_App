package com.example.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.mainbutton1);
        button2 = findViewById(R.id.mainbutton2);
        button3 = findViewById(R.id.mainbutton3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler3();
            }
        });
    }

    public void handler1(){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
    public void handler2(){
        Intent i = new Intent(this, report_ar.class);
        startActivity(i);
    }
    public void handler3(){
        Intent i = new Intent(this, log_activity.class);
        startActivity(i);
    }
}

