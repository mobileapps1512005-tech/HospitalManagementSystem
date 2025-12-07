package com.example.hospitalmanagementsystem.InsuranceModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class ClaimInsuranceAdapter extends RecyclerView.Adapter<ClaimInsuranceAdapter.ViewHolder>{
ArrayList<ModelClass> modelClassArrayList;
Context context;

    public ClaimInsuranceAdapter(ArrayList<ModelClass> modelClassArrayList, Context context) {
        this.modelClassArrayList = modelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_claim_insurence,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      ModelClass modelClass = modelClassArrayList.get(position);
      holder.TvName.setText(modelClass.getName());

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView TvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TvName = itemView.findViewById(R.id.TvName);
        }
    }
}
