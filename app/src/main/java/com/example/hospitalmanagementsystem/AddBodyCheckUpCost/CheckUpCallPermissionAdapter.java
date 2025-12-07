package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class CheckUpCallPermissionAdapter extends RecyclerView.Adapter<CheckUpCallPermissionAdapter.ViewHolder>{
ArrayList<CheckupModelClass> checkupModelClassArrayList;
Context context;

    public CheckUpCallPermissionAdapter(ArrayList<CheckupModelClass> checkupModelClassArrayList, Context context) {
        this.checkupModelClassArrayList = checkupModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkupcallpermission_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CheckupModelClass checkupModelClass = checkupModelClassArrayList.get(position);
        holder.name.setText(checkupModelClass.getName());
        holder.part.setText(checkupModelClass.getPart());
        holder.price.setText(checkupModelClass.getPrice());
        holder.discount.setText(checkupModelClass.getDiscount());
        holder.phone.setText(checkupModelClass.getPhone());
        holder.upImg.setVisibility(View.GONE);
        String UniqueId = String.valueOf(checkupModelClass.getId());

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

        SharedPreferences sharedPreferences = context.getSharedPreferences("Checkup",MODE_PRIVATE);
        boolean IsAvail = sharedPreferences.getBoolean(UniqueId,false);

        holder.aSwitch.setOnCheckedChangeListener(null);
        holder.aSwitch.setChecked(IsAvail);

        if(IsAvail){
            holder.status.setText("Call Permission Allow");
            holder.status.setTextColor(Color.GREEN);
        }else {
            holder.status.setText("Call Permission Not Allow");
            holder.status.setTextColor(Color.RED);
        }

         holder.aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putBoolean(UniqueId,isChecked);
         editor.apply();

            if(isChecked){
                holder.status.setText("Call Permission Allow");
                holder.status.setTextColor(Color.GREEN);
            }else {
                holder.status.setText("Call Permission Not Allow");
                holder.status.setTextColor(Color.RED);
            }

        });

    }

    @Override
    public int getItemCount() {
        return checkupModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,price,phone,discount,status;
        ImageView upImg,downImg,updateImg;
        LinearLayout layout1;
        Switch aSwitch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            price = itemView.findViewById(R.id.tvCost);
            phone = itemView.findViewById(R.id.tvPhone);
            discount = itemView.findViewById(R.id.tvDiscount);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            updateImg = itemView.findViewById(R.id.updateImg);
            layout1 = itemView.findViewById(R.id.layout1);
            aSwitch = itemView.findViewById(R.id.Switche);
            status = itemView.findViewById(R.id.tvStatus);


        }
    }
}
