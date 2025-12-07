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

public class UpdateDoctordetailsFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList;
DoctorDataBase doctorDataBase;
DoctorDetailsUpdateAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_doctordetails, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        doctorCallModelClassArrayList = new ArrayList<>();
        doctorDataBase = new DoctorDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DoctorDetailsUpdateAdapter(doctorCallModelClassArrayList,getContext());
        recyclerViews.setAdapter(adapter);

        ReloadDataRefresh();


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
           ReloadDataRefresh();
    }

    public void ReloadDataRefresh() {
        doctorCallModelClassArrayList.clear();
        Cursor cursor = doctorDataBase.GetAllDoctorDetails();
        while(cursor.moveToNext()){
            DoctorCallModelClass doctorCallModelClass = new DoctorCallModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8));
            doctorCallModelClassArrayList.add(doctorCallModelClass);
        }

        adapter.notifyDataSetChanged();
    }

}