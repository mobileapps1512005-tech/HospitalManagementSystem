package com.example.hospitalmanagementsystem.NurseManageTask;

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


public class NurseCallPermissionFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<NurseModelClass> nurseModelClassArrayList;
NurseDataBase nurseDataBase;
NurseCallPermissionAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nurse_call_permission2, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        nurseModelClassArrayList = new ArrayList<>();
        nurseDataBase = new NurseDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NurseCallPermissionAdapter(nurseModelClassArrayList,getContext());
        recyclerViews.setAdapter(adapter);
        Cursor cursor = nurseDataBase.GetAllNurseData();
        while(cursor.moveToNext()){
            NurseModelClass nurseModelClass = new NurseModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getString(6),cursor.getString(7));
            nurseModelClassArrayList.add(nurseModelClass);
        }

        return view;
    }
}