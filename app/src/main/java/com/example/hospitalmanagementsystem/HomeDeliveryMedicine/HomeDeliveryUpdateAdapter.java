package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

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

public class HomeDeliveryUpdateAdapter extends RecyclerView.Adapter<HomeDeliveryUpdateAdapter.ViewHolder>{
ArrayList<ModelClass> modelClassArrayList;
Context context;

    public HomeDeliveryUpdateAdapter(ArrayList<ModelClass> modelClassArrayList, Context context) {
        this.modelClassArrayList = modelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homedeliveryupdate_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = modelClassArrayList.get(position);
        holder.tvName.setText(modelClass.getName());
        holder.tvEmail.setText(modelClass.getEmail());
        holder.tvLocation.setText(modelClass.getLocation());
        holder.tvPhone.setText(modelClass.getPhone());
        holder.tvGender.setText(modelClass.getGender());
        holder.tvExperience.setText(modelClass.getExperience());

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.DownImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
            }
        });

        holder.updateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvEmail,tvLocation,tvGender,tvExperience,tvPhone;
        LinearLayout layout1;
        ImageView UpImg,DownImg,updateImg;

     public ViewHolder(@NonNull View itemView) {
         super(itemView);

         tvName = itemView.findViewById(R.id.tvName);
         tvEmail = itemView.findViewById(R.id.tvEmail);
         tvLocation = itemView.findViewById(R.id.tvLocation);
         tvPhone = itemView.findViewById(R.id.tvPhone);
         tvGender = itemView.findViewById(R.id.tvGender);
         tvExperience = itemView.findViewById(R.id.tvExperience);
         layout1 = itemView.findViewById(R.id.layout1);
         UpImg = itemView.findViewById(R.id.UpImg);
         DownImg = itemView.findViewById(R.id.DownImg);
         updateImg = itemView.findViewById(R.id.updateImg);

     }
   }
}
