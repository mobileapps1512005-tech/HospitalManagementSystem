package com.example.hospitalmanagementsystem.DoctorManageTask;

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


public class DoctorDetailsUpdateAdapter extends RecyclerView.Adapter<DoctorDetailsUpdateAdapter.ViewHolder>{
ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList;
Context context;

    public DoctorDetailsUpdateAdapter(ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList, Context context) {
        this.doctorCallModelClassArrayList = doctorCallModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updatedoctordetails,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorCallModelClass doctorCallModelClass = doctorCallModelClassArrayList.get(position);
        holder.name.setText(doctorCallModelClass.getName());
        holder.email.setText(doctorCallModelClass.getEmail());
        holder.qualification.setText(doctorCallModelClass.getQualification());
        holder.experience.setText(doctorCallModelClass.getExperience());
        holder.specialist.setText(doctorCallModelClass.getSpecialist());
        holder.availableDay.setText(doctorCallModelClass.getAvailableDay());
        holder.availableTime.setText(doctorCallModelClass.getAvailableTime());
        holder.phone.setText(doctorCallModelClass.getPhone());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.GONE);

            }
        });

        holder.EditImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateDoctorDetails.class);
                intent.putExtra("id",doctorCallModelClass.getId());
                intent.putExtra("name",doctorCallModelClass.getName());
                intent.putExtra("email",doctorCallModelClass.getEmail());
                intent.putExtra("qualification",doctorCallModelClass.getQualification());
                intent.putExtra("experience",doctorCallModelClass.getExperience());
                intent.putExtra("specialist",doctorCallModelClass.getSpecialist());
                intent.putExtra("availableDay",doctorCallModelClass.getAvailableDay());
                intent.putExtra("availableTime",doctorCallModelClass.getAvailableTime());
                intent.putExtra("phone",doctorCallModelClass.getPhone());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return doctorCallModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,qualification,experience,specialist,availableDay,availableTime,phone;
        ImageView EditImg,UpImg,DownImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            qualification = itemView.findViewById(R.id.tvQualification);
            experience = itemView.findViewById(R.id.tvExperience);
            specialist = itemView.findViewById(R.id.tvSpecialist);
            availableDay = itemView.findViewById(R.id.tvAvailableDay);
            availableTime = itemView.findViewById(R.id.tvAvailableTime);
            phone = itemView.findViewById(R.id.tvPhone);
            EditImg = itemView.findViewById(R.id.EditImg);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }

}
