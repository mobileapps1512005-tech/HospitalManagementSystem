package com.example.hospitalmanagementsystem.BottomFragment;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.RequiresFeature;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.DoctorManageTask.HealDietDataBase;
import com.example.hospitalmanagementsystem.DoctorManageTask.HealDietModelClass;
import com.example.hospitalmanagementsystem.DoctorManageTask.PatientViewHealDietAdapter;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;


public class HealDietFragment extends Fragment {
 RecyclerView recyclerViews;
 ArrayList<HealDietModelClass> healDietModelClassArrayList;
 HealDietDataBase healDietDataBase;
 PatientViewHealDietAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_heal_diet, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        healDietModelClassArrayList = new ArrayList<>();
        healDietDataBase = new HealDietDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PatientViewHealDietAdapter(healDietModelClassArrayList,getContext());
        recyclerViews.setAdapter(adapter);

        RefReshData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        RefReshData();

    }
    public void RefReshData(){
        healDietModelClassArrayList.clear();
        Cursor cursor = healDietDataBase.GetAllHealDetails();
        while (cursor.moveToNext()){
            HealDietModelClass healDietModelClass = new HealDietModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7));
            healDietModelClassArrayList.add(healDietModelClass);
        }

    }
}