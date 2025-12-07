package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class OwnerAcceptRejectMedicineOrderAdapter extends RecyclerView.Adapter<OwnerAcceptRejectMedicineOrderAdapter.ViewHolder>{
ArrayList<MedicineModelClass> medicineModelClassArrayList;
Context context;

    public OwnerAcceptRejectMedicineOrderAdapter(ArrayList<MedicineModelClass> medicineModelClassArrayList, Context context) {
        this.medicineModelClassArrayList = medicineModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicineacceptrejectowner_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicineModelClass modelClass = medicineModelClassArrayList.get(position);
        holder.name.setText(modelClass.getName());
        holder.email.setText(modelClass.getEmail());
        holder.phone.setText(modelClass.getPhone());
        holder.location.setText(modelClass.getLocation());
        holder.deliveryLocation.setText(modelClass.getDeliveryLocation());
        holder.medicineName.setText(modelClass.getMedicineName());
        holder.order.setText(modelClass.getOrder());
        holder.requiredDate.setText(modelClass.getRequiredDate());
        holder.requiredTime.setText(modelClass.getRequiredTime());
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

        holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Accept Confirmation....");
                builder.setMessage("Are You Sure You Want To Accept Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, AcceptOrderRequestActivity.class);
                        intent.putExtra("id",modelClass.getId());
                        intent.putExtra("name",modelClass.getName());
                        intent.putExtra("email",modelClass.getEmail());
                        intent.putExtra("phone",modelClass.getPhone());
                        intent.putExtra("location",modelClass.getLocation());
                        intent.putExtra("deliverLocation",modelClass.getDeliveryLocation());
                        intent.putExtra("medicineName",modelClass.getMedicineName());
                        intent.putExtra("order",modelClass.getOrder());
                        intent.putExtra("Date",modelClass.getRequiredDate());
                        intent.putExtra("Time",modelClass.getRequiredTime());
                        context.startActivity(intent);
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

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Reject Confirmation....");
                builder.setMessage("Are You Sure You Want To Reject Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.delbin);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, OnlyRejectMedicineOrderActivity.class);
                        intent.putExtra("id",modelClass.getId());
                        intent.putExtra("name",modelClass.getName());
                        intent.putExtra("email",modelClass.getEmail());
                        intent.putExtra("phone",modelClass.getPhone());
                        intent.putExtra("location",modelClass.getLocation());
                        intent.putExtra("deliverLocation",modelClass.getDeliveryLocation());
                        intent.putExtra("medicineName",modelClass.getMedicineName());
                        intent.putExtra("order",modelClass.getOrder());
                        intent.putExtra("Date",modelClass.getRequiredDate());
                        intent.putExtra("Time",modelClass.getRequiredTime());
                        context.startActivity(intent);
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
        return medicineModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,location,deliveryLocation,medicineName,order,requiredDate,requiredTime;
        LinearLayout layout1;
        ImageView upImg,downImg;
        Button btnConfirm,btnCancel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            location = itemView.findViewById(R.id.tvLocation);
            deliveryLocation = itemView.findViewById(R.id.tvDelivery);
            medicineName = itemView.findViewById(R.id.tvMedicine);
            order = itemView.findViewById(R.id.tvBookDate);
            requiredDate = itemView.findViewById(R.id.tvrequiredDate);
            requiredTime = itemView.findViewById(R.id.tvrequiredTime);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            btnConfirm = itemView.findViewById(R.id.btnConfirm);
            btnCancel = itemView.findViewById(R.id.btnCancel);
            layout1 = itemView.findViewById(R.id.layout1);


        }
    }
}
