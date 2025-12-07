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


public class UpdateNurseDetailsFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<NurseModelClass> nurseModelClassArrayList;
NurseDataBase dataBase;
NurseUpdateAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_nurse_details, container, false);

         recyclerViews = view.findViewById(R.id.recyclerViews);
         nurseModelClassArrayList = new ArrayList<>();
         dataBase = new NurseDataBase(getContext());
         recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
         adapter = new NurseUpdateAdapter(nurseModelClassArrayList,getContext());
         recyclerViews.setAdapter(adapter);

        RefreshLoad();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        RefreshLoad();
    }

    public void RefreshLoad(){
        nurseModelClassArrayList.clear();
        Cursor cursor = dataBase.GetAllNurseData();
        while(cursor.moveToNext()) {
            NurseModelClass nurseModelClass = new NurseModelClass(cursor.getInt(0),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6),
                    cursor.getString(7));
            nurseModelClassArrayList.add(nurseModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}