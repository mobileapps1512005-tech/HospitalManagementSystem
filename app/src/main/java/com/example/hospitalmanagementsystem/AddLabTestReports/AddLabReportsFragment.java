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

public class AddLabReportsFragment extends Fragment {
EditText edName,edPart,edCost,edPhone;
Button btnSubmit;
String name,part,cost,phone;
LadReportsDataBase ladReportsDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_add_lab_reports, container, false);

           edName = view.findViewById(R.id.edName);
           edPart = view.findViewById(R.id.edPart);
           edCost = view.findViewById(R.id.edCost);
           edPhone = view.findViewById(R.id.edPhone);
           btnSubmit = view.findViewById(R.id.btnSubmit);
           ladReportsDataBase = new LadReportsDataBase(getContext());

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
        part = edPart.getText().toString();
        cost = edCost.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z0-9 ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        } else if (part.isEmpty()) {
            edPart.requestFocus();
            edPart.setError("part can't empty...");
            return;
        } else if (!part.matches("[a-zA-Z0-9 ]+")) {
            edPart.requestFocus();
            edPart.setError("Invalid try again...");
            return;
        }else if (cost.isEmpty()) {
            edCost.requestFocus();
            edCost.setError("cost can't empty...");
            return;
        } else if (!cost.matches("[a-zA-Z0-9 ]+")) {
            edCost.requestFocus();
            edCost.setError("Invalid try again...");
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
     boolean b = ladReportsDataBase.InsertLadData(name,part,cost,phone);
        if (b==true){
            edName.setText("");
            edPart.setText("");
            edCost.setText("");
            edPhone.setText("");
            Toast.makeText(getContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }
}