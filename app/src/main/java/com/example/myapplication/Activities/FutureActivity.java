package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.FutureAdapter;
import com.example.myapplication.Domains.Future;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_future);

        initRecycleView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> startActivity(new Intent(FutureActivity.this, MainActivity.class)));
        finish();
    }

    private void initRecycleView() {
        ArrayList<Future> items = new ArrayList<>();
        items.add(new Future("Sat", "storm","Storm", 25,14));
        items.add(new Future("Sun", "cloudy","Cloudy", 24,16));
        items.add(new Future("Mon", "windy","Windy", 25,17));
        items.add(new Future("Tue", "sunny","Sunny", 28, 19));
        items.add(new Future("Wed", "rainy","Rainy", 25, 15));
        items.add(new Future("Thu", "rainy","Rainy", 25, 15));
        items.add(new Future("Fri", "rainy","Rainy", 25, 15));

        recyclerView = findViewById(R.id.weatherList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTomorrow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}
