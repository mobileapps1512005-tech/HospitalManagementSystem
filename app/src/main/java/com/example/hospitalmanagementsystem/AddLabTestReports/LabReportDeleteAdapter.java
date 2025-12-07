package com.example.hospitalmanagementsystem.AddLabTestReports;

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

import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorDataBase;
import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class LabReportDeleteAdapter extends RecyclerView.Adapter<LabReportDeleteAdapter.ViewHolder>{
ArrayList<LabModelClass> labModelClassArrayList;
Context context;
LadReportsDataBase ladReportsDataBase;

    public LabReportDeleteAdapter(ArrayList<LabModelClass> labModelClassArrayList, Context context) {
        this.labModelClassArrayList = labModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.labreportsdelete_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
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

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation....");
                builder.setMessage("Are You Sure You Want To Delete Conformation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ladReportsDataBase.GetDeleteLabDetail(modelClass.getId());
                        labModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeRemoved(position,labModelClassArrayList.size());
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
        ImageView upImg,downImg,delete;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            cost = itemView.findViewById(R.id.tvCost);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            delete = itemView.findViewById(R.id.deleteImg);

        }
    }
}
