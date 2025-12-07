package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

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

public class CheckPendingFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<CheckupModelClass> checkupModelClassArrayList;
CheckUpBookingDataBase checkUpBookingDataBase;
CheckPendingAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_pending, container, false);

         recyclerViews = view.findViewById(R.id.recyclerViews);
         checkupModelClassArrayList = new ArrayList<>();
         checkUpBookingDataBase = new CheckUpBookingDataBase(getContext());
         recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
         adapter = new CheckPendingAdapter(checkupModelClassArrayList,getContext());
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
        checkupModelClassArrayList.clear();
        Cursor cursor = checkUpBookingDataBase.AllGetDetails();
        while(cursor.moveToNext()){
           CheckupModelClass checkupModelClass = new CheckupModelClass(cursor.getInt(0),cursor.getString(1),
                   cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
           checkupModelClassArrayList.add(checkupModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}