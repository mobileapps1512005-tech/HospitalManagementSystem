package com.example.hospitalmanagementsystem.AdminModule;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.AddBodyCheckupActivity;
import com.example.hospitalmanagementsystem.AddCanteenDetailManage.AddCanteenActivity;
import com.example.hospitalmanagementsystem.AddLabTestReports.LabReportsActivity;
import com.example.hospitalmanagementsystem.AmbulanceManageTask.AddAmbulanceActivity;
import com.example.hospitalmanagementsystem.BloodManage.AddBloodActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorSuggestHealDietActivity;
import com.example.hospitalmanagementsystem.InsuranceModule.InquiryInsuranceActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.AddTabDoctorActivity;
import com.example.hospitalmanagementsystem.HomeDeliveryMedicine.HomeDeliveryActivity;
import com.example.hospitalmanagementsystem.HospitalManageTask.AddHospitalActivity;
import com.example.hospitalmanagementsystem.MainActivity.MainActivity;
import com.example.hospitalmanagementsystem.MedicalReports.TestReportActivity;
import com.example.hospitalmanagementsystem.MedicineOrderTaskManage.OwnerCheckMedicineBookingActivity;
import com.example.hospitalmanagementsystem.MedicineReturnsPolicy.MedicineReturnsPolicyTabActivity;
import com.example.hospitalmanagementsystem.NurseManageTask.AddTabNurseActivity;
import com.example.hospitalmanagementsystem.PatientBillings.BillingTabViewActivity;
import com.example.hospitalmanagementsystem.PharmacyManageTask.PharmacyActivity;
import com.example.hospitalmanagementsystem.R;
import com.example.hospitalmanagementsystem.SplashScreenActivity.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

public class AdminModule extends AppCompatActivity {
DrawerLayout drawer;
BottomNavigationView bottomNavigation;
NavigationView navigationView;
ActionBarDrawerToggle actionBarDrawerToggle;
FrameLayout frameLayout;
Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_module);

        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        navigationView = findViewById(R.id.navigationView);
         setSupportActionBar(toolbar);

         actionBarDrawerToggle = new ActionBarDrawerToggle(AdminModule.this,drawer,toolbar,R.string.OpenAdmin,R.string.CloseAdmin);
         drawer.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new AdminFellDetailsFragment()).commit();

         bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                 if (menuItem.getItemId()==R.id.AdmHome){
                     getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AdminFellDetailsFragment()).commit();
                 } else if (menuItem.getItemId()==R.id.StaffCall) {
                     getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new StaffCallModuleFragment()).commit();
                 }
                 return true;
             }
         });


         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                 if (menuItem.getItemId()==R.id.UserDashBoard){
                     startActivity(new Intent(AdminModule.this, MainActivity.class));
                 } else if (menuItem.getItemId()==R.id.Logout) {
                     SharedPreferences sharedPreferences = getSharedPreferences("Share",MODE_PRIVATE);
                     sharedPreferences.edit().clear().apply();
                     startActivity(new Intent(AdminModule.this, LoginActivity.class));
                 }
                 return true;
             }
         });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}