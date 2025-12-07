package com.example.hospitalmanagementsystem.PatientBillings;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

import com.example.hospitalmanagementsystem.AmbulanceManageTask.AmbulanceDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;
import java.util.Calendar;


public class PatientAddDetailsFragment extends Fragment {
EditText edHospital,edName,edEmail,edPhone,edCost;
Spinner spinDiscount,spinTypeBill;
TextView tvDate,tvTime;
Button btnSubmit;
PatientBillingDataBase patientBillingDataBase;
String hospital,name,email,phone,typeBill,discount,cost,date,time,DateFormate,TimeFormate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_patient_add_details, container, false);

        edHospital = view.findViewById(R.id.edHospital);
        edName = view.findViewById(R.id.edName);
        edEmail = view.findViewById(R.id.edEmail);
        edPhone = view.findViewById(R.id.edPhone);
        edCost = view.findViewById(R.id.edCost);
        spinTypeBill = view.findViewById(R.id.spinTypeBill);
        spinDiscount = view.findViewById(R.id.spinDiscount);
        tvDate = view.findViewById(R.id.tvDate);
        tvTime = view.findViewById(R.id.tvTime);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        patientBillingDataBase = new PatientBillingDataBase(getContext());

       SelectTypeOfBilling();
       selectDiscountType();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               BillingInsertData();
            }
        });

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

        spinTypeBill.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeBill = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinDiscount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              discount = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public void BillingInsertData(){
        hospital = edHospital.getText().toString();
        name = edName.getText().toString();
        email = edEmail.getText().toString();
        phone = edPhone.getText().toString();
        cost = edCost.getText().toString();
        date = tvDate.getText().toString();
        time = tvTime.getText().toString();

        if (hospital.isEmpty()){
            edHospital.requestFocus();
            edHospital.setError("hospital can't empty...");
            return;
        } else if (!hospital.matches("[a-zA-Z0-9 ]+")) {
            edHospital.requestFocus();
            edHospital.setError("Invalid try again...");
            return;
        } else if (name.isEmpty()) {
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        } else if (email.isEmpty()) {
            edEmail.requestFocus();
            edEmail.setError("email can't empty...");
            return;
        } else if (!email.matches("[a-zA-Z-0-9]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
            edEmail.requestFocus();
            edEmail.setError("Invalid try again...");
            return;
        }else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty...");
            return;
        } else if (!phone.matches("[0-9]+")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }else if (cost.isEmpty()) {
            edCost.requestFocus();
            edCost.setError("cost can't empty...");
            return;
        } else if (!cost.matches("[a-zA-Z0-9 ]+")) {
            edCost.requestFocus();
            edCost.setError("Invalid try again..");
            return;
        } if (typeBill.equals("Please Select Billing Type")){
            Toast.makeText(getContext(), "Please Select Valid Billing Option", Toast.LENGTH_SHORT).show();
            return;
        } if (discount.equals("Please Select Discount")){
            Toast.makeText(getContext(), "Please Select Valid Discount Option", Toast.LENGTH_SHORT).show();
            return;
        } if (date.equals("Please Select Date")) {
            Toast.makeText(getContext(), "Please Select Date", Toast.LENGTH_SHORT).show();
            return;
        } if (time.equals("Please Select Time")) {
            Toast.makeText(getContext(), "Please Select Time", Toast.LENGTH_SHORT).show();
            return;
        }
     boolean b = patientBillingDataBase.InsertBillingData(hospital,name,email,phone,cost,discount,typeBill,date,time);
       if (b==true){
           edHospital.setText("");
           edName.setText("");
           edEmail.setText("");
           edPhone.setText("");
           edCost.setText("");
           spinTypeBill.setSelection(0);
           spinDiscount.setSelection(0);
           tvDate.setText("Please Select Date");
           tvTime.setText("Please Select Time");
           Toast.makeText(getContext(), "SuccessFully...", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(getContext(), "Failed....", Toast.LENGTH_SHORT).show();
       }
    }
    public void SelectTypeOfBilling(){
        ArrayList<String> selectTypeBill = new ArrayList<>();

        selectTypeBill.add("Please Select Billing Type");
        selectTypeBill.add("OPD Billing");
        selectTypeBill.add("IPD Billing");
        selectTypeBill.add("Emergency Billing");
        selectTypeBill.add("Laboratory Billing");
        selectTypeBill.add("Radiology Billing");
        selectTypeBill.add("Pharmacy Billing");
        selectTypeBill.add("Surgery Billing");
        selectTypeBill.add("Nursing Charges");
        selectTypeBill.add("Room Charges");
        selectTypeBill.add("Consultation Charges");
        selectTypeBill.add("Procedure Charges");
        selectTypeBill.add("Package Billing");
        selectTypeBill.add("Insurance Billing");
        selectTypeBill.add("Corporate Billing");
        selectTypeBill.add("Cash Billing");
        selectTypeBill.add("Credit Billing");
        selectTypeBill.add("Miscellaneous Charges");

// More billing types
        selectTypeBill.add("Physiotherapy Billing");
        selectTypeBill.add("Dialysis Billing");
        selectTypeBill.add("Blood Bank Billing");
        selectTypeBill.add("Ambulance Billing");
        selectTypeBill.add("Ventilator Charges");
        selectTypeBill.add("ICU Charges");
        selectTypeBill.add("NICU Charges");
        selectTypeBill.add("PICU Charges");
        selectTypeBill.add("Operation Theater Charges");
        selectTypeBill.add("Anesthesia Charges");
        selectTypeBill.add("Endoscopy Billing");
        selectTypeBill.add("Chemotherapy Billing");
        selectTypeBill.add("Radiotherapy Billing");
        selectTypeBill.add("Vaccination Billing");
        selectTypeBill.add("Home Care Billing");
        selectTypeBill.add("Telemedicine Billing");
        selectTypeBill.add("Mortuary Billing");
        selectTypeBill.add("Medical Equipment Rental");
        selectTypeBill.add("Dietary Charges");
        selectTypeBill.add("Biomedical Waste Charges");
        selectTypeBill.add("Case Paper Charges");
        selectTypeBill.add("Registration Charges");
        selectTypeBill.add("Admission Charges");
        selectTypeBill.add("Discharge Summary Charges");
        selectTypeBill.add("Medical Certificate Charges");
        selectTypeBill.add("Attendant Charges");
        selectTypeBill.add("Monitoring Charges");
        selectTypeBill.add("Dressing Charges");
        selectTypeBill.add("Consumables Charges");
        selectTypeBill.add("Ward Upgradation Charges");
        selectTypeBill.add("Health Checkup Billing");
        selectTypeBill.add("Medicine Billing");
        selectTypeBill.add("Medicine Return Billing");
        selectTypeBill.add("Pharmacy Discount Billing");
        selectTypeBill.add("Pharmacy Credit Billing");
        selectTypeBill.add("Ambulance Billing");
        selectTypeBill.add("Ambulance Oxygen Charges");
        selectTypeBill.add("Ambulance Mileage Charges");
        selectTypeBill.add("Ambulance Emergency Team Charges");
        selectTypeBill.add("Ambulance Night Charges");
        selectTypeBill.add("Ambulance Waiting Charges");
        selectTypeBill.add("Air Ambulance Billing");
        selectTypeBill.add("Ward Charges");
        selectTypeBill.add("General Ward Charges");
        selectTypeBill.add("Private Room Charges");
        selectTypeBill.add("Deluxe Room Charges");
        selectTypeBill.add("Semi-Private Room Charges");

        selectTypeBill.add("Bed Charges");
        selectTypeBill.add("Stretcher Charges");
        selectTypeBill.add("Wheelchair Charges");

        selectTypeBill.add("Dressing Charges");
        selectTypeBill.add("Injection Charges");
        selectTypeBill.add("Nebulization Charges");

        selectTypeBill.add("ECG Charges");
        selectTypeBill.add("EEG Charges");
        selectTypeBill.add("EMG Charges");
        selectTypeBill.add("Echo Charges");
        selectTypeBill.add("TMT Charges");

        selectTypeBill.add("Ultrasound Billing");
        selectTypeBill.add("CT Scan Billing");
        selectTypeBill.add("MRI Billing");
        selectTypeBill.add("X-Ray Billing");

        selectTypeBill.add("Blood Transfusion Charges");
        selectTypeBill.add("Plasma Charges");
        selectTypeBill.add("Platelet Charges");

        selectTypeBill.add("Ventilator Charges");
        selectTypeBill.add("Oxygen Charges");
        selectTypeBill.add("Nebulizer Charges");

        selectTypeBill.add("Nursing Procedure Charges");
        selectTypeBill.add("Catheterization Charges");
        selectTypeBill.add("Cannula Charges");
        selectTypeBill.add("Syringe/Needle Charges");

        selectTypeBill.add("Doctor Visit Charges");
        selectTypeBill.add("Specialist Consultation Billing");
        selectTypeBill.add("Follow-Up Consultation Billing");

        selectTypeBill.add("Physiotherapy Session Billing");
        selectTypeBill.add("Occupational Therapy Billing");

        selectTypeBill.add("Dialysis Session Billing");
        selectTypeBill.add("Chemotherapy Session Billing");
        selectTypeBill.add("Radiotherapy Session Billing");

        selectTypeBill.add("Endoscopy Billing");
        selectTypeBill.add("Colonoscopy Billing");
        selectTypeBill.add("Bronchoscopy Billing");

        selectTypeBill.add("ICU Charges");
        selectTypeBill.add("HDU Charges");
        selectTypeBill.add("NICU Charges");
        selectTypeBill.add("PICU Charges");

        selectTypeBill.add("Emergency Room Charges");
        selectTypeBill.add("Trauma Care Billing");

        selectTypeBill.add("Surgery Charges");
        selectTypeBill.add("Anesthesia Charges");
        selectTypeBill.add("Operation Theater Charges");

        selectTypeBill.add("Admission Charges");
        selectTypeBill.add("Registration Charges");
        selectTypeBill.add("File Charges");
        selectTypeBill.add("Discharge Processing Charges");

        selectTypeBill.add("Health Checkup Package Billing");
        selectTypeBill.add("Corporate Health Package Billing");
        selectTypeBill.add("Insurance Claim Processing Charges");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,selectTypeBill);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinTypeBill.setAdapter(arrayAdapter);


     }
    public void selectDiscountType(){
    ArrayList<String> selectDiscount = new ArrayList<>();
        selectDiscount.add("Please Select Discount");
// Rupees Discount Billing (Increment ₹500)
        selectDiscount.add("Discount Rs. 500");
        selectDiscount.add("Discount Rs. 1000");
        selectDiscount.add("Discount Rs. 1500");
        selectDiscount.add("Discount Rs. 2000");
        selectDiscount.add("Discount Rs. 2500");
        selectDiscount.add("Discount Rs. 3000");
        selectDiscount.add("Discount Rs. 3500");
        selectDiscount.add("Discount Rs. 4000");
        selectDiscount.add("Discount Rs. 4500");
        selectDiscount.add("Discount Rs. 5000");
        selectDiscount.add("Discount Rs. 5500");
        selectDiscount.add("Discount Rs. 6000");
        selectDiscount.add("Discount Rs. 6500");
        selectDiscount.add("Discount Rs. 7000");
        selectDiscount.add("Discount Rs. 7500");
        selectDiscount.add("Discount Rs. 8000");
        selectDiscount.add("Discount Rs. 8500");
        selectDiscount.add("Discount Rs. 9000");
        selectDiscount.add("Discount Rs. 9500");
        selectDiscount.add("Discount Rs. 10000");
        selectDiscount.add("Discount Rs. 10500");
        selectDiscount.add("Discount Rs. 11000");
        selectDiscount.add("Discount Rs. 11500");
        selectDiscount.add("Discount Rs. 12000");
        selectDiscount.add("Discount Rs. 12500");
        selectDiscount.add("Discount Rs. 13000");
        selectDiscount.add("Discount Rs. 13500");
        selectDiscount.add("Discount Rs. 14000");
        selectDiscount.add("Discount Rs. 14500");
        selectDiscount.add("Discount Rs. 15000");
        selectDiscount.add("Discount Rs. 15500");
        selectDiscount.add("Discount Rs. 16000");
        selectDiscount.add("Discount Rs. 16500");
        selectDiscount.add("Discount Rs. 17000");
        selectDiscount.add("Discount Rs. 17500");
        selectDiscount.add("Discount Rs. 18000");
        selectDiscount.add("Discount Rs. 18500");
        selectDiscount.add("Discount Rs. 19000");
        selectDiscount.add("Discount Rs. 19500");
        selectDiscount.add("Discount Rs. 20000");

        selectDiscount.add("Discount Rs. 20500");
        selectDiscount.add("Discount Rs. 21000");
        selectDiscount.add("Discount Rs. 21500");
        selectDiscount.add("Discount Rs. 22000");
        selectDiscount.add("Discount Rs. 22500");
        selectDiscount.add("Discount Rs. 23000");
        selectDiscount.add("Discount Rs. 23500");
        selectDiscount.add("Discount Rs. 24000");
        selectDiscount.add("Discount Rs. 24500");
        selectDiscount.add("Discount Rs. 25000");
        selectDiscount.add("Discount Rs. 25500");
        selectDiscount.add("Discount Rs. 26000");
        selectDiscount.add("Discount Rs. 26500");
        selectDiscount.add("Discount Rs. 27000");
        selectDiscount.add("Discount Rs. 27500");
        selectDiscount.add("Discount Rs. 28000");
        selectDiscount.add("Discount Rs. 28500");
        selectDiscount.add("Discount Rs. 29000");
        selectDiscount.add("Discount Rs. 29500");
        selectDiscount.add("Discount Rs. 30000");
        selectDiscount.add("Discount Rs. 30500");
        selectDiscount.add("Discount Rs. 31000");
        selectDiscount.add("Discount Rs. 31500");
        selectDiscount.add("Discount Rs. 32000");
        selectDiscount.add("Discount Rs. 32500");
        selectDiscount.add("Discount Rs. 33000");
        selectDiscount.add("Discount Rs. 33500");
        selectDiscount.add("Discount Rs. 34000");
        selectDiscount.add("Discount Rs. 34500");
        selectDiscount.add("Discount Rs. 35000");
        selectDiscount.add("Discount Rs. 35500");
        selectDiscount.add("Discount Rs. 36000");
        selectDiscount.add("Discount Rs. 36500");
        selectDiscount.add("Discount Rs. 37000");
        selectDiscount.add("Discount Rs. 37500");
        selectDiscount.add("Discount Rs. 38000");
        selectDiscount.add("Discount Rs. 38500");
        selectDiscount.add("Discount Rs. 39000");
        selectDiscount.add("Discount Rs. 39500");
        selectDiscount.add("Discount Rs. 40000");
        selectDiscount.add("Discount Rs. 40500");
        selectDiscount.add("Discount Rs. 41000");
        selectDiscount.add("Discount Rs. 41500");
        selectDiscount.add("Discount Rs. 42000");
        selectDiscount.add("Discount Rs. 42500");
        selectDiscount.add("Discount Rs. 43000");
        selectDiscount.add("Discount Rs. 43500");
        selectDiscount.add("Discount Rs. 44000");
        selectDiscount.add("Discount Rs. 44500");
        selectDiscount.add("Discount Rs. 45000");
        selectDiscount.add("Discount Rs. 45500");
        selectDiscount.add("Discount Rs. 46000");
        selectDiscount.add("Discount Rs. 46500");
        selectDiscount.add("Discount Rs. 47000");
        selectDiscount.add("Discount Rs. 47500");
        selectDiscount.add("Discount Rs. 48000");
        selectDiscount.add("Discount Rs. 48500");
        selectDiscount.add("Discount Rs. 49000");
        selectDiscount.add("Discount Rs. 49500");
        selectDiscount.add("Discount Rs. 50000");

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,selectDiscount);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinDiscount.setAdapter(arrayAdapter);

    }
    public void SelectDate(){

        Calendar calendar = Calendar.getInstance();
        int Date = calendar.get(Calendar.DAY_OF_MONTH);
        int MonthOfDay = calendar.get(Calendar.MONTH);
        int Years = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
              DateFormate = String.format("%02d/%02d/%02d",dayOfMonth,(month+1),year);
              tvDate.setText(DateFormate);
            }
        },Years,MonthOfDay,Date);
        datePickerDialog.show();
    }
    public void SelectTime(){
        Calendar calendar = Calendar.getInstance();
        int Hours = calendar.get(Calendar.HOUR_OF_DAY);
        int Minutes = calendar.get(Calendar.MINUTE);
        int Second = calendar.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                TimeFormate = String.format("%02d:%02d:%02d",hourOfDay,minute,Second);
                tvTime.setText(TimeFormate);
            }
        },Hours,Minutes,true);
        timePickerDialog.show();
    }
}