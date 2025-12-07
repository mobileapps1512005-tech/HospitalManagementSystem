package com.example.hospitalmanagementsystem.GrievanceActivity;

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

public class ShowPatientGrievanceAdapter extends RecyclerView.Adapter<ShowPatientGrievanceAdapter.ViewHolder>{
    ArrayList<GrievanceModelClass> grievanceModelClasses;
    Context context;
    public static final int RequestCode=1;

    public ShowPatientGrievanceAdapter(ArrayList<GrievanceModelClass> grievanceModelClasses, Context context) {
        this.grievanceModelClasses = grievanceModelClasses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grievance_itemsss,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GrievanceModelClass grievanceModel = grievanceModelClasses.get(position);
        holder.hospital.setText(grievanceModel.getHospital());
        holder.name.setText(grievanceModel.getName());
        holder.phone.setText(grievanceModel.getPhone());
        holder.staff.setText(grievanceModel.getStaff());
        holder.grievance.setText(grievanceModel.getGrievance());
        holder.upImg.setVisibility(View.GONE);

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

                if (ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+grievanceModel.getPhone()));
                    context.startActivity(intent);
                }else {
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},RequestCode);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return grievanceModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital,name,phone,staff,grievance;
        ImageView upImg,downImg,callImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospital = itemView.findViewById(R.id.tvHospital);
            name = itemView.findViewById(R.id.tvName);
            phone = itemView.findViewById(R.id.tvPhone);
            staff = itemView.findViewById(R.id.tvStaff);
            grievance = itemView.findViewById(R.id.tvGrievance);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            callImg = itemView.findViewById(R.id.callImg);

        }
    }
}
