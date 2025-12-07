package com.example.hospitalmanagementsystem.NurseManageTask;

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


public class NurseAddDetailsFragment extends Fragment {

    EditText EdName,EdEmail,EdLocation,EdPhone;
    Spinner SpinGender,SpinQualification,SpinExperience;
    Button BtnSubmit;
    String name,email,Qualification,Experience,Gender,Location,Phone;
    NurseDataBase nurseDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nurse_add_details, container, false);

        EdName = view.findViewById(R.id.EdName);
        EdEmail = view.findViewById(R.id.EdEmail);
        SpinQualification = view.findViewById(R.id.SpinQualification);
        SpinExperience = view.findViewById(R.id.SpinExperience);
        EdLocation = view.findViewById(R.id.EdLocation);
        EdPhone = view.findViewById(R.id.EdPhone);
        SpinGender = view.findViewById(R.id.SpinGender);
        BtnSubmit = view.findViewById(R.id.BtnSubmit);
        nurseDataBase = new NurseDataBase(getContext());

        SelectQualification();
        SelectExperiences();
        SelectGender();

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertNurseData();
            }
        });

        SpinGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Gender = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        SpinQualification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Qualification = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    public void InsertNurseData() {
        name = EdName.getText().toString();
        email = EdEmail.getText().toString();
        Location = EdLocation.getText().toString();
        Phone = EdPhone.getText().toString();

        if (name.isEmpty()) {
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
        } else if (Location.isEmpty()) {
            EdLocation.requestFocus();
            EdLocation.setError("Location Can't Empty");
            return;
        } else if (!Location.matches("[a-zA-Z0-9 ]+")) {
            EdLocation.requestFocus();
            EdLocation.setError("Invalid Location Try Again...");
            return;
        } else if (Phone.isEmpty()) {
            EdPhone.requestFocus();
            EdPhone.setError("Phone Number Can't Empty");
            return;
        } else if (!Phone.matches("[0-9]+\\d{9}")) {
            EdPhone.requestFocus();
            EdPhone.setError("Invalid Try Again...");
            return;
        } if (Gender.equals("Please Select Gender")){
            Toast.makeText(getContext(), "Please Select Valid Gender Option", Toast.LENGTH_SHORT).show();
            return;
        } if (Qualification.equals("Please Select Qualification")){
            Toast.makeText(getContext(), "Please Select Valid Qualification Option", Toast.LENGTH_SHORT).show();
            return;
        } if (Experience.equals("Please Select Experience")){
            Toast.makeText(getContext(), "Please Select Valid Experience Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = nurseDataBase.InsertNurseData(name,email,Qualification,Experience,Gender,Location,Phone);
        if (b==true){
            Toast.makeText(getContext(), "Insert SuccessFully...", Toast.LENGTH_SHORT).show();
            EdName.setText("");
            EdEmail.setText("");
            EdLocation.setText("");
            EdPhone.setText("");
            SpinQualification.setSelection(0);
            SpinExperience.setSelection(0);
            SpinGender.setSelection(0);
        }else {
            Toast.makeText(getContext(), "Failed SuccessFully...", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectGender(){
        ArrayList<String> SelectGender = new ArrayList<>();
        SelectGender.add("Please Select Gender");
        SelectGender.add("Male");
        SelectGender.add("Female");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectGender);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinGender.setAdapter(arrayAdapter);
    }

    public void SelectQualification(){
        ArrayList<String> SelectQualification = new ArrayList<>();
        // Basic qualifications
        SelectQualification.add("Please Select Qualification");
        SelectQualification.add("ANM (Auxiliary Nurse Midwife)");
        SelectQualification.add("GNM (General Nursing and Midwifery)");
        SelectQualification.add("BSc Nursing");
        SelectQualification.add("Post Basic BSc Nursing");

// Advanced / Specialized qualifications
        SelectQualification.add("MSc Nursing");
        SelectQualification.add("PhD in Nursing");
        SelectQualification.add("Diploma in Critical Care Nursing");
        SelectQualification.add("Diploma in Psychiatric Nursing");
        SelectQualification.add("Diploma in Pediatric Nursing");
        SelectQualification.add("Diploma in Midwifery");
        SelectQualification.add("Diploma in Community Health Nursing");

// International / Other recognized nursing degrees
        SelectQualification.add("BSN (Bachelor of Science in Nursing)");
        SelectQualification.add("MSN (Master of Science in Nursing)");
        SelectQualification.add("DNP (Doctor of Nursing Practice)");

// Alternative entry-level qualifications (for assistants or aides)
        SelectQualification.add("Nursing Assistant Certificate");
        SelectQualification.add("Practical Nursing Diploma (LPN/LVN)");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectQualification);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinQualification.setAdapter(arrayAdapter);
    }

    public void SelectExperiences(){
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

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectExperience);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinExperience.setAdapter(arrayAdapter);
    }

}