package com.example.hospitalmanagementsystem.GrievanceActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

public class ComplaneFragment extends Fragment {
EditText edHospital,edName,edPhone,edStaff,edGrievance;
Button btnSubmit;
String hospital,name,phone,staff,grievance;
GrievanceDataBase grievanceDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_complane, container, false);


        edHospital = view.findViewById(R.id.edHospital);
        edName = view.findViewById(R.id.edName);
        edPhone = view.findViewById(R.id.edPhone);
        edStaff = view.findViewById(R.id.edStaff);
        edGrievance = view.findViewById(R.id.edGrievance);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        grievanceDataBase = new GrievanceDataBase(getContext());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GrievanceInsertData();
            }
        });

        return view;
    }

    public void GrievanceInsertData(){

       hospital = edHospital.getText().toString();
       name = edName.getText().toString();
       phone = edPhone.getText().toString();
       staff = edStaff.getText().toString();
       grievance = edGrievance.getText().toString();

       if (hospital.isEmpty()) {
           edHospital.requestFocus();
           edHospital.setError("hospital name can't empty");
           return;
       } else if (!hospital.matches("[a-zA-Z0-9 ]+")) {
           edHospital.requestFocus();
           edHospital.setError("Invalid try again....");
           return;
       } else if (name.isEmpty()) {
           edName.requestFocus();
           edName.setError("name can't empty");
           return;
       } else if (!name.matches("[a-zA-Z ]+")){
           edName.requestFocus();
           edName.setError("Invalid try again....");
           return;
       }else if (phone.isEmpty()) {
           edPhone.requestFocus();
           edPhone.setError("phone can't empty");
           return;
       } else if (!phone.matches("[0-9]+\\d{9}")){
           edPhone.requestFocus();
           edPhone.setError("Invalid try again....");
           return;
       }else if (staff.isEmpty()) {
           edStaff.requestFocus();
           edStaff.setError("staff can't empty");
           return;
       } else if (!staff.matches("[a-zA-Z ]+")){
           edStaff.requestFocus();
           edStaff.setError("Invalid try again....");
           return;
       }else if (grievance.isEmpty()) {
           edGrievance.requestFocus();
           edGrievance.setError("grievance can't empty");
           return;
       } else if (!grievance.matches("[a-zA-Z0-9-,./' ]+")){
           edGrievance.requestFocus();
           edGrievance.setError("Invalid try again....");
           return;
       }
    boolean b = grievanceDataBase.GrievanceInsertData(hospital,name,phone,staff,grievance);
       if (b==true){
           Toast.makeText(getContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
           edHospital.setText("");
           edName.setText("");
           edPhone.setText("");
           edStaff.setText("");
           edGrievance.setText("");
       }else {
           Toast.makeText(getContext(), "Failed...", Toast.LENGTH_SHORT).show();
       }
    }

}