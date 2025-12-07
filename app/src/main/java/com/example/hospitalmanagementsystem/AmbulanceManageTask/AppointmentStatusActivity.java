package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.DoctorManageTask.CancelFragment;
import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class AppointmentStatusActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointment_status);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab Pending = tabLayout.newTab();
        Pending.setText("Pending");
        tabLayout.addTab(Pending);

        TabLayout.Tab Appointment = tabLayout.newTab();
        Appointment.setText("Approval");
        tabLayout.addTab(Appointment);

        TabLayout.Tab Cancel = tabLayout.newTab();
        Cancel.setText("Cancel");
        tabLayout.addTab(Cancel);


        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new PendingAmbulanceFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new PendingAmbulanceFragment()).commit();
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ApprovalAmbulanceFragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CancelAmbulanceFragment()).commit();
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