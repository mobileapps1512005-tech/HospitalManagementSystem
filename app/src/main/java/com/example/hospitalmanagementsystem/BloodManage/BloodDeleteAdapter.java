package com.example.hospitalmanagementsystem.BloodManage;

import android.annotation.SuppressLint;
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

import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class BloodDeleteAdapter extends RecyclerView.Adapter<BloodDeleteAdapter.ViewHolder>{
ArrayList<BloodModelClass> bloodModelClassArrayList;
Context context;
BloodDataBase bloodDataBase;

    public BloodDeleteAdapter(ArrayList<BloodModelClass> bloodModelClassArrayList, Context context) {
        this.bloodModelClassArrayList = bloodModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blooddelete_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        bloodDataBase = new BloodDataBase(context);
        BloodModelClass modelClass = bloodModelClassArrayList.get(position);
        holder.hospital.setText(modelClass.getHospital());
        holder.blood.setText(modelClass.getBlood());
        holder.quantity.setText(modelClass.getQuantity());
        holder.phone.setText(modelClass.getPhone());

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

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation....");
                builder.setMessage("Are You Sure You Want To Delete Details...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bloodDataBase.GetDeleteDetails(modelClass.getId());
                        bloodModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,bloodModelClassArrayList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return bloodModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital,blood,quantity,phone;
        ImageView upImg,downImg,deleteImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospital = itemView.findViewById(R.id.tvHospital);
            blood = itemView.findViewById(R.id.tvBloodType);
            quantity = itemView.findViewById(R.id.tvBloodQuantity);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            deleteImg = itemView.findViewById(R.id.deleteImg);

        }
    }
}
