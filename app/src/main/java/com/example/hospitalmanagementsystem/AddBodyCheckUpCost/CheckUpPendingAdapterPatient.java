package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

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

public class CheckUpPendingAdapterPatient extends RecyclerView.Adapter<CheckUpPendingAdapterPatient.ViewHolder>{
ArrayList<CheckupModelClass> checkupModelClassArrayList;
Context context;

    public CheckUpPendingAdapterPatient(ArrayList<CheckupModelClass> checkupModelClassArrayList, Context context) {
        this.checkupModelClassArrayList = checkupModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkpateintpendingappointment_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CheckupModelClass checkupModelClass = checkupModelClassArrayList.get(position);
        holder.name.setText(checkupModelClass.getName());
        holder.part.setText(checkupModelClass.getPart());
        holder.price.setText(checkupModelClass.getPrice());
        holder.discount.setText(checkupModelClass.getDiscount());
        holder.phone.setText(checkupModelClass.getPhone());
        holder.upImg.setVisibility(View.GONE);

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
    }

    @Override
    public int getItemCount() {
        return checkupModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,price,phone,discount;
        ImageView upImg,downImg,bookingImg;
        LinearLayout layout1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            price = itemView.findViewById(R.id.tvCost);
            discount = itemView.findViewById(R.id.tvDiscount);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            bookingImg = itemView.findViewById(R.id.bookingImg);
            layout1 = itemView.findViewById(R.id.layout1);
        }
    }
}
