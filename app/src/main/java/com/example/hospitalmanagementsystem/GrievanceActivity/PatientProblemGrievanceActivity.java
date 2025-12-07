package com.example.hospitalmanagementsystem.GrievanceActivity;

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

public class PatientProblemGrievanceActivity extends AppCompatActivity {
    RecyclerView recyclerViews;
    ArrayList<GrievanceModelClass> grievanceModelClasses;
    GrievanceDataBase grievanceDataBase;
    ShowPatientGrievanceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_problem_grievance);

        recyclerViews = findViewById(R.id.recyclerViews);
        grievanceDataBase = new GrievanceDataBase(getApplicationContext());
        grievanceModelClasses = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ShowPatientGrievanceAdapter(grievanceModelClasses,getApplicationContext());
        recyclerViews.setAdapter(adapter);

        RefreshData();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        RefreshData();
    }
    public void RefreshData(){
        grievanceModelClasses.clear();
        Cursor cursor = grievanceDataBase.GetAllGrievance();
        while (cursor.moveToNext()) {
            GrievanceModelClass grievanceModelClass = new GrievanceModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5));
            grievanceModelClasses.add(grievanceModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}