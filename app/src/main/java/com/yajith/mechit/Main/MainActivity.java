package com.yajith.mechit.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yajith.mechit.R;
import com.yajith.mechit.Service;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Model> arrayList=new ArrayList<>();
        button=findViewById(R.id.service);
        recyclerView=findViewById(R.id.recycler);
        arrayList.clear();
        arrayList.add(new Model("Battery",R.drawable.battery,34));
        arrayList.add(new Model("SpeedoMeter",R.drawable.dashboard,75));
        arrayList.add(new Model("Engine",R.drawable.engine,83));
        arrayList.add(new Model("Wheel",R.drawable.wheel,59));
        arrayList.add(new Model("Gear",R.drawable.gear,40));
        arrayList.add(new Model("Gas",R.drawable.gas,90));
        MainCustomAdapter mainCustomAdapter=new MainCustomAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainCustomAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Service.class);
                startActivity(intent);
            }
        });
    }
}