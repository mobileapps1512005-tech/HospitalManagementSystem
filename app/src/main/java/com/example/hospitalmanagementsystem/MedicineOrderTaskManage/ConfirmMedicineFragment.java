package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

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


public class ConfirmMedicineFragment extends Fragment {
    RecyclerView recyclerViews;
    ArrayList<MedicineModelClass> medicineModelClassArrayList;
    OnlyAcceptMedicineOrderDataBase onlyAcceptMedicineOrderDataBase;
    OnlyMedicineOrderAcceptAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_medicine, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        medicineModelClassArrayList = new ArrayList<>();
        onlyAcceptMedicineOrderDataBase = new OnlyAcceptMedicineOrderDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new OnlyMedicineOrderAcceptAdapter(medicineModelClassArrayList,getContext());
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
        medicineModelClassArrayList.clear();
        Cursor cursor = onlyAcceptMedicineOrderDataBase.AcceptGetAllDetails();
        while(cursor.moveToNext()){
            MedicineModelClass modelClass = new MedicineModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9));
            medicineModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }
}