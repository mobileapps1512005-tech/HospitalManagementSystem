package com.example.hospitalmanagementsystem.AmbulanceManageTask;

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

public class AmbulanceBookingForPatientActivity extends AppCompatActivity {
    EditText EdName,EdEmail,EdPhone,EdAlterNumber,EdLocation;
    Spinner SpinAmbulance;
    Button BtnSubmit;
    String name,email,phone,alterNumber,location,ambulance;
    AmbulanceBookingDataBase ambulanceBookingDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambulance_boking_for_patient);


        EdName = findViewById(R.id.EdName);
        EdEmail = findViewById(R.id.EdEmail);
        EdPhone = findViewById(R.id.EdPhone);
        EdAlterNumber = findViewById(R.id.EdAlterNumber);
        EdLocation = findViewById(R.id.EdLocation);
        SpinAmbulance = findViewById(R.id.SpinAmbulance);
        BtnSubmit = findViewById(R.id.BtnSubmit);
        ambulanceBookingDataBase = new AmbulanceBookingDataBase(getApplication());

        SelectAmbulance();

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            InsertData();

            }
        });

        SpinAmbulance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ambulance = parent.getItemAtPosition(position).toString();
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

    public void InsertData(){
        name = EdName.getText().toString();
        email = EdEmail.getText().toString();
        phone = EdPhone.getText().toString();
        alterNumber = EdAlterNumber.getText().toString();
        location = EdLocation.getText().toString();

        if (name.isEmpty()){
            EdName.requestFocus();
            EdName.setError("Name Can't Empty....");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            EdName.requestFocus();
            EdName.setError("Invalid Name...");
            return;
        }else if (email.isEmpty()) {
            EdEmail.requestFocus();
            EdEmail.setError("Email Can't Empty....");
            return;
        }else if (!email.matches("[a-zA-Z]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
            EdEmail.requestFocus();
            EdEmail.setError("Invalid Email id....");
            return;
        }else if (phone.isEmpty()) {
            EdPhone.requestFocus();
            EdPhone.setError("Phone Can't Empty....");
            return;
        }else if (!phone.matches("[0-9]+\\d{9}")) {
            EdPhone.requestFocus();
            EdPhone.setError("Invalid Phone....");
            return;
        }else if (alterNumber.isEmpty()) {
            EdAlterNumber.requestFocus();
            EdAlterNumber.setError("AlterNumber Can't Empty....");
            return;
        }else if (!alterNumber.matches("[0-9]+\\d{9}")) {
            EdAlterNumber.requestFocus();
            EdAlterNumber.setError("Invalid AlterNumber...");
            return;
        }else if (location.isEmpty()) {
            EdLocation.requestFocus();
            EdLocation.setError("Location Can't Empty....");
            return;
        }else if (!location.matches("[a-zA-Z0-9 ]+")) {
            EdLocation.requestFocus();
            EdLocation.setError("Invalid Location....");
            return;
        }if (ambulance.equals("Please Select Ambulance")){
            Toast.makeText(this, "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = ambulanceBookingDataBase.InsertData(name,email,phone,alterNumber,location,ambulance);
        if (b==true){
            EdName.setText("");
            EdEmail.setText("");
            EdPhone.setText("");
            EdAlterNumber.setText("");
            EdLocation.setText("");
            SpinAmbulance.setSelection(0);
            Toast.makeText(this, "SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Failed....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectAmbulance(){
        ArrayList<String> ambulance = new ArrayList<>();
        ambulance.add("Please Select Ambulance");
        ambulance.add("Ambulance With Doctor");
        ambulance.add("Ambulance WithOut Doctor");
        ambulance.add("Ambulance With Ac");
        ambulance.add("Ambulance With Ac");
        ambulance.add("Ambulance All Package");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,ambulance);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAmbulance.setAdapter(arrayAdapter);

    }

}