package com.example.hospitalmanagementsystem.NavigationBar;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.DoctorManageTask.MedSuggestAdapter;
import com.example.hospitalmanagementsystem.DoctorManageTask.MedSuggestDataBase;
import com.example.hospitalmanagementsystem.DoctorManageTask.MedSuggestModelClass;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class PrescriptionActivity extends AppCompatActivity {
RecyclerView recyclerViews;
ArrayList<MedSuggestModelClass> medSuggestModelClasses;
MedSuggestDataBase medSuggestDataBase;
MedSuggestAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_presciption);

        recyclerViews = findViewById(R.id.recyclerViews);
        medSuggestDataBase = new MedSuggestDataBase(getApplicationContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        medSuggestModelClasses = new ArrayList<>();
        adapter = new MedSuggestAdapter(medSuggestModelClasses,getApplicationContext());
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
        medSuggestModelClasses.clear();
        Cursor cursor = medSuggestDataBase.GetAllMedDetails();
        while (cursor.moveToNext()) {
            MedSuggestModelClass modelClass = new MedSuggestModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            medSuggestModelClasses.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }
}