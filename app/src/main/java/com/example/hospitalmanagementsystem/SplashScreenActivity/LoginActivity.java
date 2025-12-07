package com.example.hospitalmanagementsystem.SplashScreenActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.AdminModule.AdminModule;
import com.example.hospitalmanagementsystem.MainActivity.MainActivity;
import com.example.hospitalmanagementsystem.R;

public class LoginActivity extends AppCompatActivity {
    EditText edEmail,edPassword;
    Button btnRegister,btnSignIn;
    String email,password;
    RegisterDataBase registerDataBase;
    TextView tvForgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        registerDataBase = new RegisterDataBase(getApplicationContext());




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               LoginInsertData();
           }
       });

        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(), ForgetPasswordActivity.class));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void LoginInsertData(){

        email = edEmail.getText().toString();
        password = edPassword.getText().toString();

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
        }
        String  role = registerDataBase.Login(email,password);
        SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("Share",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Login",true);
        editor.putString("role",role);
        editor.apply();
            if (role.equalsIgnoreCase("admin")){
                edEmail.setText("");
                edPassword.setText("");
                Toast.makeText(this, "Login SuccessFully.....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), AdminModule.class));
                finishAffinity();
            }else if (role.equalsIgnoreCase("user")){
                edEmail.setText("");
                edPassword.setText("");
                Toast.makeText(this, "Login SuccessFully.....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finishAffinity();
            }  else {
                Toast.makeText(this, "Invalid Email and Password try again...", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}