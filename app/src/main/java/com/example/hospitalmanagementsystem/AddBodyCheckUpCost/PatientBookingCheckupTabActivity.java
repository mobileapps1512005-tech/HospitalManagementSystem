package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

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

public class PatientBookingCheckupTabActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_bookin_checkuptab);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);


        TabLayout.Tab Booking = tabLayout.newTab();
        Booking.setText("Booking");
        tabLayout.addTab(Booking);

        TabLayout.Tab Call = tabLayout.newTab();
        Call.setText("CallPermission");
        tabLayout.addTab(Call);


        TabLayout.Tab Appointment = tabLayout.newTab();
        Appointment.setText("Appointment");
        tabLayout.addTab(Appointment);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new CheckUpBookingFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                  switch (tab.getPosition()){
                      case 0:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CheckUpBookingFragment()).commit();
                          break;

                      case 1:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new CheckUpCallPermissionPatentFragment()).commit();
                          break;

                      case 2:
                           startActivity(new Intent(getApplicationContext(),PatientCheckUpAppointmentActivity.class));
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