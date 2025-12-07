package com.example.hospitalmanagementsystem.MedicalReports;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;
import java.util.Calendar;

public class UpdateMedicalActivity extends AppCompatActivity {
    EditText edName,edPart,edDescribeReport,edPhone;
    TextView tvDate,tvTime;
    Spinner spinCondition;
    Button btnSubmit;
    String name,part,phone,describe,conditions,dateFormate,timeFormate,date,time;
    MedicalReportsDataBase medicalReportsDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_medical);

        edName = findViewById(R.id.edName);
        edPart = findViewById(R.id.edPart);
        edDescribeReport = findViewById(R.id.edDescribeReport);
        edPhone = findViewById(R.id.edPhone);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        spinCondition = findViewById(R.id.spinCondition);
        btnSubmit = findViewById(R.id.btnSubmit);
        medicalReportsDataBase = new MedicalReportsDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        edName.setText(getIntent().getStringExtra("name"));
        edPart.setText(getIntent().getStringExtra("part"));
        tvDate.setText(getIntent().getStringExtra("date"));
        tvTime.setText(getIntent().getStringExtra("time"));
        conditions =  getIntent().getStringExtra("conditions");
        edDescribeReport.setText(getIntent().getStringExtra("describe"));
        edPhone.setText(getIntent().getStringExtra("phone"));



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
                conditions = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
            Toast.makeText(getApplicationContext(), "Required Date can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }if (time.equals("Please Select Time")){
            Toast.makeText(getApplicationContext(), "Required Time can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }if (conditions.equals("Please Select Condition")){
            Toast.makeText(this, "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = medicalReportsDataBase.UpdateMedicals(id,name,part,date,time,conditions,describe,phone);
        if (b==true){
            edName.setText("");
            edPart.setText("");
            edDescribeReport.setText("");
            edPhone.setText("");
            spinCondition.setSelection(0);
            tvDate.setText("Please Select Date");
            tvTime.setText("Please Select Time");
            Toast.makeText(getApplicationContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Failed...", Toast.LENGTH_SHORT).show();
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

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,condition);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinCondition.setAdapter(arrayAdapter);

          if (condition!=null) {
              int position = arrayAdapter.getPosition(condition.toString());
              if (position > 0) {
                  spinCondition.setSelection(position);
              }
          }

    }
    public void SelectDate(){
        Calendar calendar = Calendar.getInstance();
        int Days = calendar.get(Calendar.DAY_OF_MONTH);
        int Months = calendar.get(Calendar.MONTH);
        int Years = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(UpdateMedicalActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        int Hours = calendar.get(Calendar.HOUR);
        int Minutes = calendar.get(Calendar.MINUTE);
        int Second = calendar.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(UpdateMedicalActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeFormate = String.format("%02d:%02d:%02d",hourOfDay,minute,Second);
                tvTime.setText(timeFormate);
            }
        }, Hours, Minutes, true);
        timePickerDialog.show();
    }

}