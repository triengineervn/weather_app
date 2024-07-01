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
import com.example.myapplication.Domains.Hourly;
import com.example.myapplication.R;

import java.util.ArrayList;

public class HourlyAdapter  extends RecyclerView.Adapter<HourlyAdapter.viewHolder> {
    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HourlyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflare = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly, parent, false);
        context = parent.getContext();
        return new viewHolder(inflare);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.viewHolder holder, int position) {
        holder.hourlyTxt.setText(items.get(position).getHour());
        holder.tempTxt.setText(items.get(position).getTemp()+"°C");

        int drawableResourseId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context).load(drawableResourseId).into(holder.picImg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView hourlyTxt, tempTxt;
        ImageView picImg;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            hourlyTxt = itemView.findViewById(R.id.hourTxt);
            tempTxt = itemView.findViewById(R.id.tempTxt);
            picImg = itemView.findViewById(R.id.picImg);
        }
    }
}
