package com.example.hospitalmanagementsystem.AddLabTestReports;

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


public class LabReportPatientBookingPendingFragment extends Fragment {
RecyclerView recyclerViews;
LabReportBookingDataBase labReportBookingDataBase;
ArrayList<LabModelClass> modelClassArrayList;
PatientLabReportPendingAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lab_report_patient_booking_pending, container, false);


        recyclerViews = view.findViewById(R.id.recyclerViews);
        modelClassArrayList = new ArrayList<>();
        labReportBookingDataBase = new LabReportBookingDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PatientLabReportPendingAdapter(modelClassArrayList,getContext());
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
        modelClassArrayList.clear();
        Cursor cursor = labReportBookingDataBase.GetAllDetailLab();
        while (cursor.moveToNext()){
            LabModelClass modelClass = new LabModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4));
            modelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }

}