package com.example.hospitalmanagementsystem.DoctorManageTask;

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


public class DoctorCallPermissionAdapter extends RecyclerView.Adapter<DoctorCallPermissionAdapter.ViweHolder>{
    ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList;
    Context context;

    public DoctorCallPermissionAdapter(ArrayList<DoctorCallModelClass> doctorCallModelClassArrayList, Context context) {
        this.doctorCallModelClassArrayList = doctorCallModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorcallpermission_items,parent,false);
        return new ViweHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViweHolder holder, int position) {
        DoctorCallModelClass doctorCallModelClass = doctorCallModelClassArrayList.get(position);
        holder.name.setText(doctorCallModelClass.getName());
        holder.email.setText(doctorCallModelClass.getEmail());
        holder.qualification.setText(doctorCallModelClass.getQualification());
        holder.experience.setText(doctorCallModelClass.getExperience());
        holder.specialist.setText(doctorCallModelClass.getSpecialist());
        holder.availableDay.setText(doctorCallModelClass.getAvailableDay());
        holder.availableTime.setText(doctorCallModelClass.getAvailableTime());
        String UniqueIdKy = String.valueOf(doctorCallModelClass.getId());
        holder.phone.setText(UniqueIdKy);
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.GONE);

            }
        });

        SharedPreferences sharedPreferences = context.getSharedPreferences("Permission",MODE_PRIVATE);
        boolean IsAvail = sharedPreferences.getBoolean(UniqueIdKy,false);

        holder.aSwitch.setOnCheckedChangeListener(null);
        holder.aSwitch.setChecked(IsAvail);

        if (IsAvail){
         holder.status.setText("Available");
         holder.status.setTextColor(Color.GREEN);
        }else {
            holder.status.setText("Not Available");
            holder.status.setTextColor(Color.RED);
        }

        holder.aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(UniqueIdKy,isChecked);
            editor.apply();

            if (isChecked){
                holder.status.setText("Available");
                holder.status.setTextColor(Color.GREEN);
            }else {
                holder.status.setText("Not Available");
                holder.status.setTextColor(Color.RED);
            }
        });

    }

    @Override
    public int getItemCount() {
        return doctorCallModelClassArrayList.size();
    }

    public class ViweHolder extends RecyclerView.ViewHolder{
        TextView name,email,qualification,experience,specialist,availableDay,availableTime,phone,status;
        ImageView UpImg,DownImg,call;
        LinearLayout layout1;
        Switch aSwitch;

        public ViweHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            qualification = itemView.findViewById(R.id.tvQualification);
            experience = itemView.findViewById(R.id.tvExperience);
            specialist = itemView.findViewById(R.id.tvSpecialist);
            availableDay = itemView.findViewById(R.id.tvAvailableDay);
            availableTime = itemView.findViewById(R.id.tvAvailableTime);
            phone = itemView.findViewById(R.id.tvPhone);
            status = itemView.findViewById(R.id.tvStatus);
            call = itemView.findViewById(R.id.callImg);
            aSwitch = itemView.findViewById(R.id.Switche);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
