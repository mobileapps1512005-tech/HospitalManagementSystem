package com.example.hospitalmanagementsystem.GrievanceActivity;

import android.content.Context;
import android.content.Intent;
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

public class ComplaneUpdateAdapter extends RecyclerView.Adapter<ComplaneUpdateAdapter.ViewHolder>{
ArrayList<GrievanceModelClass> grievanceModelClassArrayList;
Context context;

    public ComplaneUpdateAdapter(ArrayList<GrievanceModelClass> grievanceModelClassArrayList, Context context) {
        this.grievanceModelClassArrayList = grievanceModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grievance_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     GrievanceModelClass grievanceModel = grievanceModelClassArrayList.get(position);
        holder.hospital.setText(grievanceModel.getHospital());
        holder.name.setText(grievanceModel.getName());
        holder.phone.setText(grievanceModel.getPhone());
        holder.staff.setText(grievanceModel.getStaff());
        holder.grievance.setText(grievanceModel.getGrievance());

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
            }
        });

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
            }
        });

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateGrievanceActivity.class);
                intent.putExtra("id",grievanceModel.getId());
                intent.putExtra("hospital",grievanceModel.getHospital());
                intent.putExtra("name",grievanceModel.getName());
                intent.putExtra("phone",grievanceModel.getPhone());
                intent.putExtra("staff",grievanceModel.getStaff());
                intent.putExtra("grievance",grievanceModel.getGrievance());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return grievanceModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

         TextView hospital,name,phone,staff,grievance;
         ImageView upImg,downImg,update;
         LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospital = itemView.findViewById(R.id.tvHospital);
            name = itemView.findViewById(R.id.tvName);
            phone = itemView.findViewById(R.id.tvPhone);
            staff = itemView.findViewById(R.id.tvStaff);
            grievance = itemView.findViewById(R.id.tvGrievance);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            update = itemView.findViewById(R.id.updateImg);


        }
    }
}
