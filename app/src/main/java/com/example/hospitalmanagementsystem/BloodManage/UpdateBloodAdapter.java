package com.example.hospitalmanagementsystem.BloodManage;

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

public class UpdateBloodAdapter extends RecyclerView.Adapter<UpdateBloodAdapter.ViewHolder>{
ArrayList<BloodModelClass> bloodModelClassArrayList;
Context context;

    public UpdateBloodAdapter(ArrayList<BloodModelClass> bloodModelClassArrayList, Context context) {
        this.bloodModelClassArrayList = bloodModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blood_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BloodModelClass modelClass = bloodModelClassArrayList.get(position);
        holder.hospital.setText(modelClass.getHospital());
        holder.blood.setText(modelClass.getBlood());
        holder.quantity.setText(modelClass.getQuantity());
        holder.phone.setText(modelClass.getPhone());

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

        holder.updateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id",modelClass.getId());
                intent.putExtra("hospital",modelClass.getHospital());
                intent.putExtra("phone",modelClass.getPhone());
                intent.putExtra("blood",modelClass.getBlood());
                intent.putExtra("quantity",modelClass.getQuantity());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return bloodModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
              TextView hospital,blood,quantity,phone;
              ImageView upImg,downImg,updateImg;
              LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospital = itemView.findViewById(R.id.tvHospital);
            blood = itemView.findViewById(R.id.tvBloodType);
            quantity = itemView.findViewById(R.id.tvBloodQuantity);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            updateImg = itemView.findViewById(R.id.updateImg);

        }
    }
}
