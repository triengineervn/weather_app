package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.HourlyAdapter;
import com.example.myapplication.Domains.Hourly;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterHourly;
private RecyclerView recyclerView;
    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        initRecycleView();
        setVariable();
    }

    private void setVariable() {
        TextView next7Btn = findViewById(R.id.nextBtn);
        next7Btn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
        finish();
    }

    private void initRecycleView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("10 pm", 28,"cloudy"));
        items.add(new Hourly("11 pm", 27,"cloudy"));
        items.add(new Hourly("12 pm", 27,"cloudy"));
        items.add(new Hourly("1 am", 26,"rainy"));
        items.add(new Hourly("2 am", 26,"rainy"));

        recyclerView = findViewById(R.id.weatherView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
