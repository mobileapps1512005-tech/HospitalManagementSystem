package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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


public class AddCanteenDetailsFragment extends Fragment {
EditText edMenu,edHalf,edHalfPrice,edFullPlate,edFullPrice,edCombo,edPhone;
Spinner spinDiscounts;
Button btnSubmit;
String menu,half,halfPrice,fullPlate,fullPrice,combo,phone,discount;
CanteenDataBase canteenDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_add_canteen_details, container, false);

        edMenu = view.findViewById(R.id.edMenu);
        edHalf = view.findViewById(R.id.edHalf);
        edHalfPrice = view.findViewById(R.id.edHalPrice);
        edFullPlate = view.findViewById(R.id.edFullPlate);
        edFullPrice = view.findViewById(R.id.edFullPrice);
        spinDiscounts = view.findViewById(R.id.SpinDiscountAllow);
        edCombo = view.findViewById(R.id.edCombo);
        edPhone = view.findViewById(R.id.edPhone);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        canteenDataBase = new CanteenDataBase(getActivity());


        SetDiscountAllow();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        spinDiscounts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     discount = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;


    }

    public void InsertData(){

        menu = edMenu.getText().toString();
        half = edHalf.getText().toString();
        halfPrice = edHalfPrice.getText().toString();
        fullPlate = edFullPlate.getText().toString();
        fullPrice = edFullPrice.getText().toString();
        combo = edCombo.getText().toString();
        phone = edPhone.getText().toString();

        if (menu.isEmpty()){
            edMenu.requestFocus();
            edMenu.setError("menu can't empty...");
            return;
        } else if (!menu.matches("[a-zA-Z0-9 ]+")) {
            edMenu.requestFocus();
            edMenu.setError("Invalid try again...");
            return;
        }else if (half.isEmpty()){
            edHalf.requestFocus();
            edHalf.setError("half can't empty...");
            return;
        } else if (!half.matches("[a-zA-Z0-9 ]+")) {
            edHalf.requestFocus();
            edHalf.setError("Invalid try again...");
            return;
        }else if (halfPrice.isEmpty()){
            edHalfPrice.requestFocus();
            edHalfPrice.setError("halfPlate price can't empty...");
            return;
        } else if (!halfPrice.matches("[a-zA-Z0-9 ]+")) {
            edHalfPrice.requestFocus();
            edHalfPrice.setError("Invalid try again...");
            return;
        }else if (fullPlate.isEmpty()){
            edFullPlate.requestFocus();
            edFullPlate.setError("fullPlate can't empty...");
            return;
        } else if (!fullPlate.matches("[a-zA-Z0-9 ]+")) {
            edFullPlate.requestFocus();
            edFullPlate.setError("Invalid try again...");
            return;
        }else if (fullPrice.isEmpty()){
            edFullPrice.requestFocus();
            edFullPrice.setError("halfPlate price can't empty...");
            return;
        } else if (!fullPrice.matches("[a-zA-Z0-9 ]+")) {
            edFullPrice.requestFocus();
            edFullPrice.setError("Invalid try again...");
            return;
        } else if (combo.isEmpty()) {
            edCombo.requestFocus();
            edCombo.setError("combo can't empty...");
            return;
        } else if (!combo.matches("[a-zA-Z0-9 ]+")) {
            edCombo.requestFocus();
            edCombo.setError("Invalid try again...");
            return;
        } else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone number can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }if (discount.equals("Please Select Discount Allow")){
            Toast.makeText(getActivity(), "Please Select Valid Option...", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = canteenDataBase.InsertDataCanteen(menu,half,halfPrice,fullPlate,fullPrice,discount,combo,phone);
        if (b==true){
            Toast.makeText(getActivity(), "SuccessFully...", Toast.LENGTH_SHORT).show();
            edMenu.setText("");
            edHalf.setText("");
            edHalfPrice.setText("");
            edFullPlate.setText("");
            edFullPrice.setText("");
            edCombo.setText("");
            edPhone.setText("");
            spinDiscounts.setSelection(0);
        }else {
            Toast.makeText(getActivity(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }
    public void SetDiscountAllow(){
        ArrayList<String> discountAllow = new ArrayList<>();
        discountAllow.add("Please Select Discount Allow");
        discountAllow.add("99 to 150 → 5%");
        discountAllow.add("151 to 300 → 7%");
        discountAllow.add("301 to 500 → 10%");
        discountAllow.add("501 to 800 → 15%");
        discountAllow.add("801 to 1200 → 20%");
        discountAllow.add("1201 to 2000 → 25%");
        discountAllow.add("Above 2000 → 100%");

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,discountAllow);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinDiscounts.setAdapter(arrayAdapter);


    }

}