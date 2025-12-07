package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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

public class PatientFoodOrderCallQueryAdapter extends RecyclerView.Adapter<PatientFoodOrderCallQueryAdapter.ViewHolder>{
ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClasses;
Context context;
public static final int RequestCode=1515;

    public PatientFoodOrderCallQueryAdapter(ArrayList<PatientFoodRequestModelClass> patientFoodRequestModelClasses, Context context) {
        this.patientFoodRequestModelClasses = patientFoodRequestModelClasses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pateintfoodordercall_items,parent,false);
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

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+patientFood.getPhone()));
                    context.startActivity(intent);
                }else {
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},RequestCode);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return patientFoodRequestModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,menu,quantity,floor,bad,phone;
        ImageView upImg,downImg,call;
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
            call = itemView.findViewById(R.id.callImg);

        }
    }
}
