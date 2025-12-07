package com.example.hospitalmanagementsystem.HospitalManageTask;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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


public class HospitalViewAdapter extends RecyclerView.Adapter<HospitalViewAdapter.ViewHolder>{
ArrayList<HospitalModelClass> hospitalViewAdapterArrayList;
Context context;

    public HospitalViewAdapter(ArrayList<HospitalModelClass> hospitalViewAdapterArrayList, Context context) {
        this.hospitalViewAdapterArrayList = hospitalViewAdapterArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospitals_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HospitalModelClass hospitalModelClass = hospitalViewAdapterArrayList.get(position);
        holder.tvName.setText(hospitalModelClass.getName());
        holder.tvEmail.setText(hospitalModelClass.getEmail());
        holder.tvYear.setText(hospitalModelClass.getYear());
        holder.tvLocation.setText(hospitalModelClass.getLocation());
        holder.tvPhone.setText(hospitalModelClass.getPhone());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.DownImg.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hospitalViewAdapterArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvEmail,tvYear,tvLocation,tvPhone;
        ImageView UpImg,DownImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvYear = itemView.findViewById(R.id.tvEstablished);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);


        }
    }
}
