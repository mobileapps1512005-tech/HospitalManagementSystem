package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AddAmbulanceActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_ambulance);

         tabLayout = findViewById(R.id.tabLayout);
         frameLayout = findViewById(R.id.frameLayout);

         TabLayout.Tab AmbulanceAdd = tabLayout.newTab();
        AmbulanceAdd.setText("AddDetails");
        tabLayout.addTab(AmbulanceAdd);

        TabLayout.Tab AmbulanceUpdate = tabLayout.newTab();
        AmbulanceUpdate.setText("UpdateDetails");
        tabLayout.addTab(AmbulanceUpdate);

        TabLayout.Tab AmbulanceStatus = tabLayout.newTab();
        AmbulanceStatus.setText("Status");
        tabLayout.addTab(AmbulanceStatus);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new AddAmbulanceDetailsFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddAmbulanceDetailsFragment()).commit();
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateAmbulanceFragment()).commit();
                        break;

                    case 2:
                        startActivity(new Intent(getApplication(), AmbulanceStatusActivity.class));
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