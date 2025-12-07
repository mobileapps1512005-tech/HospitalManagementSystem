package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class DoctorCallPatientFragment extends Fragment {
RecyclerView recyclerViews;
public static final int RequestCode=10012;
ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList;
DoctorDataBase doctorDataBase;
DoctorCallPatientAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_doctor_call, container, false);

      CallPermission();

      recyclerViews = view.findViewById(R.id.recyclerViews);
      doctorCallModelClassArrayList = new ArrayList<>();
      doctorDataBase = new DoctorDataBase(getContext());
      recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
      adapter = new DoctorCallPatientAdapter(doctorCallModelClassArrayList,getContext());
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

    public void CallPermission(){

        if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getContext(), "Permission Already Granted....", Toast.LENGTH_SHORT).show();
        }else {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},RequestCode);
            Toast.makeText(getContext(), "Please Allow Permission....", Toast.LENGTH_SHORT).show();
        }
    }
}