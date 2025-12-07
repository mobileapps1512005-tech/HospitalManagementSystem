package com.example.hospitalmanagementsystem.PharmacyManageTask;

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

public class PharmacyDeleteAdapter extends RecyclerView.Adapter<PharmacyDeleteAdapter.VewHolder>{
ArrayList<PharmacyModelClass> pharmacyModelClassArrayList;
Context context;
PharmacyDetailDataBase pharmacyDetailDataBase;
    public PharmacyDeleteAdapter(ArrayList<PharmacyModelClass> pharmacyModelClassArrayList, Context context) {
        this.pharmacyModelClassArrayList = pharmacyModelClassArrayList;
        this.context = context;
    }

    @Override
    public VewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacydelete_items,parent,false);
        return new VewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VewHolder holder, @SuppressLint("RecyclerView") int position) {
        pharmacyDetailDataBase = new PharmacyDetailDataBase(context);
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

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("Are You Sure You Want To Delete Confirmation....");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pharmacyDetailDataBase.DeletePharmacyDetails(pharmacyModelClass.getId());
                        pharmacyModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeRemoved(position,pharmacyModelClassArrayList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(true);
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pharmacyModelClassArrayList.size();
    }

    public class VewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,location,pharmacyName,qualification,EmergencyService,discount,returns,EmergencyTime,home;
        ImageView upImg,downImg,deleteImg;
        LinearLayout layout1;
        public VewHolder(@NonNull View itemView) {
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
            deleteImg = itemView.findViewById(R.id.deleteImg);

        }
    }
}
