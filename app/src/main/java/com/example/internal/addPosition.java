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
import com.example.internal.model.VT;

import java.util.ArrayList;

public class addPosition extends AppCompatActivity {
    private ArrayList<VT> nvlist;
    private ArrayAdapter<VT> adnv;
    private Button btnadd;
    private EditText title,des;
    private String filename="vt.txt";
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_position);
        btnadd= findViewById(R.id.button);
        title=findViewById(R.id.editTextTextPersonName);
        des=findViewById(R.id.editTextTextPersonName2);
        lv=findViewById(R.id.list);

        nvlist= IOFile.doc(this,filename);
        if(nvlist.size()>0){
            VT.setSvt(nvlist.get(nvlist.size()-1).getId()+1);

            adnv= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nvlist);
            adnv.setNotifyOnChange(true);
            lv.setAdapter(adnv);
        }

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VT nv= new VT(title.getText().toString(),des.getText().toString());
                nvlist.add(nv);
                IOFile.ghi(addPosition.this,filename,nvlist);
                nvlist= IOFile.doc(addPosition.this,filename);

                adnv= new ArrayAdapter<>(addPosition.this, android.R.layout.simple_list_item_1,nvlist);
                adnv.setNotifyOnChange(true);
                lv.setAdapter(adnv);
            }
        });
    }

}