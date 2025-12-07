package com.example.hospitalmanagementsystem.AboutManage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.DoctorManageTask.DoctorDataBase;
import com.example.hospitalmanagementsystem.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder>{
ArrayList<AboutModelClass> aboutModelClassArrayList;
Context context;

    public AboutAdapter(ArrayList<AboutModelClass> aboutModelClassArrayList, Context context) {
        this.aboutModelClassArrayList = aboutModelClassArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.abotu_items,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AboutModelClass aboutModelClass = aboutModelClassArrayList.get(position);
        holder.name.setText(aboutModelClass.getName());
         holder.describe.setText(aboutModelClass.getDescription());
         holder.img.setImageResource(aboutModelClass.getImg());

        holder.upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.GONE);
                holder.downImg.setVisibility(View.VISIBLE);
                holder.upImg.setVisibility(View.GONE);

            }
        });

        holder.downImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout1.setVisibility(View.VISIBLE);
                holder.downImg.setVisibility(View.GONE);
                holder.upImg.setVisibility(View.VISIBLE);
            }
        });

         if ("GitHub Profile Click".equals(aboutModelClass.getName())){

             holder.cardRecyclerView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     AlertDialog.Builder builder = new AlertDialog.Builder(context);
                     builder.setTitle("Account Confirmation...");
                     builder.setMessage("Are You Sure Want To Visit GitHub...");
                     builder.setCancelable(false);
                     builder.setIcon(R.drawable.github);

                     builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                         }
                     });

                     builder.setNegativeButton("Account 2", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                             Intent intent = new Intent(Intent.ACTION_VIEW);
                             intent.setData(Uri.parse("https://github.com/vivekjaiswal99"));
                             context.startActivity(intent);
                         }
                     });

                     builder.setPositiveButton("Account 1", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                             Intent intent = new Intent(Intent.ACTION_VIEW);
                             intent.setData(Uri.parse("https://github.com/vivekjaiswal1515"));
                             context.startActivity(intent);
                         }
                     });
                     builder.show();
                 }
             });


         } else if ("LinkedIn Profile Click".equals(aboutModelClass.getName())) {
             holder.cardRecyclerView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(Intent.ACTION_VIEW);
                     intent.setData(Uri.parse("https://www.linkedin.com/in/vivek-jaiswal-7947a0268?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"));
                     context.startActivity(intent);
                 }
             });

         } else if ("Resume Check".equals(aboutModelClass.getName())){
             holder.cardRecyclerView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    context.startActivity(new Intent(context, ResumeActivity.class));
                 }
             });
         }else {
             holder.cardRecyclerView.setOnClickListener(null);
         }

    }

    @Override
    public int getItemCount() {
        return aboutModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView name,describe;
            ImageView upImg,downImg,img;
            LinearLayout layout1;
            MaterialCardView cardRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            describe = itemView.findViewById(R.id.tvDescribe);
            upImg = itemView.findViewById(R.id.UpImg);
            img = itemView.findViewById(R.id.img);
            downImg = itemView.findViewById(R.id.DownImg);
            layout1 = itemView.findViewById(R.id.layout1);
            cardRecyclerView = itemView.findViewById(R.id.cardRecyclerView);

        }
    }
}
