package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import static android.content.Intent.getIntent;
import static com.example.hospitalmanagementsystem.HomeDeliveryMedicine.DeliveryOtpStatusFragment.SendOtp;

import android.Manifest;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

import java.util.Random;


public class FoodConfirmationOtpFragment extends Fragment {
EditText edPhone,edOne,edTwo,edThree,edFour,edFive,edSix;
Button Submit,BtnSubmit,BtnResend;;
TextView tvTime;
String phone,one,two,three,four,five,six;
public static final int Request=1515;
public static String SendOtp;
FoodOrderPatientDataBase foodOrderPatientDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirmation, container, false);

        edPhone = view.findViewById(R.id.edPhone);
        edOne = view.findViewById(R.id.edOne);
        edTwo = view.findViewById(R.id.edTwo);
        edThree = view.findViewById(R.id.edThree);
        edFour = view.findViewById(R.id.edFour);
        edFive = view.findViewById(R.id.edFive);
        edSix = view.findViewById(R.id.edSix);
        tvTime = view.findViewById(R.id.tvTime);
        Submit = view.findViewById(R.id.Submit);
        BtnSubmit = view.findViewById(R.id.BtnSubmit);
        BtnResend = view.findViewById(R.id.BtnResend);
        foodOrderPatientDataBase = new FoodOrderPatientDataBase(getContext());


           SmsPermission();
           EditTextNexIndicate();

            BtnSubmit.setEnabled(false);
            BtnSubmit.setAlpha(0.5f);
            BtnResend.setEnabled(false);
            BtnResend.setAlpha(0.5f);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    PhoneNumberValidation();
                    edPhone.setText("");
            }
        });

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchOtp();
            }
        });

        BtnResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTimeContDown();
                ReSendOtp();
            }
        });

        return view;
    }

    public void SmsPermission(){

     if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED){
         Toast.makeText(getContext(), "Permission Already Granted...", Toast.LENGTH_SHORT).show();
     }else {
         ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS},Request);
         Toast.makeText(getContext(), "Please Allow Permission...", Toast.LENGTH_SHORT).show();

       }
    }

    public void PhoneNumberValidation(){
        phone = edPhone.getText().toString();
        if (phone.isEmpty()){
            edPhone.requestFocus();
            edPhone.setError("Phone number can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }if (phone!=null){
            GeneratedOtp(phone);
            SetTimeContDown();
            Submit.setEnabled(false);
            Submit.setAlpha(0.5f);
            BtnSubmit.setEnabled(true);
            BtnSubmit.setAlpha(1f);
        }
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
            Toast.makeText(getContext(), "Verification SuccessFully...", Toast.LENGTH_SHORT).show();
        }else {
            edOne.setText("");
            edTwo.setText("");
            edThree.setText("");
            edFour.setText("");
            edFive.setText("");
            edSix.setText("");
            Toast.makeText(getContext(), "Invalid Otp...", Toast.LENGTH_SHORT).show();
        }
    }

    public void GeneratedOtp(String phone){

        try {
            String Messages = "Your verification code (OTP) for order delivery confirmation is: ";
            Random random = new Random();
            SendOtp = String.format("%06d", random.nextInt(900000));
            String Merge = Messages + SendOtp + "\n- Aarogyam Hospital";
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, Merge, null, null);
            Toast.makeText(getContext(), "Otp :"+SendOtp, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getContext(), "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ReSendOtp(){
        SendOtp = "";
        GeneratedOtp(phone);
        BtnResend.setEnabled(false);
        BtnResend.setAlpha(0.5f);
    }

    public void EditTextNexIndicate(){

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


    }

    public void SetTimeContDown(){

        CountDownTimer countDownTimer = new CountDownTimer(45000,1000) {
            @Override
            public void onFinish() {
               tvTime.setText("Time Up's....");
                BtnResend.setEnabled(true);
                BtnResend.setAlpha(1f);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                long Second = millisUntilFinished/1000;
                String time = String.format("%02d:%02d",Second/60,Second%60);
                if (Second<=15){
                    tvTime.setTextColor(Color.RED);
                } else {
                    tvTime.setTextColor(Color.BLACK);
                }
                tvTime.setText("Left Time  "+time);
            }
        };
        countDownTimer.start();
    }


}