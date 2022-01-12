package com.example.horizontalrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.horizontalrv.R;
import com.example.horizontalrv.model.Fruit;
import com.example.horizontalrv.model.FruitSub;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Fruit> fruits;

    public CustomAdapter(Context context, ArrayList<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }


    @Override
    public int getItemCount() {
        return fruits.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_list, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);

        if (holder instanceof CustomViewHolder) {
            RecyclerView recyclerView = ((CustomViewHolder) holder).recyclerView;
            // Build Horizontal RecyclerView
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            refreshAdapter(fruit.getFruitSubs(), recyclerView);
        }

    }


    private void refreshAdapter(ArrayList<FruitSub> fruitSubs, RecyclerView recyclerView) {
        CustomSubAdapter adapter = new CustomSubAdapter(context, fruitSubs);
        recyclerView.setAdapter(adapter);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public RecyclerView recyclerView;

        public CustomViewHolder(View v) {
            super(v);
            this.view = v;
            recyclerView = view.findViewById(R.id.recyclerView_sub);
        }

    }


}
