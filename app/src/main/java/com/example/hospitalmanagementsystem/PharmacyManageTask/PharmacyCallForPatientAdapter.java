package com.example.hospitalmanagementsystem.PharmacyManageTask;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
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

public class PharmacyCallForPatientAdapter extends RecyclerView.Adapter<PharmacyCallForPatientAdapter.ViewHolder>{
ArrayList<PharmacyModelClass> pharmacyModelClassArrayList;
Context context;

    public PharmacyCallForPatientAdapter(ArrayList<PharmacyModelClass> pharmacyModelClassArrayList, Context context) {
        this.pharmacyModelClassArrayList = pharmacyModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacycall_items,parent,false);
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
        String UniqueId = String.valueOf(pharmacyModelClass.getId());


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

        SharedPreferences sharedPreferences = context.getSharedPreferences("Permission",MODE_PRIVATE);
        boolean IsAvail = sharedPreferences.getBoolean(UniqueId,false);

        if (IsAvail){
            holder.status.setText("Pharmacy Call Allow");
            holder.status.setTextColor(Color.GREEN);
            holder.callImg.setVisibility(View.VISIBLE);
        }else {
            holder.status.setText("Pharmacy Call Not Allow");
            holder.status.setTextColor(Color.RED);
            holder.callImg.setVisibility(View.GONE);
        }

        holder.callImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+pharmacyModelClass.getPhone()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pharmacyModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,location,pharmacyName,qualification,EmergencyService,discount,returns,EmergencyTime,home,status;
        ImageView upImg,downImg,callImg;
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
            callImg = itemView.findViewById(R.id.callImg);
            status = itemView.findViewById(R.id.status);

        }
    }
}
