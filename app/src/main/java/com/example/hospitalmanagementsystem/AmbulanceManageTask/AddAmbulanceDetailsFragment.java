package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class AddAmbulanceDetailsFragment extends Fragment {
    EditText EdName,EdEmail,EdLicense,EdDriverContact,EdVehicleNumber,
            EdHospitalName,EdHospitalContact,EdBaseFare,EdPerKmCost,EdEmergencyCost;
    Spinner SpinDoctor,SpinWithOutDoctor,SpinAC,SpinWithoutAC,SpinAmbulancePack,SpinExperience;
    Button BtnSubmit;
    String name,email,Experience,license,DriverContact,VehicleNo,HospitalName,HospitalNo,BaseFare,
            PerKmCost,EmergencyCost,WithDoctor,WithoutDoctor,WithAC,WithoutAC,AmbulanceAllPackage;
    AmbulanceDataBase ambulanceDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_add_ambulance_details, container, false);


        SpinExperience = view.findViewById(R.id.SpinExperience);
        EdLicense = view.findViewById(R.id.EdLicense);
        EdDriverContact = view.findViewById(R.id.EdDriverContact);
        EdVehicleNumber = view.findViewById(R.id.EdVehicleNumber);
        EdName = view.findViewById(R.id.EdName);
        EdEmail = view.findViewById(R.id.EdEmail);
        EdHospitalName = view.findViewById(R.id.EdHospitalName);
        EdHospitalContact = view.findViewById(R.id.EdHospitalContact);
        EdBaseFare = view.findViewById(R.id.EdBaseFare);
        EdPerKmCost = view.findViewById(R.id.EdPerKmCost);
        EdEmergencyCost = view.findViewById(R.id.EdEmergencyCost);
        SpinDoctor = view.findViewById(R.id.SpinDoctor);
        SpinWithOutDoctor = view.findViewById(R.id.SpinWithOutDoctor);
        SpinAC = view.findViewById(R.id.SpinAC);
        SpinWithoutAC = view.findViewById(R.id.SpinWithoutAC);
        SpinAmbulancePack = view.findViewById(R.id.SpinAmbulancePack);
        BtnSubmit = view.findViewById(R.id.BtnSubmit);
        ambulanceDataBase = new AmbulanceDataBase(getContext());

        SetDriverExperience();
        SetAmbulanceWithDoctor();
        SetAmbulanceWithoutDoctor();
        SetAmbulanceWithAc();
        SetAmbulanceWithoutAc();
        SetAmbulanceAllPackage();

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetInsertAmbulanceDetails();
            }
        });

        SpinExperience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Experience = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WithDoctor = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinWithOutDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WithoutDoctor = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinAC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WithAC = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinWithoutAC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WithoutAC = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinAmbulancePack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AmbulanceAllPackage = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }
    public void SetInsertAmbulanceDetails(){
        name = EdName.getText().toString();
        email = EdEmail.getText().toString();
        license = EdLicense.getText().toString();
        DriverContact = EdDriverContact.getText().toString();
        VehicleNo = EdVehicleNumber.getText().toString();
        HospitalName = EdHospitalName.getText().toString();
        HospitalNo = EdHospitalContact.getText().toString();
        BaseFare = EdBaseFare.getText().toString();
        PerKmCost = EdPerKmCost.getText().toString();
        EmergencyCost = EdEmergencyCost.getText().toString();

        if (name.isEmpty()){
            EdName.requestFocus();
            EdName.setError("Name Can't Empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            EdName.requestFocus();
            EdName.setError("Invalid Name Try Again...");
            return;
        } else if (email.isEmpty()) {
            EdEmail.requestFocus();
            EdEmail.setError("Email Id Can't Empty...");
            return;
        } else if (!email.matches("[a-zA-Z0-9]+[@][a-z]+[.][a-z]+")) {
            EdEmail.requestFocus();
            EdEmail.setError("Invalid Email Try Again...");
            return;
        } else if (license.isEmpty()) {
            EdLicense.requestFocus();
            EdLicense.setError("License Can't Empty...");
            return;
        } else if (!license.matches("[a-zA-Z0-9 ]+")) {
            EdLicense.requestFocus();
            EdLicense.setError("Invalid Licence Try Again...");
            return;
        } else if (DriverContact.isEmpty()) {
            EdDriverContact.requestFocus();
            EdDriverContact.setError("Phone Number Can't Empty");
            return;
        } else if (!DriverContact.matches("[0-9]+\\d{9}")) {
            EdDriverContact.requestFocus();
            EdDriverContact.setError("Invalid Try Again...");
            return;
        } else if (VehicleNo.isEmpty()) {
            EdVehicleNumber.requestFocus();
            EdVehicleNumber.setError("Vehicle Number Can't Empty...");
            return;
        } else if (!VehicleNo.matches("[a-zA-Z0-9 ]+")) {
            EdVehicleNumber.requestFocus();
            EdVehicleNumber.setError("Invalid Vehicle Number Try Again...");
            return;
        } else if (HospitalName.isEmpty()){
            EdHospitalName.requestFocus();
            EdHospitalName.setError("Hospital Name Can't Empty...");
            return;
        } else if (!HospitalName.matches("[a-zA-Z ]+")) {
            EdHospitalName.requestFocus();
            EdHospitalName.setError("Invalid Hospital Name...");
            return;
        } else if (HospitalNo.isEmpty()) {
            EdHospitalContact.requestFocus();
            EdHospitalContact.setError("Hospital Contact Can't Empty...");
            return;
        } else if (!HospitalNo.matches("[0-9 ]+\\d{9}")) {
            EdHospitalContact.requestFocus();
            EdHospitalContact.setError("Invalid Hospital Contact Try Again...");
            return;
        } else if (BaseFare.isEmpty()) {
            EdBaseFare.requestFocus();
            EdBaseFare.setError("Base Fare Cost Can't Empty...");
            return;
        } else if (!BaseFare.matches("[a-zA-Z0-9 ]+")) {
            EdBaseFare.requestFocus();
            EdBaseFare.setError("Invalid Base Fare Try Again...");
            return;
        } else if (PerKmCost.isEmpty()) {
            EdPerKmCost.requestFocus();
            EdPerKmCost.setError("Per Km Cost Can't Empty...");
            return;
        } else if (!PerKmCost.matches("[a-zA-Z0-9 ]+")){
            EdPerKmCost.requestFocus();
            EdPerKmCost.setError("Invalid Per Km Cost Try Again..");
            return;
        } else if (EmergencyCost.isEmpty()) {
            EdEmergencyCost.requestFocus();
            EdEmergencyCost.setError("Emergency Cost Can't Empty...");
            return;
        } else if (!EmergencyCost.matches("[a-zA-Z0-9 ]+")) {
            EdEmergencyCost.requestFocus();
            EdEmergencyCost.setError("Invalid Emergency Cost Try Again...");
            return;
        } if (Experience.equals("Please Select Experience")){
            Toast.makeText(getContext(), "Please Select Valid Experience", Toast.LENGTH_SHORT).show();
            return;
        } if (WithDoctor.equals("Please Select With Doctor Cost")){
            Toast.makeText(getContext(), "Please Select Valid WithDoctor", Toast.LENGTH_SHORT).show();
            return;
        } if (WithoutDoctor.equals("Please Select Without Doctor Cost")){
            Toast.makeText(getContext(), "Please Select Valid WithoutDoctor", Toast.LENGTH_SHORT).show();
            return;
        } if (WithAC.equals("please Select With AC Cost")){
            Toast.makeText(getContext(), "Please Select Valid WithAc", Toast.LENGTH_SHORT).show();
            return;
        } if (WithoutAC.equals("please Select WithOut AC Cost")){
            Toast.makeText(getContext(), "Please Select Valid WithOutAc", Toast.LENGTH_SHORT).show();
            return;
        } if (AmbulanceAllPackage.equals("Please Select All Ambulance Kit Cost")){
            Toast.makeText(getContext(), "Please Select Valid AmbulancePackage", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = ambulanceDataBase.SetInsertAmbulanceData(name,email,Experience,license,DriverContact,VehicleNo,HospitalName,HospitalNo,BaseFare,PerKmCost,EmergencyCost,WithDoctor,WithoutDoctor,WithAC,WithoutAC,AmbulanceAllPackage);
        if (b==true){
            Toast.makeText(getContext(), "SuccessFully...", Toast.LENGTH_SHORT).show();
            EdName.setText("");
            EdEmail.setText("");
            EdEmergencyCost.setText("");
            EdLicense.setText("");
            EdDriverContact.setText("");
            EdVehicleNumber.setText("");
            EdHospitalName.setText("");
            EdHospitalContact.setText("");
            EdBaseFare.setText("");
            EdPerKmCost.setText("");
            SpinDoctor.setSelection(0);
            SpinExperience.setSelection(0);
            SpinWithOutDoctor.setSelection(0);
            SpinAC.setSelection(0);
            SpinWithoutAC.setSelection(0);
            SpinAmbulancePack.setSelection(0);
        }else {
            Toast.makeText(getContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }

    public void SetDriverExperience(){
        ArrayList<String> SelectExperience = new ArrayList<>();

        SelectExperience.add("Please Select Experience");
        SelectExperience.add("1 Year Of Experience");
        SelectExperience.add("2 Years Of Experience");
        SelectExperience.add("3 Years Of Experience");
        SelectExperience.add("4 Years Of Experience");
        SelectExperience.add("5 Years Of Experience");
        SelectExperience.add("6 Years Of Experience");
        SelectExperience.add("7 Years Of Experience");
        SelectExperience.add("8 Years Of Experience");
        SelectExperience.add("9 Years Of Experience");
        SelectExperience.add("10 Years Of Experience");
        SelectExperience.add("11 Years Of Experience");
        SelectExperience.add("12 Years Of Experience");
        SelectExperience.add("13 Years Of Experience");
        SelectExperience.add("14 Years Of Experience");
        SelectExperience.add("15 Years Of Experience");
        SelectExperience.add("16 Years Of Experience");
        SelectExperience.add("17 Years Of Experience");
        SelectExperience.add("18 Years Of Experience");
        SelectExperience.add("19 Years Of Experience");
        SelectExperience.add("20 Years Of Experience");
        SelectExperience.add("21 Years Of Experience");
        SelectExperience.add("22 Years Of Experience");
        SelectExperience.add("23 Years Of Experience");
        SelectExperience.add("24 Years Of Experience");
        SelectExperience.add("25 Years Of Experience");
        SelectExperience.add("26 Years Of Experience");
        SelectExperience.add("27 Years Of Experience");
        SelectExperience.add("28 Years Of Experience");
        SelectExperience.add("29 Years Of Experience");
        SelectExperience.add("30 Years Of Experience");
        SelectExperience.add("31 Years Of Experience");
        SelectExperience.add("32 Years Of Experience");
        SelectExperience.add("33 Years Of Experience");
        SelectExperience.add("34 Years Of Experience");
        SelectExperience.add("35 Years Of Experience");
        SelectExperience.add("36 Years Of Experience");
        SelectExperience.add("37 Years Of Experience");
        SelectExperience.add("38 Years Of Experience");
        SelectExperience.add("39 Years Of Experience");
        SelectExperience.add("40 Years Of Experience");
        SelectExperience.add("41 Years Of Experience");
        SelectExperience.add("42 Years Of Experience");
        SelectExperience.add("43 Years Of Experience");
        SelectExperience.add("44 Years Of Experience");
        SelectExperience.add("45 Years Of Experience");
        SelectExperience.add("46 Years Of Experience");
        SelectExperience.add("47 Years Of Experience");
        SelectExperience.add("48 Years Of Experience");
        SelectExperience.add("49 Years Of Experience");
        SelectExperience.add("50 Years Of Experience");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,SelectExperience);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinExperience.setAdapter(arrayAdapter);
    }

    public void SetAmbulanceWithDoctor(){
        ArrayList<String> AmbulanceWithDoctor = new ArrayList<>();

        AmbulanceWithDoctor.add("Please Select With Doctor Cost");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹500");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹750");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹1,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹1,500");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹2,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹2,500");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹3,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹3,500");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹4,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹5,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹6,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹7,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹8,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹9,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹10,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹12,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹15,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹18,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹20,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹25,000");
        AmbulanceWithDoctor.add("Ambulance With Doctor ₹30,000");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,AmbulanceWithDoctor);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinDoctor.setAdapter(arrayAdapter);
    }

    public void SetAmbulanceWithoutDoctor(){
        ArrayList<String> AmbulanceWithOutDoctor = new ArrayList<>();

        AmbulanceWithOutDoctor.add("Please Select Without Doctor Cost");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹500");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹750");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹1,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹1,500");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹2,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹2,500");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹3,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹3,500");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹4,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹4,500");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹5,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹6,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹7,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹8,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹9,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹10,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹11,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹12,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹13,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹14,000");
        AmbulanceWithOutDoctor.add("Ambulance Without Doctor ₹15,000");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,AmbulanceWithOutDoctor);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinWithOutDoctor.setAdapter(arrayAdapter);
    }

    public void SetAmbulanceWithAc(){
        ArrayList<String> AmbulanceWithAc = new ArrayList<>();

        AmbulanceWithAc.add("please Select With AC Cost");
        AmbulanceWithAc.add("Ambulance With AC ₹500");
        AmbulanceWithAc.add("Ambulance With AC ₹750");
        AmbulanceWithAc.add("Ambulance With AC ₹1,000");
        AmbulanceWithAc.add("Ambulance With AC ₹1,500");
        AmbulanceWithAc.add("Ambulance With AC ₹2,000");
        AmbulanceWithAc.add("Ambulance With AC ₹2,500");
        AmbulanceWithAc.add("Ambulance With AC ₹3,000");
        AmbulanceWithAc.add("Ambulance With AC ₹3,500");
        AmbulanceWithAc.add("Ambulance With AC ₹4,000");
        AmbulanceWithAc.add("Ambulance With AC ₹4,500");
        AmbulanceWithAc.add("Ambulance With AC ₹5,000");
        AmbulanceWithAc.add("Ambulance With AC ₹6,000");
        AmbulanceWithAc.add("Ambulance With AC ₹7,000");
        AmbulanceWithAc.add("Ambulance With AC ₹8,000");
        AmbulanceWithAc.add("Ambulance With AC ₹9,000");
        AmbulanceWithAc.add("Ambulance With AC ₹10,000");
        AmbulanceWithAc.add("Ambulance With AC ₹12,000");
        AmbulanceWithAc.add("Ambulance With AC ₹14,000");
        AmbulanceWithAc.add("Ambulance With AC ₹16,000");
        AmbulanceWithAc.add("Ambulance With AC ₹18,000");
        AmbulanceWithAc.add("Ambulance With AC ₹20,000");
        AmbulanceWithAc.add("Ambulance With AC ₹22,000");
        AmbulanceWithAc.add("Ambulance With AC ₹25,000");
        AmbulanceWithAc.add("Ambulance With AC ₹28,000");
        AmbulanceWithAc.add("Ambulance With AC ₹30,000");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,AmbulanceWithAc);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAC.setAdapter(arrayAdapter);

    }

    public void SetAmbulanceWithoutAc(){
        ArrayList<String> AmbulanceWithOutAc = new ArrayList<>();

        AmbulanceWithOutAc.add("please Select WithOut AC Cost");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹500");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹750");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹1,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹1,500");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹2,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹2,500");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹3,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹3,500");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹4,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹4,500");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹5,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹6,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹7,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹8,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹9,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹10,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹11,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹12,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹13,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹14,000");
        AmbulanceWithOutAc.add("Ambulance WithOut AC ₹15,000");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,AmbulanceWithOutAc);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinWithoutAC.setAdapter(arrayAdapter);

    }

    public void SetAmbulanceAllPackage(){
        ArrayList<String> AmbulanceWithAllPackage = new ArrayList<>();

        AmbulanceWithAllPackage.add("Please Select All Ambulance Kit Cost");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹5,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹7,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹10,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹12,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹15,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹18,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹20,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹22,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹25,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹28,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹30,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹35,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹40,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹45,000");
        AmbulanceWithAllPackage.add("Ambulance With Doctor + AC + All Features ₹50,000");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,AmbulanceWithAllPackage);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAmbulancePack.setAdapter(arrayAdapter);

    }

}