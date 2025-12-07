package com.example.hospitalmanagementsystem.DoctorManageTask;

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


public class PatientViewHealDietAdapter extends RecyclerView.Adapter<PatientViewHealDietAdapter.ViewHolder>{
ArrayList<HealDietModelClass> healDietModelClassArrayList;
Context context;

    public PatientViewHealDietAdapter(ArrayList<HealDietModelClass> healDietModelClassArrayList, Context context) {
        this.healDietModelClassArrayList = healDietModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.healdiet_items,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HealDietModelClass healDietModelClass = healDietModelClassArrayList.get(position);
        holder.tvName.setText(healDietModelClass.getName());
        holder.tvAge.setText(healDietModelClass.getAge());
        holder.tvMorning.setText(healDietModelClass.getMorning());
        holder.tvLunch.setText(healDietModelClass.getLunch());
        holder.tvDinner.setText(healDietModelClass.getDinner());
        holder.tvDoctor.setText(healDietModelClass.getDoctor());
        holder.tvPhone.setText(healDietModelClass.getPhone());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.DownImg.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return healDietModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvAge,tvMorning,tvLunch,tvDinner,tvDoctor,tvPhone;
        ImageView UpImg,DownImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvMorning = itemView.findViewById(R.id.tvMorning);
            tvLunch = itemView.findViewById(R.id.tvLunch);
            tvDinner = itemView.findViewById(R.id.tvDinner);
            tvDoctor = itemView.findViewById(R.id.tvDoctor);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }

}
