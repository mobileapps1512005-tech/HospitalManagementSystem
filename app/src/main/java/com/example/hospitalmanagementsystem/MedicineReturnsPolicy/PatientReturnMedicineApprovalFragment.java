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


public class PatientReturnMedicineApprovalFragment extends Fragment {
    RecyclerView recyclerViews;
    ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList;
    MedicineReturnAcceptDataBase medicineReturnAcceptDataBase;
    MedicineReturnOnlyAcceptAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_return_medicine_approval, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        medicineReturnModelClassArrayList = new ArrayList<>();
        medicineReturnAcceptDataBase = new MedicineReturnAcceptDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MedicineReturnOnlyAcceptAdapter(medicineReturnModelClassArrayList,getContext());
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
        Cursor cursor =medicineReturnAcceptDataBase.GetAllAcceptMedicine();
        while (cursor.moveToNext()) {
            MedicineReturnModelClass returnModelClass = new MedicineReturnModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3));
            medicineReturnModelClassArrayList.add(returnModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}