package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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


public class CanteenCallPermissionFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<CanteenModelClass> canteenModelClassArrayList;
CanteenCallPermissionAdapter adapter;
CanteenDataBase canteenDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canteen_call_permission, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        canteenModelClassArrayList = new ArrayList<>();
        canteenDataBase = new CanteenDataBase(getActivity());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CanteenCallPermissionAdapter(canteenModelClassArrayList,getActivity());
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
        canteenModelClassArrayList.clear();
        Cursor cursor = canteenDataBase.GetAllCanteenData();
        while (cursor.moveToNext()){
            CanteenModelClass canteenModelClass = new CanteenModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8));
            canteenModelClassArrayList.add(canteenModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}