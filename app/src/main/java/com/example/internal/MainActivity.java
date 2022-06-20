package com.example.internal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button add_staff,add_position,p_s,statistic, list_staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_staff= findViewById(R.id.button2);
        add_position=findViewById(R.id.button3);
        p_s=findViewById(R.id.button4);
        statistic=findViewById(R.id.button6);
        list_staff=findViewById(R.id.button5);
        add_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,addStaff.class);
                startActivity(i);
            }
        });
        add_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,addPosition.class);
                startActivity(i);
            }
        });
        p_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,addSP.class);
                startActivity(i);
            }
        });
        list_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,List_Staff.class);
                startActivity(i);
            }
        });
        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,Statistic.class);
                startActivity(i);
            }
        });
    }
}