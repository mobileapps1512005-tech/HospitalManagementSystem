package com.example.hospitalmanagementsystem.PharmacyManageTask;

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

public class PharmacyViewAdapter extends RecyclerView.Adapter<PharmacyViewAdapter.ViewHolder>{
ArrayList<PharmacyModelClass> pharmacyModelClassArrayList;
Context context;

    public PharmacyViewAdapter(ArrayList<PharmacyModelClass> pharmacyModelClassArrayList, Context context) {
        this.pharmacyModelClassArrayList = pharmacyModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacyview_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PharmacyModelClass pharmacyModelClass = pharmacyModelClassArrayList.get(position);
        holder.name.setText(pharmacyModelClass.getName());
        holder.email.setText(pharmacyModelClass.getEmail());
        holder.phone.setText(pharmacyModelClass.getPhone());
        holder.location.setText(pharmacyModelClass.getLocation());
        holder.pharmacyName.setText(pharmacyModelClass.getPharmacyName());
        holder.qualification.setText(pharmacyModelClass.getQualification());
        holder.EmergencyService.setText(pharmacyModelClass.getEmergencyService());
        holder.discount.setText(pharmacyModelClass.getDiscount());
        holder.returns.setText(pharmacyModelClass.getReturns());
        holder.EmergencyTime.setText(pharmacyModelClass.getEmergencyTime());
        holder.home.setText(pharmacyModelClass.getHome());
        holder.upImg.setVisibility(View.GONE);

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
        return pharmacyModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,location,pharmacyName,qualification,EmergencyService,discount,returns,EmergencyTime,home;
        ImageView upImg,downImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            location = itemView.findViewById(R.id.tvLocation);
            pharmacyName = itemView.findViewById(R.id.tvDuty);
            qualification = itemView.findViewById(R.id.tvQualification);
            EmergencyService = itemView.findViewById(R.id.tvEmergencyService);
            discount = itemView.findViewById(R.id.tvDiscount);
            returns = itemView.findViewById(R.id.tvReturn);
            EmergencyTime = itemView.findViewById(R.id.tvTime);
            home = itemView.findViewById(R.id.tvHomeDelivery);
            downImg = itemView.findViewById(R.id.DownImg);
            upImg = itemView.findViewById(R.id.UpImg);
            layout1 = itemView.findViewById(R.id.layout1);


        }
    }
}
