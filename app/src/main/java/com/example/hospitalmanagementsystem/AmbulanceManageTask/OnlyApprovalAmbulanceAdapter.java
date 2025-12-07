package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class OnlyApprovalAmbulanceAdapter extends RecyclerView.Adapter<OnlyApprovalAmbulanceAdapter.ViewHolder>{
ArrayList<AmbulanceBookingModelClass> ambulanceBookingModelClassArrayList;
Context context;

    public OnlyApprovalAmbulanceAdapter(ArrayList<AmbulanceBookingModelClass> ambulanceBookingModelClassArrayList, Context context) {
        this.ambulanceBookingModelClassArrayList = ambulanceBookingModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.approvalambulace_items_only,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AmbulanceBookingModelClass bookingModelClass = ambulanceBookingModelClassArrayList.get(position);
        holder.name.setText(bookingModelClass.getName());
        holder.email.setText(bookingModelClass.getEmail());
        holder.phone.setText(bookingModelClass.getPhone());
        holder.alter.setText(bookingModelClass.getAlters());
        holder.location.setText(bookingModelClass.getLocation());
        holder.ambulance.setText(bookingModelClass.getAmbulance());
        holder.upImg.setVisibility(View.GONE);

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return ambulanceBookingModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,alter,location,ambulance;
        ImageView upImg,downImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            alter = itemView.findViewById(R.id.tvAlter);
            location = itemView.findViewById(R.id.tvLocation);
            ambulance = itemView.findViewById(R.id.tvAmbulance);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
        }
    }
}
