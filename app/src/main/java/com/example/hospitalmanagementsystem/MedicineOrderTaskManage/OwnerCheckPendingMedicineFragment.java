package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

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

public class OwnerCheckPendingMedicineFragment extends Fragment {
    RecyclerView recyclerViews;
    ArrayList<MedicineModelClass> medicineModelClassArrayList;
    PatientMedicineOrderDataBase patientMedicineOrderDataBase;
    OwnerAcceptRejectMedicineOrderAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_check_pending_medicine, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        medicineModelClassArrayList = new ArrayList<>();
        patientMedicineOrderDataBase = new PatientMedicineOrderDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new OwnerAcceptRejectMedicineOrderAdapter(medicineModelClassArrayList,getContext());
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
        medicineModelClassArrayList.clear();
        Cursor cursor = patientMedicineOrderDataBase.GetAllDetails();
        while(cursor.moveToNext()){
            MedicineModelClass modelClass = new MedicineModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9));
            medicineModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }
}