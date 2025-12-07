package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class AddTabDoctorActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_doctor);


        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab AddDetails = tabLayout.newTab();
        AddDetails.setText("AddBio");
        tabLayout.addTab( AddDetails);

        TabLayout.Tab MedSuggest = tabLayout.newTab();
        MedSuggest.setText("MedSuggest");
        tabLayout.addTab(MedSuggest);

        TabLayout.Tab Update = tabLayout.newTab();
        Update.setText("Update");
        tabLayout.addTab( Update);

        TabLayout.Tab Status = tabLayout.newTab();
        Status.setText("Status");
        tabLayout.addTab( Status);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new AddDetailsFragment()).commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                  switch (tab.getPosition()){

                      case 0:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddDetailsFragment()).commit();
                          break;

                      case 1:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new MediSuggestFragment()).commit();
                          break;

                      case 2:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateDoctordetailsFragment()).commit();
                          break;

                      case 3:
                          Intent intent = new Intent(getApplication(), DoctorStatusActivity.class);
                          startActivity(intent);
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