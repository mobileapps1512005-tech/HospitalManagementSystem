package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;


public class PatientReturnMedicineBookingFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList;
MedicineReturnPatientAdapter adapter;
MedicineReturnPolicyDataBase medicineReturnPolicyDataBase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_patient_return_medicine_booking, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        medicineReturnModelClassArrayList = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        medicineReturnPolicyDataBase = new MedicineReturnPolicyDataBase(getContext());
        adapter = new MedicineReturnPatientAdapter(medicineReturnModelClassArrayList,getContext());
        recyclerViews.setAdapter(adapter);

        RefreshData();

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        RefreshData();
    }
    
    public void RefreshData(){
        medicineReturnModelClassArrayList.clear();
        Cursor cursor = medicineReturnPolicyDataBase.GetAllPolicyDetails();
        while (cursor.moveToNext()) {
            MedicineReturnModelClass returnModelClass = new MedicineReturnModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3));
            medicineReturnModelClassArrayList.add(returnModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}