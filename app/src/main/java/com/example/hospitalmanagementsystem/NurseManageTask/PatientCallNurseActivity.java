package com.example.hospitalmanagementsystem.NurseManageTask;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class PatientCallNurseActivity extends AppCompatActivity {
RecyclerView recyclerViews;
ArrayList<NurseModelClass> nurseModelClassArrayList;
NurseDataBase nurseDataBase;
PatientCallNurseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_call_nurse);

        recyclerViews = findViewById(R.id.recyclerViews);
        nurseModelClassArrayList = new ArrayList<>();
        nurseDataBase = new NurseDataBase(getApplicationContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new PatientCallNurseAdapter(nurseModelClassArrayList,getApplicationContext());
        recyclerViews.setAdapter(adapter);
        Cursor cursor = nurseDataBase.GetAllNurseData();
        while(cursor.moveToNext()){
            NurseModelClass nurseModelClass = new NurseModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7));
            nurseModelClassArrayList.add(nurseModelClass);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}