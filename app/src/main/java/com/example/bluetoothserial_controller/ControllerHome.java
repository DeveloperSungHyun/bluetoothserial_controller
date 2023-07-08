package com.example.bluetoothserial_controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluetoothserial_controller.RecyclerView.RecyclerViewAdapter;
import com.example.bluetoothserial_controller.RecyclerView.RecyclerViewDecoration;
import com.example.bluetoothserial_controller.RecyclerView.ViewItem;

import java.util.ArrayList;

public class ControllerHome extends Fragment {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView RecyclerView_game;

    ArrayList<ViewItem> viewItems;
    ViewItem item;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.controller_home, container, false);

        RecyclerView_game = view.findViewById(R.id.RecyclerView_game);

        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL , false);
        RecyclerView_game.setLayoutManager(linearLayoutManager);

        RecyclerViewDecoration recyclerViewDecoration = new RecyclerViewDecoration(30);
        RecyclerView_game.addItemDecoration(recyclerViewDecoration);

        viewItems = new ArrayList<>();
        item = new ViewItem(R.drawable.ic_launcher_background);

        for (int i = 0; i < 5; i++) {
            viewItems.add(item);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(viewItems);

        RecyclerView_game.setAdapter(recyclerViewAdapter);

        return view;
    }
}
