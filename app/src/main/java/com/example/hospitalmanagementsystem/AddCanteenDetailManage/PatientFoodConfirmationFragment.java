package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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


public class PatientFoodConfirmationFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClassArrayList;
CanteenOwnerFoodAcceptAdapter adapter;
OwnerConfirmationDataBase ownerConfirmationDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_patient_food_confirmation, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        patientFoodRequestModelClassArrayList = new ArrayList<>();
        ownerConfirmationDataBase = new OwnerConfirmationDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CanteenOwnerFoodAcceptAdapter(patientFoodRequestModelClassArrayList,getContext());
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
        patientFoodRequestModelClassArrayList.clear();
        Cursor cursor = ownerConfirmationDataBase.getOwnerAllData();
        while (cursor.moveToNext()){
            PatientFoodRequestModelClass patientFood = new PatientFoodRequestModelClass(cursor.getInt(0),cursor.getString(1)
                    ,cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getString(6));
            patientFoodRequestModelClassArrayList.add(patientFood);
        }
        adapter.notifyDataSetChanged();
    }
}