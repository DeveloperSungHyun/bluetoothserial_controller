package com.example.bluetoothserial_controller.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluetoothserial_controller.JoystickLayout.JoystickLayout_1;
import com.example.bluetoothserial_controller.R;
import com.example.bluetoothserial_controller.RecyclerView.ItemData;
import com.example.bluetoothserial_controller.RecyclerView.RecyclerViewAdapter;
import com.example.bluetoothserial_controller.RecyclerView.RecyclerViewDecoration;
import com.example.bluetoothserial_controller.RecyclerView.RecyclerViewManager;
import com.example.bluetoothserial_controller.RecyclerView.ViewItem;

import java.util.ArrayList;

public class ControllerHome extends Fragment {
    Intent intent;
    RecyclerViewManager recyclerViewManager;
    RecyclerView RecyclerView_joystick, RecyclerView_remote, RecyclerView_sensor;

    ArrayList<ItemData> itemArrayList_1, itemArrayList_2, itemArrayList_3;
    ItemData itemData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.controller_home, container, false);

        RecyclerView_joystick = view.findViewById(R.id.RecyclerView_joystick);
        RecyclerView_remote = view.findViewById(R.id.RecyclerView_remote);
        RecyclerView_sensor = view.findViewById(R.id.RecyclerView_sensor);

        intent = new Intent(view.getContext(), JoystickLayout_1.class);

        itemArrayList_1 = new ArrayList<>();
        itemData = new ItemData(intent, R.drawable.test);

        for (int i = 0; i < 5; i++) {
            itemArrayList_1.add(itemData);
        }

        itemArrayList_2 = new ArrayList<>();
        itemData = new ItemData(intent, R.drawable.test2);

        for (int i = 0; i < 5; i++) {
            itemArrayList_2.add(itemData);
        }

        itemArrayList_3 = new ArrayList<>();
        itemData = new ItemData(intent, R.drawable.test2);

        for (int i = 0; i < 5; i++) {
            itemArrayList_3.add(itemData);
        }

        recyclerViewManager = new RecyclerViewManager(getContext(), RecyclerView_joystick,0,  itemArrayList_1);
        recyclerViewManager = new RecyclerViewManager(getContext(), RecyclerView_remote,1, itemArrayList_2);
        recyclerViewManager = new RecyclerViewManager(getContext(), RecyclerView_sensor,1, itemArrayList_3);

        return view;
    }
}
