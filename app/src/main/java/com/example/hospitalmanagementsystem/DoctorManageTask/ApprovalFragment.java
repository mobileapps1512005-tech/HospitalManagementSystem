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

import java.util.ArrayList;


public class ApprovalFragment extends Fragment {

    RecyclerView recyclerViews;
    ArrayList<PatientModelClassAppointment> patientModelClassAppointmentArrayList;
    ConfirmAppointmentAdapterDr adapter;
    DoctorConfirmAppointmentDataBase doctorConfirmAppointmentDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_approval, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        patientModelClassAppointmentArrayList = new ArrayList<>();
        doctorConfirmAppointmentDataBase = new DoctorConfirmAppointmentDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        Cursor cursor = doctorConfirmAppointmentDataBase.GetAllConfirmAppointmentDetails();

        while (cursor.moveToNext()){
            PatientModelClassAppointment appointment = new PatientModelClassAppointment(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5));
            patientModelClassAppointmentArrayList.add(appointment);
        }
        adapter = new ConfirmAppointmentAdapterDr(patientModelClassAppointmentArrayList,getContext());
        recyclerViews.setAdapter(adapter);

        return view;
    }
}