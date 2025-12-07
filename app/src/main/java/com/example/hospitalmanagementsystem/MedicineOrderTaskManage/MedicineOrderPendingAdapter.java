package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

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

public class MedicineOrderPendingAdapter extends RecyclerView.Adapter<MedicineOrderPendingAdapter.ViewHolder>{
ArrayList<MedicineModelClass> medicineModelClassArrayList;
Context context;

    public MedicineOrderPendingAdapter(ArrayList<MedicineModelClass> medicineModelClassArrayList, Context context) {
        this.medicineModelClassArrayList = medicineModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinependingonly_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicineModelClass modelClass = medicineModelClassArrayList.get(position);
        holder.name.setText(modelClass.getName());
        holder.email.setText(modelClass.getEmail());
        holder.phone.setText(modelClass.getPhone());
        holder.location.setText(modelClass.getLocation());
        holder.deliveryLocation.setText(modelClass.getDeliveryLocation());
        holder.medicineName.setText(modelClass.getMedicineName());
        holder.order.setText(modelClass.getOrder());
        holder.requiredDate.setText(modelClass.getRequiredDate());
        holder.requiredTime.setText(modelClass.getRequiredTime());


        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return medicineModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,location,deliveryLocation,medicineName,order,requiredDate,requiredTime;
        LinearLayout layout1;
        ImageView upImg,downImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            location = itemView.findViewById(R.id.tvLocation);
            deliveryLocation = itemView.findViewById(R.id.tvDelivery);
            medicineName = itemView.findViewById(R.id.tvMedicine);
            order = itemView.findViewById(R.id.tvBookDate);
            requiredDate = itemView.findViewById(R.id.tvrequiredDate);
            requiredTime = itemView.findViewById(R.id.tvrequiredTime);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
