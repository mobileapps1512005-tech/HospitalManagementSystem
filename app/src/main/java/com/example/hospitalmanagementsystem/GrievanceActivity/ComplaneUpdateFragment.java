package com.example.hospitalmanagementsystem.GrievanceActivity;

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

public class ComplaneUpdateFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<GrievanceModelClass> grievanceModelClasses;
GrievanceDataBase grievanceDataBase;
ComplaneUpdateAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_update_complane, container, false);

       recyclerViews = view.findViewById(R.id.recyclerViews);
       grievanceDataBase = new GrievanceDataBase(getContext());
       grievanceModelClasses = new ArrayList<>();
       recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
       adapter = new ComplaneUpdateAdapter(grievanceModelClasses,getContext());
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
        grievanceModelClasses.clear();
        Cursor cursor = grievanceDataBase.GetAllGrievance();
        while (cursor.moveToNext()) {
            GrievanceModelClass grievanceModelClass = new GrievanceModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5));
            grievanceModelClasses.add(grievanceModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}