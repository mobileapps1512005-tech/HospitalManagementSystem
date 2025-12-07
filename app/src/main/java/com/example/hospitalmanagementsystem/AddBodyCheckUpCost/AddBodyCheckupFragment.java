package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

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


public class AddBodyCheckupFragment extends Fragment {
EditText edName,edPart,edPrice,edPhone;
Spinner spinDiscount;
Button btnSubmit;
String name,part,price,phone,discounts;
CheckupBodyDataBase checkupBodyDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_body_checkup, container, false);

         edName = view.findViewById(R.id.edName);
         edPart = view.findViewById(R.id.edPart);
         edPrice = view.findViewById(R.id.edPrice);
         edPhone = view.findViewById(R.id.edPhone);
         spinDiscount = view.findViewById(R.id.spinDiscount);
         btnSubmit = view.findViewById(R.id.btnSubmit);
         checkupBodyDataBase = new CheckupBodyDataBase(getContext());


         SelectDiscount();
         btnSubmit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 InsertDataCheckup();
             }
         });

         spinDiscount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  discounts = parent.getItemAtPosition(position).toString();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

        return view;


    }

    public void InsertDataCheckup(){

        name = edName.getText().toString();
        part = edPart.getText().toString();
        price = edPrice.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try Again...");
            return;
        } else if (part.isEmpty()) {
            edPart.requestFocus();
            edPart.setError("part can't empty...");
            return;
        } else if (!part.matches("[a-zA-Z0-9 ]+")) {
            edPart.requestFocus();
            edPart.setError("Invalid try again...");
            return;
        } else if (price.isEmpty()) {
            edPrice.requestFocus();
            edPrice.setError("price can't empty...");
            return;
        } else if (!price.matches("[a-zA-Z0-9 ]+")) {
            edPrice.requestFocus();
            edPrice.setError("Invalid try again...");
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
        boolean b = checkupBodyDataBase.InsertData(name,part,price,discounts,phone);
        if (b==true){
            edName.setText("");
            edPart.setText("");
            edPrice.setText("");
            edPhone.setText("");
            spinDiscount.setSelection(0);
            Toast.makeText(getContext(), "SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }
    public void SelectDiscount(){

        ArrayList<String> discount = new ArrayList<>();
        discount.add("Please Select Discount");
        discount.add("Discount Not Available");
        discount.add("5% discount Available");
        discount.add("10% discount Available");
        discount.add("15% discount Available");
        discount.add("20% discount Available");
        discount.add("25% discount Available");
        discount.add("30% discount Available");
        discount.add("35% discount Available");
        discount.add("40% discount Available");
        discount.add("45% discount Available");
        discount.add("50% discount Available");
        discount.add("55% discount Available");
        discount.add("60% discount Available");
        discount.add("65% discount Available");
        discount.add("70% discount Available");
        discount.add("75% discount Available");
        discount.add("80% discount Available");
        discount.add("85% discount Available");
        discount.add("90% discount Available");
        discount.add("95% discount Available");
        discount.add("100% discount Available");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,discount);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinDiscount.setAdapter(arrayAdapter);



    }

}