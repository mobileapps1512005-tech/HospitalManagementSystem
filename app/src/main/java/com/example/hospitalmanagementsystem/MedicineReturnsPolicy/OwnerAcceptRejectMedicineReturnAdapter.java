package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

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


public class OwnerAcceptRejectMedicineReturnAdapter extends RecyclerView.Adapter<OwnerAcceptRejectMedicineReturnAdapter.ViewHolder>{
    ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList;
    Context context;

    public OwnerAcceptRejectMedicineReturnAdapter(ArrayList<MedicineReturnModelClass> medicineReturnModelClassArrayList, Context context) {
        this.medicineReturnModelClassArrayList = medicineReturnModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinereturnacceptreject_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicineReturnModelClass medicineReturnModelClass = medicineReturnModelClassArrayList.get(position);
        holder.name.setText(medicineReturnModelClass.getName());
        holder.condition.setText(medicineReturnModelClass.getCondition());
        holder.phone.setText(medicineReturnModelClass.getPhone());

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
            }
        });

        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Accept Confirmation...");
                builder.setMessage("Are You Sure You Want To Accept Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.medicinepreview);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, MedicineReturnAcceptActivity.class);
                        intent.putExtra("id",medicineReturnModelClass.getId());
                        intent.putExtra("name",medicineReturnModelClass.getName());
                        intent.putExtra("condition",medicineReturnModelClass.getCondition());
                        intent.putExtra("phone",medicineReturnModelClass.getPhone());
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

        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Reject Confirmation...");
                builder.setMessage("Are You Sure You Want To Reject Confirmation...");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.medicinepreview);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, MedicineReturnRejectActivity.class);
                        intent.putExtra("id",medicineReturnModelClass.getId());
                        intent.putExtra("name",medicineReturnModelClass.getName());
                        intent.putExtra("condition",medicineReturnModelClass.getCondition());
                        intent.putExtra("phone",medicineReturnModelClass.getPhone());
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
        return medicineReturnModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,condition,phone;
        ImageView upImg,downImg;
        Button confirm,cancel;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            condition = itemView.findViewById(R.id.tvCondition);
            phone = itemView.findViewById(R.id.tvPhone);
            downImg = itemView.findViewById(R.id.DownImg);
            upImg = itemView.findViewById(R.id.UpImg);
            layout1 = itemView.findViewById(R.id.layout1);
            confirm = itemView.findViewById(R.id.btnConfirm);
            cancel = itemView.findViewById(R.id.btnCancel);

        }
    }
}
