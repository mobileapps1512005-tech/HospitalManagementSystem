package com.example.hospitalmanagementsystem.AddLabTestReports;

import static java.security.AccessController.getContext;

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

public class CheckLabReportsActivity extends AppCompatActivity {
RecyclerView recyclerViews;
CheckLabReportAdapter adapter;
ArrayList<ReportModelClass> reportModelClassArrayList;
OwnerAddReportDataBase ownerAddReportDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_lab_reports);

        recyclerViews = findViewById(R.id.recyclerViews);
        reportModelClassArrayList = new ArrayList<>();
        ownerAddReportDataBase = new OwnerAddReportDataBase(getApplicationContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new CheckLabReportAdapter(reportModelClassArrayList,getApplicationContext());
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
        reportModelClassArrayList.clear();
        Cursor cursor =ownerAddReportDataBase.GetAllDetailLabAdd();
        while (cursor.moveToNext()) {
            ReportModelClass reportModelClass = new ReportModelClass(cursor.getString(1),cursor.getString(3),
                    cursor.getString(2));
            reportModelClassArrayList.add(reportModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}