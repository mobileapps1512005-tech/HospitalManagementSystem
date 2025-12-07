package com.example.hospitalmanagementsystem.AdminModule;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.AddBodyCheckupActivity;
import com.example.hospitalmanagementsystem.AddCanteenDetailManage.AddCanteenActivity;
import com.example.hospitalmanagementsystem.AddLabTestReports.LabReportsActivity;
import com.example.hospitalmanagementsystem.AmbulanceManageTask.AddAmbulanceActivity;
import com.example.hospitalmanagementsystem.BloodManage.AddBloodActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.AddTabDoctorActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorSuggestHealDietActivity;
import com.example.hospitalmanagementsystem.HomeDeliveryMedicine.HomeDeliveryActivity;
import com.example.hospitalmanagementsystem.HospitalManageTask.AddHospitalActivity;
import com.example.hospitalmanagementsystem.InsuranceModule.InquiryInsuranceActivity;
import com.example.hospitalmanagementsystem.InsuranceModule.ReadInsuranceClaimFragment;
import com.example.hospitalmanagementsystem.MedicalReports.TestReportActivity;
import com.example.hospitalmanagementsystem.MedicineOrderTaskManage.OwnerCheckMedicineBookingActivity;
import com.example.hospitalmanagementsystem.MedicineReturnsPolicy.MedicineReturnsPolicyTabActivity;
import com.example.hospitalmanagementsystem.NurseManageTask.AddTabNurseActivity;
import com.example.hospitalmanagementsystem.PatientBillings.BillingTabViewActivity;
import com.example.hospitalmanagementsystem.PharmacyManageTask.PharmacyActivity;
import com.example.hospitalmanagementsystem.R;
import com.google.android.material.card.MaterialCardView;

public class AdminFellDetailsFragment extends Fragment {
            MaterialCardView CardHospitalAdm,CardDoctorAdm,CardInsuranceAdm,CardNurseAdm,
            CardAmbulanceAdm,CardPharmacyAdm,CardMedicineOrderAdm,CardHomeDeliveryAdm,
            CardTestReportAdm,CardLabReportAdm,CardCanteenAdm,CardBloodAdm,cardHealDiet,
            cardAddBodyCheckAdm,cardMedicineReturnAdm,CardBillingAdm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_admin_fell_details, container, false);

        CardHospitalAdm = view.findViewById(R.id.CardHospitalAdm);
        CardDoctorAdm = view.findViewById(R.id.CardDoctorAdm);
        CardInsuranceAdm = view.findViewById(R.id.CardInsuranceAdm);
        CardNurseAdm = view.findViewById(R.id.CardNurseAdm);
        CardAmbulanceAdm = view.findViewById(R.id.CardAmbulanceAdm);
        CardPharmacyAdm = view.findViewById(R.id.CardPharmacyAdm);
        CardMedicineOrderAdm = view.findViewById(R.id.CardMedicineOrderAdm);
        CardHomeDeliveryAdm = view.findViewById(R.id.CardHomeDeliveryAdm);
        CardTestReportAdm = view.findViewById(R.id.CardTestReportAdm);
        CardLabReportAdm = view.findViewById(R.id.CardLabReportAdm);
        CardCanteenAdm = view.findViewById(R.id.CardCanteenAdm);
        CardBloodAdm = view.findViewById(R.id.CardBloodAdm);
        cardHealDiet = view.findViewById(R.id.cardHealDiet);
        cardAddBodyCheckAdm = view.findViewById(R.id.cardAddBodyCheckAdm);
        cardMedicineReturnAdm = view.findViewById(R.id.cardMedicineReturnAdm);
        CardBillingAdm = view.findViewById(R.id.CardBillingAdm);


        CardHospitalAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddHospitalActivity.class));
            }
        });

        CardDoctorAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AddTabDoctorActivity.class);
                startActivity(intent);
            }
        });

        CardInsuranceAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getParentFragmentManager().beginTransaction().add(R.id.frameLayout,new ReadInsuranceClaimFragment()).commit();
            }
        });

        CardNurseAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddTabNurseActivity.class);
                startActivity(intent);
            }
        });

        CardAmbulanceAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddAmbulanceActivity.class);
                startActivity(intent);
            }
        });

        CardPharmacyAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PharmacyActivity.class);
                startActivity(intent);
            }
        });

        CardMedicineOrderAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OwnerCheckMedicineBookingActivity.class));
            }
        });

        CardHomeDeliveryAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeDeliveryActivity.class);
                startActivity(intent);
            }
        });

        CardTestReportAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TestReportActivity.class);
                startActivity(intent);
            }
        });

        CardLabReportAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LabReportsActivity.class);
                startActivity(intent);
            }
        });

        CardCanteenAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddCanteenActivity.class);
                startActivity(intent);
            }
        });

        CardBloodAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddBloodActivity.class);
                startActivity(intent);
            }
        });

        cardHealDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DoctorSuggestHealDietActivity.class);
                startActivity(intent);
            }
        });

        cardAddBodyCheckAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddBodyCheckupActivity.class));
            }
        });

        CardCanteenAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddCanteenActivity.class));
            }
        });

        cardMedicineReturnAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MedicineReturnsPolicyTabActivity.class));
            }
        });

        CardBillingAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BillingTabViewActivity.class));
            }
        });


        return view;
    }
}