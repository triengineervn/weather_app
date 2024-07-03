package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domains.Future;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewHolder> {
    ArrayList<Future> items;
    Context context;

    public FutureAdapter(ArrayList<Future> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FutureAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflare = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_future, parent, false);
        context = parent.getContext();
        return new viewHolder(inflare);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.viewHolder holder, int position) {
        holder.dayTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.highTxt.setText(items.get(position).getHighTemp()+ "°");
        holder.lowTxt.setText(items.get(position).getLowTemp() + "°");


        int drawableResourseId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context).load(drawableResourseId).into(holder.picPath);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView dayTxt, statusTxt, highTxt, lowTxt;
        ImageView picPath;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            picPath = itemView.findViewById(R.id.picPath);
            dayTxt = itemView.findViewById(R.id.dayTxt);
            statusTxt = itemView.findViewById(R.id.statusTxt);
            highTxt = itemView.findViewById(R.id.highTxt);
            lowTxt = itemView.findViewById(R.id.lowTxt);
        }
    }
}
