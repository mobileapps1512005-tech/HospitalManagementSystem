package com.example.hospitalmanagementsystem.BloodManage;

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

import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;
import java.util.Arrays;


public class AddBloodFragment extends Fragment {
    EditText edHospital,edPhone;
    Button BtnSubmit;
    Spinner SpinBloodType,SpinBloodQuantity;
    String Blood,Quantity;
    String hospital,phone;
    BloodDataBase bloodDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_add_blood, container, false);

        edHospital = view.findViewById(R.id.edHospital);
        edPhone = view.findViewById(R.id.edPhone);
        SpinBloodType = view.findViewById(R.id.SpinBloodType);
        SpinBloodQuantity = view.findViewById(R.id.SpinBloodQuantity);
        bloodDataBase = new BloodDataBase(getContext());
        BtnSubmit = view.findViewById(R.id.BtnSubmit);

        SelectBloodType();
        SelectBloodQuantity();

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDoctorData();
            }
        });

        SpinBloodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Blood = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinBloodQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Quantity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public void InsertDoctorData(){
        hospital = edHospital.getText().toString();
        phone = edPhone.getText().toString();

        if (hospital.isEmpty()){
            edHospital.requestFocus();
            edHospital.setError("Hospital Can't Empty...");
            return;
        } else if (!hospital.matches("[a-zA-Z ]+")) {
            edHospital.requestFocus();
            edHospital.setError("Invalid Name Try Again...");
            return;
        } else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("Phone Can't Empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        } if (Blood.equals("Please Select Blood Group")){
            Toast.makeText(getContext(), "Please Select Valid Blood Group", Toast.LENGTH_SHORT).show();
            return;
        }if (Quantity.equals("Please Select Quantity")){
            Toast.makeText(getContext(), "Please Select Valid Quantity", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = bloodDataBase.InsertBloodDetails(hospital,Blood,Quantity,phone);
        if (b==true){
            Toast.makeText(getContext(), "SuccessFully...", Toast.LENGTH_SHORT).show();
            edHospital.setText("");
            edPhone.setText("");
            SpinBloodType.setSelection(0);
            SpinBloodQuantity.setSelection(0);
        } else {
            Toast.makeText(getContext(), "Data Failed...", Toast.LENGTH_SHORT).show();
        }
    }
    public void SelectBloodType(){


        ArrayList<String> BloodGroups = new ArrayList<>();
        BloodGroups.add("Please Select Blood Group");
        BloodGroups.add("A Positive (A+)");
        BloodGroups.add("A Negative (A-)");
        BloodGroups.add("B Positive (B+)");
        BloodGroups.add("B Negative (B-)");
        BloodGroups.add("AB Positive (AB+)");
        BloodGroups.add("AB Negative (AB-)");
        BloodGroups.add("O Positive (O+)");
        BloodGroups.add("O Negative (O-)");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,BloodGroups);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinBloodType.setAdapter(arrayAdapter);

    }
    public void SelectBloodQuantity(){

        ArrayList<String> SelectQuantityNumber = new ArrayList<>();

        SelectQuantityNumber.add("Please Select Quantity");

        for (int i = 1; i <= 50; i++) {
            SelectQuantityNumber.add("Available Quantity " + i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectQuantityNumber);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinBloodQuantity.setAdapter(arrayAdapter);

    }

}