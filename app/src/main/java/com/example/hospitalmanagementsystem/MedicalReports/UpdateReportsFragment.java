package com.example.hospitalmanagementsystem.MedicalReports;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.R;

import java.lang.ref.Reference;
import java.util.ArrayList;


public class UpdateReportsFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList;
MedicalReportsDataBase medicalReportsDataBase;
MedicalReportsUpdateAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_reports, container, false);

           recyclerViews = view.findViewById(R.id.recyclerViews);
           medicalReportModelClassArrayList = new ArrayList<>();
           medicalReportsDataBase = new MedicalReportsDataBase(getContext());
           recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
           adapter = new MedicalReportsUpdateAdapter(medicalReportModelClassArrayList,getContext());
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
        medicalReportModelClassArrayList.clear();
        Cursor cursor = medicalReportsDataBase.AllGetDetails();
        while (cursor.moveToNext()){
            MedicalReportModelClass modelClass = new MedicalReportModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),
                    cursor.getString(6),cursor.getString(7));
            medicalReportModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();

    }
}