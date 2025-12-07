package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.content.Context;
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

public class DeliveryMedicineStatusAdapter extends RecyclerView.Adapter<DeliveryMedicineStatusAdapter.ViewHolder>{
ArrayList<MedicineStatusModelClass> medicineStatusModelClassArrayList;
Context context;

    public DeliveryMedicineStatusAdapter(ArrayList<MedicineStatusModelClass> medicineStatusModelClassArrayList, Context context) {
        this.medicineStatusModelClassArrayList = medicineStatusModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliveryboychechdeliverystatus,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     MedicineStatusModelClass medicineStatusModelClass = medicineStatusModelClassArrayList.get(position);
        holder.name.setText(medicineStatusModelClass.getName());
        holder.email.setText(medicineStatusModelClass.getEmail());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return medicineStatusModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView name,email;
            ImageView UpImg,DownImg;
            LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
