package com.example.hospitalmanagementsystem.DoctorManageTask;

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

public class HealDietUpdateActivity extends AppCompatActivity {
    EditText edName,edAge,edMorning,edLunch,edDinner,edDoctor,edPhone;
    Button btnSubmit;
    String name,age,morning,lunch,dinner,doctor,phone;
    HealDietDataBase healDietDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_heal_diet_update);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edMorning = findViewById(R.id.edMorning);
        edLunch = findViewById(R.id.edLunch);
        edDinner = findViewById(R.id.edDinner);
        edDoctor = findViewById(R.id.edDoctor);
        edPhone = findViewById(R.id.edPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        healDietDataBase = new HealDietDataBase(getApplicationContext());


        id = getIntent().getIntExtra("id",0);
        edName.setText(getIntent().getStringExtra("name"));
        edAge.setText(getIntent().getStringExtra("age"));
        edMorning.setText(getIntent().getStringExtra("morning"));
        edLunch.setText(getIntent().getStringExtra("lunch"));
        edDinner.setText(getIntent().getStringExtra("dinner"));
        edDoctor.setText(getIntent().getStringExtra("doctor"));
        edPhone.setText(getIntent().getStringExtra("phone"));


        btnSubmit.setOnClickListener(new View.OnClickListener() {
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

        name = edName.getText().toString();
        age = edAge.getText().toString();
        morning = edMorning.getText().toString();
        lunch = edLunch.getText().toString();
        dinner = edDinner.getText().toString();
        doctor = edDoctor.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("Name Can't Empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again....");
            return;
        } else if (age.isEmpty()){
            edAge.requestFocus();
            edAge.setError("Age Can't Empty...");
            return;
        } else if (!age.matches("[0-9/| ]+")) {
            edAge.requestFocus();
            edAge.setError("Invalid try again....");
            return;
        } else if (morning.isEmpty()){
            edMorning.requestFocus();
            edMorning.setError("Morning Can't Empty...");
            return;
        } else if (!morning.matches("[a-zA-Z0-9,/| ]+")) {
            edMorning.requestFocus();
            edMorning.setError("Invalid try again....");
            return;
        }else if (lunch.isEmpty()){
            edLunch.requestFocus();
            edLunch.setError("Lunch Can't Empty...");
            return;
        } else if (!lunch.matches("[a-zA-Z0-9,/| ]+")) {
            edLunch.requestFocus();
            edLunch.setError("Invalid try again....");
            return;
        } else if (dinner.isEmpty()){
            edDinner.requestFocus();
            edDinner.setError("Dinner Can't Empty...");
            return;
        } else if (!dinner.matches("[a-zA-Z0-9,/| ]+")) {
            edDinner.requestFocus();
            edDinner.setError("Invalid try again....");
            return;
        } else if (doctor.isEmpty()){
            edDoctor.requestFocus();
            edDoctor.setError("Doctor Can't Empty...");
            return;
        } else if (!doctor.matches("[a-zA-Z0-9 ]+")) {
            edDoctor.requestFocus();
            edDoctor.setError("Invalid try again....");
            return;
        } else if (phone.isEmpty()){
            edPhone.requestFocus();
            edPhone.setError("Phone Can't Empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again....");
            return;
        }
        boolean b = healDietDataBase.UpdateDataHeal(id,name,age,morning,lunch,dinner,doctor,phone);
        if (b==true){
            Toast.makeText(getApplicationContext(), "Update SuccessFully....", Toast.LENGTH_SHORT).show();
            edName.setText("");
            edAge.setText("");
            edMorning.setText("");
            edLunch.setText("");
            edDinner.setText("");
            edDoctor.setText("");
            edPhone.setText("");
        }else {
            Toast.makeText(getApplicationContext(), "Failed....", Toast.LENGTH_SHORT).show();
        }
    }
}