package com.example.bluetoothserial_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bluetoothserial_controller.FragmentActivity.CommandHome;
import com.example.bluetoothserial_controller.FragmentActivity.ControllerHome;
import com.example.bluetoothserial_controller.FragmentActivity.MonitorHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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