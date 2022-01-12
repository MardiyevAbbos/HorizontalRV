package com.example.horizontalrv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.horizontalrv.R;
import com.example.horizontalrv.adapter.CustomAdapter;
import com.example.horizontalrv.model.Fruit;
import com.example.horizontalrv.model.FruitSub;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Fruit> fruits = prepareFruitList();
        refreshAdapter(fruits);

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }


    private void refreshAdapter(ArrayList<Fruit> fruits) {
        CustomAdapter adapter = new CustomAdapter(context, fruits);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<Fruit> prepareFruitList() {
        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 1; i < 41; i++) {
            fruits.add(new Fruit(prepareFruitSubList(i)));
        }
        return fruits;
    }


    private ArrayList<FruitSub> prepareFruitSubList(int test) {
        ArrayList<FruitSub> fruitSubs = new ArrayList<>();

        for (int i = test; i < 21 + test; i++) {
            if (i % 3 == 1) {
                fruitSubs.add(new FruitSub(R.drawable.apple));
            } else if (i % 3 == 2) {
                fruitSubs.add(new FruitSub(R.drawable.pineapple));
            } else {
                fruitSubs.add(new FruitSub(R.drawable.orange));
            }
        }
        return fruitSubs;
    }


}