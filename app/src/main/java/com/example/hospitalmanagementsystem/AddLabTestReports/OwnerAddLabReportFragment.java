package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;


public class OwnerAddLabReportFragment extends Fragment {
    EditText edName,edCondition,edPhone;
    Button btnSubmit;
    String name,condition,phone;
    OwnerAddReportDataBase ownerAddReportDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_owner_add_lab_report, container, false);

        edName = view.findViewById(R.id.edName);
        edCondition = view.findViewById(R.id.edCondition);
        edPhone = view.findViewById(R.id.edPhone);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        ownerAddReportDataBase = new OwnerAddReportDataBase(getContext());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertLabData();
            }
        });

        return view;
    }

    public void InsertLabData(){

        name = edName.getText().toString();
        condition = edCondition.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z0-9 ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        }else if (condition.isEmpty()) {
            edCondition.requestFocus();
            edCondition.setError("cost can't empty...");
            return;
        } else if (!condition.matches("[a-zA-Z0-9 ]+")) {
            edCondition.requestFocus();
            edCondition.setError("Invalid try again...");
            return;
        }else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }
        boolean b = ownerAddReportDataBase.OwnerInsertLabDataAdd(name,condition,phone);
        if (b==true){
            edName.setText("");
            edCondition.setText("");
            edPhone.setText("");
            Toast.makeText(getContext(), "Add Report SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }
}