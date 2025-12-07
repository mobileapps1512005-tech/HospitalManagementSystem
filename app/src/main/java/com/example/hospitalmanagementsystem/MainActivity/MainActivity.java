package com.example.hospitalmanagementsystem.MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.hospitalmanagementsystem.AboutManage.AboutsFragment;
import com.example.hospitalmanagementsystem.BottomFragment.AppointmentBookFragment;
import com.example.hospitalmanagementsystem.BottomFragment.HealDietFragment;
import com.example.hospitalmanagementsystem.BottomFragment.HomeFragment;
import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorCallPatientFragment;
import com.example.hospitalmanagementsystem.DrawerLayout.BottomDialogFragment;
import com.example.hospitalmanagementsystem.DrawerLayout.billingActivity;
import com.example.hospitalmanagementsystem.NavigationBar.PrescriptionActivity;
import com.example.hospitalmanagementsystem.R;
import com.example.hospitalmanagementsystem.SplashScreenActivity.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout Drawer;
    NavigationView NavigationViewBar;
    BottomNavigationView BottomNavigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Drawer = findViewById(R.id.Drawer);
        toolbar = findViewById(R.id.toolbar);
        NavigationViewBar = findViewById(R.id.NavigationViewBar);
        BottomNavigationView = findViewById(R.id.BottomNavigation);
        frameLayout = findViewById(R.id.frameLayout);

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, Drawer, toolbar, R.string.Open, R.string.Close);
        Drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Drawer.closeDrawer(GravityCompat.START);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new HomeFragment()).commit();

        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.Home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
                } else if (menuItem.getItemId() == R.id.Appointment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AppointmentBookFragment()).commit();
                }  else if (menuItem.getItemId() == R.id.DoctorCall) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DoctorCallPatientFragment()).commit();
                } else if (menuItem.getItemId() == R.id.About) {
                 getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AboutsFragment()).commit();
                } else if (menuItem.getItemId() == R.id.Diet) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HealDietFragment()).commit();
                }
                return true;
            }
        });

        NavigationViewBar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.Billing) {
                    startActivity(new Intent(getApplicationContext(), billingActivity.class));
                } else if (menuItem.getItemId() == R.id.Prescription) {
                   startActivity(new Intent(getApplicationContext(), PrescriptionActivity.class));
                } else if (menuItem.getItemId()==R.id.HealthBenefit) {
                    BottomDialogFragment bottomDialogFragment = new BottomDialogFragment();
                    bottomDialogFragment.show(getSupportFragmentManager(),bottomDialogFragment.getTag());
                } else if (menuItem.getItemId() == R.id.Logout) {
                    SharedPreferences sharedPreferences = getSharedPreferences("Share",MODE_PRIVATE);
                    sharedPreferences.edit().clear().apply();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
                return true;
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Drawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       }
}
