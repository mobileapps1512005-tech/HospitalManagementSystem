package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.HospitalManageTask.HospitalDataBase;
import com.example.hospitalmanagementsystem.HospitalManageTask.HospitalModelClass;
import com.example.hospitalmanagementsystem.HospitalManageTask.HospitalViewAdapter;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class HospitalViewActivity extends AppCompatActivity {
RecyclerView recyclerViews;
ArrayList<HospitalModelClass> hospitalModelClassArrayList;
HospitalDataBase dataBase;
HospitalViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hospital_view);

        recyclerViews = findViewById(R.id.recyclerViews);
        hospitalModelClassArrayList = new ArrayList<>();
        dataBase = new HospitalDataBase(getApplicationContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new HospitalViewAdapter(hospitalModelClassArrayList,getApplicationContext());
        recyclerViews.setAdapter(adapter);
        Cursor cursor = dataBase.GetAllHospitalData();
        while (cursor.moveToNext()){
            HospitalModelClass hospitalModelClass = new HospitalModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5));
            hospitalModelClassArrayList.add(hospitalModelClass);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}