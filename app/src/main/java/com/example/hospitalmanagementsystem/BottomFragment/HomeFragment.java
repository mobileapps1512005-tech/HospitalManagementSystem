package com.example.hospitalmanagementsystem.BottomFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.PatientBookingCheckupTabActivity;
import com.example.hospitalmanagementsystem.AddCanteenDetailManage.PatientCanteenViewActivity;
import com.example.hospitalmanagementsystem.AddLabTestReports.PatientViewLabReportTabActivity;
import com.example.hospitalmanagementsystem.AmbulanceManageTask.AmbulanceViewTabActivity;
import com.example.hospitalmanagementsystem.BloodManage.CheckBloodDetailsActivity;
import com.example.hospitalmanagementsystem.DoctorManageTask.TabViewDoctorAppointmentActivity;
import com.example.hospitalmanagementsystem.GrievanceActivity.GrievanceActivity;
import com.example.hospitalmanagementsystem.HomeDeliveryMedicine.HospitalViewActivity;
import com.example.hospitalmanagementsystem.HomeDeliveryMedicine.PatientViewMedicineHomeDeliveryActivity;
import com.example.hospitalmanagementsystem.MedicalReports.PatientCheckMedicalReportsActivity;
import com.example.hospitalmanagementsystem.MedicineOrderTaskManage.MedicineOrdersActivity;
import com.example.hospitalmanagementsystem.InsuranceModule.TabClaimInsuranceActivity;
import com.example.hospitalmanagementsystem.MedicineReturnsPolicy.PatientBookingMedicineReturnActivity;
import com.example.hospitalmanagementsystem.NurseManageTask.PatientCallNurseActivity;
import com.example.hospitalmanagementsystem.PharmacyManageTask.pharmacyViewTabActivity;
import com.example.hospitalmanagementsystem.R;
import com.google.android.material.card.MaterialCardView;


public class HomeFragment extends Fragment {
View view;
    MaterialCardView CardInsurance,cardMedicineOrder,cardHome,cardViewDoctor,cardNurse,CardAmbulance,CardPharmacy,cardMedicalReports,
            cardCheckupBooking,CardCanteen,cardMedicineReturn,CardLabReport,CardHomeDelivery,cardGrievance,CardBlood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        CardInsurance = view.findViewById(R.id.CardInsurance);
        cardMedicineOrder = view.findViewById(R.id.cardMedicineOrder);
        cardHome = view.findViewById(R.id.cardHome);
        cardViewDoctor = view.findViewById(R.id.cardViewDoctor);
        cardNurse = view.findViewById(R.id.cardNurse);
        CardAmbulance = view.findViewById(R.id.CardAmbulance);
        CardPharmacy = view.findViewById(R.id.CardPharmacy);
        cardMedicalReports = view.findViewById(R.id.cardMedicalReports);
        cardCheckupBooking = view.findViewById(R.id.cardCheckupBooking);
        CardCanteen = view.findViewById(R.id.CardCanteen);
        cardMedicineReturn =view.findViewById(R.id.cardMedicineReturn);
        CardLabReport = view.findViewById(R.id.CardLabReport);
        CardHomeDelivery = view.findViewById(R.id.CardHomeDelivery);
        cardGrievance = view.findViewById(R.id.cardGrievance);
        CardBlood = view.findViewById(R.id.CardBlood);


        CardInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TabClaimInsuranceActivity.class);
                startActivity(intent);
            }
        });

        cardMedicineOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MedicineOrdersActivity.class);
                startActivity(intent);
            }
        });

        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HospitalViewActivity.class);
                startActivity(intent);
            }
        });

        cardViewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TabViewDoctorAppointmentActivity.class);
                startActivity(intent);
            }
        });

        cardNurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(getContext(), PatientCallNurseActivity.class);
             startActivity(intent);
            }
        });

        CardAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getContext(), AmbulanceViewTabActivity.class);
                 startActivity(intent);
            }
        });

        CardPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(getContext(), pharmacyViewTabActivity.class);
              startActivity(intent);
            }
        });

        cardMedicalReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getContext(), PatientCheckMedicalReportsActivity.class));
            }
        });

        cardCheckupBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PatientBookingCheckupTabActivity.class));
            }
        });

        CardCanteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PatientCanteenViewActivity.class));
            }
        });

        cardMedicineReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PatientBookingMedicineReturnActivity.class));
            }
        });

        CardLabReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PatientViewLabReportTabActivity.class));
            }
        });

        CardHomeDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getContext(), PatientViewMedicineHomeDeliveryActivity.class));
            }
        });

        cardGrievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GrievanceActivity.class));
            }
        });

        CardBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CheckBloodDetailsActivity.class));
            }
        });

        return view;
    }
}