package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class AppointmentConfirmActivity extends AppCompatActivity {
    EditText EdName,EdEmail,EdPhone;
    Button BtnSubmit;
    Spinner SpinAvailable,SpinAvailableTime;
    DoctorConfirmAppointmentDataBase doctorConfirmAppointmentDataBase;
    String AvailableDay,AvailableTime;
    String name,email,phone;
    DoctorAppointmentDataBase doctorAppointmentDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointment_confirm);

        EdName = findViewById(R.id.EdName);
        EdEmail = findViewById(R.id.EdEmail);
        SpinAvailable = findViewById(R.id.SpinAvailable);
        SpinAvailableTime = findViewById(R.id.SpinAvailableTime);
        EdPhone = findViewById(R.id.EdPhone);
        BtnSubmit = findViewById(R.id.BtnSubmit);
        doctorConfirmAppointmentDataBase = new DoctorConfirmAppointmentDataBase(getApplicationContext());
        doctorAppointmentDataBase = new DoctorAppointmentDataBase(getApplicationContext());

          id  = getIntent().getIntExtra("id",0);
          EdName.setText(getIntent().getStringExtra("name"));
          EdEmail.setText(getIntent().getStringExtra("email"));
          EdPhone.setText(getIntent().getStringExtra("phone"));
          AvailableDay = getIntent().getStringExtra("day");
          AvailableTime = getIntent().getStringExtra("time");

        SelectAvailableDay();
        SelectAvailableTime();

        SpinAvailable.setEnabled(false);
        SpinAvailableTime.setEnabled(false);
        EdName.setEnabled(false);
        EdEmail.setEnabled(false);
        EdPhone.setEnabled(false);

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDoctorData();
            }
        });

        SpinAvailable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvailableDay = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinAvailableTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvailableTime = parent.getItemAtPosition(position).toString();
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

    public void SelectAvailableDay(){
        ArrayList<String> SelectDay = new ArrayList<>();
        // 🔹 Basic Days
        SelectDay.add("Please Select Available Day");
        SelectDay.add("All Days");
        SelectDay.add("Sun");
        SelectDay.add("Mon");
        SelectDay.add("Tue");
        SelectDay.add("Wed");
        SelectDay.add("Thu");
        SelectDay.add("Fri");
        SelectDay.add("Sat");

// 🔹 Common Combinations
        SelectDay.add("Mon,Wed,Fri");
        SelectDay.add("Tue,Thu,Sat");
        SelectDay.add("Sat,Sun");
        SelectDay.add("Sun,Mon");
        SelectDay.add("Mon,Tue,Wed,Thu,Fri");
        SelectDay.add("Mon,Tue,Wed,Thu,Fri,Sat");
        SelectDay.add("Mon,Wed");
        SelectDay.add("Tue,Thu");
        SelectDay.add("Sun,Fri");
        SelectDay.add("Sun,Wed");
        SelectDay.add("Sun,Thu");
        SelectDay.add("Weekends (Sat,Sun)");

// 🔹 All 3-Day Combinations (Total 35)
        SelectDay.add("Sun,Mon,Tue");
        SelectDay.add("Sun,Mon,Wed");
        SelectDay.add("Sun,Mon,Thu");
        SelectDay.add("Sun,Mon,Fri");
        SelectDay.add("Sun,Mon,Sat");
        SelectDay.add("Sun,Tue,Wed");
        SelectDay.add("Sun,Tue,Thu");
        SelectDay.add("Sun,Tue,Fri");
        SelectDay.add("Sun,Tue,Sat");
        SelectDay.add("Sun,Wed,Thu");
        SelectDay.add("Sun,Wed,Fri");
        SelectDay.add("Sun,Wed,Sat");
        SelectDay.add("Sun,Thu,Fri");
        SelectDay.add("Sun,Thu,Sat");
        SelectDay.add("Sun,Fri,Sat");
        SelectDay.add("Mon,Tue,Wed");
        SelectDay.add("Mon,Tue,Thu");
        SelectDay.add("Mon,Tue,Fri");
        SelectDay.add("Mon,Tue,Sat");
        SelectDay.add("Mon,Wed,Thu");
        SelectDay.add("Mon,Wed,Fri");
        SelectDay.add("Mon,Wed,Sat");
        SelectDay.add("Mon,Thu,Fri");
        SelectDay.add("Mon,Thu,Sat");
        SelectDay.add("Mon,Fri,Sat");
        SelectDay.add("Tue,Wed,Thu");
        SelectDay.add("Tue,Wed,Fri");
        SelectDay.add("Tue,Wed,Sat");
        SelectDay.add("Tue,Thu,Fri");
        SelectDay.add("Tue,Thu,Sat");
        SelectDay.add("Tue,Fri,Sat");
        SelectDay.add("Wed,Thu,Fri");
        SelectDay.add("Wed,Thu,Sat");
        SelectDay.add("Wed,Fri,Sat");
        SelectDay.add("Thu,Fri,Sat");

// 🔹 All 4-Day Combinations (Total 35)
        SelectDay.add("Sun,Mon,Tue,Wed");
        SelectDay.add("Sun,Mon,Tue,Thu");
        SelectDay.add("Sun,Mon,Tue,Fri");
        SelectDay.add("Sun,Mon,Tue,Sat");
        SelectDay.add("Sun,Mon,Wed,Thu");
        SelectDay.add("Sun,Mon,Wed,Fri");
        SelectDay.add("Sun,Mon,Wed,Sat");
        SelectDay.add("Sun,Mon,Thu,Fri");
        SelectDay.add("Sun,Mon,Thu,Sat");
        SelectDay.add("Sun,Mon,Fri,Sat");
        SelectDay.add("Sun,Tue,Wed,Thu");
        SelectDay.add("Sun,Tue,Wed,Fri");
        SelectDay.add("Sun,Tue,Wed,Sat");
        SelectDay.add("Sun,Tue,Thu,Fri");
        SelectDay.add("Sun,Tue,Thu,Sat");
        SelectDay.add("Sun,Tue,Fri,Sat");
        SelectDay.add("Sun,Wed,Thu,Fri");
        SelectDay.add("Sun,Wed,Thu,Sat");
        SelectDay.add("Sun,Wed,Fri,Sat");
        SelectDay.add("Sun,Thu,Fri,Sat");
        SelectDay.add("Mon,Tue,Wed,Thu");
        SelectDay.add("Mon,Tue,Wed,Fri");
        SelectDay.add("Mon,Tue,Wed,Sat");
        SelectDay.add("Mon,Tue,Thu,Fri");
        SelectDay.add("Mon,Tue,Thu,Sat");
        SelectDay.add("Mon,Tue,Fri,Sat");
        SelectDay.add("Mon,Wed,Thu,Fri");
        SelectDay.add("Mon,Wed,Thu,Sat");
        SelectDay.add("Mon,Wed,Fri,Sat");
        SelectDay.add("Mon,Thu,Fri,Sat");
        SelectDay.add("Tue,Wed,Thu,Fri");
        SelectDay.add("Tue,Wed,Thu,Sat");
        SelectDay.add("Tue,Wed,Fri,Sat");
        SelectDay.add("Tue,Thu,Fri,Sat");
        SelectDay.add("Wed,Thu,Fri,Sat");

        ArrayAdapter<String> arrayAdapterDay = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,SelectDay);
        arrayAdapterDay.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAvailable.setAdapter(arrayAdapterDay);

         if (SelectDay!=null){
             int position = arrayAdapterDay.getPosition(AvailableDay.trim());
             if (position>=0){
                 SpinAvailable.setSelection(position);
             }
         }

    }
    public void SelectAvailableTime(){
        ArrayList<String> SelectTime = new ArrayList<>();

        SelectTime.add("Please Select Available Time");
        SelectTime.add("Morning (medium): 06:00 - 09:00");
        SelectTime.add("Morning (medium): 07:00 - 10:00");
        SelectTime.add("Morning (early): 08:00 - 11:00");
        SelectTime.add("Morning (standard): 09:00 - 12:00");
        SelectTime.add("Morning (most common): 10:00 - 13:00");
        SelectTime.add("Noon (medium): 11:00 - 14:00");

        SelectTime.add("Noon (medium): 12:00 - 15:00");
        SelectTime.add("Afternoon (medium): 13:00 - 16:00");
        SelectTime.add("Afternoon (common): 14:00 - 17:00");
        SelectTime.add("Afternoon (medium): 15:00 - 18:00");
        SelectTime.add("Evening (standard): 16:00 - 19:00");

        SelectTime.add("Evening (very common): 17:00 - 20:00");
        SelectTime.add("Evening (common): 18:00 - 21:00");
        SelectTime.add("Late Evening (rare): 19:00 - 22:00");
        SelectTime.add("Night (medium): 20:00 - 23:00");

        SelectTime.add("Night (rare): 21:00 - 24:00");
        SelectTime.add("Night (rare): 22:00 - 01:00");
        SelectTime.add("Emergency (rare): 23:00 - 02:00");
        SelectTime.add("24x7 Emergency: Continuous");


        ArrayAdapter<String> arrayAdapterTime = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,SelectTime);
        arrayAdapterTime.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAvailableTime.setAdapter(arrayAdapterTime);

        if (SelectTime!=null){
            int position = arrayAdapterTime.getPosition(AvailableTime.trim());
            if (position>=0){
                SpinAvailableTime.setSelection(position);
            }
        }

    }
    public void InsertDoctorData(){
        name = EdName.getText().toString();
        email = EdEmail.getText().toString();
        phone = EdPhone.getText().toString();

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
        } else if (phone.isEmpty()) {
            EdPhone.requestFocus();
            EdPhone.setError("Phone Number Can't Empty");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            EdPhone.requestFocus();
            EdPhone.setError("Invalid Try Again...");
            return;
        } if (AvailableDay.equals("Please Select Available Day")){
            Toast.makeText(getApplication(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        } if (AvailableTime.equals("Please Select Available Time")){
            Toast.makeText(getApplication(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = doctorConfirmAppointmentDataBase.InsertDrConAppointmentData(name,email,AvailableDay,AvailableTime,phone);
        if (b==true){
            Toast.makeText(getApplication(), "Confirm SuccessFully...", Toast.LENGTH_SHORT).show();
            EdName.setText("");
            EdEmail.setText("");
            EdPhone.setText("");
            SpinAvailable.setSelection(0);
            SpinAvailableTime.setSelection(0);
            doctorAppointmentDataBase.GetDeleteAppointmentDetails(id);
        } else {
            Toast.makeText(getApplication(), "Confirm Failed...", Toast.LENGTH_SHORT).show();
        }
    }
}