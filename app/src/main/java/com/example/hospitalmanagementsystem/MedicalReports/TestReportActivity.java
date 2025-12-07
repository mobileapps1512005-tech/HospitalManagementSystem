package com.example.hospitalmanagementsystem.MedicalReports;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class TestReportActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_report);

      tabLayout = findViewById(R.id.tabLayout);
      frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab  Add = tabLayout.newTab();
        Add.setText("AddReports");
        tabLayout.addTab(Add);

      TabLayout.Tab  Update = tabLayout.newTab();
      Update.setText("UpdateReports");
      tabLayout.addTab(Update);

      TabLayout.Tab  Delete = tabLayout.newTab();
      Delete.setText("DeleteReports");
      tabLayout.addTab(Delete);

       getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new AddMedicalDetailsFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                   switch(tab.getPosition()){
                       case 0:
                           getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddMedicalDetailsFragment()).commit();
                           break;
                       case 1:
                           getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateReportsFragment()).commit();
                           break;

                       case 2:
                           getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DeleteReportsFragment()).commit();
                           break;
                   }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}