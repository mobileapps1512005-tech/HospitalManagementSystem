package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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

public class CanteenAppointmentActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_canteen_appointment);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab pending = tabLayout.newTab();
        pending.setText("pendingFood");
        tabLayout.addTab(pending);

        TabLayout.Tab Confirm = tabLayout.newTab();
        Confirm.setText("CustomerCall");
        tabLayout.addTab(Confirm);

        TabLayout.Tab Delivered = tabLayout.newTab();
        Delivered.setText("FoodConfirmation");
        tabLayout.addTab(Delivered);


        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new PatientFoodRequestFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new PatientFoodRequestFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new PatientFoodOrderCallFragment()).commit();
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),FoodStatusSecurityActivity.class));
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