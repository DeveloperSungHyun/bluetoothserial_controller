package com.example.bluetoothserial_controller.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluetoothserial_controller.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Intent intent;
    View view;
    ArrayList<ItemData> itemArrayList;
    private int ViewType;

    public RecyclerViewAdapter(int ViewType, ArrayList<ItemData> itemArrayList){
        this.ViewType = ViewType;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch (ViewType){
            case 0: view = layoutInflater.inflate(R.layout.item_layout_width, parent, false);
            break;
            case 1: view = layoutInflater.inflate(R.layout.item_layout_length, parent, false);
            break;
        }

        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        int i = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.getContext().startActivity(itemArrayList.get(i).intent);
            }
        });

        holder.ImageView_CheckImg.setImageResource(itemArrayList.get(position).image);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ImageView_CheckImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ImageView_CheckImg = itemView.findViewById(R.id.ImageView_CheckImg);
        }
    }
}
