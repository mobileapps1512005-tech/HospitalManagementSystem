package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

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

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class MedicineReturnDeleteAdapter extends RecyclerView.Adapter<MedicineReturnDeleteAdapter.ViewHolder>{
ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList;
Context context;
MedicineReturnPolicyDataBase medicineReturnPolicyDataBase;

    public MedicineReturnDeleteAdapter(ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList, Context context) {
        this.medicineReturnModelClassArrayList = medicineReturnModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinereturndelete_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        medicineReturnPolicyDataBase = new MedicineReturnPolicyDataBase(context);
        MedicineReturnModelClass medicineReturnModelClass = medicineReturnModelClassArrayList.get(position);
        holder.name.setText(medicineReturnModelClass.getName());
        holder.condition.setText(medicineReturnModelClass.getCondition());
        holder.phone.setText(medicineReturnModelClass.getPhone());

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
            }
        });

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("Are You Sure You Want To Delete Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        medicineReturnPolicyDataBase.DeleteMedicineDetails(medicineReturnModelClass.getId());
                        medicineReturnModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeRemoved(position,medicineReturnModelClassArrayList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         builder.setCancelable(true);
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return medicineReturnModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,condition,phone;
        ImageView upImg,downImg,deleteImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            condition = itemView.findViewById(R.id.tvCondition);
            phone = itemView.findViewById(R.id.tvPhone);
            downImg = itemView.findViewById(R.id.DownImg);
            upImg = itemView.findViewById(R.id.UpImg);
            layout1 = itemView.findViewById(R.id.layout1);
            deleteImg = itemView.findViewById(R.id.deleteImg);

        }
    }
}
