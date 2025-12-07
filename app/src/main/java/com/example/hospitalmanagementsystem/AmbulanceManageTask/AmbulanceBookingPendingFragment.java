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

import java.util.ArrayList;


public class AmbulanceBookingPendingFragment extends Fragment {
    RecyclerView recyclerViews;
    ArrayList<AmbulanceBookingModelClass> ambulanceBookingModelClassArrayList;
    AmbulanceBookingDataBase ambulanceBookingDataBase;
    BookingPatientPendingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_ambulance_booking_pending, container, false);



        recyclerViews = view.findViewById(R.id.recyclerViews);
        ambulanceBookingModelClassArrayList = new ArrayList<>();
        ambulanceBookingDataBase = new AmbulanceBookingDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BookingPatientPendingAdapter(ambulanceBookingModelClassArrayList,getContext());
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
        ambulanceBookingModelClassArrayList.clear();
        Cursor cursor = ambulanceBookingDataBase.GetAllDetailsAmbulanceBook();
        while(cursor.moveToNext()){
            AmbulanceBookingModelClass bookingModelClass = new AmbulanceBookingModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6));
            ambulanceBookingModelClassArrayList.add(bookingModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}