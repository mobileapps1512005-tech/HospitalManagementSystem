package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class MedSuggestAdapter extends RecyclerView.Adapter<MedSuggestAdapter.ViewHolder>{
ArrayList<MedSuggestModelClass> medSuggestModelClasses;
Context context;

    public MedSuggestAdapter(ArrayList<MedSuggestModelClass> medSuggestModelClasses, Context context) {
        this.medSuggestModelClasses = medSuggestModelClasses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.presciption_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedSuggestModelClass suggestModelClass = medSuggestModelClasses.get(position);
        holder.hospital.setText(suggestModelClass.getHospital());
        holder.doctor.setText(suggestModelClass.getDoctor());
        holder.name.setText(suggestModelClass.getName());
        holder.phone.setText(suggestModelClass.getPhone());
        holder.treatment.setText(suggestModelClass.getTreatment());
        holder.medicine.setText(suggestModelClass.getMedicine());

    }

    @Override
    public int getItemCount() {
        return medSuggestModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView hospital,doctor,phone,name,treatment,medicine;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        hospital = itemView.findViewById(R.id.tvHospital);
        doctor = itemView.findViewById(R.id.tvDoctor);
        name = itemView.findViewById(R.id.tvName);
        phone = itemView.findViewById(R.id.tvPhone);
        treatment = itemView.findViewById(R.id.tvTreament);
        medicine = itemView.findViewById(R.id.tvMedicine);


       }
    }
}
