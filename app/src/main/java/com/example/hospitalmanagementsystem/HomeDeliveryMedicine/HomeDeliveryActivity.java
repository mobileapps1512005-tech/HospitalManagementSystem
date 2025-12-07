package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class HomeDeliveryActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_delivery);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab Detail = tabLayout.newTab();
        Detail.setText("AddDetails");
        tabLayout.addTab(Detail);

        TabLayout.Tab Update = tabLayout.newTab();
        Update.setText("Update");
        tabLayout.addTab(Update);


        TabLayout.Tab Status = tabLayout.newTab();
        Status.setText("Status");
        tabLayout.addTab(Status);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new AddDetailsDeliveryFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               switch (tab.getPosition()){
                   case 0:
                       getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddDetailsDeliveryFragment()).commit();
                       break;
                   case 1:
                       getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateDetailDeliveryFragment()).commit();
                       break;
                   case 2:
                       Intent intent = new Intent(getApplicationContext(), HomeDeliveryStatusActivity.class);
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