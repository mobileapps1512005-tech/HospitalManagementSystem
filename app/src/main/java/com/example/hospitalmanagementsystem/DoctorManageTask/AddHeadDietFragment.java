package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;


public class AddHeadDietFragment extends Fragment {
EditText edName,edAge,edMorning,edLunch,edDinner,edDoctor,edPhone;
Button btnSubmit;
String name,age,morning,lunch,dinner,doctor,phone;
HealDietDataBase healDietDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_add_head_diet, container, false);


        edName = view.findViewById(R.id.edName);
        edAge = view.findViewById(R.id.edAge);
        edMorning = view.findViewById(R.id.edMorning);
        edLunch = view.findViewById(R.id.edLunch);
        edDinner = view.findViewById(R.id.edDinner);
        edDoctor = view.findViewById(R.id.edDoctor);
        edPhone = view.findViewById(R.id.edPhone);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        healDietDataBase = new HealDietDataBase(getContext());


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              InsertData();
            }
        });

        return  view;
    }

    public void InsertData(){

        name = edName.getText().toString();
        age = edAge.getText().toString();
        morning = edMorning.getText().toString();
        lunch = edLunch.getText().toString();
        dinner = edDinner.getText().toString();
        doctor = edDoctor.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
           edName.requestFocus();
           edName.setError("Name Can't Empty...");
           return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again....");
            return;
        } else if (age.isEmpty()){
            edAge.requestFocus();
            edAge.setError("Age Can't Empty...");
            return;
        } else if (!age.matches("[0-9/| ]+")) {
            edAge.requestFocus();
            edAge.setError("Invalid try again....");
            return;
        } else if (morning.isEmpty()){
            edMorning.requestFocus();
            edMorning.setError("Morning Can't Empty...");
            return;
        } else if (!morning.matches("[a-zA-Z0-9,/| ]+")) {
            edMorning.requestFocus();
            edMorning.setError("Invalid try again....");
            return;
        }else if (lunch.isEmpty()){
            edLunch.requestFocus();
            edLunch.setError("Lunch Can't Empty...");
            return;
        } else if (!lunch.matches("[a-zA-Z0-9,/| ]+")) {
            edLunch.requestFocus();
            edLunch.setError("Invalid try again....");
            return;
        } else if (dinner.isEmpty()){
            edDinner.requestFocus();
            edDinner.setError("Dinner Can't Empty...");
            return;
        } else if (!dinner.matches("[a-zA-Z0-9,/| ]+")) {
            edDinner.requestFocus();
            edDinner.setError("Invalid try again....");
            return;
        } else if (doctor.isEmpty()){
            edDoctor.requestFocus();
            edDoctor.setError("Doctor Can't Empty...");
            return;
        } else if (!doctor.matches("[a-zA-Z0-9 ]+")) {
            edDoctor.requestFocus();
            edDoctor.setError("Invalid try again....");
            return;
        } else if (phone.isEmpty()){
            edPhone.requestFocus();
            edPhone.setError("Phone Can't Empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again....");
            return;
        }
      boolean b = healDietDataBase.InsertDataHeal(name,age,morning,lunch,dinner,doctor,phone);
        if (b==true){
            Toast.makeText(getContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
            edName.setText("");
            edAge.setText("");
            edMorning.setText("");
            edLunch.setText("");
            edDinner.setText("");
            edDoctor.setText("");
            edPhone.setText("");
        }else {
            Toast.makeText(getContext(), "Failed....", Toast.LENGTH_SHORT).show();
        }
    }
}