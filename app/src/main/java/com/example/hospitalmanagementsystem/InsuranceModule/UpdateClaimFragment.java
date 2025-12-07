package com.example.hospitalmanagementsystem.InsuranceModule;

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


public class UpdateClaimFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<InsuranceModelClass> insuranceModelClassArrayList;
InsuranceUpdateAdapter adapter;
InsuranceDataBase insuranceDataBase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_claim, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        insuranceModelClassArrayList = new ArrayList<>();
        insuranceDataBase = new InsuranceDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new InsuranceUpdateAdapter(insuranceModelClassArrayList,getContext());
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
        insuranceModelClassArrayList.clear();
        Cursor cursor = insuranceDataBase.GetAllInsuranceDetails();
        while(cursor.moveToNext()){
            InsuranceModelClass insuranceModelClass = new InsuranceModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9),
                    cursor.getString(10),cursor.getString(11),cursor.getString(12),
                    cursor.getString(13));
            insuranceModelClassArrayList.add(insuranceModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}