package com.example.hospitalmanagementsystem.HospitalManageTask;

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

public class AddHospitalActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_hospital);

       tabLayout = findViewById(R.id.tabLayout);
       frameLayout = findViewById(R.id.frameLayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddHospitalDetailsFragment()).commit();

       TabLayout.Tab AddDetails = tabLayout.newTab();
       AddDetails.setText("ADD");
       tabLayout.addTab(AddDetails);


        TabLayout.Tab UpdateDetails = tabLayout.newTab();
        UpdateDetails.setText("UPDATE");
        tabLayout.addTab(UpdateDetails);

        TabLayout.Tab Delete= tabLayout.newTab();
        Delete.setText("DELETE");
        tabLayout.addTab(Delete);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0 :
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddHospitalDetailsFragment()).commit();
                         break;
                     case 1 :
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateHospitalDetailsFragment()).commit();
                         break;

                     case 2 :
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DeleteHospitalDetailFragment()).commit();
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

