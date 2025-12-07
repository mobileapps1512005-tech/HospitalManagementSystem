package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class CanteenOwnerAcceptFoodActivity extends AppCompatActivity {
    EditText edName,edItemsName,edBad,edPhone;
    Button btnSubmit;
    Spinner spinQuantity,spinFloor;
    String name,menuItem,quantity,floor,bed,phone;
    FoodOrderPatientDataBase foodOrderPatientDataBase;
    int id;
    OwnerConfirmationDataBase ownerConfirmationDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_canteen_owner_accept_food);


        edName = findViewById(R.id.edName);
        edItemsName = findViewById(R.id.edItemsName);
        edBad = findViewById(R.id.edBad);
        edPhone = findViewById(R.id.edPhone);
        spinQuantity = findViewById(R.id.SpinQuantity);
        spinFloor = findViewById(R.id.SpinFloor);
        btnSubmit = findViewById(R.id.btnSubmit);
        foodOrderPatientDataBase = new FoodOrderPatientDataBase(getApplication());
        ownerConfirmationDataBase = new OwnerConfirmationDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        edName.setText(getIntent().getStringExtra("name"));
        edItemsName.setText(getIntent().getStringExtra("menu"));
        quantity = getIntent().getStringExtra("quantity");
        floor  = getIntent().getStringExtra("floor");
        edBad.setText(getIntent().getStringExtra("bad"));
        edPhone.setText(getIntent().getStringExtra("phone"));

        edName.setEnabled(false);
        edItemsName.setEnabled(false);
        spinQuantity.setEnabled(false);
        spinFloor.setEnabled(false);
        edBad.setEnabled(false);
        edPhone.setEnabled(false);

        SelectQuantity();
        SelectFool();



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertBookingData();
            }
        });

        spinQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quantity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinFloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                floor = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void InsertBookingData(){
        name = edName.getText().toString();
        menuItem = edItemsName.getText().toString();
        bed = edBad.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        } else if (menuItem.isEmpty()) {
            edItemsName.requestFocus();
            edItemsName.setError("food name can't empty...");
            return;
        } else if (!menuItem.matches("[a-zA-Z0-9 ]+")) {
            edItemsName.requestFocus();
            edItemsName.setError("Invalid try again...");
            return;
        }else if (bed.isEmpty()) {
            edBad.requestFocus();
            edBad.setError("bed can't empty...");
            return;
        } else if (!bed.matches("[a-zA-Z0-9 ]+")) {
            edBad.requestFocus();
            edBad.setError("Invalid try again...");
            return;
        }else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again...");
            return;
        }
        boolean b = ownerConfirmationDataBase.OwnerInsertBookingData(name,menuItem,quantity,floor,bed,phone);
        if (b==true){
            Toast.makeText(this, "Confirmation SuccessFully....", Toast.LENGTH_SHORT).show();
            edName.setText("");
            edItemsName.setText("");
            spinQuantity.setSelection(0);
            spinFloor.setSelection(0);
            edBad.setText("");
            edPhone.setText("");
            foodOrderPatientDataBase.DeleteGetAll(id);
        }else {
            Toast.makeText(this, "Failed....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectQuantity(){

        ArrayList<String> selectQuantity = new ArrayList<>();
        selectQuantity.add("Please Select Quantity");
        selectQuantity.add("Quantity 1");
        selectQuantity.add("Quantity 2");
        selectQuantity.add("Quantity 3");
        selectQuantity.add("Quantity 4");
        selectQuantity.add("Quantity 5");
        selectQuantity.add("Quantity 6");
        selectQuantity.add("Quantity 7");
        selectQuantity.add("Quantity 8");
        selectQuantity.add("Quantity 9");
        selectQuantity.add("Quantity 10");
        selectQuantity.add("Quantity 11");
        selectQuantity.add("Quantity 12");
        selectQuantity.add("Quantity 13");
        selectQuantity.add("Quantity 14");
        selectQuantity.add("Quantity 15");
        selectQuantity.add("Quantity 16");
        selectQuantity.add("Quantity 17");
        selectQuantity.add("Quantity 18");
        selectQuantity.add("Quantity 19");
        selectQuantity.add("Quantity 20");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,selectQuantity);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinQuantity.setAdapter(arrayAdapter);

        if (quantity!=null){
         int position = arrayAdapter.getPosition(quantity.toString());
            if (position>0) {
                spinQuantity.setSelection(position);
            }
        }

    }

    public void SelectFool(){
        ArrayList<String> selectFloor = new ArrayList<>();

        selectFloor.add("Please Select Floor");
        selectFloor.add("Floor 1");
        selectFloor.add("Floor 2");
        selectFloor.add("Floor 3");
        selectFloor.add("Floor 4");
        selectFloor.add("Floor 5");
        selectFloor.add("Floor 6");
        selectFloor.add("Floor 7");
        selectFloor.add("Floor 8");
        selectFloor.add("Floor 9");
        selectFloor.add("Floor 10");
        selectFloor.add("Floor 11");
        selectFloor.add("Floor 12");
        selectFloor.add("Floor 13");
        selectFloor.add("Floor 14");
        selectFloor.add("Floor 15");
        selectFloor.add("Floor 16");
        selectFloor.add("Floor 17");
        selectFloor.add("Floor 18");
        selectFloor.add("Floor 19");
        selectFloor.add("Floor 20");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,selectFloor);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinFloor.setAdapter(arrayAdapter);

          if (floor!=null){
              int position = arrayAdapter.getPosition(floor.toString());
              if (position>0){
                  spinFloor.setSelection(position);
              }
          }
    }
}