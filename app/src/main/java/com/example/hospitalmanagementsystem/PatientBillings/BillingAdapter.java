package com.example.hospitalmanagementsystem.PatientBillings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class BillingAdapter extends RecyclerView.Adapter<BillingAdapter.ViewHolder>{
ArrayList<BillingModelClass> billingModelClassArrayList;
Context context;

    public BillingAdapter(ArrayList<BillingModelClass> billingModelClassArrayList, Context context) {
        this.billingModelClassArrayList = billingModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.billing_items,parent,false);
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

    }

    @Override
    public int getItemCount() {
        return billingModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
              TextView hospital,name,email,phone,typeBill,typeDiscount,cost,date,time;

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

        }
    }
}
