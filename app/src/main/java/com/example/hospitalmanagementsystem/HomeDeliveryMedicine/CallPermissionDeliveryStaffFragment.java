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

public class CallPermissionDeliveryStaffFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<ModelClass> modelClassCArrayList;
HomeDeliveryDataBase homeDeliveryDataBase;
DeliveryStaffAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_call_permission, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        modelClassCArrayList = new ArrayList<>();
        homeDeliveryDataBase = new HomeDeliveryDataBase(getActivity());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new DeliveryStaffAdapter(modelClassCArrayList,getActivity());
        recyclerViews.setAdapter(adapter);
        Cursor cursor = homeDeliveryDataBase.GetAllDetails();
        while (cursor.moveToNext()){
            ModelClass modelClass = new ModelClass(cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6));
            modelClassCArrayList.add(modelClass);
        }


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null){
            adapter.notifyDataSetChanged();
        }
    }
}