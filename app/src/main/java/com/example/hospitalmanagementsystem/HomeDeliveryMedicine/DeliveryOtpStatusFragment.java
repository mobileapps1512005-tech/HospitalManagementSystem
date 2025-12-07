package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

import java.util.Random;


public class DeliveryOtpStatusFragment extends Fragment {
EditText edPhone,edEmail,edName;
Button BtnSubmit;
static String phone,name,email;
MedicineStatusDataBase medicineStatusDataBase;
public static final int RequestCode=1001;
public static String SendOtp;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_delivery_status, container, false);


            edName = view.findViewById(R.id.edName);
            edEmail = view.findViewById(R.id.edEmail);
            edPhone = view.findViewById(R.id.edPhone);
            BtnSubmit = view.findViewById(R.id.BtnSubmit);
            medicineStatusDataBase = new MedicineStatusDataBase(getContext());


           SmsPermission();

            BtnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   InsertPhoneDetails();
                }
            });

        return view;
    }

    public void InsertPhoneDetails(){

        name = edName.getText().toString();
        email = edEmail.getText().toString();
        phone = edPhone.getText().toString().trim();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("Name Can't Empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")){
            edName.requestFocus();
            edName.setError("Invalid Try Again...");
            return;
        } else if (email.isEmpty()){
            edEmail.requestFocus();
            edEmail.setError("Email Can't empty....");
            return;
        } else if (!email.matches("[a-zA-Z]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
            edEmail.requestFocus();
            edEmail.setError("Invalid Try Again...");
            return;
        } else if (phone.isEmpty()){
            edPhone.requestFocus();
            edPhone.setError("Phone Number Can't Empty...");
            return;
        } else if (!phone.matches("[0-9]{10}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid Try again....");
            return;
        }
        boolean b = medicineStatusDataBase.InsertDeliveryStatus(name,email,phone);
          if (b==true){
              Toast.makeText(getContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(getContext(), OtpActivity.class);
              startActivity(intent);
              edName.setText("");
              edEmail.setText("");
              edPhone.setText("");
          }else {
              Toast.makeText(getContext(), "Failed.....", Toast.LENGTH_SHORT).show();
          }
          SendOtp(phone,getContext());
    }

    public static void SendOtp(String phone, Context context){

        try {
            String Messages = "Your verification code (OTP) for order delivery confirmation is: ";
            Random random = new Random();
            SendOtp = String.format("%06d",random.nextInt(900000));
            String Merge = Messages + SendOtp + "\n- Aarogyam Hospital";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone, null, Merge, null, null);
                Toast.makeText(context, "Ok" + SendOtp, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Failed:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void SmsPermission(){

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(requireContext(), "Permission AlReady Granted..", Toast.LENGTH_SHORT).show();
        }else {
            ActivityCompat.requestPermissions(requireActivity(),new String[]{Manifest.permission.SEND_SMS},RequestCode);
            Toast.makeText(requireContext(), "Please Permission Allow", Toast.LENGTH_SHORT).show();
        }
    }


}