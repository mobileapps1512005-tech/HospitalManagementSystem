package com.example.hospitalmanagementsystem.PatientBillings;

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


public class UpdateBillingFragment extends Fragment {
    RecyclerView recyclerViews;
    BillingUpdateAdapter adapter;
    ArrayList<BillingModelClass> billingModelClassArrayList;
    PatientBillingDataBase patientBillingDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_billing, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        patientBillingDataBase = new PatientBillingDataBase(getContext());
        billingModelClassArrayList = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BillingUpdateAdapter(billingModelClassArrayList, getContext());
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
        billingModelClassArrayList.clear();
        Cursor cursor = patientBillingDataBase.GetBillingData();
        while (cursor.moveToNext()) {
            BillingModelClass modelClass = new BillingModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(7),cursor.getString(5),
                    cursor.getString(6),cursor.getString(8),cursor.getString(9));
            billingModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();

    }
}