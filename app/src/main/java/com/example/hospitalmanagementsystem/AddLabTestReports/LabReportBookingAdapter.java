package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.content.Context;
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

public class LabReportBookingAdapter extends RecyclerView.Adapter<LabReportBookingAdapter.ViewHolder>{
ArrayList<LabModelClass> labModelClassArrayList;
Context context;

    public LabReportBookingAdapter(ArrayList<LabModelClass> labModelClassArrayList, Context context) {
        this.labModelClassArrayList = labModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.labreturnbookings_items,parent,false);
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

        holder.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LabAppointmentBookingActivity.class);
                intent.putExtra("name",modelClass.getName());
                intent.putExtra("part",modelClass.getPart());
                intent.putExtra("cost",modelClass.getCost());
                intent.putExtra("phone",modelClass.getPhone());
                context.startActivity(intent);
            }
        });

        holder.btnCheckReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              context.startActivity(new Intent(context, CheckLabReportsActivity.class));
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
        Button btnCheckReport;

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
            btnCheckReport = itemView.findViewById(R.id.btnCheckReport);

        }
    }
}
