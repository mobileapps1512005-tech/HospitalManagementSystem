package com.example.hospitalmanagementsystem.HospitalManageTask;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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


public class HospitalDeleteAdapter extends RecyclerView.Adapter<HospitalDeleteAdapter.ViewHolder>{
ArrayList<HospitalModelClass> hospitalModelClassArrayList;
Context context;
HospitalDataBase hospitalDataBase;

    public HospitalDeleteAdapter(ArrayList<HospitalModelClass> hospitalModelClassArrayList, Context context) {
        this.hospitalModelClassArrayList = hospitalModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospitaldelete_itmes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        HospitalModelClass hospitalModelClass = hospitalModelClassArrayList.get(position);
        holder.name.setText(hospitalModelClass.getName());
        holder.email.setText(hospitalModelClass.getEmail());
        holder.year.setText(hospitalModelClass.getYear());
        holder.location.setText(hospitalModelClass.getLocation());
        holder.phone.setText(hospitalModelClass.getPhone());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.DownImg.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.VISIBLE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.GONE);
            }
        });

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("You Are Sure You Want To Delete Details...");
                builder.setIcon(R.drawable.aarogyamgrremovebgpreview);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hospitalDataBase = new HospitalDataBase(context);
                        hospitalDataBase.GetDeleteHospitalDetails(hospitalModelClass.getId());
                        hospitalModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeRemoved(position,hospitalModelClassArrayList.size());
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return hospitalModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
             TextView name,email,year,location,phone;
             ImageView UpImg,DownImg,deleteImg;
             LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            year = itemView.findViewById(R.id.tvEstablished);
            location = itemView.findViewById(R.id.tvLocation);
            phone = itemView.findViewById(R.id.tvPhone);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            deleteImg = itemView.findViewById(R.id.deleteImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
