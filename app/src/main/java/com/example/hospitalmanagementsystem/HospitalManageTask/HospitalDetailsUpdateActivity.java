package com.example.hospitalmanagementsystem.HospitalManageTask;

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

public class HospitalDetailsUpdateActivity extends AppCompatActivity {

    EditText EdHospitalName,EdEstablishedYear,EdHospitalEmail,EdLocation,EdPhone;
    Button BtnSubmit;
    HospitalDataBase hospitalDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hospital_details_update);

        EdHospitalName = findViewById(R.id.EdHospitalName);
        EdEstablishedYear = findViewById(R.id.EdEstablishedYear);
        EdHospitalEmail = findViewById(R.id.EdHospitalEmail);
        EdLocation =  findViewById(R.id.EdLocation);
        EdPhone =  findViewById(R.id.EdPhone);
        BtnSubmit = findViewById(R.id.BtnSubmit);
        hospitalDataBase = new HospitalDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        EdHospitalName.setText(getIntent().getStringExtra("name"));
        EdEstablishedYear.setText(getIntent().getStringExtra("year"));
        EdHospitalEmail.setText(getIntent().getStringExtra("email"));
        EdLocation.setText(getIntent().getStringExtra("location"));
        EdPhone.setText(getIntent().getStringExtra("phone"));


        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void InsertData(){
        String name,established,email,location,phone;

        name = EdHospitalName.getText().toString();
        established = EdEstablishedYear.getText().toString();
        email = EdHospitalEmail.getText().toString();
        location = EdLocation.getText().toString();
        phone = EdPhone.getText().toString();

        if (name.isEmpty()){
            EdHospitalName.requestFocus();
            EdHospitalName.setError("Name Can't Empty....");
            return;
        }else if (!name.matches("[a-zA-Z ]+")){
            EdHospitalName.requestFocus();
            EdHospitalName.setError("Invalid Name try again.....");
            return;
        }else if (established.isEmpty()){
            EdEstablishedYear.requestFocus();
            EdEstablishedYear.setError("Established year can't empty.....");
            return;
        }else if (!established.matches("[a-zA-Z0-9 ]+")){
            EdEstablishedYear.requestFocus();
            EdEstablishedYear.setError("Invalid Year try again.....");
            return;
        }else if (email.isEmpty()){
            EdHospitalEmail.requestFocus();
            EdHospitalEmail.setError("Email can't empty........");
            return;
        }else if (!email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+")){
            EdHospitalEmail.requestFocus();
            EdHospitalEmail.setError("Invalid Email try again.....");
            return;
        }else if (location.isEmpty()){
            EdLocation.requestFocus();
            EdLocation.setError("Location can't empty.....");
            return;
        }else if (!location.matches("[a-zA-Z0-9 ]+")){
            EdLocation.requestFocus();
            EdLocation.setError("Invalid Location try again.....");
            return;
        }else if (phone.isEmpty()){
            EdPhone.requestFocus();
            EdPhone.setError("Phone can't empty.....");
            return;
        }else if (!phone.matches("[0-9]+\\d{9}")){
            EdPhone.requestFocus();
            EdPhone.setError("Invalid Phone try again.....");
            return;
        }
        boolean b = hospitalDataBase.UpdateGetAllDetails(id,name,established,email,location,phone);
        if (b==true){
            Toast.makeText(getApplicationContext(), "Update SuccessFully....", Toast.LENGTH_SHORT).show();
            EdHospitalName.setText("");
            EdEstablishedYear.setText("");
            EdEstablishedYear.setText("");
            EdLocation.setText("");
            EdPhone.setText("");
        }else {
            Toast.makeText(getApplicationContext(), "Update Failed....", Toast.LENGTH_SHORT).show();
        }

    }

}