package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

import java.util.Calendar;

public class MedicineOrderFragment extends Fragment {
    EditText edName, edEmail, edPhone, edLocation, edDeliveryLocation, etMedicineName;
    Button btnSubmit;
    TextView tvOrderDate, tvRequiredTime, tvRequiredDate;
    String  name,email,Phone,Location,deliveryLocation,medicineName,Formates1,Formates2,Formates3,order,requiredDate,requiredTime;
    PatientMedicineOrderDataBase patientMedicineOrderDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_order, container, false);

        edName = view.findViewById(R.id.edName);
        edEmail = view.findViewById(R.id.edEmail);
        edPhone = view.findViewById(R.id.edPhone);
        edLocation = view.findViewById(R.id.edLocation);
        edDeliveryLocation = view.findViewById(R.id.edDeliveryLocation);
        etMedicineName = view.findViewById(R.id.etMedicineName);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        tvOrderDate = view.findViewById(R.id.tvOrderDate);
        tvRequiredDate = view.findViewById(R.id.tvRequiredDate);
        tvRequiredTime = view.findViewById(R.id.tvRequiredTime);
        patientMedicineOrderDataBase = new PatientMedicineOrderDataBase(getContext());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertMedicineDetails();
            }
        });

        tvOrderDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectOrderDate();
            }
        });

        tvRequiredDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectRequiredDate();
            }
        });

        tvRequiredTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectRequiredTime();
            }
        });

        return view;
    }

    public void InsertMedicineDetails() {
        // Trim all input to remove spaces
        name = edName.getText().toString().trim();
        email = edEmail.getText().toString().trim();
        Location = edLocation.getText().toString().trim();
        Phone = edPhone.getText().toString().trim();
        deliveryLocation = edDeliveryLocation.getText().toString().trim();
        medicineName = etMedicineName.getText().toString().trim();
        order = tvOrderDate.getText().toString().trim();
        requiredDate = tvRequiredDate.getText().toString().trim();
        requiredTime = tvRequiredTime.getText().toString().trim();

        // --- EditText Validations ---
        if (name.isEmpty()) {
            edName.requestFocus();
            edName.setError("Name can't be empty!");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid Name! Only letters allowed");
            return;
        }
        if (email.isEmpty()) {
            edEmail.requestFocus();
            edEmail.setError("Email can't be empty!");
            return;
        } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
            edEmail.requestFocus();
            edEmail.setError("Invalid Email format!");
            return;
        }
        if (Phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("Phone number can't be empty!");
            return;
        } else if (!Phone.matches("[0-9]{10}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid Phone! Must be 10 digits");
            return;
        }
        if (Location.isEmpty()) {
            edLocation.requestFocus();
            edLocation.setError("Location can't be empty!");
            return;
        }
        if (deliveryLocation.isEmpty()) {
            edDeliveryLocation.requestFocus();
            edDeliveryLocation.setError("Delivery Location can't be empty!");
            return;
        }if (medicineName.isEmpty()) {
            etMedicineName.requestFocus();
            etMedicineName.setError("Medicine name can't be empty!");
            return;
        } if (order.equals("Select Order Date")) {
                Toast.makeText(getActivity(), "Order Date can't be empty!", Toast.LENGTH_SHORT).show();
                return;
        } if (requiredDate.equals("Select Required Date")) {
                Toast.makeText(getActivity(), "Required Date can't be empty!", Toast.LENGTH_SHORT).show();
                return;
        } if (requiredTime.equals("Select Required Date")) {
                Toast.makeText(getActivity(), "Required Time can't be empty!", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean b = patientMedicineOrderDataBase.InsertMedicineDetails(name, email, Phone, Location, deliveryLocation, medicineName, order, requiredDate, requiredTime);
            if (b == true) {
                Toast.makeText(getActivity(), "SuccessFully....", Toast.LENGTH_SHORT).show();
                edName.setText("");
                edEmail.setText("");
                edPhone.setText("");
                edLocation.setText("");
                edDeliveryLocation.setText("");
                etMedicineName.setText("");
                tvOrderDate.setText("Select Order Date");
                tvRequiredDate.setText("Select Required Date");
                tvRequiredTime.setText("Select Required Date");
            } else {

            }
        }
    public void SelectOrderDate() {
        Calendar calendar = Calendar.getInstance();
        int Days = calendar.get(Calendar.DAY_OF_MONTH);
        int Months = calendar.get(Calendar.MONTH);
        int Years = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 Formates1 = String.format("%02d/%02d/%02d", dayOfMonth, (month + 1), year);
                tvOrderDate.setText(Formates1);
            }
        },Years,Months,Days);
        datePickerDialog.show();
    }

    public void SelectRequiredDate() {
        Calendar calendar = Calendar.getInstance();
        int Days = calendar.get(Calendar.DAY_OF_MONTH);
        int Months = calendar.get(Calendar.MONTH);
        int Years = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Formates2 = String.format("%02d/%02d/%02d", dayOfMonth, (month + 1), year);
                tvRequiredDate.setText(Formates2);
            }
        },Years,Months,Days);
        datePickerDialog.show();

    }

    public void SelectRequiredTime() {

        Calendar calendar = Calendar.getInstance();
        int Hours = calendar.get(Calendar.HOUR_OF_DAY);
        int Minutes = calendar.get(Calendar.MINUTE);
        int Second = calendar.get(Calendar.SECOND);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Formates3 = String.format("%02d/%02d/%02d",hourOfDay, minute, Second);
                tvRequiredTime.setText(Formates3);
            }
        }, Hours, Minutes, true);
        timePickerDialog.show();
    }

}