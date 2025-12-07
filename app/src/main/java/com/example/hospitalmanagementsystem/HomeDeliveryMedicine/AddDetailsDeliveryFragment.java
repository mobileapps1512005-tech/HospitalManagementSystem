package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.hospitalmanagementsystem.R;
import java.util.ArrayList;


public class AddDetailsDeliveryFragment extends Fragment {
EditText edName,edEmail,edLocation,edContact;
Spinner spGender,spExperience;
Button BtnSubmit;
String name,email,location,phone,gender,experience;
HomeDeliveryDataBase homeDeliveryDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_details_delivery, container, false);

          edName = view.findViewById(R.id.edName);
          edEmail = view.findViewById(R.id.edEmail);
          edLocation = view.findViewById(R.id.edLocation);
          edContact= view.findViewById(R.id.edContact);
          spGender = view.findViewById(R.id.spGender);
          spExperience = view.findViewById(R.id.spExperience);
          BtnSubmit = view.findViewById(R.id.BtnSubmit);
          homeDeliveryDataBase = new HomeDeliveryDataBase(getActivity());

          SelectGender();
          SelectExperience();

          BtnSubmit.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  InsertDetailsData();
              }
          });

          spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  gender = parent.getItemAtPosition(position).toString();
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });

          spExperience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   experience = parent.getItemAtPosition(position).toString();
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });

        return view;

    }

    public void InsertDetailsData() {

        name = edName.getText().toString();
        email = edEmail.getText().toString();
        phone = edContact.getText().toString();
        location = edLocation.getText().toString();

        if (name.isEmpty()) {
            edName.requestFocus();
            edName.setError("Name Can't Empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid Name Try Again...");
            return;
        } else if (email.isEmpty()) {
            edEmail.requestFocus();
            edEmail.setError("Email Id Can't Empty...");
            return;
        } else if (!email.matches("[a-zA-Z0-9]+[@][a-z]+[.][a-z]+")) {
            edEmail.requestFocus();
            edEmail.setError("Invalid Email Try Again...");
            return;
        } else if (location.isEmpty()) {
            edLocation.requestFocus();
            edLocation.setError("Location Can't Empty");
            return;
        } else if (!location.matches("[a-zA-Z0-9 ]+")) {
            edLocation.requestFocus();
            edLocation.setError("Invalid Try Again...");
            return;
        } else if (phone.isEmpty()) {
            edContact.requestFocus();
            edContact.setError("Phone Number Can't Empty");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edContact.requestFocus();
            edContact.setError("Invalid Try Again...");
            return;
        } if (gender.equals("Please Select Gender")){
            Toast.makeText(getActivity(), "Select Valid Gender Option", Toast.LENGTH_SHORT).show();
            return;
        } if (experience.equals("Please Select Experience")){
            Toast.makeText(getActivity(), "Select Valid Experience Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = homeDeliveryDataBase.InsertHomeDelivery(name,email,location,phone,gender,experience);
        if (b==true){
            Toast.makeText(getActivity(), "SuccessFully.....", Toast.LENGTH_SHORT).show();
            edName.setText("");
            edEmail.setText("");
            edLocation.setText("");
            edContact.setText("");
            spExperience.setSelection(0);
            spGender.setSelection(0);
        }else {
            Toast.makeText(getActivity(), "Failed.....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectGender(){
        ArrayList<String> Gender = new ArrayList<>();
        Gender.add("Please Select Gender");
        Gender.add("Male");
        Gender.add("FeMale");
        Gender.add("Other");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,Gender);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spGender.setAdapter(adapter);
    }

    public void SelectExperience(){
        ArrayList<String> SelectExperience = new ArrayList<>();

        SelectExperience.add("Please Select Experience");
        SelectExperience.add("1 Year Of Experience");
        SelectExperience.add("2 Years Of Experience");
        SelectExperience.add("3 Years Of Experience");
        SelectExperience.add("4 Years Of Experience");
        SelectExperience.add("5 Years Of Experience");
        SelectExperience.add("6 Years Of Experience");
        SelectExperience.add("7 Years Of Experience");
        SelectExperience.add("8 Years Of Experience");
        SelectExperience.add("9 Years Of Experience");
        SelectExperience.add("10 Years Of Experience");
        SelectExperience.add("11 Years Of Experience");
        SelectExperience.add("12 Years Of Experience");
        SelectExperience.add("13 Years Of Experience");
        SelectExperience.add("14 Years Of Experience");
        SelectExperience.add("15 Years Of Experience");
        SelectExperience.add("16 Years Of Experience");
        SelectExperience.add("17 Years Of Experience");
        SelectExperience.add("18 Years Of Experience");
        SelectExperience.add("19 Years Of Experience");
        SelectExperience.add("20 Years Of Experience");
        SelectExperience.add("21 Years Of Experience");
        SelectExperience.add("22 Years Of Experience");
        SelectExperience.add("23 Years Of Experience");
        SelectExperience.add("24 Years Of Experience");
        SelectExperience.add("25 Years Of Experience");
        SelectExperience.add("26 Years Of Experience");
        SelectExperience.add("27 Years Of Experience");
        SelectExperience.add("28 Years Of Experience");
        SelectExperience.add("29 Years Of Experience");
        SelectExperience.add("30 Years Of Experience");
        SelectExperience.add("31 Years Of Experience");
        SelectExperience.add("32 Years Of Experience");
        SelectExperience.add("33 Years Of Experience");
        SelectExperience.add("34 Years Of Experience");
        SelectExperience.add("35 Years Of Experience");
        SelectExperience.add("36 Years Of Experience");
        SelectExperience.add("37 Years Of Experience");
        SelectExperience.add("38 Years Of Experience");
        SelectExperience.add("39 Years Of Experience");
        SelectExperience.add("40 Years Of Experience");
        SelectExperience.add("41 Years Of Experience");
        SelectExperience.add("42 Years Of Experience");
        SelectExperience.add("43 Years Of Experience");
        SelectExperience.add("44 Years Of Experience");
        SelectExperience.add("45 Years Of Experience");
        SelectExperience.add("46 Years Of Experience");
        SelectExperience.add("47 Years Of Experience");
        SelectExperience.add("48 Years Of Experience");
        SelectExperience.add("49 Years Of Experience");
        SelectExperience.add("50 Years Of Experience");


        ArrayAdapter<String>   arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,SelectExperience);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spExperience.setAdapter(arrayAdapter);

    }

}