package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.R;

import java.sql.Ref;
import java.util.ArrayList;

public class CancelFragment extends Fragment {
RecyclerView recyclerViews;
CancelAppointmentAdapter adapter;
ArrayList<PatientModelClassAppointment> patientModelClassAppointmentArrayList;
DrCancelAppointmentDataBase drCancelAppointmentDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_cancel, container, false);

      recyclerViews = view.findViewById(R.id.recyclerViews);
      patientModelClassAppointmentArrayList = new ArrayList<>();
      drCancelAppointmentDataBase = new DrCancelAppointmentDataBase(getContext());
      recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
      adapter = new CancelAppointmentAdapter(patientModelClassAppointmentArrayList,getContext());
      recyclerViews.setAdapter(adapter);

        RefreshData();

        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();
        RefreshData();
    }

    public void RefreshData(){
        patientModelClassAppointmentArrayList.clear();
        Cursor cursor = drCancelAppointmentDataBase.GetAllCancelAppointmentDetails();
        while(cursor.moveToNext()){
            PatientModelClassAppointment modelClassAppointment = new PatientModelClassAppointment(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5));
            patientModelClassAppointmentArrayList.add(modelClassAppointment);
        }
        adapter.notifyDataSetChanged();
    }
}