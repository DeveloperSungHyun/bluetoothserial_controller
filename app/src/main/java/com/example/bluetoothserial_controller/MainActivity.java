package com.example.bluetoothserial_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.bluetoothserial_controller.Bluetooth.BluetoothManager;
import com.example.bluetoothserial_controller.Bluetooth.DeviceData;
import com.example.bluetoothserial_controller.FragmentActivity.CommandHome;
import com.example.bluetoothserial_controller.FragmentActivity.ControllerHome;
import com.example.bluetoothserial_controller.FragmentActivity.MonitorHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView TextView_BluetoothName;

    BottomNavigationView BottomNavigationView_SelectButton;

    BluetoothManager bluetoothManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_BluetoothName = findViewById(R.id.TextView_BluetoothName);
        BottomNavigationView_SelectButton = findViewById(R.id.BottomNavigationView_SelectButton);

        bluetoothManager = new BluetoothManager(getApplicationContext());

        TextView_BluetoothName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<DeviceData> deviceData = bluetoothManager.GetDeviceDataList();

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("블루투스 목록"); //제목

                ArrayList<String> DeviceList = new ArrayList<>();
                for(DeviceData device : deviceData){
                    if(device.getAlias() != null) {
                        DeviceList.add(device.getAlias());
                    }else{
                        DeviceList.add(device.getName());
                    }
                }
                String[] versionArray = new String[DeviceList.size()];
                for (int i = 0; i < DeviceList.size(); i++) {
                    versionArray[i] = DeviceList.get(i);
                }

                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String Device_Name, Device_address;

                        if(deviceData.get(which).getAlias() != null){
                            Device_Name = deviceData.get(which).getAlias();
                        }else{
                            Device_Name = deviceData.get(which).getName();
                        }

                        Device_address = deviceData.get(which).getAddress();

                        TextView_BluetoothName.setText(Device_Name);


                    }
                });

                dlg.show();
            }
        });

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