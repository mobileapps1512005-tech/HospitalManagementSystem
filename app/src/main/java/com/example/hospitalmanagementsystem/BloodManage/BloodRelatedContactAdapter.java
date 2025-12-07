package com.example.hospitalmanagementsystem.BloodManage;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class BloodRelatedContactAdapter extends RecyclerView.Adapter<BloodRelatedContactAdapter.ViewHolder>{
ArrayList<BloodModelClass> bloodModelClassArrayList;
Context context;
public static final int RequestCode=1515;

    public BloodRelatedContactAdapter(ArrayList<BloodModelClass> bloodModelClassArrayList, Context context) {
        this.bloodModelClassArrayList = bloodModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloodrelatedcall_items,parent,false);
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

        holder.callImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+modelClass.getPhone()));
                    context.startActivity(intent);
                }else {
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},RequestCode);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return bloodModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital,blood,quantity,phone;
        ImageView upImg,downImg,callImg;
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
            callImg = itemView.findViewById(R.id.callImg);

        }
    }
}
