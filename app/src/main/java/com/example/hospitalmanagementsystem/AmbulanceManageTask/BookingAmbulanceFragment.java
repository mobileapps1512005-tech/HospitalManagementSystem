package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.R;

import java.sql.Ref;
import java.util.ArrayList;


public class BookingAmbulanceFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<AmbulanceModelClass> ambulanceModelClassArrayList;
AmbulanceDataBase ambulanceDataBase;
AmbulanceBookingAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_booking_ambulance, container, false);

           recyclerViews = view.findViewById(R.id.recyclerViews);
           ambulanceModelClassArrayList = new ArrayList<>();
           ambulanceDataBase = new AmbulanceDataBase(getContext());
           recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
           adapter = new AmbulanceBookingAdapter(ambulanceModelClassArrayList,getContext());
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
        ambulanceModelClassArrayList.clear();
        Cursor cursor = ambulanceDataBase.GetAllAmbulanceDetail();
        while(cursor.moveToNext()){
            AmbulanceModelClass ambulanceModelClass = new AmbulanceModelClass(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                    cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),
                    cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),
                    cursor.getString(14),cursor.getString(15),cursor.getString(16));
            ambulanceModelClassArrayList.add(ambulanceModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}