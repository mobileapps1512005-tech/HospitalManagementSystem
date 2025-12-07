package com.example.hospitalmanagementsystem.NurseManageTask;

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

public class NurseCallPermissionAdapter extends RecyclerView.Adapter<NurseCallPermissionAdapter.ViewHolder>{
ArrayList<NurseModelClass> nurseModelClassArrayList;
Context context;

    public NurseCallPermissionAdapter(ArrayList<NurseModelClass> nurseModelClassArrayList, Context context) {
        this.nurseModelClassArrayList = nurseModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nursecallitems,parent,false);
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
        holder.phones.setText(UniqueId);

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

        holder.aSwitch.setOnCheckedChangeListener(null);
        holder.aSwitch.setChecked(IsAvail);

        if (IsAvail){
            holder.status.setText("Call Permission");
            holder.status.setTextColor(Color.GREEN);
        }else {
            holder.status.setText("Call Permission Not Available");
            holder.status.setTextColor(Color.RED);
        }

        holder.aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(UniqueId,isChecked);
            editor.apply();

            if (isChecked){
                holder.status.setText("Call Permission");
                holder.status.setTextColor(Color.GREEN);
            }else {
                holder.status.setText("Call Permission Not Available");
                holder.status.setTextColor(Color.RED);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nurseModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,qualification,experience,phones,gender,location,status;
        ImageView UpImg,DownImg;
        LinearLayout layout1;
        Switch aSwitch;

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
            aSwitch = itemView.findViewById(R.id.Switche);
            layout1 = itemView.findViewById(R.id.layout1);
            status = itemView.findViewById(R.id.tvStatus);

        }
    }
}
