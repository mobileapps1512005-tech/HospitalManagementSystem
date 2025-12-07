package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class LabReportStatusActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_report_status);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab AddReport = tabLayout.newTab();
        AddReport.setText("AddReport");
        tabLayout.addTab(AddReport);

        TabLayout.Tab Pending = tabLayout.newTab();
        Pending.setText("Pending");
        tabLayout.addTab(Pending);

        TabLayout.Tab Approval = tabLayout.newTab();
        Approval.setText("Approval");
        tabLayout.addTab(Approval);

        TabLayout.Tab Reject = tabLayout.newTab();
        Reject.setText("Reject");
        tabLayout.addTab(Reject);

         getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new OwnerAddLabReportFragment()).commit();

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               switch (tab.getPosition()) {
                   case 0:
                       getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new OwnerAddLabReportFragment()).commit();
                       break;
                   case 1:
                       getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new LabReportBookPendingFragment()).commit();
                       break;

                   case 2:
                       getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new OwnerLapReportAcceptFragment()).commit();
                       break;

                   case 3:
                       getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new LabReportRejectFragment()).commit();
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