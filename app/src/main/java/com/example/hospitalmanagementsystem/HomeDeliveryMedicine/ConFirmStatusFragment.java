package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

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

public class ConFirmStatusFragment extends Fragment {
RecyclerView recyclerViews;
DeliveryMedicineStatusAdapter adapter;
ArrayList<MedicineStatusModelClass> medicineStatusModelClassArrayList;
MedicineStatusDataBase medicineStatusDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_con_firm_status, container, false);

          recyclerViews = view.findViewById(R.id.recyclerViews);
          medicineStatusModelClassArrayList = new ArrayList<>();
          medicineStatusDataBase = new MedicineStatusDataBase(getContext());
          recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
          adapter = new DeliveryMedicineStatusAdapter(medicineStatusModelClassArrayList,getContext());
          recyclerViews.setAdapter(adapter);
          Cursor cursor = medicineStatusDataBase.GetAllDeliveryStatus();
          while(cursor.moveToNext()){
              MedicineStatusModelClass medicineStatusModelClass = new MedicineStatusModelClass(cursor.getInt(0),
                      cursor.getString(1),cursor.getString(2));
              medicineStatusModelClassArrayList.add(medicineStatusModelClass);
          }

        return view;
    }
}