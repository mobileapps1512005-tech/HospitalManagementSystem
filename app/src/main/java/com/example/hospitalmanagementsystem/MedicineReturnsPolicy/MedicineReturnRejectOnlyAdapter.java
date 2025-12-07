package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

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

public class MedicineReturnRejectOnlyAdapter extends RecyclerView.Adapter<MedicineReturnRejectOnlyAdapter.ViewHolder>{
ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList;
Context context;

    public MedicineReturnRejectOnlyAdapter(ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList, Context context) {
        this.medicineReturnModelClassArrayList = medicineReturnModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinereturnreject_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicineReturnModelClass medicineReturnModelClass = medicineReturnModelClassArrayList.get(position);
        holder.name.setText(medicineReturnModelClass.getName());
        holder.condition.setText(medicineReturnModelClass.getCondition());
        holder.phone.setText(medicineReturnModelClass.getPhone());

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicineReturnModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,condition,phone;
        ImageView upImg,downImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            condition = itemView.findViewById(R.id.tvCondition);
            phone = itemView.findViewById(R.id.tvPhone);
            downImg = itemView.findViewById(R.id.DownImg);
            upImg = itemView.findViewById(R.id.UpImg);
            layout1 = itemView.findViewById(R.id.layout1);
        }
    }
}
