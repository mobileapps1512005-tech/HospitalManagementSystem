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

public class DeleteDoctorDetailsFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList;
DoctorDataBase doctorDataBase;
DeleteDoctorDetailAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
             View view  = inflater.inflate(R.layout.fragment_delete_doctor_details, container, false);

             recyclerViews = view.findViewById(R.id.recyclerViews);
             doctorCallModelClassArrayList = new ArrayList<>();
             recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
             doctorDataBase = new DoctorDataBase(getContext());
             adapter = new DeleteDoctorDetailAdapter(doctorCallModelClassArrayList,getContext());
             recyclerViews.setAdapter(adapter);
             Cursor cursor = doctorDataBase.GetAllDoctorDetails();
              while(cursor.moveToNext()){
                  DoctorCallModelClass doctorCallModelClass = new DoctorCallModelClass(cursor.getInt(0),
                          cursor.getString(1),cursor.getString(2),cursor.getString(3),
                          cursor.getString(4),cursor.getString(5),cursor.getString(6),
                          cursor.getString(7),cursor.getString(8));
                  doctorCallModelClassArrayList.add(doctorCallModelClass);
              }

        return view;
    }
}