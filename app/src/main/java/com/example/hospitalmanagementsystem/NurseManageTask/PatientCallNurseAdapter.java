package com.example.hospitalmanagementsystem.NurseManageTask;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
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

public class PatientCallNurseAdapter extends RecyclerView.Adapter<PatientCallNurseAdapter.ViewHolder>{
    ArrayList<NurseModelClass> nurseModelClassArrayList;
    Context context;

    public PatientCallNurseAdapter(ArrayList<NurseModelClass> nurseModelClassArrayList, Context context) {
        this.nurseModelClassArrayList = nurseModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientcall_nurse_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NurseModelClass nurseModelClass = nurseModelClassArrayList.get(position);
        holder.UpImg.setVisibility(View.GONE);
        holder.name.setText(nurseModelClass.getName());
        holder.email.setText(nurseModelClass.getEmail());
        holder.qualification.setText(nurseModelClass.getQualification());
        holder.experience.setText(nurseModelClass.getExperience());
        holder.gender.setText(nurseModelClass.getGender());
        holder.location.setText(nurseModelClass.getLocation());
        String UniqueId = String.valueOf(nurseModelClass.getId());

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
            }
        });

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
            }
        });

        SharedPreferences sharedPreferences = context.getSharedPreferences("Nurse",MODE_PRIVATE);
        boolean IsAvail = sharedPreferences.getBoolean(UniqueId,false);

        if (IsAvail){
            holder.status.setText("Call For Nurse Available");
            holder.status.setTextColor(Color.GREEN);
            holder.callImg.setVisibility(View.VISIBLE);
        }else {
            holder.status.setText("Call Not Available");
            holder.status.setTextColor(Color.RED);
            holder.callImg.setVisibility(View.GONE);
        }

        holder.callImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+nurseModelClass.getPhone()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nurseModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,qualification,experience,phones,gender,location,status;
        ImageView UpImg,DownImg,callImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            qualification = itemView.findViewById(R.id.tvQualification);
            experience = itemView.findViewById(R.id.tvExperience);
            gender = itemView.findViewById(R.id.tvGender);
            location = itemView.findViewById(R.id.tvLocation);
            phones = itemView.findViewById(R.id.tvPhones);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            callImg = itemView.findViewById(R.id.callImg);
            layout1 = itemView.findViewById(R.id.layout1);
            status = itemView.findViewById(R.id.tvStatus);


        }
    }
}
