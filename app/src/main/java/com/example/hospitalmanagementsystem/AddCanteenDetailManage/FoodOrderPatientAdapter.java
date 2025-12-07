package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class FoodOrderPatientAdapter extends RecyclerView.Adapter<FoodOrderPatientAdapter.ViewHolder>{
ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClasses;
Context context;

    public FoodOrderPatientAdapter(ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClasses, Context context) {
        this.patientFoodRequestModelClasses = patientFoodRequestModelClasses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientfoodorderdetails_iitems,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PatientFoodRequestModelClass patientFood = patientFoodRequestModelClasses.get(position);
        holder.name.setText(patientFood.getName());
        holder.menu.setText(patientFood.getMenu());
        holder.quantity.setText(patientFood.getQuantity());
        holder.floor.setText(patientFood.getFloor());
        holder.bad.setText(patientFood.getBad());
        holder.phone.setText(patientFood.getPhone());

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.GONE);
            }
        });

        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CanteenOwnerAcceptFoodActivity.class);
                intent.putExtra("id",patientFood.getId());
                intent.putExtra("name",patientFood.getName());
                intent.putExtra("menu",patientFood.getMenu());
                intent.putExtra("quantity",patientFood.getQuantity());
                intent.putExtra("floor",patientFood.getFloor());
                intent.putExtra("bad",patientFood.getBad());
                intent.putExtra("phone",patientFood.getPhone());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return patientFoodRequestModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView name,menu,quantity,floor,bad,phone;
            ImageView upImg,downImg;
            LinearLayout layout1;
            Button confirm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            menu = itemView.findViewById(R.id.tvItemName);
            quantity = itemView.findViewById(R.id.tvQuantity);
            floor = itemView.findViewById(R.id.tvFloor);
            bad = itemView.findViewById(R.id.tvBad);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            confirm = itemView.findViewById(R.id.btnConfirm);

        }
    }
}
