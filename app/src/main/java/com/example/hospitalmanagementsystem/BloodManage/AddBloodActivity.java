package com.example.hospitalmanagementsystem.BloodManage;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.tabs.TabLayout;

public class AddBloodActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_blood);

        frameLayout = findViewById(R.id.frameLayout);
        tabLayout = findViewById(R.id.tabLayout);


        TabLayout.Tab AddBlood = tabLayout.newTab();
        AddBlood.setText("AddBlood");
        tabLayout.addTab(AddBlood);

        TabLayout.Tab UpdateBlood = tabLayout.newTab();
        UpdateBlood.setText("Update");
        tabLayout.addTab(UpdateBlood);

        TabLayout.Tab DeleteBlood = tabLayout.newTab();
        DeleteBlood.setText("Delete");
        tabLayout.addTab(DeleteBlood);

         getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new AddBloodFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AddBloodFragment()).commit();
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateBloodFragment()).commit();
                        break;

                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DeleteBloodFragment()).commit();
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