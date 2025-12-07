package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
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

public class PatientCallDeliveryBodAdapter extends RecyclerView.Adapter<PatientCallDeliveryBodAdapter.ViewHolder>{
ArrayList<ModelClass> modelClassArrayList;
Context context;
public static final int RequestCode=1515;
    public PatientCallDeliveryBodAdapter(ArrayList<ModelClass> modelClassArrayList, Context context) {
        this.modelClassArrayList = modelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliveryboycalloption_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       ModelClass modelClass = modelClassArrayList.get(position);
        holder.tvName.setText(modelClass.getName());
        holder.tvEmail.setText(modelClass.getEmail());
        holder.tvLocation.setText(modelClass.getLocation());
        String UniqueId = modelClass.getPhone();
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

        SharedPreferences sharedPreferences = context.getSharedPreferences("Status",MODE_PRIVATE);
        boolean isAvail = sharedPreferences.getBoolean(UniqueId,false);

        if (isAvail){
            holder.tvStatus.setText("Call Option Available");
            holder.tvStatus.setTextColor(Color.GREEN);
            holder.call.setVisibility(View.VISIBLE);
        }else {
            holder.tvStatus.setText("Call Option Not Available");
            holder.tvStatus.setTextColor(Color.RED);
            holder.call.setVisibility(View.GONE);
        }

        holder.call.setOnClickListener(new View.OnClickListener() {
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
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvEmail,tvLocation,tvGender,tvExperience,tvPhone,tvStatus;
        LinearLayout layout1;
        ImageView UpImg,DownImg,call;
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
            tvStatus = itemView.findViewById(R.id.tvStatus);
            call = itemView.findViewById(R.id.callImg);

        }
    }
}
