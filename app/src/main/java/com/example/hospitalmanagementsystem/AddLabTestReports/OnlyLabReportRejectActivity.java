package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hospitalmanagementsystem.R;

public class OnlyLabReportRejectActivity extends AppCompatActivity {
    EditText edName,edPart,edCost,edPhone;
    Button btnSubmit;
    String name,part,cost,phone;
    LabReportBookingDataBase labReportBookingDataBase;
    OnlyLabReportRejectDataBase onlyLabReportRejectDataBase;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_only_lab_report_reject);


        edName =  findViewById(R.id.edName);
        edPart =  findViewById(R.id.edPart);
        edCost =   findViewById(R.id.edCost);
        edPhone =  findViewById(R.id.edPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        labReportBookingDataBase = new LabReportBookingDataBase(getApplicationContext());
        onlyLabReportRejectDataBase = new OnlyLabReportRejectDataBase(getApplicationContext());

        id = getIntent().getIntExtra("id",0);
        edName.setText(getIntent().getStringExtra("name"));
        edPart.setText(getIntent().getStringExtra("part"));
        edCost.setText(getIntent().getStringExtra("cost"));
        edPhone.setText(getIntent().getStringExtra("phone"));


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertLabData();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void InsertLabData(){

        name = edName.getText().toString();
        part = edPart.getText().toString();
        cost = edCost.getText().toString();
        phone = edPhone.getText().toString();

        if (name.isEmpty()){
            edName.requestFocus();
            edName.setError("name can't empty...");
            return;
        } else if (!name.matches("[a-zA-Z0-9 ]+")) {
            edName.requestFocus();
            edName.setError("Invalid try again...");
            return;
        } else if (part.isEmpty()) {
            edPart.requestFocus();
            edPart.setError("part can't empty...");
            return;
        } else if (!part.matches("[a-zA-Z0-9 ]+")) {
            edPart.requestFocus();
            edPart.setError("Invalid try again...");
            return;
        }else if (cost.isEmpty()) {
            edCost.requestFocus();
            edCost.setError("cost can't empty...");
            return;
        } else if (!cost.matches("[a-zA-Z0-9 ]+")) {
            edCost.requestFocus();
            edCost.setError("Invalid try again...");
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
        boolean b = onlyLabReportRejectDataBase.OwnerInsertLabDataReject(name,part,cost,phone);
        if (b==true){
            edName.setText("");
            edPart.setText("");
            edCost.setText("");
            edPhone.setText("");
            Toast.makeText(getApplicationContext(), "Reject SuccessFully....", Toast.LENGTH_SHORT).show();
            labReportBookingDataBase.GetDeleteLabDetail(id);
        }else {
            Toast.makeText(getApplicationContext(), "Failed...", Toast.LENGTH_SHORT).show();
        }
    }
}