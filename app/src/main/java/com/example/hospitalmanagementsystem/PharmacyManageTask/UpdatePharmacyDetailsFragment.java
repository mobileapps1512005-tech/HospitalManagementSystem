package com.example.hospitalmanagementsystem.PharmacyManageTask;

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


public class UpdatePharmacyDetailsFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<PharmacyModelClass> pharmacyModelClassArrayList;
PharmacyAdapter adapter;
PharmacyDetailDataBase pharmacyDetailDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_pharmacy_details, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        pharmacyModelClassArrayList = new ArrayList<>();
        pharmacyDetailDataBase = new PharmacyDetailDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PharmacyAdapter(pharmacyModelClassArrayList,getContext());
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
        pharmacyModelClassArrayList.clear();
        Cursor cursor = pharmacyDetailDataBase.GetAllPharmacyDetail();
        while(cursor.moveToNext()){
            PharmacyModelClass pharmacyModelClass = new PharmacyModelClass(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9),
                    cursor.getString(10),cursor.getString(11));
            pharmacyModelClassArrayList.add(pharmacyModelClass);
        }
        adapter.notifyDataSetChanged();
    }
}