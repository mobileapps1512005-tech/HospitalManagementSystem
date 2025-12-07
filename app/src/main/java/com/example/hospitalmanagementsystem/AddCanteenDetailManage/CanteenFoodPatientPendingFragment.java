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


public class CanteenFoodPatientPendingFragment extends Fragment {
 RecyclerView recyclerViews;
 ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClassArrayList;
 PatientFoodPendingAdapter adapter;
 FoodOrderPatientDataBase foodOrderPatientDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canteen_food_patient_pending, container, false);

          recyclerViews = view.findViewById(R.id.recyclerViews);
          patientFoodRequestModelClassArrayList = new ArrayList<>();
          recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
          foodOrderPatientDataBase = new FoodOrderPatientDataBase(getContext());
          adapter = new PatientFoodPendingAdapter(patientFoodRequestModelClassArrayList,getContext());
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
        while (cursor.moveToNext()){
            PatientFoodRequestModelClass patientFood = new PatientFoodRequestModelClass(cursor.getInt(0),cursor.getString(1)
                    ,cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getString(6));
            patientFoodRequestModelClassArrayList.add(patientFood);
        }
        adapter.notifyDataSetChanged();
    }
}
