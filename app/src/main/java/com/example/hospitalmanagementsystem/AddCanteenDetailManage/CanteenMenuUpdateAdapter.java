package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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

public class CanteenMenuUpdateAdapter extends RecyclerView.Adapter<CanteenMenuUpdateAdapter.ViewHolder>{
ArrayList<CanteenModelClass> canteenModelClassArrayList;
Context context;

    public CanteenMenuUpdateAdapter(ArrayList<CanteenModelClass> canteenModelClassArrayList, Context context) {
        this.canteenModelClassArrayList = canteenModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.canteenupdate_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       CanteenModelClass canteenModelClass = canteenModelClassArrayList.get(position);
        holder.menu.setText(canteenModelClass.getMenu());
        holder.half.setText(canteenModelClass.getHalf());
        holder.halfPrice.setText(canteenModelClass.getHalfPrice());
        holder.fullPlate.setText(canteenModelClass.getFullPlate());
        holder.fullPrice.setText(canteenModelClass.getFullPrice());
        holder.discount.setText(canteenModelClass.getDiscount());
        holder.combo.setText(canteenModelClass.getCombo());
        holder.phone.setText(canteenModelClass.getPhone());


        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.GONE);
            }
        });

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CanteenMenuUpdateActivity.class);
                intent.putExtra("id",canteenModelClass.getId());
                intent.putExtra("menu",canteenModelClass.getMenu());
                intent.putExtra("half",canteenModelClass.getHalf());
                intent.putExtra("halfPrice",canteenModelClass.getHalfPrice());
                intent.putExtra("fully",canteenModelClass.getFullPlate());
                intent.putExtra("fullyPrice",canteenModelClass.getFullPrice());
                intent.putExtra("discount",canteenModelClass.getDiscount());
                intent.putExtra("combo",canteenModelClass.getCombo());
                intent.putExtra("phone",canteenModelClass.getPhone());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return canteenModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
          TextView  menu,half,halfPrice,fullPlate,fullPrice,discount,combo,phone;
          ImageView upImg,downImg,update;
          LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            menu = itemView.findViewById(R.id.tvMenu);
            half = itemView.findViewById(R.id.tvHalf);
            halfPrice = itemView.findViewById(R.id.tvHalfPrice);
            fullPlate = itemView.findViewById(R.id.tvFull);
            fullPrice = itemView.findViewById(R.id.tvFullPrice);
            discount = itemView.findViewById(R.id.tvDiscount);
            combo = itemView.findViewById(R.id.tvCombo);
            phone = itemView.findViewById(R.id.tvPhone);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            update = itemView.findViewById(R.id.updateImg);

        }
    }
}
