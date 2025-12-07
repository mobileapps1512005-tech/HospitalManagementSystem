package com.example.hospitalmanagementsystem.MedicalReports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class UserCheckPdfReportAdapter extends RecyclerView.Adapter<UserCheckPdfReportAdapter.ViewHolder>{
ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList;
Context context;

    public UserCheckPdfReportAdapter(ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList, Context context) {
        this.medicalReportModelClassArrayList = medicalReportModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdfformreports_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicalReportModelClass reportModelClass = medicalReportModelClassArrayList.get(position);
        holder.name.setText(reportModelClass.getName());
        holder.part.setText(reportModelClass.getPart());
        holder.date.setText(reportModelClass.getDate());
        holder.time.setText(reportModelClass.getTime());
        holder.condition.setText(reportModelClass.getCondition());
        holder.describe.setText(reportModelClass.getDescribe());
        holder.phone.setText(reportModelClass.getPhone());


    }

    @Override
    public int getItemCount() {
        return medicalReportModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,date,time,condition,describe,phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
            condition = itemView.findViewById(R.id.tvCondition);
            describe = itemView.findViewById(R.id.tvDescribe);
            phone = itemView.findViewById(R.id.tvphone);

        }
    }
}
