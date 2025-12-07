package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

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

import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.CheckUpBookingDataBase;
import com.example.hospitalmanagementsystem.AddBodyCheckUpCost.CheckupBodyDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class BookingPageOrganActivity extends AppCompatActivity {
    EditText edName,edPart,edPrice,edPhone;
    Spinner spinDiscount;
    Button btnSubmit;
    String name,part,price,phone,discounts;
    CheckUpBookingDataBase checkUpBookingDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking_page_organ);


        edName = findViewById(R.id.edName);
        edPart = findViewById(R.id.edPart);
        edPrice = findViewById(R.id.edPrice);
        edPhone = findViewById(R.id.edPhone);
        spinDiscount = findViewById(R.id.spinDiscount);
        btnSubmit = findViewById(R.id.btnSubmit);
        checkUpBookingDataBase = new CheckUpBookingDataBase(getApplicationContext());

        edName.setText(getIntent().getStringExtra("name"));
        edPart.setText(getIntent().getStringExtra("part"));
        edPrice.setText(getIntent().getStringExtra("price"));
        discounts = getIntent().getStringExtra("discounts");
        edPhone.setText(getIntent().getStringExtra("phone"));

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


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
        }if (discounts.equals("Please Select Discount")){
            Toast.makeText(this, "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = checkUpBookingDataBase.InsertData(name,part,price,discounts,phone);
        if (b==true){
            edName.setText("");
            edPart.setText("");
            edPrice.setText("");
            edPhone.setText("");
            spinDiscount.setSelection(0);
            Toast.makeText(getApplicationContext(), "Booking SuccessFully....", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Failed...", Toast.LENGTH_SHORT).show();
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

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,discount);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinDiscount.setAdapter(arrayAdapter);

      if (discount!=null){
          int position = arrayAdapter.getPosition(discounts.toString());
          if (position>0){
              spinDiscount.setSelection(position);
          }
      }

    }

}