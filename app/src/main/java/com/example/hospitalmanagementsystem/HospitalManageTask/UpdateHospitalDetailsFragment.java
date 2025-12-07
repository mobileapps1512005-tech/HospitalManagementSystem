package com.example.hospitalmanagementsystem.HospitalManageTask;

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

public class UpdateHospitalDetailsFragment extends Fragment {
RecyclerView recyclerViews;
HospitalUpdateAdapter adapter;
ArrayList<HospitalModelClass> hospitalModelClassArrayList;
HospitalDataBase hospitalDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_hospital_details, container, false);

         recyclerViews = view.findViewById(R.id.recyclerViews);
         hospitalModelClassArrayList = new ArrayList<>();
         hospitalDataBase = new HospitalDataBase(getContext());
         recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
         adapter = new HospitalUpdateAdapter(hospitalModelClassArrayList,getContext());
         recyclerViews.setAdapter(adapter);

         ReloadDataRefresh();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ReloadDataRefresh();
    }
    public void ReloadDataRefresh(){
        hospitalModelClassArrayList.clear();
        Cursor cursor = hospitalDataBase.GetAllHospitalData();
        while (cursor.moveToNext()){
            HospitalModelClass hospitalModelClass = new HospitalModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5));
            hospitalModelClassArrayList.add(hospitalModelClass);
        }
        adapter.notifyDataSetChanged();

    }
}