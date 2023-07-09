package com.example.bluetoothserial_controller.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluetoothserial_controller.R;

import java.util.ArrayList;

public class RecyclerViewManager {
    private Context context;
    private RecyclerView recyclerView;

    private int ViewType = 0;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<ViewItem> viewItems;

    ArrayList<ItemData> itemArrayList;
    public RecyclerViewManager(Context context, RecyclerView recyclerView, int ViewType, ArrayList<ItemData> itemArrayList){
        this.context = context;
        this.recyclerView = recyclerView;
        this.itemArrayList = itemArrayList;

        this.ViewType = ViewType;
        init();
    }

    private void init(){
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL , false);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewDecoration recyclerViewDecoration = new RecyclerViewDecoration(30);
        recyclerView.addItemDecoration(recyclerViewDecoration);

        ListView_draw();

    }

    private void ListView_draw(){

        recyclerViewAdapter = new RecyclerViewAdapter(ViewType, itemArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
