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
import com.example.internal.model.NVVT;
import com.example.internal.model.VT;

import java.util.ArrayList;

public class addSP extends AppCompatActivity {
    private ArrayList<NVVT> nvvtlist;
    private ArrayAdapter<NVVT> adnvvt;
    private ArrayList<NV> nv;
    private ArrayList<VT> vt;
    private Button btnadd;
    private Spinner spvt,spnv;
    private String filename="nvvt.txt";
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sp);
        btnadd= findViewById(R.id.button);

        spvt=findViewById(R.id.spvt);
        spnv=findViewById(R.id.spnv);
        lv=findViewById(R.id.list);

        nv= IOFile.doc(this,"nv.txt");
        vt= IOFile.doc(this,"vt.txt");
        if(nv!=null && vt!=null){
            ArrayAdapter<NV> ad= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,nv);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnv.setAdapter(ad);

            ArrayAdapter<VT> ad2= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,vt);
            ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spvt.setAdapter(ad2);
        }


        nvvtlist= IOFile.doc(this,filename);
        if(nvvtlist.size()>0){
            NVVT.setSnv(nvvtlist.get(nvvtlist.size()-1).getId()+1);

            adnvvt= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nvvtlist);
            adnvvt.setNotifyOnChange(true);
            lv.setAdapter(adnvvt);
        }


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NV nv= (NV) spnv.getSelectedItem();
                VT vt= (VT) spvt.getSelectedItem();
                NVVT nvvt= new NVVT(nv,vt);
                nvvtlist.add(nvvt);
                IOFile.ghi(addSP.this,filename,nvvtlist);
                nvvtlist= IOFile.doc(addSP.this,filename);

                adnvvt= new ArrayAdapter<>(addSP.this, android.R.layout.simple_list_item_1,nvvtlist);
                adnvvt.setNotifyOnChange(true);
                lv.setAdapter(adnvvt);
            }
        });
    }
}