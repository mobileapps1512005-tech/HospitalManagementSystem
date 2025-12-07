package com.example.hospitalmanagementsystem.SplashScreenActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.example.hospitalmanagementsystem.AdminModule.AdminModule;
import com.example.hospitalmanagementsystem.MainActivity.MainActivity;
import com.example.hospitalmanagementsystem.R;

public class SplashScreenActivity extends AppCompatActivity {
LottieAnimationView lottieAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        lottieAnimation = findViewById(R.id.lottieAnimation);
        lottieAnimation.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences("Share",MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean("Login",false);
                String role =    sharedPreferences.getString("role","").trim();
                if (isLogin) {
                    if (role.equals("admin")) {
                        startActivity(new Intent(getApplicationContext(), AdminModule.class));
                    } else if (role.equals("user")) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    } else {
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    }
                }else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
                finish();
            }
        }, 4000);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}