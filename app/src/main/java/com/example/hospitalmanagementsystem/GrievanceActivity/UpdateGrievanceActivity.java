package com.example.hospitalmanagementsystem.GrievanceActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

public class UpdateGrievanceActivity extends AppCompatActivity {
    EditText edHospital,edName,edPhone,edStaff,edGrievance;
    Button btnSubmit;
    String hospital,name,phone,staff,grievance;
    GrievanceDataBase grievanceDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_grievance);


        edHospital = findViewById(R.id.edHospital);
        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        edStaff = findViewById(R.id.edStaff);
        edGrievance = findViewById(R.id.edGrievance);
        btnSubmit = findViewById(R.id.btnSubmit);
        grievanceDataBase = new GrievanceDataBase(getApplicationContext());


        id = getIntent().getIntExtra("id",0);
        edHospital.setText(getIntent().getStringExtra("hospital"));
        edName.setText(getIntent().getStringExtra("name"));
        edPhone.setText(getIntent().getStringExtra("phone"));
        edStaff.setText(getIntent().getStringExtra("staff"));
        edGrievance.setText(getIntent().getStringExtra("grievance"));


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GrievanceInsertData();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void GrievanceInsertData(){

        hospital = edHospital.getText().toString();
        name = edName.getText().toString();
        phone = edPhone.getText().toString();
        staff = edStaff.getText().toString();
        grievance = edGrievance.getText().toString();

        if (hospital.isEmpty()) {
            edHospital.requestFocus();
            edHospital.setError("hospital name can't empty");
            return;
        } else if (!hospital.matches("[a-zA-Z0-9 ]+")) {
            edHospital.requestFocus();
            edHospital.setError("Invalid try again....");
            return;
        } else if (name.isEmpty()) {
            edName.requestFocus();
            edName.setError("name can't empty");
            return;
        } else if (!name.matches("[a-zA-Z ]+")){
            edName.requestFocus();
            edName.setError("Invalid try again....");
            return;
        }else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")){
            edPhone.requestFocus();
            edPhone.setError("Invalid try again....");
            return;
        }else if (staff.isEmpty()) {
            edStaff.requestFocus();
            edStaff.setError("staff can't empty");
            return;
        } else if (!staff.matches("[a-zA-Z ]+")){
            edStaff.requestFocus();
            edStaff.setError("Invalid try again....");
            return;
        }else if (grievance.isEmpty()) {
            edGrievance.requestFocus();
            edGrievance.setError("grievance can't empty");
            return;
        } else if (!grievance.matches("[a-zA-Z0-9-,./' ]+")){
            edGrievance.requestFocus();
            edGrievance.setError("Invalid try again....");
            return;
        }
        boolean b = grievanceDataBase.GrievanceUpdateData(id,hospital,name,phone,staff,grievance);
        if (b==true){
            Toast.makeText(getApplicationContext(), "Update SuccessFully....", Toast.LENGTH_SHORT).show();
            edHospital.setText("");
            edName.setText("");
            edPhone.setText("");
            edStaff.setText("");
            edGrievance.setText("");
        }else {
            Toast.makeText(getApplicationContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }

}