package com.example.bluetoothserial_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import com.example.bluetoothserial_controller.RecyclerView.ViewItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView BottomNavigationView_SelectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView_SelectButton = findViewById(R.id.BottomNavigationView_SelectButton);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new ControllerHome()).commit();


        BottomNavigationView_SelectButton.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Controller :
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new ControllerHome()).commit();
                        return true;
                    case R.id.Monitor :
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new MonitorHome()).commit();
                        return true;
                    case R.id.Command :
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new CommandHome()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}