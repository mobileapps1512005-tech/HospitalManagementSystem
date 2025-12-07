package com.example.hospitalmanagementsystem.InsuranceModule;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class TabClaimInsuranceActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout FrameLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_claim_insurance);

        tabLayout = findViewById(R.id.TabLayouts);
        FrameLayouts = findViewById(R.id.FrameLayouts);

        TabLayout.Tab Check = tabLayout.newTab();
        Check.setText("CHECK");
        tabLayout.addTab(Check);

        TabLayout.Tab Apply = tabLayout.newTab();
        Apply.setText("APPLY");
        tabLayout.addTab(Apply);

        TabLayout.Tab Update = tabLayout.newTab();
        Update.setText("UPDATE");
        tabLayout.addTab(Update);

        getSupportFragmentManager().beginTransaction().add(R.id.FrameLayouts,new ReadInsuranceClaimFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               switch (tab.getPosition()){
                   case 0:
                       getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayouts,new ReadInsuranceClaimFragment()).commit();
                       break;
                   case 1:
                       getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayouts,new ApplyClaimFragment()).commit();
                       break;
                   case 2:
                       getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayouts,new UpdateClaimFragment()).commit();
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