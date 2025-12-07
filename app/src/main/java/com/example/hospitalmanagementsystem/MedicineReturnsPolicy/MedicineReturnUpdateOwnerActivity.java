package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

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

public class MedicineReturnUpdateOwnerActivity extends AppCompatActivity {
    EditText edName,edPhone;
    Spinner spinCondition;
    Button btnSubmit;
    String name,condition,phone;
    MedicineReturnPolicyDataBase medicineReturnPolicyDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicine_return_update_owner);

        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        spinCondition = findViewById(R.id.spinCondition);
        btnSubmit = findViewById(R.id.btnSubmit);
         medicineReturnPolicyDataBase = new MedicineReturnPolicyDataBase(getApplicationContext());

           id = getIntent().getIntExtra("id",0);
           edName.setText(getIntent().getStringExtra("name"));
           condition = getIntent().getStringExtra("condition");
           edPhone.setText(getIntent().getStringExtra("phone"));

        SelectMedicineReturnCondition();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertAddPolicyData();
            }
        });

        spinCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                condition = parent.getItemAtPosition(position).toString();
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

    public void InsertAddPolicyData(){

        name = edName.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z0-9 ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        } else if (phone.isEmpty()) {
            edPhone.requestFocus();
            edPhone.setError("phone number can't empty...");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            edPhone.requestFocus();
            edPhone.setError("Invalid try again....");
            return;
        }
        boolean b = medicineReturnPolicyDataBase.UpdateDataPolicy(id,name,condition,phone);
        if (b==true){
            Toast.makeText(getApplicationContext(), "Update SuccessFully...", Toast.LENGTH_SHORT).show();
            edName.setText("");
            spinCondition.setSelection(0);
            edPhone.setText("");
        }else {
            Toast.makeText(getApplicationContext(), "Failed....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectMedicineReturnCondition(){
        ArrayList<String> selectPolicy = new ArrayList<>();
        selectPolicy.add("Please Select Medicine Policy");
        selectPolicy.add("Return within 7 days");
        selectPolicy.add("Return within 15 days");
        selectPolicy.add("No return after opening");
        selectPolicy.add("Refund only with bill");
        selectPolicy.add("Exchange only – no refund");
        selectPolicy.add("Return allowed only before expiry date");
        selectPolicy.add("Return not accepted after 30 days");
        selectPolicy.add("Damaged product return within 48 hours");
        selectPolicy.add("Return only with original packaging");
        selectPolicy.add("Return not accepted without batch number");
        selectPolicy.add("Temperature-sensitive items not returnable");
        selectPolicy.add("Insulin products not returnable");
        selectPolicy.add("Expired products cannot be returned");
        selectPolicy.add("Billing name must match customer ID");
        selectPolicy.add("Return allowed only with doctor prescription");
        selectPolicy.add("Return not allowed for discounted items");
        selectPolicy.add("Opened strips are non-returnable");
        selectPolicy.add("Return only if seal is intact");
        selectPolicy.add("Return only for manufacturing defect");
        selectPolicy.add("Return subject to quality check");
        selectPolicy.add("Return request must be raised within 24 hours");
        selectPolicy.add("Refund processed within 3–5 working days");
        selectPolicy.add("Exchange allowed within 48 hours");
        selectPolicy.add("Exchange allowed only for same product");
        selectPolicy.add("Return allowed for wrong item delivered");
        selectPolicy.add("No refund for controlled drugs");
        selectPolicy.add("Narcotics and psychotropic drugs non-returnable");
        selectPolicy.add("Cold-chain medicines non-returnable");
        selectPolicy.add("Vaccine products cannot be returned");
        selectPolicy.add("Biological products are not returnable");
        selectPolicy.add("Liquid medicines return only if seal intact");
        selectPolicy.add("Glass bottle breakage not covered");
        selectPolicy.add("Return only for unexpired products");
        selectPolicy.add("Return only within working hours");
        selectPolicy.add("Return not accepted during stock clearance");
        selectPolicy.add("Return only after approval from pharmacist");
        selectPolicy.add("Return allowed only with proper invoice");
        selectPolicy.add("Medicine recall items must be returned immediately");
        selectPolicy.add("Refund only after batch verification");
        selectPolicy.add("Return packaging must be clean & unused");
        selectPolicy.add("Online order returns require order ID");
        selectPolicy.add("Return only through registered mobile number");
        selectPolicy.add("Return charges may apply");
        selectPolicy.add("Cash refunds above ₹500 processed via bank");
        selectPolicy.add("No return without valid reason");
        selectPolicy.add("Return window depends on product category");
        selectPolicy.add("Return not accepted for gift cards");
        selectPolicy.add("Return not accepted for sample medicines");
        selectPolicy.add("Return not allowed for hospital-supplied medicines");
        selectPolicy.add("Damaged strip return not accepted");
        selectPolicy.add("Return of Schedule H drugs restricted");
        selectPolicy.add("Return only for incorrect billing");
        selectPolicy.add("Return allowed only with batch verification");
        selectPolicy.add("Temperature-damaged products non-returnable");
        selectPolicy.add("Return allowed only for sealed bottles");
        selectPolicy.add("Free items cannot be returned");
        selectPolicy.add("Exchange allowed for packing damage only");
        selectPolicy.add("Return claim must include photographs");
        selectPolicy.add("Opened bottle returns are not allowed");
        selectPolicy.add("Return allowed only for allergic reactions with doctor note");
        selectPolicy.add("Return only allowed for expired items purchased within 7 days");
        selectPolicy.add("No return after dispatch for online orders");
        selectPolicy.add("Return only allowed if delivery was delayed");
        selectPolicy.add("Refund subject to company policy");
        selectPolicy.add("Return only for incorrect quantity received");
        selectPolicy.add("Return not allowed if product label removed");
        selectPolicy.add("Return not allowed for promotional packs");
        selectPolicy.add("Return allowed only for leakage complaints");
        selectPolicy.add("Return request must match batch & invoice");
        selectPolicy.add("Online return allowed only within 3 days");
        selectPolicy.add("Return not allowed for custom-order medicines");
        selectPolicy.add("Return not allowed for imported medicines");
        selectPolicy.add("Return allowed only for unused syringes");
        selectPolicy.add("Return allowed for doctor-recommended replacements");
        selectPolicy.add("Return of injection vials not allowed");
        selectPolicy.add("Return allowed only for strip mismatch");
        selectPolicy.add("Multiple returns not allowed for same order");
        selectPolicy.add("Return allowed only once per order");
        selectPolicy.add("Return request must be approved via app");
        selectPolicy.add("Return only for approved defective batch numbers");
        selectPolicy.add("Refund only through original payment mode");
        selectPolicy.add("Return allowed only with expiration verification");
        selectPolicy.add("Return of pediatric medicines restricted");
        selectPolicy.add("Return request must include reason code");
        selectPolicy.add("Refund timeline may vary by payment method");
        selectPolicy.add("Return allowed only if product not tampered");
        selectPolicy.add("Return allowed for incorrect MRP printed");
        selectPolicy.add("Return not allowed for part-used bottles");
        selectPolicy.add("Return allowed only before medicine is opened");
        selectPolicy.add("Return allowed only for prescriptions older than 3 days");
        selectPolicy.add("Return allowed only with company authorization");
        selectPolicy.add("Return not allowed after policy change");
        selectPolicy.add("Return allowed only for temperature excursion");
        selectPolicy.add("Return only when original container provided");
        selectPolicy.add("Return not allowed for items bought during festive sale");
        selectPolicy.add("Return only for incorrect batch number delivered");
        selectPolicy.add("Return allowed only for tampered seal complaint");
        selectPolicy.add("Return not allowed for items below ₹10 value");
        selectPolicy.add("Return allowed only for transport damage");
        selectPolicy.add("Return not allowed for injection syringes once opened");
        selectPolicy.add("Return only allowed for duplicate items received");
        selectPolicy.add("Return allowed only for mismatch in strip count");
        selectPolicy.add("Return allowed only for missing items");
        selectPolicy.add("Return requires prior approval via phone");
        selectPolicy.add("Return not accepted for blood-related products");
        selectPolicy.add("Return of medical devices allowed within 7 days");
        selectPolicy.add("Return only allowed for faulty dispenser cap");
        selectPolicy.add("Return allowed only for damaged blister pack");
        selectPolicy.add("Return allowed for incorrect dosage form delivered");
        selectPolicy.add("Return not allowed for O.T.C. products sold on discount");
        selectPolicy.add("Return allowed only for duplicate packaging");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,selectPolicy);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinCondition.setAdapter(arrayAdapter);

        if (selectPolicy!=null){
            int position = arrayAdapter.getPosition(condition.toString());
            if (position>0){
                spinCondition.setSelection(position);
            }
        }
    }

}