package com.example.hospitalmanagementsystem.PharmacyManageTask;

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

public class PharmacyUpdateActivity extends AppCompatActivity {
    EditText EdName,EdPharmacyEmail,EdPharmacist,EdPharmacyPhone,EdPharmacyLocation;
    Spinner SpinPharmacyQualification,SpinPharmacyEmergency,SpinDiscount,SpinReturnPolicy,SpinEmergencyTime,SpinHomeDelivery;
    Button BtnSubmit;
    String name,email,phone,location,pharmacyName,qualification,EmergencyService,discount,returns,EmergencyTime,home;
    PharmacyDetailDataBase pharmacyDetailData;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pharmacy_update);

        EdName = findViewById(R.id.EdName);
        EdPharmacyEmail = findViewById(R.id.EdPharmacyEmail);
        EdPharmacist = findViewById(R.id.EdPharmacist);
        EdPharmacyPhone = findViewById(R.id.EdPharmacyPhone);
        EdPharmacyLocation = findViewById(R.id.EdPharmacyLocation);
        SpinPharmacyQualification = findViewById(R.id.SpinPharmacyQualification);
        SpinPharmacyEmergency = findViewById(R.id.SpinPharmacyEmergency);
        SpinDiscount = findViewById(R.id.SpinDiscount);
        SpinReturnPolicy = findViewById(R.id.SpinReturnPolicy);
        SpinEmergencyTime = findViewById(R.id.SpinEmergencyTime);
        SpinHomeDelivery = findViewById(R.id.SpinHomeDelivery);
        BtnSubmit = findViewById(R.id.BtnSubmit);
        pharmacyDetailData = new PharmacyDetailDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        EdName.setText(getIntent().getStringExtra("name"));
        EdPharmacyEmail.setText(getIntent().getStringExtra("email"));
        EdPharmacist.setText(getIntent().getStringExtra("pharmacy"));
        EdPharmacyPhone.setText(getIntent().getStringExtra("phone"));
        EdPharmacyLocation.setText(getIntent().getStringExtra("location"));
        qualification = getIntent().getStringExtra("qualification");
        EmergencyService = getIntent().getStringExtra("service");
        discount = getIntent().getStringExtra("discounts");
        returns = getIntent().getStringExtra("returns");
        EmergencyTime = getIntent().getStringExtra("time");
        home = getIntent().getStringExtra("home");


        SelectQualification();
        SelectEmergencyOpenClose();
        SelectDiscount();
        SelectEmergencyArrivalTime();
        SelectReturn();
        SelectHomeDelivery();

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetInsertPharmacyDetails();
            }
        });

        SpinPharmacyQualification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                qualification = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinPharmacyEmergency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EmergencyService = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinDiscount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                discount = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinEmergencyTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EmergencyTime = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinReturnPolicy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                returns = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinHomeDelivery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                home = parent.getItemAtPosition(position).toString();
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
    public void SetInsertPharmacyDetails(){
        name = EdName.getText().toString();
        email= EdPharmacyEmail.getText().toString();
        phone = EdPharmacyPhone.getText().toString();
        location = EdPharmacyLocation.getText().toString();
        pharmacyName = EdPharmacist.getText().toString();

        if (name.isEmpty()){
            EdName.requestFocus();
            EdName.setError("Name Can't Empty....");
            return;
        }else if (!name.matches("[a-zA-Z ]+")){
            EdName.requestFocus();
            EdName.setError("Invalid Name try again.....");
            return;
        }else if (email.isEmpty()){
            EdPharmacyEmail.requestFocus();
            EdPharmacyEmail.setError("Email can't empty.....");
            return;
        }else if (!email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+")){
            EdPharmacyEmail.requestFocus();
            EdPharmacyEmail.setError("Invalid Email try again.....");
            return;
        }else if (pharmacyName.isEmpty()){
            EdPharmacist.requestFocus();
            EdPharmacist.setError("Pharmacy Duty can't empty........");
            return;
        }else if (!pharmacyName.matches("[a-zA-Z ]+")){
            EdPharmacist.requestFocus();
            EdPharmacist.setError("Invalid Pharmacy Duty try again.....");
            return;
        }else if (phone.isEmpty()){
            EdPharmacyPhone.requestFocus();
            EdPharmacyPhone.setError("Phone can't empty.....");
            return;
        }else if (!phone.matches("[0-9]+\\d{9}")){
            EdPharmacyPhone.requestFocus();
            EdPharmacyPhone.setError("Invalid Phone try again.....");
            return;
        }else if (location.isEmpty()){
            EdPharmacyLocation.requestFocus();
            EdPharmacyLocation.setError("Location can't empty.....");
            return;
        }else if (!location.matches("[a-zA-Z0-9 ]+")){
            EdPharmacyLocation.requestFocus();
            EdPharmacyLocation.setError("Invalid Location try again.....");
            return;
        } if (qualification.equals("Select Category Pharmacy")){
            Toast.makeText(getApplicationContext(), "Select Valid Qualification Option", Toast.LENGTH_SHORT).show();
            return;
        } if (EmergencyService.equals("Select Pharmacy Service Timing")){
            Toast.makeText(getApplicationContext(), "Select Valid EmergencyTime Option", Toast.LENGTH_SHORT).show();
            return;
        } if (returns.equals("Select Return Medicine Policy")){
            Toast.makeText(getApplicationContext(), "Select Valid ReturnPolicy Option", Toast.LENGTH_SHORT).show();
            return;
        } if (discount.equals("Select Medicine Discount")){
            Toast.makeText(getApplicationContext(), "Select Valid Discount Option", Toast.LENGTH_SHORT).show();
            return;
        } if (EmergencyTime.equals("Select Medicine Delivery Time")){
            Toast.makeText(getApplicationContext(), "Select Valid EmergencyAvailable Option", Toast.LENGTH_SHORT).show();
            return;
        } if (home.equals("Select Medicine Delivery Category")){
            Toast.makeText(getApplicationContext(), "Select Valid Home Delivery Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = pharmacyDetailData.InsertUpdateDetails(id,name,email,phone,location,pharmacyName,qualification,EmergencyService,returns,discount,EmergencyTime,home);
        if (b==true){
            Toast.makeText(getApplicationContext(), "Update SuccessFully....", Toast.LENGTH_SHORT).show();
            EdName.setText("");
            EdPharmacyEmail.setText("");
            EdPharmacist.setText("");
            EdPharmacyPhone.setText("");
            EdPharmacyLocation.setText("");
            SpinPharmacyQualification.setSelection(0);
            SpinPharmacyEmergency.setSelection(0);
            SpinReturnPolicy.setSelection(0);
            SpinDiscount.setSelection(0);
            SpinHomeDelivery.setSelection(0);
            SpinEmergencyTime.setSelection(0);
        }else {
            Toast.makeText(getApplicationContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectEmergencyOpenClose(){
        ArrayList<String> SelectPharmacyService = new ArrayList<>();
        SelectPharmacyService.add("Select Pharmacy Service Timing");
        SelectPharmacyService.add("24 * 7 Service");  // 24 hours, 7 days a week
        SelectPharmacyService.add("24 * 6 Service (Closed on Sunday)");
        SelectPharmacyService.add("24 * 5 Service (Mon-Fri)");
        SelectPharmacyService.add("Daytime Service (8 AM - 8 PM)");
        SelectPharmacyService.add("Morning Service (8 AM - 12 PM)");
        SelectPharmacyService.add("Afternoon Service (12 PM - 4 PM)");
        SelectPharmacyService.add("Evening Service (4 PM - 8 PM)");
        SelectPharmacyService.add("Night Service (8 PM - 8 AM)");
        SelectPharmacyService.add("Weekend Service (Sat-Sun)");
        SelectPharmacyService.add("Weekday Service (Mon-Fri)");
        SelectPharmacyService.add("Emergency / On Call Service");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectPharmacyService);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinPharmacyEmergency.setAdapter(arrayAdapter);
        if (SelectPharmacyService!=null){
            int position = arrayAdapter.getPosition(EmergencyService.trim());
            if (position>0){
                SpinPharmacyEmergency.setSelection(position);
            }
        }
    }

    public void SelectDiscount(){
        ArrayList<String> SelectMedicineDiscount = new ArrayList<>();
        SelectMedicineDiscount.add("Select Medicine Discount");
        SelectMedicineDiscount.add("No Discount (Below ₹1000)");
        SelectMedicineDiscount.add("5% Discount (₹1000 - ₹1499)");
        SelectMedicineDiscount.add("7% Discount (₹1500 - ₹1999)");
        SelectMedicineDiscount.add("10% Discount (₹2000 - ₹2499)");
        SelectMedicineDiscount.add("12% Discount (₹2500 - ₹2999)");
        SelectMedicineDiscount.add("15% Discount (₹3000 & Above)");
        SelectMedicineDiscount.add("Seasonal / Festival Discount");
        SelectMedicineDiscount.add("Membership / Loyalty Discount");
        SelectMedicineDiscount.add("Bulk Purchase Discount (10+ Medicines)");
        SelectMedicineDiscount.add("Special Offer - Buy 1 Get 1 Free");
        SelectMedicineDiscount.add("Emergency / Priority Delivery Discount");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectMedicineDiscount);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinDiscount.setAdapter(arrayAdapter);

        if (SelectMedicineDiscount!=null){
            int position = arrayAdapter.getPosition(discount.trim());
            if (position>0){
                SpinDiscount.setSelection(position);
            }
        }

    }

    public void SelectReturn(){
        ArrayList<String> SelectReturnMedicine = new ArrayList<>();
        SelectReturnMedicine.add("Select Return Medicine Policy");
        SelectReturnMedicine.add("Unopened / Sealed Medicine - Within 24 Hours");
        SelectReturnMedicine.add("Unopened / Sealed Medicine - Within 48 Hours");
        SelectReturnMedicine.add("Unopened / Sealed Medicine - Within 7 Days");
        SelectReturnMedicine.add("Opened Medicine - Not Returnable");
        SelectReturnMedicine.add("Defective / Damaged Medicine - Return Within 24 Hours");
        SelectReturnMedicine.add("Expired Medicine - Return Within 7 Days");
        SelectReturnMedicine.add("Prescription Error - Return Within 48 Hours");
        SelectReturnMedicine.add("Replacement Only - No Refund");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectReturnMedicine);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinReturnPolicy.setAdapter(arrayAdapter);

        if (SelectReturnMedicine!=null){
            int position = arrayAdapter.getPosition(returns.trim());
            if (position>0){
                SpinReturnPolicy.setSelection(position);
            }
        }

    }

    public void SelectEmergencyArrivalTime(){
        ArrayList<String> SelectEmergencyArrivalTime = new ArrayList<>();
        SelectEmergencyArrivalTime.add("Select Medicine Delivery Time");
        SelectEmergencyArrivalTime.add("Immediate / ASAP - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Within 1 Hour - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Within 2 Hours - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Within 4 Hours - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Morning (8 AM - 12 PM) - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Afternoon (12 PM - 4 PM) - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Evening (4 PM - 8 PM) - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Night (8 PM - 10 PM) - ₹50 (Under ₹500) / Free (Above ₹500)");
        SelectEmergencyArrivalTime.add("Scheduled Time (Custom) - ₹50 (Under ₹500) / Free (Above ₹500)");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectEmergencyArrivalTime);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinEmergencyTime.setAdapter(arrayAdapter);

        if (SelectEmergencyArrivalTime!=null){
            int position = arrayAdapter.getPosition(EmergencyTime.trim());
            if (position>0){
                SpinEmergencyTime.setSelection(position);
            }
        }

    }

    public void SelectHomeDelivery(){
        ArrayList<String> SelectDelivery = new ArrayList<>();
        SelectDelivery.add("Select Medicine Delivery Category");
        SelectDelivery.add("In-Pharmacy Pickup - Free");
        SelectDelivery.add("In-Hospital Ward Delivery - Free");
        SelectDelivery.add("Home Delivery - Free (Above ₹500)");
        SelectDelivery.add("Home Delivery - ₹50 (Under ₹500)");
        SelectDelivery.add("Online Order Delivery - Free (Above ₹500)");
        SelectDelivery.add("Online Order Delivery - ₹50 (Under ₹500)");
        SelectDelivery.add("Emergency / 24x7 Delivery - ₹100");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectDelivery);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinHomeDelivery.setAdapter(arrayAdapter);

        if (SelectDelivery!=null){
            int position = arrayAdapter.getPosition(home.trim());
            if (position>0){
                SpinHomeDelivery.setSelection(position);
            }
        }

    }

    public void SelectQualification(){
        ArrayList<String> SelectQualification = new ArrayList<>();
        SelectQualification.add("Select Category Pharmacy");
        SelectQualification.add("D Pharmacy");
        SelectQualification.add("B Pharmacy");
        SelectQualification.add("M Pharmacy");
        SelectQualification.add("Pharm D");
        SelectQualification.add("Pharm D (Post Baccalaureate)");
        SelectQualification.add("PhD in Pharmacy");
        SelectQualification.add("Diploma in Pharmacy Practice");
        SelectQualification.add("Certificate in Pharmaceutical Sciences");
        SelectQualification.add("MSc in Pharmaceutical Chemistry");
        SelectQualification.add("MSc in Pharmacology");
        SelectQualification.add("MSc in Pharmacognosy");
        SelectQualification.add("MSc in Pharmaceutics");
        SelectQualification.add("MSc in Industrial Pharmacy");
        SelectQualification.add("PG Diploma in Clinical Research");
        SelectQualification.add("PG Diploma in Pharmaceutical Management");
        SelectQualification.add("PG Diploma in Quality Assurance");
        SelectQualification.add("PG Diploma in Drug Regulatory Affairs");
        SelectQualification.add("MBA in Pharmaceutical Management");
        SelectQualification.add("MBA in Hospital and Healthcare Management");
        SelectQualification.add("BSc in Pharmaceutical Sciences");
        SelectQualification.add("BSc in Clinical Pharmacy");
        SelectQualification.add("BSc in Pharmacology");
        SelectQualification.add("Certificate Course in Drug Safety");
        SelectQualification.add("Certificate Course in Pharmacovigilance");
        SelectQualification.add("Certificate Course in Clinical Research");
        SelectQualification.add("Certificate Course in Quality Control");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,SelectQualification);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinPharmacyQualification.setAdapter(arrayAdapter);

        if (SelectQualification!=null){
            int position = arrayAdapter.getPosition(qualification.trim());
            if (position>0){
                SpinPharmacyQualification.setSelection(position);
            }
        }
    }

}