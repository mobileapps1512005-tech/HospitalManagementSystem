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

public class CanteenStatusActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_canteen_status);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab outOfStock = tabLayout.newTab();
        outOfStock.setText("MenuStock");
        tabLayout.addTab(outOfStock);

        TabLayout.Tab call = tabLayout.newTab();
        call.setText("CallPermission");
        tabLayout.addTab(call);

        TabLayout.Tab appointment = tabLayout.newTab();
        appointment.setText("FoodStatus");
        tabLayout.addTab(appointment);


        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new MenuStockFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new MenuStockFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CanteenCallPermissionFragment()).commit();
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), CanteenAppointmentActivity.class));
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