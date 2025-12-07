package com.example.hospitalmanagementsystem.DoctorManageTask;

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

import com.example.hospitalmanagementsystem.PatientBillings.PatientBillingDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;


public class MediSuggestFragment extends Fragment {
EditText edHospital,edDoctor,edPhone,edName,edMedicine;
Spinner spinTreatment;
String hospital,doctor,phone,name,treatment,medicine;
Button btnSubmit;
MedSuggestDataBase medSuggestDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medi_suggest, container, false);

        edHospital = view.findViewById(R.id.edHospital);
        edDoctor = view.findViewById(R.id.edDoctor);
        edName = view.findViewById(R.id.edName);
        edPhone = view.findViewById(R.id.edPhone);
        spinTreatment = view.findViewById(R.id.spinTreatment);
        edMedicine = view.findViewById(R.id.edMedicine);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        medSuggestDataBase = new MedSuggestDataBase(getContext());

        SelectTypeOfTreatment();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedSuggestInsertData();
            }
        });

        spinTreatment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                treatment = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }

    public void MedSuggestInsertData(){

        hospital = edHospital.getText().toString();
        doctor = edDoctor.getText().toString();
        name = edName.getText().toString();
        phone = edPhone.getText().toString();
        medicine = edMedicine.getText().toString();
        
        if (hospital.isEmpty()){
            edHospital.requestFocus();
            edHospital.setError("hospital can't empty...");
            return;
        } else if (!hospital.matches("[a-zA-Z0-9 ]+")) {
            edHospital.requestFocus();
            edHospital.setError("Invalid try again...");
            return;
        }else if (doctor.isEmpty()) {
            edDoctor.requestFocus();
            edDoctor.setError("doctor can't empty...");
            return;
        } else if (!doctor.matches("[a-zA-Z-0-9 ]+")) {
            edDoctor.requestFocus();
            edDoctor.setError("Invalid try again...");
            return;
        }else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }  else if (name.isEmpty()) {
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        } else if (medicine.isEmpty()) {
            edMedicine.requestFocus();
            edMedicine.setError("medicine can't empty...");
            return;
        } else if (!medicine.matches("[a-zA-Z0-9-,/': ]+")) {
            edMedicine.requestFocus();
            edMedicine.setError("Invalid try again..");
            return;
        } if (treatment.equals("Please Select Treatment")) {
            Toast.makeText(getContext(), "Select Valid Treatment Option...", Toast.LENGTH_SHORT).show();
             return;
        }
        boolean b = medSuggestDataBase.InsertDataMed(hospital,doctor,phone,name,treatment,medicine);
        if (b==true){
            edHospital.setText("");
            edDoctor.setText("");
            edName.setText("");
            edPhone.setText("");
            edMedicine.setText("");
            spinTreatment.setSelection(0);
            Toast.makeText(getContext(), "SuccessFully...", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Failed....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectTypeOfTreatment(){
        ArrayList<String> treatmentList = new ArrayList<>();
        treatmentList.add("Please Select Treatment");
        treatmentList.add("OPD");
        treatmentList.add("IPD");
        treatmentList.add("Emergency");
        treatmentList.add("Package");
        treatmentList.add("Insurance");
        treatmentList.add("Corporate");
        treatmentList.add("Cash");
        treatmentList.add("Credit");
        treatmentList.add("Miscellaneous");

// ----- Department Treatments -----
        treatmentList.add("Laboratory");
        treatmentList.add("Radiology");
        treatmentList.add("Pharmacy");
        treatmentList.add("Surgery");
        treatmentList.add("Endoscopy");
        treatmentList.add("Chemotherapy");
        treatmentList.add("Radiotherapy");
        treatmentList.add("Physiotherapy");
        treatmentList.add("Dialysis");
        treatmentList.add("Blood Bank");
        treatmentList.add("Home Care");
        treatmentList.add("Telemedicine");
        treatmentList.add("Vaccination");
        treatmentList.add("Health Checkup");
        treatmentList.add("Health Checkup Package");
        treatmentList.add("Corporate Health Package");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,treatmentList);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinTreatment.setAdapter(arrayAdapter);


    }

}