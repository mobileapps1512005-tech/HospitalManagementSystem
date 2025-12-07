package com.example.hospitalmanagementsystem.AdminModule;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.AddBodyCheckupActivity;
import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.CheckUpCallPermissionPatentFragment;
import com.example.hospitalmanagementsystem.AddCanteenDetailManage.AddCanteenActivity;
import com.example.hospitalmanagementsystem.AddCanteenDetailManage.PatientCallCanteenFragment;
import com.example.hospitalmanagementsystem.AddLabTestReports.LabReportsActivity;
import com.example.hospitalmanagementsystem.AmbulanceManageTask.AddAmbulanceActivity;
import com.example.hospitalmanagementsystem.BloodManage.AddBloodActivity;
import com.example.hospitalmanagementsystem.BloodManage.CheckBloodDetailsActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.AddTabDoctorActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorCallPatientFragment;
import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorSuggestHealDietActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.TabViewDoctorAppointmentActivity;
import com.example.hospitalmanagementsystem.GrievanceActivity.PatientProblemGrievanceActivity;
import com.example.hospitalmanagementsystem.HomeDeliveryMedicine.HomeDeliveryActivity;
import com.example.hospitalmanagementsystem.HomeDeliveryMedicine.HospitalViewActivity;
import com.example.hospitalmanagementsystem.HospitalManageTask.AddHospitalActivity;
import com.example.hospitalmanagementsystem.InsuranceModule.InquiryInsuranceActivity;
import com.example.hospitalmanagementsystem.MedicalReports.TestReportActivity;
import com.example.hospitalmanagementsystem.MedicineOrderTaskManage.OwnerCheckMedicineBookingActivity;
import com.example.hospitalmanagementsystem.MedicineReturnsPolicy.MedicineReturnsPolicyTabActivity;
import com.example.hospitalmanagementsystem.NurseManageTask.AddTabNurseActivity;
import com.example.hospitalmanagementsystem.NurseManageTask.PatientCallNurseActivity;
import com.example.hospitalmanagementsystem.PatientBillings.BillingTabViewActivity;
import com.example.hospitalmanagementsystem.PharmacyManageTask.CallPharmacyFragment;
import com.example.hospitalmanagementsystem.PharmacyManageTask.PharmacyActivity;
import com.example.hospitalmanagementsystem.PharmacyManageTask.PharmacyCallForPatientFragment;
import com.example.hospitalmanagementsystem.R;
import com.google.android.material.card.MaterialCardView;

public class StaffCallModuleFragment extends Fragment {
    MaterialCardView CardDoctorAdm,CardInsuranceAdm,CardNurseAdm,CardPharmacyAdm,CardCanteenAdm,CardBloodAdm,cardAddBodyCheckAdm,cardGrievanceAdm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_staff_call_module, container, false);


        CardDoctorAdm = view.findViewById(R.id.CardDoctorAdm);
        CardInsuranceAdm = view.findViewById(R.id.CardInsuranceAdm);
        CardNurseAdm = view.findViewById(R.id.CardNurseAdm);
        CardPharmacyAdm = view.findViewById(R.id.CardPharmacyAdm);
        CardCanteenAdm = view.findViewById(R.id.CardCanteenAdm);
        CardBloodAdm = view.findViewById(R.id.CardBloodAdm);
        cardAddBodyCheckAdm = view.findViewById(R.id.cardAddBodyCheckAdm);
        cardGrievanceAdm = view.findViewById(R.id.cardGrievanceAdm);


        CardDoctorAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.frameLayout, new  DoctorCallPatientFragment()).addToBackStack(null).commit();
            }
        });

        CardInsuranceAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), InquiryInsuranceActivity.class));
            }
        });

        CardNurseAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PatientCallNurseActivity.class);
                startActivity(intent);
            }
        });

        CardPharmacyAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getParentFragmentManager().beginTransaction().replace(R.id.frameLayout,new PharmacyCallForPatientFragment()).addToBackStack(null).commit();
            }
        });

        CardCanteenAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.frameLayout,new PatientCallCanteenFragment()).addToBackStack(null).commit();
            }
        });

        CardBloodAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CheckBloodDetailsActivity.class);
                startActivity(intent);
            }
        });

        cardAddBodyCheckAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.frameLayout, new CheckUpCallPermissionPatentFragment()).addToBackStack(null).commit();
            }
        });

        cardGrievanceAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PatientProblemGrievanceActivity.class));
            }
        });


        return view;
    }

}