package com.example.hospitalmanagementsystem.HospitalManageTask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

public class AddHospitalDetailsFragment extends Fragment {
    EditText EdHospitalName,EdEstablishedYear,EdHospitalEmail,EdLocation,EdPhone;
    Button BtnSubmit;
    HospitalDataBase hospitalDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_hospital_details, container, false);

        EdHospitalName = view.findViewById(R.id.EdHospitalName);
        EdEstablishedYear = view.findViewById(R.id.EdEstablishedYear);
        EdHospitalEmail = view.findViewById(R.id.EdHospitalEmail);
        EdLocation = view.findViewById(R.id.EdLocation);
        EdPhone = view.findViewById(R.id.EdPhone);
        BtnSubmit = view.findViewById(R.id.BtnSubmit);
        hospitalDataBase = new HospitalDataBase(getContext());


        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        return view;
    }

    public void InsertData(){
        String name,established,email,location,phone;

        name = EdHospitalName.getText().toString();
        established = EdEstablishedYear.getText().toString();
        email = EdHospitalEmail.getText().toString();
        location = EdLocation.getText().toString();
        phone = EdPhone.getText().toString();

        if (name.isEmpty()){
            EdHospitalName.requestFocus();
            EdHospitalName.setError("Name Can't Empty....");
            return;
        }else if (!name.matches("[a-zA-Z ]+")){
            EdHospitalName.requestFocus();
            EdHospitalName.setError("Invalid Name try again.....");
            return;
        }else if (established.isEmpty()){
            EdEstablishedYear.requestFocus();
            EdEstablishedYear.setError("Established year can't empty.....");
            return;
        }else if (!established.matches("[a-zA-Z0-9 ]+")){
            EdEstablishedYear.requestFocus();
            EdEstablishedYear.setError("Invalid Year try again.....");
            return;
        }else if (email.isEmpty()){
            EdHospitalEmail.requestFocus();
            EdHospitalEmail.setError("Email can't empty........");
            return;
        }else if (!email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+")){
            EdHospitalEmail.requestFocus();
            EdHospitalEmail.setError("Invalid Email try again.....");
            return;
        }else if (location.isEmpty()){
            EdLocation.requestFocus();
            EdLocation.setError("Location can't empty.....");
            return;
        }else if (!location.matches("[a-zA-Z0-9 ]+")){
            EdLocation.requestFocus();
            EdLocation.setError("Invalid Location try again.....");
            return;
        }else if (phone.isEmpty()){
            EdPhone.requestFocus();
            EdPhone.setError("Phone can't empty.....");
            return;
        }else if (!phone.matches("[0-9]+\\d{9}")){
            EdPhone.requestFocus();
            EdPhone.setError("Invalid Phone try again.....");
            return;
        }
        boolean b = hospitalDataBase.InsertHospitalData(name,established,email,location,phone);
        if (b==true){
            Toast.makeText(getContext(), "Insert SuccessFully....", Toast.LENGTH_SHORT).show();
            EdHospitalName.setText("");
            EdEstablishedYear.setText("");
            EdEstablishedYear.setText("");
            EdLocation.setText("");
            EdPhone.setText("");
        }else {
            Toast.makeText(getContext(), "Insert Failed....", Toast.LENGTH_SHORT).show();
        }

    }

}