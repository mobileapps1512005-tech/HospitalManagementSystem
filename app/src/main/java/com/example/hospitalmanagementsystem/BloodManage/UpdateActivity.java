package com.example.hospitalmanagementsystem.BloodManage;

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

public class UpdateActivity extends AppCompatActivity {
    EditText edHospital,edPhone;
    Button BtnSubmit;
    Spinner SpinBloodType,SpinBloodQuantity;
    String Blood,Quantity;
    String hospital,phone;
    BloodDataBase bloodDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);


        edHospital = findViewById(R.id.edHospital);
        edPhone = findViewById(R.id.edPhone);
        SpinBloodType = findViewById(R.id.SpinBloodType);
        SpinBloodQuantity = findViewById(R.id.SpinBloodQuantity);
        bloodDataBase = new BloodDataBase(getApplicationContext());
        BtnSubmit = findViewById(R.id.BtnSubmit);

        id = getIntent().getIntExtra("id",0);
        edHospital.setText(getIntent().getStringExtra("hospital"));
        edPhone.setText(getIntent().getStringExtra("phone"));
        Blood = getIntent().getStringExtra("blood");
        Quantity = getIntent().getStringExtra("quantity");


        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDoctorData();
            }
        });

        SpinBloodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Blood = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinBloodQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Quantity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        SelectBloodType();
        SelectBloodQuantity();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void InsertDoctorData(){
        hospital = edHospital.getText().toString();
        phone = edPhone.getText().toString();

        if (hospital.isEmpty()){
            edHospital.requestFocus();
            edHospital.setError("Hospital Can't Empty...");
            return;
        } else if (!hospital.matches("[a-zA-Z ]+")) {
            edHospital.requestFocus();
            edHospital.setError("Invalid Name Try Again...");
            return;
        } else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("Phone Can't Empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        } if (Blood.equals("Please Select Blood Group")){
            Toast.makeText(getApplicationContext(), "Please Select Valid Blood Group", Toast.LENGTH_SHORT).show();
            return;
        }if (Quantity.equals("Please Select Quantity")){
            Toast.makeText(getApplicationContext(), "Please Select Valid Quantity", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = bloodDataBase.UpdateBloodDetails(id,hospital,Blood,Quantity,phone);
        if (b==true){
            Toast.makeText(getApplicationContext(), "SuccessFully...", Toast.LENGTH_SHORT).show();
            edHospital.setText("");
            edPhone.setText("");
            SpinBloodType.setSelection(0);
            SpinBloodQuantity.setSelection(0);
        } else {
            Toast.makeText(getApplicationContext(), "Data Failed...", Toast.LENGTH_SHORT).show();
        }
    }
    public void SelectBloodType(){


        ArrayList<String> BloodGroups = new ArrayList<>();
        BloodGroups.add("Please Select Blood Group");
        BloodGroups.add("A Positive (A+)");
        BloodGroups.add("A Negative (A-)");
        BloodGroups.add("B Positive (B+)");
        BloodGroups.add("B Negative (B-)");
        BloodGroups.add("AB Positive (AB+)");
        BloodGroups.add("AB Negative (AB-)");
        BloodGroups.add("O Positive (O+)");
        BloodGroups.add("O Negative (O-)");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,BloodGroups);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinBloodType.setAdapter(arrayAdapter);

        if (BloodGroups!=null){
            int position = arrayAdapter.getPosition(Blood.toString());
            if (position>0){
                SpinBloodType.setSelection(position);
            }
        }

    }
    public void SelectBloodQuantity(){
        ArrayList<String> SelectQuantityNumber = new ArrayList<>();
        SelectQuantityNumber.add("Please Select Quantity");
        SelectQuantityNumber.add("Available Quantity 1");
        SelectQuantityNumber.add("Available Quantity 2");
        SelectQuantityNumber.add("Available Quantity 3");
        SelectQuantityNumber.add("Available Quantity 4");
        SelectQuantityNumber.add("Available Quantity 5");
        SelectQuantityNumber.add("Available Quantity 6");
        SelectQuantityNumber.add("Available Quantity 7");
        SelectQuantityNumber.add("Available Quantity 8");
        SelectQuantityNumber.add("Available Quantity 9");
        SelectQuantityNumber.add("Available Quantity 10");
        SelectQuantityNumber.add("Available Quantity 11");
        SelectQuantityNumber.add("Available Quantity 12");
        SelectQuantityNumber.add("Available Quantity 13");
        SelectQuantityNumber.add("Available Quantity 14");
        SelectQuantityNumber.add("Available Quantity 15");
        SelectQuantityNumber.add("Available Quantity 16");
        SelectQuantityNumber.add("Available Quantity 17");
        SelectQuantityNumber.add("Available Quantity 18");
        SelectQuantityNumber.add("Available Quantity 19");
        SelectQuantityNumber.add("Available Quantity 20");
        SelectQuantityNumber.add("Available Quantity 21");
        SelectQuantityNumber.add("Available Quantity 22");
        SelectQuantityNumber.add("Available Quantity 23");
        SelectQuantityNumber.add("Available Quantity 24");
        SelectQuantityNumber.add("Available Quantity 25");
        SelectQuantityNumber.add("Available Quantity 26");
        SelectQuantityNumber.add("Available Quantity 27");
        SelectQuantityNumber.add("Available Quantity 28");
        SelectQuantityNumber.add("Available Quantity 29");
        SelectQuantityNumber.add("Available Quantity 30");
        SelectQuantityNumber.add("Available Quantity 31");
        SelectQuantityNumber.add("Available Quantity 32");
        SelectQuantityNumber.add("Available Quantity 33");
        SelectQuantityNumber.add("Available Quantity 34");
        SelectQuantityNumber.add("Available Quantity 35");
        SelectQuantityNumber.add("Available Quantity 36");
        SelectQuantityNumber.add("Available Quantity 37");
        SelectQuantityNumber.add("Available Quantity 38");
        SelectQuantityNumber.add("Available Quantity 39");
        SelectQuantityNumber.add("Available Quantity 40");
        SelectQuantityNumber.add("Available Quantity 41");
        SelectQuantityNumber.add("Available Quantity 42");
        SelectQuantityNumber.add("Available Quantity 43");
        SelectQuantityNumber.add("Available Quantity 44");
        SelectQuantityNumber.add("Available Quantity 45");
        SelectQuantityNumber.add("Available Quantity 46");
        SelectQuantityNumber.add("Available Quantity 47");
        SelectQuantityNumber.add("Available Quantity 48");
        SelectQuantityNumber.add("Available Quantity 49");
        SelectQuantityNumber.add("Available Quantity 50");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectQuantityNumber);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinBloodQuantity.setAdapter(arrayAdapter);

        if (SelectQuantityNumber!=null){
            int position = arrayAdapter.getPosition(Quantity.toString());
            if (position>0){
              SpinBloodQuantity.setSelection(position);
            }
        }
    }
}