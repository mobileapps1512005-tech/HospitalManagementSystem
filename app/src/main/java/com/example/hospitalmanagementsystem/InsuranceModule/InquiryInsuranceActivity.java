package com.example.hospitalmanagementsystem.InsuranceModule;

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

public class InquiryInsuranceActivity extends AppCompatActivity {
RecyclerView recyclerViews;
ArrayList<InsuranceModelClass> insuranceModelClassArrayList;
InsuranceDataBase dataBase;
CheckClaimInsuranceAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inquary_insurance);

         recyclerViews = findViewById(R.id.recyclerViews);
         insuranceModelClassArrayList = new ArrayList<>();
         dataBase = new InsuranceDataBase(getApplicationContext());
         recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
         adapter = new CheckClaimInsuranceAdapter(insuranceModelClassArrayList,getApplicationContext());
         recyclerViews.setAdapter(adapter);
        Cursor cursor = dataBase.GetAllInsuranceDetails();
        while (cursor.moveToNext()){
            InsuranceModelClass insuranceModelClass = new InsuranceModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),
                    cursor.getString(11),cursor.getString(12),cursor.getString(13));
                 insuranceModelClassArrayList.add(insuranceModelClass);
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}