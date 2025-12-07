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


public class OwnerLapReportAcceptFragment extends Fragment {
RecyclerView recyclerViews;
OwnerLabReportAcceptDataBase ownerLabReportAcceptDataBase;
ArrayList<LabModelClass> labModelClassArrayList;
OnlyAcceptLabReportAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_owner_lap_report_accept, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        labModelClassArrayList = new ArrayList<>();
        ownerLabReportAcceptDataBase = new OwnerLabReportAcceptDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new OnlyAcceptLabReportAdapter(labModelClassArrayList,getContext());
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
        labModelClassArrayList.clear();
        Cursor cursor = ownerLabReportAcceptDataBase.GetAllDetailLabOwner();
        while (cursor.moveToNext()){
            LabModelClass modelClass = new LabModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4));
            labModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }
}