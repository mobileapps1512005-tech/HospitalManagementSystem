package com.example.hospitalmanagementsystem.MedicalReports;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class MedicalReportsDeleteAdapter extends RecyclerView.Adapter<MedicalReportsDeleteAdapter.ViewHolder>{
ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList;
Context context;
MedicalReportsDataBase medicalReportsDataBase;

    public MedicalReportsDeleteAdapter(ArrayList<MedicalReportModelClass> medicalReportModelClassArrayList, Context context) {
        this.medicalReportModelClassArrayList = medicalReportModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reportsdelete_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        medicalReportsDataBase = new MedicalReportsDataBase(context);
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

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("Are You Sure You Want To Delete Confirmation...");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        medicalReportsDataBase.GetDeleteMedicalReports(reportModelClass.getId());
                        medicalReportModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeRemoved(position,medicalReportModelClassArrayList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(false);
                    }
                });
                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return medicalReportModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,date,time,condition,describe,phone;
        ImageView upImg,downImg,deleteImg;
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
            deleteImg = itemView.findViewById(R.id.deleteImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
