package com.example.hospitalmanagementsystem.BloodManage;

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

public class CheckBloodDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerViews;
    ArrayList<BloodModelClass> bloodModelClassArrayList;
    BloodDataBase bloodDataBase;
    BloodRelatedContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_blood_details);

        recyclerViews = findViewById(R.id.recyclerViews);
        bloodModelClassArrayList = new ArrayList<>();
        bloodDataBase = new BloodDataBase(getApplicationContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new BloodRelatedContactAdapter(bloodModelClassArrayList,getApplicationContext());
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
        bloodModelClassArrayList.clear();
        Cursor cursor = bloodDataBase.GetAllDetails();
        while (cursor.moveToNext()) {
            BloodModelClass modelClass = new BloodModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4));
            bloodModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }
}