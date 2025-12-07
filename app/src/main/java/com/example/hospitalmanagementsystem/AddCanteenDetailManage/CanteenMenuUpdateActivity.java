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

public class CanteenMenuUpdateActivity extends AppCompatActivity {
    EditText edMenu,edHalf,edHalfPrice,edFullPlate,edFullPrice,edCombo,edPhone;
    Spinner spinDiscounts;
    Button btnSubmit;
    String menu,half,halfPrice,fullPlate,fullPrice,combo,phone,discount;
    CanteenDataBase canteenDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_canteen_menu_update);


        edMenu = findViewById(R.id.edMenu);
        edHalf = findViewById(R.id.edHalf);
        edHalfPrice = findViewById(R.id.edHalPrice);
        edFullPlate = findViewById(R.id.edFullPlate);
        edFullPrice = findViewById(R.id.edFullPrice);
        spinDiscounts = findViewById(R.id.SpinDiscountAllow);
        edCombo = findViewById(R.id.edCombo);
        edPhone = findViewById(R.id.edPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        canteenDataBase = new CanteenDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        edMenu.setText(getIntent().getStringExtra("menu"));
        edHalf.setText(getIntent().getStringExtra("half"));
        edHalfPrice.setText(getIntent().getStringExtra("halfPrice"));
        edFullPlate.setText(getIntent().getStringExtra("fully"));
        edFullPrice.setText(getIntent().getStringExtra("fullyPrice"));
        discount = getIntent().getStringExtra("discount");
        edCombo.setText(getIntent().getStringExtra("combo"));
        edPhone.setText(getIntent().getStringExtra("phone"));


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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
            Toast.makeText(getApplicationContext(), "Please Select Valid Option...", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = canteenDataBase.UpdateDataCanteen(id,menu,half,halfPrice,fullPlate,fullPrice,discount,combo,phone);
        if (b==true){
            Toast.makeText(getApplicationContext(), "SuccessFully...", Toast.LENGTH_SHORT).show();
            edMenu.setText("");
            edHalf.setText("");
            edHalfPrice.setText("");
            edFullPlate.setText("");
            edFullPrice.setText("");
            edCombo.setText("");
            edPhone.setText("");
            spinDiscounts.setSelection(0);
        }else {
            Toast.makeText(getApplicationContext(), "Failed...", Toast.LENGTH_SHORT).show();
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

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,discountAllow);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinDiscounts.setAdapter(arrayAdapter);

        if (discountAllow!=null){
            int position = arrayAdapter.getPosition(discount.toString());
         if (position>0){
             spinDiscounts.setSelection(position);
            }
        }
    }
}