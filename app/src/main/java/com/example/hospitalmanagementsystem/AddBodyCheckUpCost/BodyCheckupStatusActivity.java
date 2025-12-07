package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class BodyCheckupStatusActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_body_checkup_status);


        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);


        TabLayout.Tab  DeleteCheckUp =  tabLayout.newTab();
        DeleteCheckUp.setText("Delete");
        tabLayout.addTab(DeleteCheckUp);

        TabLayout.Tab  CallPermission =  tabLayout.newTab();
        CallPermission.setText("CallPermission");
        tabLayout.addTab(CallPermission);


        TabLayout.Tab  AppointmentCheckUp =  tabLayout.newTab();
        AppointmentCheckUp.setText("Appointment");
        tabLayout.addTab(AppointmentCheckUp);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new CheckDeleteFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){

                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CheckDeleteFragment()).commit();
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CheckupCallPermissionFragment()).commit();
                        break;

                    case 2:
                        startActivity(new Intent(getApplicationContext(), CheckAppointmentStatusActivity.class));
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