package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class CheckLabReportAdapter extends RecyclerView.Adapter<CheckLabReportAdapter.ViewHolder>{
ArrayList<ReportModelClass> reportModelClassArrayList;
Context context;

    public CheckLabReportAdapter(ArrayList<ReportModelClass> reportModelClassArrayList, Context context) {
        this.reportModelClassArrayList = reportModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkpdflabreport_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     ReportModelClass reportModelClass = reportModelClassArrayList.get(position);
        holder.name.setText(reportModelClass.getName());
        holder.phone.setText(reportModelClass.getPhone());
        holder.condition.setText(reportModelClass.getCondition());


    }

    @Override
    public int getItemCount() {
        return reportModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
                TextView name,phone,condition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            phone = itemView.findViewById(R.id.tvphone);
            condition = itemView.findViewById(R.id.tvCondition);

        }
    }
}
