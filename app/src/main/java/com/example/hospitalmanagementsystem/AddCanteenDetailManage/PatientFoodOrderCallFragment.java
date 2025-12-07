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


public class PatientFoodOrderCallFragment extends Fragment {
RecyclerView recyclerViews;
PatientFoodOrderCallQueryAdapter adapter;
ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClassArrayList;
FoodOrderPatientDataBase foodOrderPatientDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_patient_food_order_call, container, false);

           recyclerViews = view.findViewById(R.id.recyclerViews);
           patientFoodRequestModelClassArrayList = new ArrayList<>();
           foodOrderPatientDataBase = new FoodOrderPatientDataBase(getContext());
           recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
           adapter = new PatientFoodOrderCallQueryAdapter(patientFoodRequestModelClassArrayList,getContext());
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
        Cursor cursor = foodOrderPatientDataBase.getAllData();
        while(cursor.moveToNext()){
            PatientFoodRequestModelClass patientFoodRequest = new PatientFoodRequestModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            patientFoodRequestModelClassArrayList.add(patientFoodRequest);
        }
        adapter.notifyDataSetChanged();
    }
}