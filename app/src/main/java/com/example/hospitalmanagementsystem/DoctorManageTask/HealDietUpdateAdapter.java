package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.HospitalManageTask.HospitalDetailsUpdateActivity;
import com.example.hospitalmanagementsystem.HospitalManageTask.HospitalModelClass;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class HealDietUpdateAdapter extends RecyclerView.Adapter<HealDietUpdateAdapter.ViewHolder>{
    ArrayList<HealDietModelClass> healDietModelClassArrayList;
    Context context;

    public HealDietUpdateAdapter(ArrayList<HealDietModelClass> healDietModelClassArrayList, Context context) {
        this.healDietModelClassArrayList = healDietModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.healdietupdate_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HealDietModelClass healDietModelClass = healDietModelClassArrayList.get(position);
        holder.tvName.setText(healDietModelClass.getName());
        holder.tvAge.setText(healDietModelClass.getAge());
        holder.tvMorning.setText(healDietModelClass.getMorning());
        holder.tvLunch.setText(healDietModelClass.getLunch());
        holder.tvDinner.setText(healDietModelClass.getDinner());
        holder.tvDoctor.setText(healDietModelClass.getDoctor());
        holder.tvPhone.setText(healDietModelClass.getPhone());
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
                holder.UpImg.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

        holder.updateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Update Confirmation...");
                builder.setMessage("Are You Sure You Want To Update Confirmation...");
                builder.setIcon(R.drawable.edit);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,HealDietUpdateActivity.class);
                        intent.putExtra("id",healDietModelClass.getId());
                        intent.putExtra("name",healDietModelClass.getName());
                        intent.putExtra("age",healDietModelClass.getAge());
                        intent.putExtra("morning",healDietModelClass.getMorning());
                        intent.putExtra("lunch",healDietModelClass.getLunch());
                        intent.putExtra("dinner",healDietModelClass.getDinner());
                        intent.putExtra("doctor",healDietModelClass.getDoctor());
                        intent.putExtra("phone",healDietModelClass.getPhone());
                        context.startActivity(intent);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return healDietModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvAge,tvMorning,tvLunch,tvDinner,tvDoctor,tvPhone;
        ImageView updateImg,UpImg,DownImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvMorning = itemView.findViewById(R.id.tvMorning);
            tvLunch = itemView.findViewById(R.id.tvLunch);
            tvDinner = itemView.findViewById(R.id.tvDinner);
            tvDoctor = itemView.findViewById(R.id.tvDoctor);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            updateImg = itemView.findViewById(R.id.updateImg);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
