package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class CheckPatientCallAdapter extends RecyclerView.Adapter<CheckPatientCallAdapter.ViewHolder>{
ArrayList<CheckupModelClass> checkupModelClassArrayList;
Context context;
public static final int RequestCode=1001;
    public CheckPatientCallAdapter(ArrayList<CheckupModelClass> checkupModelClassArrayList, Context context) {
        this.checkupModelClassArrayList = checkupModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkupcallpatient_items,parent,false);
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
        String UniqueId = String.valueOf(checkupModelClass.getId());


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
                }else {
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},RequestCode);
                }
            }
        });

        SharedPreferences sharedPreferences = context.getSharedPreferences("Checkup",MODE_PRIVATE);
        boolean IsAvail = sharedPreferences.getBoolean(UniqueId,false);

        if (IsAvail){
            holder.status.setText("Call Permission Allow");
            holder.status.setTextColor(Color.GREEN);
            holder.call.setVisibility(View.VISIBLE);
        }else {
            holder.status.setText("Call Permission Not Allow");
            holder.status.setTextColor(Color.RED);
            holder.call.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return checkupModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,price,phone,discount,status;
        ImageView upImg,downImg,updateImg,call;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            price = itemView.findViewById(R.id.tvCost);
            phone = itemView.findViewById(R.id.tvPhone);
            discount = itemView.findViewById(R.id.tvDiscount);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            updateImg = itemView.findViewById(R.id.updateImg);
            layout1 = itemView.findViewById(R.id.layout1);
            status = itemView.findViewById(R.id.tvStatus);
            call = itemView.findViewById(R.id.callImg);


        }
    }
}
