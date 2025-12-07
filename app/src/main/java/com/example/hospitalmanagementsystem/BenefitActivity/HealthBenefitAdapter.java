package com.example.hospitalmanagementsystem.BenefitActivity;

import android.content.Context;
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

public class HealthBenefitAdapter extends RecyclerView.Adapter<HealthBenefitAdapter.ViewHolder>{
ArrayList<BenefitModelClass> benefitModelClassArrayList;
Context context;

    public HealthBenefitAdapter(ArrayList<BenefitModelClass> benefitModelClassArrayList, Context context) {
        this.benefitModelClassArrayList = benefitModelClassArrayList;
        this.context = context;
    }

    public void SetFilterLists(ArrayList<BenefitModelClass> Filter){
        this.benefitModelClassArrayList=Filter;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.benefit_itemss,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    BenefitModelClass benefitModelClass = benefitModelClassArrayList.get(position);
     holder.name.setText(benefitModelClass.getName());
     holder.reason.setText(benefitModelClass.getReason());

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
            }
        });

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return benefitModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
           TextView name,reason;
           ImageView upImg,downImg;
           LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            reason = itemView.findViewById(R.id.tvTips);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);


        }
    }
}
