package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.HospitalManageTask.HospitalModelClass;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;


public class HealDeleteFragment extends Fragment {
RecyclerView recyclerViews;
HealDietDataBase healDietDataBase;
ArrayList<HealDietModelClass> healDietModelClassArrayList;
HealDietDeleteAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heal_delete, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        healDietDataBase = new HealDietDataBase(getContext());
        healDietModelClassArrayList = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HealDietDeleteAdapter(healDietModelClassArrayList,getContext());
        recyclerViews.setAdapter(adapter);


        ReFreshData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ReFreshData();
    }
    public void ReFreshData(){
        healDietModelClassArrayList.clear();
        Cursor cursor = healDietDataBase.GetAllHealDetails();
        while (cursor.moveToNext()){
            HealDietModelClass healDietModelClass = new HealDietModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7));
            healDietModelClassArrayList.add(healDietModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}