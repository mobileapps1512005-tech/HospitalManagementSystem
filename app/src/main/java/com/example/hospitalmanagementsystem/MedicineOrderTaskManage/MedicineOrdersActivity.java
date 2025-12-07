package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

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

public class MedicineOrdersActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicine_order);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab Order = tabLayout.newTab();
        Order.setText("Orders");
        tabLayout.addTab(Order);


        TabLayout.Tab Update = tabLayout.newTab();
        Update.setText("Updates");
        tabLayout.addTab(Update);

        TabLayout.Tab Exits = tabLayout.newTab();
        Exits.setText("Delete");
        tabLayout.addTab(Exits);

        TabLayout.Tab Check = tabLayout.newTab();
        Check.setText("Status");
        tabLayout.addTab(Check);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new MedicineOrderFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0 :
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new MedicineOrderFragment()).commit();
                         break;

                     case 1 :
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateMedicineFragment()).commit();
                         break;

                     case 2 :
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CancelMedicineFragment()).commit();
                         break;

                     case 3 :
                         Intent intent = new Intent(getBaseContext(), CheckMedicineActivity.class);
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