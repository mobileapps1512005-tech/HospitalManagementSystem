package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

import java.util.Calendar;

public class AcceptOrderRequestActivity extends AppCompatActivity {
    EditText edName, edEmail, edPhone, edLocation, edDeliveryLocation, etMedicineName;
    Button btnSubmit;
    TextView tvOrderDate, tvRequiredTime, tvRequiredDate;
    String  name,email,Phone,Location,deliveryLocation,medicineName,Formates1,Formates2,Formates3,order,requiredDate,requiredTime;
    PatientMedicineOrderDataBase patientMedicineOrderDataBase;
    OnlyAcceptMedicineOrderDataBase onlyAcceptMedicineOrderDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accept_order_request);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        edLocation = findViewById(R.id.edLocation);
        edDeliveryLocation = findViewById(R.id.edDeliveryLocation);
        etMedicineName = findViewById(R.id.etMedicineName);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvOrderDate = findViewById(R.id.tvOrderDate);
        tvRequiredDate = findViewById(R.id.tvRequiredDate);
        tvRequiredTime = findViewById(R.id.tvRequiredTime);
        onlyAcceptMedicineOrderDataBase = new OnlyAcceptMedicineOrderDataBase(getApplicationContext());
        patientMedicineOrderDataBase = new PatientMedicineOrderDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        edName.setText(getIntent().getStringExtra("name"));
        edEmail.setText(getIntent().getStringExtra("email"));
        edPhone.setText(getIntent().getStringExtra("phone"));
        edLocation.setText(getIntent().getStringExtra("location"));
        edDeliveryLocation.setText(getIntent().getStringExtra("deliverLocation"));
        etMedicineName.setText(getIntent().getStringExtra("medicineName"));
        tvOrderDate.setText(getIntent().getStringExtra("order"));
        tvRequiredDate.setText(getIntent().getStringExtra("Date"));
        tvRequiredTime.setText(getIntent().getStringExtra("Time"));

        edName.setEnabled(false);
        edEmail.setEnabled(false);
        edPhone.setEnabled(false);
        edLocation.setEnabled(false);
        edDeliveryLocation.setEnabled(false);
        etMedicineName.setEnabled(false);
        tvOrderDate.setEnabled(false);
        tvRequiredDate.setEnabled(false);
        tvRequiredTime.setEnabled(false);


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


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
            Toast.makeText(getApplicationContext(), "Order Date can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        } if (requiredDate.equals("Select Required Date")) {
            Toast.makeText(getApplicationContext(), "Required Date can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        } if (requiredTime.equals("Select Required Date")) {
            Toast.makeText(getApplicationContext(), "Required Time can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = onlyAcceptMedicineOrderDataBase.AcceptInsertMedicineDetails(name, email, Phone, Location, deliveryLocation, medicineName, order, requiredDate, requiredTime);
        if (b == true) {
            Toast.makeText(getApplicationContext(), "Accept SuccessFully....", Toast.LENGTH_SHORT).show();
            patientMedicineOrderDataBase.GetDeleteMedicineDetails(id);
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
            Toast.makeText(getApplicationContext(), "Failed....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectOrderDate() {
        Calendar calendar = Calendar.getInstance();
        int Days = calendar.get(Calendar.DAY_OF_MONTH);
        int Months = calendar.get(Calendar.MONTH);
        int Years = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
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
        TimePickerDialog timePickerDialog = new TimePickerDialog(getApplicationContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Formates3 = String.format("%02d/%02d/%02d",hourOfDay, minute, Second);
                tvRequiredTime.setText(Formates3);
            }
        }, Hours, Minutes, true);
        timePickerDialog.show();
    }

}