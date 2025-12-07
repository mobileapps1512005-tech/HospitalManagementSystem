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

import java.util.ArrayList;


public class CheckDeleteFragment extends Fragment {
 RecyclerView recyclerViews;
 ArrayList<CheckupModelClass> checkupModelClassArrayList;
 CheckupBodyDataBase checkupBodyDataBase;
 CheckUpDeleteAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_delete, container, false);

        recyclerViews = view.findViewById(R.id.recyclerViews);
        checkupModelClassArrayList = new ArrayList<>();
        checkupBodyDataBase = new CheckupBodyDataBase(getContext());
        recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CheckUpDeleteAdapter(checkupModelClassArrayList,getContext());
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
        checkupModelClassArrayList.clear();
        Cursor cursor = checkupBodyDataBase.AllGetDetails();
        while(cursor.moveToNext()){
            CheckupModelClass modelClass = new CheckupModelClass(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5));
            checkupModelClassArrayList.add(modelClass);
        }
        adapter.notifyDataSetChanged();
    }

}