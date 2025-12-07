package com.example.hospitalmanagementsystem.InsuranceModule;

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

public class InsuranceUpdateActivity extends AppCompatActivity {
    EditText etFullName,etDOB,etPhone,etEmail,etID,etPolicyNumber,etPolicyStart,etPolicyEnd,etNomineeName,etHospitalName;
    Spinner spGender,spInsuranceCompany,spHospitalBranch;
    Button btnSubmitClaim;
    String name,dob,gender,phone,email,aadhar,policyNumber,selectCompany,selectHospital,date,time,nominee,hospita;
    InsuranceDataBase insuranceDataBase;
    int ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inurance_update);

        etFullName = findViewById(R.id.etFullName);
        etDOB = findViewById(R.id.etDOB);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etID = findViewById(R.id.etID);
        etPolicyNumber = findViewById(R.id.etPolicyNumber);
        etPolicyStart = findViewById(R.id.etPolicyStart);
        etPolicyEnd = findViewById(R.id.etPolicyEnd);
        etNomineeName = findViewById(R.id.etNomineeName);
        etHospitalName = findViewById(R.id.etHospitalName);
        spHospitalBranch = findViewById(R.id.spHospitalBranch);
        spGender = findViewById(R.id.spGender);
        spInsuranceCompany = findViewById(R.id.spInsuranceCompany);
        btnSubmitClaim = findViewById(R.id.btnSubmitClaim);
        insuranceDataBase = new InsuranceDataBase(getApplicationContext());


        ids = getIntent().getIntExtra("id",0);
        etFullName.setText(getIntent().getStringExtra("name"));
        etDOB.setText(getIntent().getStringExtra("dob"));
        gender = getIntent().getStringExtra("gender");
        etPhone.setText(getIntent().getStringExtra("phone"));
        etEmail.setText(getIntent().getStringExtra("email"));
        etID.setText(getIntent().getStringExtra("aadhar"));
        etPolicyNumber.setText(getIntent().getStringExtra("policyNumber"));
        selectCompany = getIntent().getStringExtra("selectCompany");
        selectHospital = getIntent().getStringExtra("selectHospital");
        etPolicyStart.setText(getIntent().getStringExtra("date"));
        etPolicyEnd.setText(getIntent().getStringExtra("time"));
        etNomineeName.setText(getIntent().getStringExtra("nominee"));
        etHospitalName.setText(getIntent().getStringExtra("hospital"));

        SelectGender();
        SelectInsuranceCompany();
        SelectHospitalBranch();

        btnSubmitClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDataDetails();
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

        spInsuranceCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectCompany = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spHospitalBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectHospital = parent.getItemAtPosition(position).toString();
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

    public void InsertDataDetails() {
        name = etFullName.getText().toString();
        email = etEmail.getText().toString();
        phone = etPhone.getText().toString();
        policyNumber = etPolicyNumber.getText().toString();
        date = etPolicyStart.getText().toString();
        time = etPolicyEnd.getText().toString();
        aadhar = etID.getText().toString();
        dob = etDOB.getText().toString();
        hospita = etHospitalName.getText().toString();
        nominee = etNomineeName.getText().toString();

        if (name.isEmpty()) {
            etFullName.requestFocus();
            etFullName.setError("Name Can't Empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            etFullName.requestFocus();
            etFullName.setError("Invalid Name Try Again...");
            return;
        } else if (dob.isEmpty()) {
            etDOB.requestFocus();
            etDOB.setError("DOB Can't Empty");
            return;
        } else if (!dob.matches("[0-9/]+")) {
            etDOB.requestFocus();
            etDOB.setError("Invalid Try Again... 12/2/2012 this format");
            return;
        }if (gender.equals("Please Select Gender")){
            Toast.makeText(getApplicationContext(), "Select Valid Gender Option", Toast.LENGTH_SHORT).show();
            return;
        } else if (phone.isEmpty()) {
            etPhone.requestFocus();
            etPhone.setError("Phone Number Can't Empty");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            etPhone.requestFocus();
            etPhone.setError("Invalid Try Again...");
            return;
        } else if (email.isEmpty()) {
            etEmail.requestFocus();
            etEmail.setError("Email Id Can't Empty...");
            return;
        } else if (!email.matches("[a-zA-Z0-9]+[@][a-z]+[.][a-z]+")) {
            etEmail.requestFocus();
            etEmail.setError("Invalid Email Try Again...");
            return;
        }  else if (aadhar.isEmpty()) {
            etID.requestFocus();
            etID.setError("PAN / Aadhar / passport only one any Can't Empty");
            return;
        } else if (!aadhar.matches("[a-zA-Z0-9 ]+")) {
            etID.requestFocus();
            etID.setError("Invalid Try Again...");
            return;
        } else if (policyNumber.isEmpty()) {
            etPolicyNumber.requestFocus();
            etPolicyNumber.setError("PolicyNumber Can't Empty");
            return;
        } else if (!policyNumber.matches("[a-zA-Z0-9 ]+")) {
            etPolicyNumber.requestFocus();
            etPolicyNumber.setError("Invalid Try Again...");
            return;
        }if (selectHospital.equals("Select Insurance Company")){
            Toast.makeText(getApplicationContext(), "Select Valid HospitalBranch Option", Toast.LENGTH_SHORT).show();
            return;
        } if (selectCompany.equals("Select Hospital Branch")){
            Toast.makeText(getApplicationContext(), "Select Valid InsuranceCompany Option", Toast.LENGTH_SHORT).show();
            return;
        } else if (date.isEmpty()) {
            etPolicyStart.requestFocus();
            etPolicyStart.setError("StartPolicy Date Can't Empty");
            return;
        } else if (!date.matches("[0-9/]+")) {
            etPolicyStart.requestFocus();
            etPolicyStart.setError("Invalid Try Again...");
            return;
        } else if (time.isEmpty()) {
            etPolicyEnd.requestFocus();
            etPolicyEnd.setError("EndPolicy Date Can't Empty");
            return;
        } else if (!time.matches("[0-9/]+")) {
            etPolicyEnd.requestFocus();
            etPolicyEnd.setError("Invalid Try Again...");
            return;
        } else if (nominee.isEmpty()) {
            etNomineeName.requestFocus();
            etNomineeName.setError("NomineeName Can't Empty");
            return;
        } else if (!nominee.matches("[a-zA-Z ]+")) {
            etNomineeName.requestFocus();
            etNomineeName.setError("Invalid Try Again...");
            return;
        } else if (hospita.isEmpty()) {
            etHospitalName.requestFocus();
            etHospitalName.setError("HospitalName Can't Empty");
            return;
        } else if (!hospita.matches("[a-zA-Z0-9 ]+")) {
            etHospitalName.requestFocus();
            etHospitalName.setError("Invalid Try Again...");
            return;
        }
        boolean b = insuranceDataBase.UpdateInsuranceDetails(ids,name,dob,gender,phone,email,aadhar,policyNumber,selectCompany,selectHospital,date,time,nominee,hospita);
        if (b==true){
            Toast.makeText(getApplicationContext(), "Update SuccessFully....", Toast.LENGTH_SHORT).show();
            etFullName.setText("");
            etEmail.setText("");
            etDOB.setText("");
            etPhone.setText("");
            etID.setText("");
            etPolicyNumber.setText("");
            etPolicyStart.setText("");
            etPolicyEnd.setText("");
            etHospitalName.setText("");
            etNomineeName.setText("");
            spHospitalBranch.setSelection(0);
            spInsuranceCompany.setSelection(0);
            spGender.setSelection(0);
        }else {
            Toast.makeText(getApplicationContext(), "Failed....", Toast.LENGTH_SHORT).show();
        }
    }

    public void SelectGender(){
        ArrayList<String> Gender = new ArrayList<>();
        Gender.add("Please Select Gender");
        Gender.add("Male");
        Gender.add("Female");
        Gender.add("Other");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,Gender);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spGender.setAdapter(adapter);

        if (Gender!=null){
            int position = adapter.getPosition(gender.trim());
            if (position>0){
                spGender.setSelection(position);
            }
        }

    }

    public void SelectInsuranceCompany(){
        ArrayList<String> insuranceCompany = new ArrayList<>();
        insuranceCompany.add("Select Insurance Company");
        insuranceCompany.add("ICICI Lombard");
        insuranceCompany.add("HDFC ERGO");
        insuranceCompany.add("Star Health");
        insuranceCompany.add("Religare");
        insuranceCompany.add("New India Assurance");
        insuranceCompany.add("United India Insurance");
        insuranceCompany.add("Reliance General Insurance");
        insuranceCompany.add("Bharti AXA");
        insuranceCompany.add("Future Generali");
        insuranceCompany.add("Aditya Birla Health");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, insuranceCompany);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spInsuranceCompany.setAdapter(adapter);

        if (insuranceCompany!=null){
            int position = adapter.getPosition(selectCompany.trim());
            if (position>0){
                spInsuranceCompany.setSelection(position);
            }
        }

    }

    public void SelectHospitalBranch(){
        ArrayList<String> hospitalBranch = new ArrayList<>();
        hospitalBranch.add("Select Hospital Branch");
        hospitalBranch.add("Apollo Hospital - Main Branch, Chennai");
        hospitalBranch.add("Apollo Hospital - Greams Road, Chennai");
        hospitalBranch.add("Fortis Hospital - Bannerghatta, Bengaluru");
        hospitalBranch.add("Fortis Hospital - Mohali, Punjab");
        hospitalBranch.add("Max Super Specialty Hospital - Saket, New Delhi");
        hospitalBranch.add("Max Hospital - Shalimar Bagh, New Delhi");
        hospitalBranch.add("AIIMS - New Delhi");
        hospitalBranch.add("AIIMS - Bhubaneswar");
        hospitalBranch.add("Manipal Hospital - Old Airport Road, Bengaluru");
        hospitalBranch.add("Manipal Hospital - Whitefield, Bengaluru");
        hospitalBranch.add("Medanta - The Medicity, Gurugram");
        hospitalBranch.add("Narayana Health - Bommasandra, Bengaluru");
        hospitalBranch.add("KIMS Hospital - Hyderabad");
        hospitalBranch.add("Care Hospital - Banjara Hills, Hyderabad");
        hospitalBranch.add("Lilavati Hospital - Bandra, Mumbai");
        hospitalBranch.add("Nanavati Max Hospital - Mumbai");
        hospitalBranch.add("Jaslok Hospital - Mumbai");
        hospitalBranch.add("Ruby Hall Clinic - Pune");
        hospitalBranch.add("Columbia Asia Hospital - Hebbal, Bengaluru");
        hospitalBranch.add("Sir Ganga Ram Hospital - New Delhi");
        hospitalBranch.add("Tata Memorial Hospital - Mumbai");
        hospitalBranch.add("CMC Vellore - Tamil Nadu");
        hospitalBranch.add("Aster Medcity - Kochi");
        hospitalBranch.add("Amrita Hospital - Kochi");
        hospitalBranch.add("Kokilaben Dhirubhai Ambani Hospital - Mumbai");
        hospitalBranch.add("Sunshine Hospital - Hyderabad");
        hospitalBranch.add("Paras Hospital - Gurugram");
        hospitalBranch.add("HCG Cancer Centre - Bengaluru");
        hospitalBranch.add("Dr. Rela Institute - Chennai");
        hospitalBranch.add("Global Hospital - Chennai");
        hospitalBranch.add("Rainbow Children’s Hospital - Hyderabad");
        hospitalBranch.add("Sakra World Hospital - Bengaluru");
        hospitalBranch.add("Yashoda Hospital - Secunderabad");
        hospitalBranch.add("Hinduja Hospital - Mumbai");
        hospitalBranch.add("Continental Hospital - Hyderabad");
        hospitalBranch.add("BLK Max Hospital - New Delhi");
        hospitalBranch.add("Seven Hills Hospital - Mumbai");
        hospitalBranch.add("Care Institute of Medical Sciences (CIMS) - Ahmedabad");
        hospitalBranch.add("Sterling Hospital - Ahmedabad");

        ArrayAdapter<String> arrayadapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,hospitalBranch);
        arrayadapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spHospitalBranch.setAdapter(arrayadapter);

        if (hospitalBranch!=null){
            int position =arrayadapter.getPosition(selectHospital.trim());

            if (position>0){
                spHospitalBranch.setSelection(position);
            }
        }

    }

}