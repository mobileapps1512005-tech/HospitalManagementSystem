package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

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

public class CheckUpDeleteAdapter extends RecyclerView.Adapter<CheckUpDeleteAdapter.ViewHolder>{
ArrayList<CheckupModelClass> checkupModelClassArrayList;
Context context;
CheckupBodyDataBase checkupBodyDataBase;

    public CheckUpDeleteAdapter(ArrayList<CheckupModelClass> checkupModelClassArrayList, Context context) {
        this.checkupModelClassArrayList = checkupModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkupdelete_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        checkupBodyDataBase = new CheckupBodyDataBase(context);
        CheckupModelClass checkupModelClass = checkupModelClassArrayList.get(position);
        holder.name.setText(checkupModelClass.getName());
        holder.part.setText(checkupModelClass.getPart());
        holder.price.setText(checkupModelClass.getPrice());
        holder.discount.setText(checkupModelClass.getDiscount());
        holder.phone.setText(checkupModelClass.getPhone());
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

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Confirmation...");
                builder.setMessage("Are You Sure You Want To Delete Confirmation...");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkupBodyDataBase.GetDeleteCheckDelete(checkupModelClass.getId());
                        checkupModelClassArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeRemoved(position,checkupModelClassArrayList.size());
                        notifyDataSetChanged();
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
        return checkupModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,part,price,phone,discount;
        ImageView upImg,downImg,deleteImg;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            part = itemView.findViewById(R.id.tvPart);
            price = itemView.findViewById(R.id.tvCost);
            phone = itemView.findViewById(R.id.tvPhone);
            discount = itemView.findViewById(R.id.tvDiscount);
            upImg = itemView.findViewById(R.id.UpImg);
            downImg = itemView.findViewById(R.id.DownImg);
            deleteImg = itemView.findViewById(R.id.deleteImg);
            layout1 = itemView.findViewById(R.id.layout1);

        }
    }
}
