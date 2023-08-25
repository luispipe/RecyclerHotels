package com.example.recyclerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElements> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        items= new ArrayList<>();
        items.add(new ListElements("Hotel Redentor","#FFF44336","Rio de Janeiro","Disponible"));
        items.add(new ListElements("Hotel Cancun","#FF03A9F4","Cancun","Disponible"));
        items.add(new ListElements("Hotel Monjuit","#FF673AB7","Barcelona","No Disponible"));
        items.add(new ListElements("Hotel Castle White","#FFFFEB3B","Aruba","No Disponible"));
        items.add(new ListElements("Hotel Cameron","#FF4CAF50","Cartagena","Disponible"));
        items.add(new ListElements("Hotel King","#FFE91E63","Miami","No Disponible"));

        ListAdapter listAdapter= new ListAdapter(items,this);
        RecyclerView recyclerView= findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}