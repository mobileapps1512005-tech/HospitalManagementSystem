package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

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


public class UpdateDetailDeliveryFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<ModelClass> modelClassArrayList;
HomeDeliveryDataBase homeDeliveryDataBase;
HomeDeliveryUpdateAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_detail_delivery, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        modelClassArrayList = new ArrayList<>();
        homeDeliveryDataBase = new HomeDeliveryDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeDeliveryUpdateAdapter(modelClassArrayList,getContext());
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
        modelClassArrayList.clear();
        Cursor cursor = homeDeliveryDataBase.GetAllDetails();
        while (cursor.moveToNext()) {
            ModelClass modelClass = new ModelClass(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getString(6));
            modelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }
}