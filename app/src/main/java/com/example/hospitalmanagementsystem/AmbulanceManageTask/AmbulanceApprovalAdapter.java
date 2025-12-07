package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.annotation.SuppressLint;
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

public class AmbulanceApprovalAdapter extends RecyclerView.Adapter<AmbulanceApprovalAdapter.ViewHolder>{
ArrayList<AmbulanceBookingModelClass> ambulanceBookingModelClassArrayList;
Context context;

    public AmbulanceApprovalAdapter(ArrayList<AmbulanceBookingModelClass> ambulanceBookingModelClassArrayList,Context context) {
        this.ambulanceBookingModelClassArrayList = ambulanceBookingModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ambulancebookapproval_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AmbulanceBookingModelClass bookingModelClass = ambulanceBookingModelClassArrayList.get(position);
        holder.name.setText(bookingModelClass.getName());
        holder.email.setText(bookingModelClass.getEmail());
        holder.phone.setText(bookingModelClass.getPhone());
        holder.alter.setText(bookingModelClass.getAlters());
        holder.location.setText(bookingModelClass.getLocation());
        holder.ambulance.setText(bookingModelClass.getAmbulance());
        holder.upImg.setVisibility(View.GONE);

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
            }
        });

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
            }
        });

        holder.BtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Approval Confirmation....");
                builder.setMessage("Are You Sure You Want To Approval Confirmation....");
                builder.setIcon(R.drawable.ambulancess);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, AmbulanceApprovalAmbulanceActivity.class);
                        intent.putExtra("id",bookingModelClass.getId());
                        intent.putExtra("name",bookingModelClass.getName());
                        intent.putExtra("email",bookingModelClass.getEmail());
                        intent.putExtra("phone",bookingModelClass.getPhone());
                        intent.putExtra("alter",bookingModelClass.getAlters());
                        intent.putExtra("location",bookingModelClass.getLocation());
                        intent.putExtra("ambulance",bookingModelClass.getAmbulance());
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

        holder.BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Cancel Confirmation....");
                builder.setMessage("Are You Sure You Want To Cancel Confirmation....");
                builder.setIcon(R.drawable.ambulancess);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, AmbulanceCancelActivity.class);
                        intent.putExtra("id",bookingModelClass.getId());
                        intent.putExtra("name",bookingModelClass.getName());
                        intent.putExtra("email",bookingModelClass.getEmail());
                        intent.putExtra("phone",bookingModelClass.getPhone());
                        intent.putExtra("alter",bookingModelClass.getAlters());
                        intent.putExtra("location",bookingModelClass.getLocation());
                        intent.putExtra("ambulance",bookingModelClass.getAmbulance());
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
        return ambulanceBookingModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,alter,location,ambulance;
        ImageView upImg,downImg;
        Button BtnConfirm,BtnCancel;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            alter = itemView.findViewById(R.id.tvAlter);
            location = itemView.findViewById(R.id.tvLocation);
            ambulance = itemView.findViewById(R.id.tvAmbulance);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            BtnConfirm = itemView.findViewById(R.id.btnConfirm);
            BtnCancel = itemView.findViewById(R.id.btnCancel);


        }
    }
}
