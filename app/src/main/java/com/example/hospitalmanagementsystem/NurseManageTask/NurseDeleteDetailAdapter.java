package com.example.hospitalmanagementsystem.NurseManageTask;

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

public class NurseDeleteDetailAdapter extends RecyclerView.Adapter<NurseDeleteDetailAdapter.ViewHolder>{
ArrayList<NurseModelClass> nurseModelClassArrayList;
Context context;
NurseDataBase nurseDataBase;
    public NurseDeleteDetailAdapter(ArrayList<NurseModelClass> nurseModelClassArrayList, Context context) {
        this.nurseModelClassArrayList = nurseModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deletenursedetail_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        nurseDataBase = new NurseDataBase(context);
        NurseModelClass nurseModelClass = nurseModelClassArrayList.get(position);
        holder.UpImg.setVisibility(View.GONE);
        holder.name.setText(nurseModelClass.getName());
        holder.email.setText(nurseModelClass.getEmail());
        holder.qualification.setText(nurseModelClass.getQualification());
        holder.experience.setText(nurseModelClass.getExperience());
        holder.gender.setText(nurseModelClass.getGender());
        holder.location.setText(nurseModelClass.getLocation());
        holder.phones.setText(nurseModelClass.getPhone());

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.GONE);
                holder.layout1.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
            }
        });

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
            }
        });

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("Are You Sure Yoy Want To Delete Confirmation....");
                builder.setIcon(R.drawable.delbin);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nurseDataBase.GetDeleteNurseDetails(nurseModelClass.getId());
                        nurseModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,nurseModelClassArrayList.size());
                        notifyDataSetChanged();
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
        return nurseModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,qualification,experience,phones,gender,location;
        ImageView UpImg,DownImg,deleteImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            qualification = itemView.findViewById(R.id.tvQualification);
            experience = itemView.findViewById(R.id.tvExperience);
            gender = itemView.findViewById(R.id.tvGender);
            location = itemView.findViewById(R.id.tvLocation);
            phones = itemView.findViewById(R.id.tvPhones);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            deleteImg = itemView.findViewById(R.id.deleteImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
