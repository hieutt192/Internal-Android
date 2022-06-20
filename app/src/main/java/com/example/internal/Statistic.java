package com.example.internal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.internal.controller.IOFile;
import com.example.internal.model.NV;
import com.example.internal.model.NVVT;
import com.example.internal.model.VT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Statistic extends AppCompatActivity {
    private ArrayList<NVVT> nvvtlist;
    private ArrayAdapter<String> adnvvt;
    private String filename="nvvt.txt";
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        lv=findViewById(R.id.list);

        nvvtlist= IOFile.doc(this,filename);
        Map<String,Integer> map= new LinkedHashMap<>();
        for(NVVT nvvt: nvvtlist){
            if(map.containsKey(nvvt.getVt().getTitle())){
                int value= map.get(nvvt.getVt().getTitle());
                value++;
                map.put(nvvt.getVt().getTitle(),value);
            }
            else{
                map.put(nvvt.getVt().getTitle(),1);
            }
        }
        ArrayList<String> statistic= new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            statistic.add(entry.getKey()+" co :"+ entry.getValue() +"nv");
        }
        adnvvt= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,statistic);
        adnvvt.setNotifyOnChange(true);
        lv.setAdapter(adnvvt);
    }
}