package com.example.hospitalmanagementsystem.SplashScreenActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.MainActivity.MainActivity;
import com.example.hospitalmanagementsystem.R;

public class RegisterActivity extends AppCompatActivity {
EditText edName,edEmail,edPassword,edPhone;
RadioButton rbMale,rbFemale;
Button btnSignUp;
String name,email,password,gender,phone;
RegisterDataBase registerDataBase;
RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);


        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        edPhone = findViewById(R.id.edPhone);
        btnSignUp = findViewById(R.id.btnSign);
        radioGroup = findViewById(R.id.radioGroup);
        registerDataBase = new RegisterDataBase(getApplicationContext());


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterInsertData();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void RegisterInsertData(){
        name = edName.getText().toString();
        email = edEmail.getText().toString();
        password = edPassword.getText().toString();
        phone = edPhone.getText().toString();

        if (rbMale.isChecked()){
            gender = "" + rbMale.getText().toString();
        } if (rbFemale.isChecked()) {
            gender = "" + rbFemale.getText().toString();
        }

        if (name.isEmpty()){
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
        } else if (!email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
            edEmail.requestFocus();
            edEmail.setError("Invalid try again...");
            return;
        } else if (password.isEmpty()) {
            edPassword.requestFocus();
            edPassword.setError("password can't empty...");
            return;
        } else if (!password.matches("[a-zA-Z0-9]+")) {
            edPassword.requestFocus();
            edPassword.setError("Invalid try again...");
            return;
        } else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }
    boolean b = registerDataBase.UserDetailsAlreadyExists(email,phone);
        if (b==true){
            Toast.makeText(this, "User Already Exists...", Toast.LENGTH_SHORT).show();
        }else {
            boolean c = registerDataBase.RegisterInsertData(name,email,password,gender,phone,"user");
            if (c==true){
                edName.setText("");
                edEmail.setText("");
                edPassword.setText("");
                edPhone.setText("");
                radioGroup.clearCheck();
                SharedPreferences sharedPreferences = getSharedPreferences("Share", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Login", true);
                editor.putString("role", "user");
                editor.apply();
                Toast.makeText(this, "Register SuccessFully.....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finishAffinity();
            }else {
                Toast.makeText(this, "Register Failed.....", Toast.LENGTH_SHORT).show();
            }
        }
    }
}