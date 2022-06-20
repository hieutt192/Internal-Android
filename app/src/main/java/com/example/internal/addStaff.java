package com.example.internal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.internal.controller.IOFile;
import com.example.internal.model.NV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class addStaff extends AppCompatActivity {
    private ArrayList<NV> nvlist;
    private ArrayAdapter<NV> adnv;
    private Button btnadd;
    private Spinner sptrinhdo;
    private EditText name,que,year;
    private String filename="nv.txt";
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        btnadd= findViewById(R.id.button);
        name=findViewById(R.id.editTextTextPersonName);
        que=findViewById(R.id.editTextTextPersonName2);
        year=findViewById(R.id.editTextTextPersonName3);
        sptrinhdo=findViewById(R.id.sptrinhdo);
        lv=findViewById(R.id.list);

        String[] s= {"Dh","CD"};
        ArrayAdapter<String> ad= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,s);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptrinhdo.setAdapter(ad);

        nvlist= IOFile.doc(this,filename);
        if(nvlist.size()>0){
            NV.setSnv(nvlist.get(nvlist.size()-1).getId()+1);

            adnv= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nvlist);
            adnv.setNotifyOnChange(true);
            lv.setAdapter(adnv);
        }

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NV nv= new NV(name.getText().toString(),year.getText().toString(),que.getText().toString(),sptrinhdo.getSelectedItem().toString());
                nvlist.add(nv);
                IOFile.ghi(addStaff.this,filename,nvlist);
                nvlist= IOFile.doc(addStaff.this,filename);

                adnv= new ArrayAdapter<>(addStaff.this, android.R.layout.simple_list_item_1,nvlist);
                adnv.setNotifyOnChange(true);
                lv.setAdapter(adnv);
            }
        });
    }
}