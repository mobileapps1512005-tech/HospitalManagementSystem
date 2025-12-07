package com.example.hospitalmanagementsystem.MedicalReports;

import android.content.Context;
import android.content.Intent;
import android.media.tv.ad.TvAdView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.MedicineOrderTaskManage.CheckMedicineActivity;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class MedicalReportsUpdateAdapter extends RecyclerView.Adapter<MedicalReportsUpdateAdapter.ViewHolder>{
ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList;
Context context;

    public MedicalReportsUpdateAdapter(ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList, Context context) {
        this.medicalReportModelClassArrayList = medicalReportModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicalreportsupdate_items,parent,false);
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
        holder.upImg.setVisibility(View.GONE);

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.updateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateMedicalActivity.class);
                intent.putExtra("id",reportModelClass.getId());
                intent.putExtra("name",reportModelClass.getName());
                intent.putExtra("part",reportModelClass.getPart());
                intent.putExtra("date",reportModelClass.getDate());
                intent.putExtra("time",reportModelClass.getTime());
                intent.putExtra("conditions",reportModelClass.getCondition());
                intent.putExtra("describe",reportModelClass.getDescribe());
                intent.putExtra("phone",reportModelClass.getPhone());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return medicalReportModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView name,part,date,time,condition,describe,phone;
         ImageView upImg,downImg,updateImg;
         LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvCheck);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
            condition = itemView.findViewById(R.id.tvCondition);
            describe = itemView.findViewById(R.id.tvDescribe);
            phone = itemView.findViewById(R.id.tvphone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            updateImg = itemView.findViewById(R.id.updateImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
