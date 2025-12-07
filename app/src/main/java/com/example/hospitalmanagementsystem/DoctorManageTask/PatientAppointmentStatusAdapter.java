package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.tv.ad.TvAdView;
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

public class PatientAppointmentStatusAdapter extends RecyclerView.Adapter<PatientAppointmentStatusAdapter.ViewHolder>{
ArrayList<PatientModelClassAppointment> patientModelClassAppointmentArrayList;
Context context;
DoctorAppointmentDataBase appointmentDataBase;


    public PatientAppointmentStatusAdapter(ArrayList<PatientModelClassAppointment> patientModelClassAppointmentArrayList, Context context) {
        this.patientModelClassAppointmentArrayList = patientModelClassAppointmentArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointmentbook_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        appointmentDataBase = new DoctorAppointmentDataBase(context);
        PatientModelClassAppointment appointment = patientModelClassAppointmentArrayList.get(position);
        holder.tvName.setText(appointment.getName());
        holder.tvEmail.setText(appointment.getEmail());
        holder.AvailableDay.setText(appointment.getDay());
        holder.AvailableTime.setText(appointment.getTime());
        holder.Phone.setText(appointment.getPhone());
        holder.UpImg.setVisibility(View.GONE);

        holder.DownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.UpImg.setVisibility(View.VISIBLE);
                holder.DownImg.setVisibility(View.GONE);
            }
        });

        holder.UpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.UpImg.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
            }
        });

        holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Appointment Confirmation...");
                builder.setMessage("Are You Sure You Want To Confirm Appointment...");
                builder.setIcon(R.drawable.outline_book_2_24);
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, AppointmentConfirmActivity.class);
                        intent.putExtra("id",appointment.getId());
                        intent.putExtra("name",appointment.getName());
                        intent.putExtra("email",appointment.getEmail());
                        intent.putExtra("day",appointment.getDay());
                        intent.putExtra("time",appointment.getTime());
                        intent.putExtra("phone",appointment.getPhone());
                        context.startActivity(intent);
                    }
                });
                builder.setNeutralButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
             builder.show();
            }
        });

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Appointment Confirmation...");
                builder.setMessage("Are You Sure You Want To Cancel Appointment...");
                builder.setIcon(R.drawable.outline_book_2_24);
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, DrCancelAppointmentActivity.class);
                        intent.putExtra("id",appointment.getId());
                        intent.putExtra("name",appointment.getName());
                        intent.putExtra("email",appointment.getEmail());
                        intent.putExtra("day",appointment.getDay());
                        intent.putExtra("time",appointment.getTime());
                        intent.putExtra("phone",appointment.getPhone());
                        context.startActivity(intent);
                    }
                });

                builder.setNeutralButton("No", new DialogInterface.OnClickListener() {
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
        return patientModelClassAppointmentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
             TextView tvName,tvEmail,AvailableDay,AvailableTime,Phone;
             ImageView UpImg,DownImg,callImg;
             Button btnConfirm,btnCancel;
             LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            AvailableDay = itemView.findViewById(R.id.tvAvailableDay);
            AvailableTime = itemView.findViewById(R.id.tvAvailableTime);
            Phone = itemView.findViewById(R.id.tvPhone);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            callImg = itemView.findViewById(R.id.callImg);
            btnConfirm = itemView.findViewById(R.id.btnConfirm);
            btnCancel = itemView.findViewById(R.id.btnCancel);
            layout1 = itemView.findViewById(R.id.layout1);



        }
    }
}
