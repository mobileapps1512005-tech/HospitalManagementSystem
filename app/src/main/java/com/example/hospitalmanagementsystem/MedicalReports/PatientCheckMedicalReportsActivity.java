package com.example.hospitalmanagementsystem.MedicalReports;

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

import java.sql.Ref;
import java.util.ArrayList;

public class PatientCheckMedicalReportsActivity extends AppCompatActivity {
RecyclerView recyclerViews;
ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList;
UserCheckPdfReportAdapter adapter;
MedicalReportsDataBase medicalReportsDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_check_medical_reports);


        recyclerViews = findViewById(R.id.recyclerViews);
        medicalReportModelClassArrayList = new ArrayList<>();
        medicalReportsDataBase = new MedicalReportsDataBase(getApplicationContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new UserCheckPdfReportAdapter(medicalReportModelClassArrayList,getApplicationContext());
        recyclerViews.setAdapter(adapter);

        RefreshData();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        RefreshData();
    }

    public void RefreshData(){
        medicalReportModelClassArrayList.clear();
        Cursor cursor = medicalReportsDataBase.AllGetDetails();
        while(cursor.moveToNext()){
            MedicalReportModelClass reportModelClass = new MedicalReportModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(6),
                    cursor.getString(5),cursor.getString(7));
            medicalReportModelClassArrayList.add(reportModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}