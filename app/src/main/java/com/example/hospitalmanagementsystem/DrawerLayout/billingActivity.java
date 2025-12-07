package com.example.hospitalmanagementsystem.DrawerLayout;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.PatientBillings.BillingAdapter;
import com.example.hospitalmanagementsystem.PatientBillings.BillingModelClass;
import com.example.hospitalmanagementsystem.PatientBillings.PatientBillingDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class billingActivity extends AppCompatActivity {
RecyclerView recyclerViews;
BillingAdapter adapter;
PatientBillingDataBase patientBillingDataBase;
ArrayList<BillingModelClass> billingModelClassArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_billing_check);

        recyclerViews = findViewById(R.id.recyclerViews);
        patientBillingDataBase = new PatientBillingDataBase(getApplicationContext());
        billingModelClassArrayList = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new BillingAdapter(billingModelClassArrayList,getApplicationContext());
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
        billingModelClassArrayList.clear();
        Cursor cursor = patientBillingDataBase.GetBillingData();
        while (cursor.moveToNext()) {
            BillingModelClass modelClass = new BillingModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(7),cursor.getString(5),
                    cursor.getString(6),cursor.getString(8),cursor.getString(9));
            billingModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();

    }
}