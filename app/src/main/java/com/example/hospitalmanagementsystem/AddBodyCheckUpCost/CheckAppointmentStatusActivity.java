package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class CheckAppointmentStatusActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_appointment_status);


        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);


        TabLayout.Tab  CheckPending =  tabLayout.newTab();
        CheckPending.setText("Pending");
        tabLayout.addTab(CheckPending);

        TabLayout.Tab  CheckApproval =  tabLayout.newTab();
        CheckApproval.setText("Approval");
        tabLayout.addTab(CheckApproval);


        TabLayout.Tab  CancelCheckUp =  tabLayout.newTab();
        CancelCheckUp.setText("Cancel");
        tabLayout.addTab(CancelCheckUp);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new CheckPendingFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new CheckPendingFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new CheckApprovalFragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new CheckCancelFragment()).commit();
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