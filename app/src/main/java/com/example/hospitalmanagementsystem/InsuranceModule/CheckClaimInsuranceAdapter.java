package com.example.hospitalmanagementsystem.InsuranceModule;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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


public class CheckClaimInsuranceAdapter extends RecyclerView.Adapter<CheckClaimInsuranceAdapter.ViewHolder>{
ArrayList<InsuranceModelClass> insuranceModelClassArrayList;
Context context;

    public CheckClaimInsuranceAdapter(ArrayList<InsuranceModelClass> insuranceModelClassArrayList, Context context) {
        this.insuranceModelClassArrayList = insuranceModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insurance_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       InsuranceModelClass modelClass = insuranceModelClassArrayList.get(position);
        holder.UpImg.setVisibility(View.GONE);
        holder.name.setText(modelClass.getName());
        holder.dob.setText(modelClass.getDob());
        holder.gender.setText(modelClass.getGender());
        holder.phone.setText(modelClass.getPhone());
        holder.email.setText(modelClass.getEmail());
        holder.aadhar.setText(modelClass.getAadhar());
        holder.policyNumber.setText(modelClass.getPolicyNumber());
        holder.selectCompany.setText(modelClass.getSelectCompany());
        holder.selectHospital.setText(modelClass.getSelectHospital());
        holder.date.setText(modelClass.getDate());
        holder.time.setText(modelClass.getTime());
        holder.nominee.setText(modelClass.getNominee());
        holder.hospital.setText(modelClass.getHospital());


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
                holder.UpImg.setVisibility(View.GONE);
                holder.DownImg.setVisibility(View.VISIBLE);
                holder.layout1.setVisibility(View.GONE);
            }
        });


        holder.Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+modelClass.getPhone()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return insuranceModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView name,dob,gender,phone,email,aadhar,policyNumber,selectCompany,selectHospital,date,time,nominee,hospital;
            ImageView UpImg,DownImg,Call;
            LinearLayout layout1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            dob = itemView.findViewById(R.id.tvDob);
            gender = itemView.findViewById(R.id.tvGender);
            phone = itemView.findViewById(R.id.tvPhone);
            email = itemView.findViewById(R.id.tvEmail);
            aadhar = itemView.findViewById(R.id.tvAadhaar);
            policyNumber = itemView.findViewById(R.id.tvPolicyNumber);
            selectCompany = itemView.findViewById(R.id.tvCompany);
            selectHospital = itemView.findViewById(R.id.tvSelectHospital);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
            nominee = itemView.findViewById(R.id.tvNominne);
            hospital = itemView.findViewById(R.id.tvHospital);
            UpImg = itemView.findViewById(R.id.UpImg);
            DownImg = itemView.findViewById(R.id.DownImg);
            Call = itemView.findViewById(R.id.callImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
