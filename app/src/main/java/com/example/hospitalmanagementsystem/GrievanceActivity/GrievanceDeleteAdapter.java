package com.example.hospitalmanagementsystem.GrievanceActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class GrievanceDeleteAdapter extends RecyclerView.Adapter<GrievanceDeleteAdapter.ViewHolder>{
ArrayList<GrievanceModelClass>grievanceModelClasses;
Context context;
GrievanceDataBase grievanceDataBase;

    public GrievanceDeleteAdapter(ArrayList<GrievanceModelClass> grievanceModelClasses, Context context) {
        this.grievanceModelClasses = grievanceModelClasses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grievancedelete_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        grievanceDataBase = new GrievanceDataBase(context);
        GrievanceModelClass grievanceModel = grievanceModelClasses.get(position);
        holder.hospital.setText(grievanceModel.getHospital());
        holder.name.setText(grievanceModel.getName());
        holder.phone.setText(grievanceModel.getPhone());
        holder.staff.setText(grievanceModel.getStaff());
        holder.grievance.setText(grievanceModel.getGrievance());

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
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("Are You Sure You Want To delete Confirmation...");
                builder.setIcon(R.drawable.edit);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       grievanceDataBase.GetDeleteGrievance(grievanceModel.getId());
                       grievanceModelClasses.remove(position);
                       notifyItemRemoved(position);
                       notifyItemRangeRemoved(position,grievanceModelClasses.size());
                       notifyDataSetChanged();
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
        return grievanceModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital,name,phone,staff,grievance;
        ImageView upImg,downImg,deleteImg;
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
            deleteImg = itemView.findViewById(R.id.deleteImg);

        }
    }
}
