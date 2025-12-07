package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class CanteenCallPermissionForPatientAdapter extends RecyclerView.Adapter<CanteenCallPermissionForPatientAdapter.ViewHolder>{
ArrayList<CanteenModelClass> canteenModelClassArrayList;
Context context;
public static final int Request=10001;

    public CanteenCallPermissionForPatientAdapter(ArrayList<CanteenModelClass> canteenModelClassArrayList, Context context) {
        this.canteenModelClassArrayList = canteenModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientcallcanteen_items,parent,false);
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
        String uniqueKey = String.valueOf(canteenModelClass.getId());


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

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+canteenModelClass.getPhone()));
                    context.startActivity(intent);
                }else {
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},Request);
                }
            }
        });

        SharedPreferences sharedPreferences = context.getSharedPreferences("canteenCall",MODE_PRIVATE);
        boolean isAvail = sharedPreferences.getBoolean(uniqueKey,false);

        if (isAvail){
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
        return canteenModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView menu,half,halfPrice,fullPlate,fullPrice,discount,combo,phone,status,tvFoodStatus;
        ImageView upImg,downImg,call;
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
            status = itemView.findViewById(R.id.status);
            call = itemView.findViewById(R.id.callImg);

        }
    }
}
