package com.example.hospitalmanagementsystem.PatientBillings;

import android.content.Context;
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

public class BillingUpdateAdapter extends RecyclerView.Adapter<BillingUpdateAdapter.ViewHolder>{
ArrayList<BillingModelClass>billingModelClassArrayList;
Context context;

    public BillingUpdateAdapter(ArrayList<BillingModelClass> billingModelClassArrayList, Context context) {
        this.billingModelClassArrayList = billingModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.billingupdate_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BillingModelClass billingModelClass = billingModelClassArrayList.get(position);
        holder.hospital.setText(billingModelClass.getHospital());
        holder.name.setText(billingModelClass.getName());
        holder.email.setText(billingModelClass.getEmail());
        holder.phone.setText(billingModelClass.getPhone());
        holder.typeBill.setText(billingModelClass.getTypeBill());
        holder.typeDiscount.setText(billingModelClass.getTypeDiscount());
        holder.cost.setText(billingModelClass.getCost());
        holder.date.setText(billingModelClass.getDate());
        holder.time.setText(billingModelClass.getTime());

        holder.dowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dowImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dowImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
            }
        });

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateBillingActivity.class);
                intent.putExtra("id",billingModelClass.getId());
                intent.putExtra("hospital",billingModelClass.getHospital());
                intent.putExtra("name",billingModelClass.getName());
                intent.putExtra("email",billingModelClass.getEmail());
                intent.putExtra("phone",billingModelClass.getPhone());
                intent.putExtra("bill",billingModelClass.getTypeBill());
                intent.putExtra("cost",billingModelClass.getCost());
                intent.putExtra("discount",billingModelClass.getTypeDiscount());
                intent.putExtra("date",billingModelClass.getDate());
                intent.putExtra("time",billingModelClass.getTime());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return billingModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital,name,email,phone,typeBill,typeDiscount,cost,date,time;
        ImageView upImg,dowImg,update;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospital = itemView.findViewById(R.id.tvHospital);
            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            typeBill = itemView.findViewById(R.id.tvBill);
            typeDiscount = itemView.findViewById(R.id.tvDiscount);
            cost = itemView.findViewById(R.id.tvCost);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
            upImg = itemView.findViewById(R.id.UpImg);
            dowImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            update = itemView.findViewById(R.id.updateImg);


        }
    }
}
