package com.example.hospitalmanagementsystem.MedicalReports;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.PharmacyManageTask.PharmacyDeleteAdapter;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;
import java.util.Calendar;


public class AddMedicalDetailsFragment extends Fragment {

    EditText edName,edPart,edDescribeReport,edPhone;
    TextView tvDate,tvTime;
    Spinner spinCondition;
    Button btnSubmit;
    String name,part,phone,describe,condition,dateFormate,timeFormate,date,time;
    MedicalReportsDataBase medicalReportsDataBase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_medical_details, container, false);

        edName = view.findViewById(R.id.edName);
        edPart = view.findViewById(R.id.edPart);
        edDescribeReport = view.findViewById(R.id.edDescribeReport);
        edPhone = view.findViewById(R.id.edPhone);
        tvDate = view.findViewById(R.id.tvDate);
        tvTime = view.findViewById(R.id.tvTime);
        spinCondition = view.findViewById(R.id.spinCondition);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        medicalReportsDataBase = new MedicalReportsDataBase(getContext());


        SelectDiscount();

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDate();
            }
        });

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTime();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDataCheckup();
            }
        });

        spinCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                condition = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    public void InsertDataCheckup(){

        name = edName.getText().toString();
        part = edPart.getText().toString();
        describe = edDescribeReport.getText().toString();
        phone = edPhone.getText().toString();
        date = tvDate.getText().toString();
        time = tvTime.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try Again...");
            return;
        } else if (part.isEmpty()) {
            edPart.requestFocus();
            edPart.setError("part can't empty...");
            return;
        } else if (!part.matches("[a-zA-Z0-9 ]+")) {
            edPart.requestFocus();
            edPart.setError("Invalid try again...");
            return;
        } else if (describe.isEmpty()) {
            edDescribeReport.requestFocus();
            edDescribeReport.setError("describe can't empty...");
            return;
        } else if (!describe.matches("[a-zA-Z ]+")) {
            edDescribeReport.requestFocus();
            edDescribeReport.setError("Invalid try again...");
            return;
        } else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }if (date.equals("Please Select Date")){
            Toast.makeText(getContext(), "Required Date can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }if (time.equals("Please Select Time")){
            Toast.makeText(getContext(), "Required Time can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        } if (condition.equals("Please Select Condition")){
            Toast.makeText(getContext(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = medicalReportsDataBase.InsertData(name,part,date,time,describe,condition,phone);
        if (b==true){
            edName.setText("");
            edPart.setText("");
            edDescribeReport.setText("");
            edPhone.setText("");
            spinCondition.setSelection(0);
            tvDate.setText("Please Select Date");
            tvTime.setText("Please Select Time");
            Toast.makeText(getContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }
    public void SelectDiscount(){

        ArrayList<String> condition = new ArrayList<>();
        condition.add("Please Select Condition");
        condition.add("Normal");
        condition.add("Serious");
        condition.add("Rare");
        condition.add("Critical");
        condition.add("Other");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,condition);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinCondition.setAdapter(arrayAdapter);

    }
    public void SelectDate(){
        Calendar calendar = Calendar.getInstance();
        int Days = calendar.get(Calendar.DAY_OF_MONTH);
        int Months = calendar.get(Calendar.MONTH);
        int Years = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateFormate = String.format("%02d/%02d/%02d",dayOfMonth,(month+1),year);
                tvDate.setText(dateFormate);
            }
        },Years,Months,Days);
        datePickerDialog.show();
    }
    public void SelectTime() {
        Calendar calendar = Calendar.getInstance();
        int Hours = calendar.get(Calendar.HOUR_OF_DAY);
        int Minutes = calendar.get(Calendar.MINUTE);
        int Second = calendar.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeFormate = String.format("%02d:%02d:%02d",hourOfDay,minute,Second);
                tvTime.setText(timeFormate);
            }
        }, Hours, Minutes, true);
        timePickerDialog.show();
    }


}