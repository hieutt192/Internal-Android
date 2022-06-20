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

import java.util.ArrayList;

public class List_Staff extends AppCompatActivity {
    private ArrayList<NV> nvlist;
    private ArrayAdapter<NV> adnv;
    private Button btnadd;
    private EditText name, year;
    private String filename = "nv.txt";
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_staff);
        btnadd = findViewById(R.id.button);
        name = findViewById(R.id.editTextTextPersonName);
        year = findViewById(R.id.editTextTextPersonName2);
        lv = findViewById(R.id.list);


        nvlist = IOFile.doc(this, filename);
        if (nvlist.size() > 0) {
            NV.setSnv(nvlist.get(nvlist.size() - 1).getId() + 1);

            adnv = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nvlist);
            adnv.setNotifyOnChange(true);
            lv.setAdapter(adnv);
        }

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<NV> filter = new ArrayList<>();
                String ten = name.getText().toString();
                String nam = year.getText().toString();
                for (NV nv : nvlist) {
                    if (nv.getName().equals(ten) && nv.getYear().equals(nam)) {
                        filter.add(nv);
                    }
                }
                adnv = new ArrayAdapter<>(List_Staff.this, android.R.layout.simple_list_item_1, filter);
                adnv.setNotifyOnChange(true);
                lv.setAdapter(adnv);
            }
        });
    }
}