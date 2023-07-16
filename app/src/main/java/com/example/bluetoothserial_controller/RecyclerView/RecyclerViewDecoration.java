package com.example.bluetoothserial_controller.RecyclerView;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewDecoration extends RecyclerView.ItemDecoration {

    private final int divWidth;

    public RecyclerViewDecoration(int divWidth)
    {
        this.divWidth = divWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);

        if(position == 0){
            outRect.right = 15;
            outRect.left = 60;
        }else if(position == state.getItemCount() - 1){
            outRect.right = 60;
            outRect.left = 15;
        }else{
            outRect.right = 15;
            outRect.left = 15;
        }
        outRect.bottom = 40;
    }
}