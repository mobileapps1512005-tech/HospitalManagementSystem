package com.example.hospitalmanagementsystem.DoctorManageTask;

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

public class PatientAppointmentConfirmsDrAdapter extends RecyclerView.Adapter<PatientAppointmentConfirmsDrAdapter.ViewHolder>{
ArrayList<PatientModelClassAppointment> patientModelClassAppointmentArrayList;
Context context;

    public PatientAppointmentConfirmsDrAdapter(ArrayList<PatientModelClassAppointment> patientModelClassAppointmentArrayList, Context context) {
        this.patientModelClassAppointmentArrayList = patientModelClassAppointmentArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drconfirmsappointmentpatient_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PatientModelClassAppointment appointment = patientModelClassAppointmentArrayList.get(position);
        holder.tvName.setText(appointment.getName());
        holder.tvEmail.setText(appointment.getEmail());
        holder.AvailableDay.setText(appointment.getDay());
        holder.AvailableTime.setText(appointment.getTime());
        holder.Phone.setText(appointment.getPhone());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return patientModelClassAppointmentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvEmail,AvailableDay,AvailableTime,Phone;
        ImageView UpImg,DownImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            AvailableDay = itemView.findViewById(R.id.tvAvailableDay);
            AvailableTime = itemView.findViewById(R.id.tvAvailableTime);
            Phone = itemView.findViewById(R.id.tvPhone);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
