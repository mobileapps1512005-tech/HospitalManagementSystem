package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class DeliveryStaffAdapter extends RecyclerView.Adapter<DeliveryStaffAdapter.ViewHolder>{
ArrayList<ModelClass> modelClassArrayList;
Context context;
ModelClass modelClass;

    public DeliveryStaffAdapter(ArrayList<ModelClass> modelClassArrayList, Context context) {
        this.modelClassArrayList = modelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_delivey_staff_status,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modelClass = modelClassArrayList.get(position);
        holder.tvName.setText(modelClass.getName());
        holder.tvEmail.setText(modelClass.getEmail());
        holder.tvLocation.setText(modelClass.getLocation());
        String KeyPhone = modelClass.getPhone();
        holder.tvPhone.setText(KeyPhone);
        holder.tvGender.setText(modelClass.getGender());
        holder.tvExperience.setText(modelClass.getExperience());
        holder.UpImg.setVisibility(View.GONE);

        SharedPreferences sharedPreferences = context.getSharedPreferences("Status",MODE_PRIVATE);
        boolean IsAvail = sharedPreferences.getBoolean(KeyPhone,false);

        holder.aSwitch.setOnCheckedChangeListener(null);
        holder.aSwitch.setChecked(IsAvail);

        if (IsAvail){
            holder.tvStatus.setText("Available");
            holder.tvStatus.setTextColor(Color.GREEN);
        }else {
            holder.tvStatus.setText("Not Available");
            holder.tvStatus.setTextColor(Color.RED);
        }

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

        holder.aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putBoolean(KeyPhone,isChecked);
         editor.apply();

            if (isChecked){
                holder.tvStatus.setText("Available");
                holder.tvStatus.setTextColor(Color.GREEN);
            }else {
                holder.tvStatus.setText("Not Available");
                holder.tvStatus.setTextColor(Color.RED);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
             Switch aSwitch;
             TextView tvName,tvEmail,tvLocation,tvGender,tvExperience,tvPhone,tvStatus;
             LinearLayout layout1;
             ImageView UpImg,DownImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            aSwitch = itemView.findViewById(R.id.Switche);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvExperience = itemView.findViewById(R.id.tvExperience);
            layout1 = itemView.findViewById(R.id.layout1);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }

}
