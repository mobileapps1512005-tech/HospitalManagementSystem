package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.DoctorManageTask.PatientViewHealDietAdapter;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class AmbulanceViewAdapter extends RecyclerView.Adapter<AmbulanceViewAdapter.ViewHolder>{
ArrayList<AmbulanceModelClass> ambulanceModelClassArrayList;
Context context;
    public AmbulanceViewAdapter(ArrayList<AmbulanceModelClass> ambulanceModelClassArrayList, Context context) {
        this.ambulanceModelClassArrayList = ambulanceModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ambulanceview_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AmbulanceModelClass ambulanceModelClass = ambulanceModelClassArrayList.get(position);
        holder.name.setText(ambulanceModelClass.getName());
        holder.email.setText(ambulanceModelClass.getEmail());
        holder.Experience.setText(ambulanceModelClass.getExperience());
        holder.license.setText(ambulanceModelClass.getLicense());
        holder.DriverContact.setText(ambulanceModelClass.getDriverContact());
        holder.VehicleNo.setText(ambulanceModelClass.getVehicleNo());
        holder.HospitalName.setText(ambulanceModelClass.getHospitalName());
        holder.HospitalNo.setText(ambulanceModelClass.getHospitalNo());
        holder.BaseFare.setText(ambulanceModelClass.getBaseFare());
        holder.PerKmCost.setText(ambulanceModelClass.getPerKmCost());
        holder.EmergencyCost.setText(ambulanceModelClass.getEmergencyCost());
        holder.WithDoctor.setText(ambulanceModelClass.getWithDoctor());
        holder.WithoutDoctor.setText(ambulanceModelClass.getWithoutDoctor());
        holder.WithAC.setText(ambulanceModelClass.getWithAC());
        holder.WithoutAC.setText(ambulanceModelClass.getWithoutAC());
        holder.AmbulanceAllPackage.setText(ambulanceModelClass.getAmbulanceAllPackage());
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
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.GONE);
            }
        });



    }

    @Override
    public int getItemCount() {
        return ambulanceModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,Experience,license,DriverContact,VehicleNo,HospitalName,HospitalNo,BaseFare,
                PerKmCost,EmergencyCost,WithDoctor,WithoutDoctor,WithAC,WithoutAC,AmbulanceAllPackage;
        ImageView UpImg,DownImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            Experience = itemView.findViewById(R.id.tvExperience);
            license = itemView.findViewById(R.id.tvLicense);
            DriverContact = itemView.findViewById(R.id.tvDriverContact);
            VehicleNo = itemView.findViewById(R.id.tvVehicleNo);
            HospitalName = itemView.findViewById(R.id.tvHospitalName);
            HospitalNo = itemView.findViewById(R.id.tvHospitalNo);
            BaseFare = itemView.findViewById(R.id.tvBaseFare);
            PerKmCost = itemView.findViewById(R.id.tvPerKmCost);
            EmergencyCost = itemView.findViewById(R.id.tvEmergencyCost);
            WithDoctor = itemView.findViewById(R.id.tvWithDoctor);
            WithoutDoctor = itemView.findViewById(R.id.tvWithoutDoctor);
            WithAC = itemView.findViewById(R.id.tvWithAC);
            WithoutAC = itemView.findViewById(R.id.tvWithoutAC);
            AmbulanceAllPackage = itemView.findViewById(R.id.tvAmbulanceAllPackage);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
