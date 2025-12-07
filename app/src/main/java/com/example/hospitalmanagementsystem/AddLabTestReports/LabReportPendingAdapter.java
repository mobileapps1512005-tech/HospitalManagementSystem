package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class LabReportPendingAdapter extends RecyclerView.Adapter<LabReportPendingAdapter.ViewHolder>{
ArrayList<LabModelClass> labModelClassArrayList;
Context context;

    public LabReportPendingAdapter(ArrayList<LabModelClass> labModelClassArrayList, Context context) {
        this.labModelClassArrayList = labModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.labreportacceptreject_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LabModelClass modelClass = labModelClassArrayList.get(position);
        holder.name.setText(modelClass.getName());
        holder.part.setText(modelClass.getPart());
        holder.cost.setText(modelClass.getCost());
        holder.phone.setText(modelClass.getPhone());

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

        holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Accept Confirmation....");
                builder.setMessage("Are You Sure You Want To Accept Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, OnlyAcceptLabReportActivity.class);
                        intent.putExtra("id",modelClass.getId());
                        intent.putExtra("name",modelClass.getName());
                        intent.putExtra("part",modelClass.getPart());
                        intent.putExtra("cost",modelClass.getCost());
                        intent.putExtra("phone",modelClass.getPhone());
                        context.startActivity(intent);
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

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Reject Confirmation....");
                builder.setMessage("Are You Sure You Want To Reject Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, OnlyLabReportRejectActivity.class);
                        intent.putExtra("id",modelClass.getId());
                        intent.putExtra("name",modelClass.getName());
                        intent.putExtra("part",modelClass.getPart());
                        intent.putExtra("cost",modelClass.getCost());
                        intent.putExtra("phone",modelClass.getPhone());
                        context.startActivity(intent);
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
        return labModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,cost,phone;
        ImageView upImg,downImg,booking;
        LinearLayout layout1;
        Button btnConfirm,btnCancel;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            cost = itemView.findViewById(R.id.tvCost);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            booking = itemView.findViewById(R.id.bookingImg);
            btnCancel = itemView.findViewById(R.id.btnCancel);
            btnConfirm = itemView.findViewById(R.id.btnConfirm);

            
        }
    }
}
