package com.example.hospitalmanagementsystem.SplashScreenActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

public class ForgetPasswordActivity extends AppCompatActivity {
EditText edEmail,edPassword,edPassword2;
Button btnForGet;
String email,password,password2;
RegisterDataBase registerDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);


        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edPassword2 = findViewById(R.id.edPassword2);
        btnForGet = findViewById(R.id.btnForget);
        registerDataBase = new RegisterDataBase(getApplicationContext());

        btnForGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            PasswordForGet();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void PasswordForGet(){

        email = edEmail.getText().toString();
        password = edPassword.getText().toString();
        password2 = edPassword2.getText().toString();

        if (email.isEmpty()) {
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
        } else if (password2.isEmpty()) {
            edPassword2.requestFocus();
            edPassword2.setError("confirm can't empty...");
            return;
        } else if (!password2.matches("[a-zA-Z0-9]+")) {
            edPassword2.requestFocus();
            edPassword2.setError("Invalid try again...");
            return;
        } if (password.equals(password2)){
            boolean b = registerDataBase.ForgetPassword(email,password);
            if (b==true){
                edEmail.setText("");
                edPassword.setText("");
                edPassword2.setText("");
                Toast.makeText(this, "Password ForGet SuccessFully....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }else {
                Toast.makeText(this, "Email Doesn't SuccessFully....", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Password Doesn't Exists.... ", Toast.LENGTH_SHORT).show();
        }
    }
}