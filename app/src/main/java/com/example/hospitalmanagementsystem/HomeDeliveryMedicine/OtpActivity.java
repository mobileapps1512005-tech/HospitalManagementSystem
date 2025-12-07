package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import static com.example.hospitalmanagementsystem.HomeDeliveryMedicine.DeliveryOtpStatusFragment.SendOtp;
import static com.example.hospitalmanagementsystem.HomeDeliveryMedicine.DeliveryOtpStatusFragment.phone;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.example.hospitalmanagementsystem.R;

public class OtpActivity extends AppCompatActivity {
EditText edOne,edTwo,edThree,edFour,edFive,edSix;
Button BtnSubmit,BtnResend;
TextView tvTime;
String one,two,three,four,five,six;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otp);


        edOne = findViewById(R.id.edOne);
        edTwo = findViewById(R.id.edTwo);
        edThree = findViewById(R.id.edThree);
        edFour = findViewById(R.id.edFour);
        edFive = findViewById(R.id.edFive);
        edSix = findViewById(R.id.edSix);
        tvTime = findViewById(R.id.tvTime);
        BtnSubmit = findViewById(R.id.BtnSubmit);
        BtnResend = findViewById(R.id.BtnResend);

        BtnResend.setEnabled(false);
        BtnResend.setAlpha(0.5f);
        EditTextChangeNext();


        StartCountTimer();

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MatchOtp();
            }
        });

        BtnResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ResendOtp();
                 StartCountTimer();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void MatchOtp(){

        one = edOne.getText().toString();
        two = edTwo.getText().toString();
        three = edThree.getText().toString();
        four = edFour.getText().toString();
        five = edFive.getText().toString();
        six = edSix.getText().toString();
        String Merge = one+two+three+four+five+six;
        if (one.isEmpty()){
            edOne.requestFocus();
            edOne.setError("Can't Empty..");
            return;
        } else if (two.isEmpty()) {
            edTwo.requestFocus();
            edTwo.setError("Can't Empty..");
            return;
        }else if (three.isEmpty()) {
            edThree.requestFocus();
            edThree.setError("Can't Empty..");
            return;
        }else if (four.isEmpty()) {
            edFour.requestFocus();
            edFour.setError("Can't Empty..");
            return;
        }else if (five.isEmpty()) {
            edFive.requestFocus();
            edFive.setError("Can't Empty..");
            return;
        }else if (six.isEmpty()) {
            edSix.requestFocus();
            edSix.setError("Can't Empty..");
            return;
        }
        if (Merge.equals(SendOtp)){
            edOne.setText("");
            edTwo.setText("");
            edThree.setText("");
            edFour.setText("");
            edFive.setText("");
            edSix.setText("");
            Toast.makeText(this, "Verification SuccessFully...", Toast.LENGTH_SHORT).show();
        }else {
            edOne.setText("");
            edTwo.setText("");
            edThree.setText("");
            edFour.setText("");
            edFive.setText("");
            edSix.setText("");
            Toast.makeText(this, "Invalid Otp...", Toast.LENGTH_SHORT).show();
        }
    }

    public void StartCountTimer() {

        CountDownTimer countDownTimer = new CountDownTimer(45000,1000) {
            @Override
            public void onFinish() {
                tvTime.setText("Time's Up...");
                BtnResend.setEnabled(true);
                BtnResend.setAlpha(1f);

            }

            @Override
            public void onTick(long millisUntilFinished) {
               long Second = millisUntilFinished/1000;
               String Times = String.format("%02d:%02d ",Second/60,Second%60);

               if (Second<=15){
                   tvTime.setTextColor(Color.RED);
               } else {
                   tvTime.setTextColor(Color.BLACK);
               }
                tvTime.setText("Left Time  "+Times);
            }
        };
        countDownTimer.start();
    }

    public void ResendOtp(){
        SendOtp="";
        DeliveryOtpStatusFragment.SendOtp(phone,getApplicationContext());
        BtnResend.setEnabled(false);
        BtnResend.setAlpha(0.5f);
    }

    public void EditTextChangeNext(){

        edOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().isEmpty()){
                    edTwo.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        edTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    edThree.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        edThree.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    edFour.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        edFour.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    edFive.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        edFive.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    edSix.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        edSix.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().isEmpty()){
                    edSix.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


    }

}