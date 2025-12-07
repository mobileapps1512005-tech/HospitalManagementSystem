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

public class DeleteHospitalDetailFragment extends Fragment {
    RecyclerView recyclerViews;
    ArrayList<HospitalModelClass> hospitalModelClassArrayList;
    HospitalDataBase hospitalDataBase;
    HospitalDeleteAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_hospital_detail, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        hospitalDataBase = new HospitalDataBase(getContext());
        hospitalModelClassArrayList = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        Cursor cursor = hospitalDataBase.GetAllHospitalData();
        adapter = new HospitalDeleteAdapter(hospitalModelClassArrayList,getContext());
        recyclerViews.setAdapter(adapter);
        while(cursor.moveToNext()){
            HospitalModelClass hospitalModelClass = new HospitalModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5));
            hospitalModelClassArrayList.add(hospitalModelClass);
        }



        return view;
    }
}