package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

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

public class CheckMedicineActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_check_medicine);


        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        TabLayout.Tab Pending = tabLayout.newTab();
        Pending.setText("Pending");
        tabLayout.addTab(Pending);

        TabLayout.Tab Available = tabLayout.newTab();
        Available.setText("Confirms");
        tabLayout.addTab(Available);

        TabLayout.Tab NoAvailable = tabLayout.newTab();
        NoAvailable.setText("NoAvailable");
        tabLayout.addTab(NoAvailable);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new PendingMedicineFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new PendingMedicineFragment()).commit();
                         break;
                     case 1:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConfirmMedicineFragment()).commit();
                         break;
                     case 2:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new NoAvailableFragment()).commit();
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