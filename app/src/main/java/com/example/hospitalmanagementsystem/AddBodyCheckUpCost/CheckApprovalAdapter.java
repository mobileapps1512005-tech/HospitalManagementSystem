package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class CheckApprovalAdapter extends RecyclerView.Adapter<CheckApprovalAdapter.ViewHolder>{
ArrayList<CheckupModelClass> checkupModelClassArrayList;
Context context;
public static final int RequestCode=1001;

    public CheckApprovalAdapter(ArrayList<CheckupModelClass> checkupModelClassArrayList, Context context) {
        this.checkupModelClassArrayList = checkupModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkapprovalonly_items,parent,false);
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

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+checkupModelClass.getPhone()));
                    context.startActivity(intent);
                }else {
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},RequestCode);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return checkupModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,price,phone,discount;
        ImageView upImg,downImg,bookingImg,call;
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
            call = itemView.findViewById(R.id.callImg);


        }
    }
}
