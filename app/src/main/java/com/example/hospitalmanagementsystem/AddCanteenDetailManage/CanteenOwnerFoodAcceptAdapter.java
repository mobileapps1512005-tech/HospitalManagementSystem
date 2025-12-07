package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import android.content.Context;
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

public class CanteenOwnerFoodAcceptAdapter extends RecyclerView.Adapter<CanteenOwnerFoodAcceptAdapter.ViewHolder>{
ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClassArrayList;
Context context;

    public CanteenOwnerFoodAcceptAdapter(ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClassArrayList, Context context) {
        this.patientFoodRequestModelClassArrayList = patientFoodRequestModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ownerfood_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PatientFoodRequestModelClass patientFood = patientFoodRequestModelClassArrayList.get(position);
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

    }

    @Override
    public int getItemCount() {
        return patientFoodRequestModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,menu,quantity,floor,bad,phone;
        ImageView upImg,downImg;
        LinearLayout layout1;

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
        }
    }
}
