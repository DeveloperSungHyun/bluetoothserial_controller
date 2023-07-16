package com.example.bluetoothserial_controller.Bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

public class BluetoothManager {

    Context context;
    View view;
    BluetoothAdapter bluetoothAdapter;

    static BluetoothSocket bluetoothSocket;

    private static final UUID MY_UUID_INSECURE =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @RequiresPermission(value = "android.permission.BLUETOOTH")
    public BluetoothManager(Context context) {
        this.context = context;
        this.view = view;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public ArrayList<DeviceData> GetAddressList() {
        ArrayList<DeviceData> deviceData = new ArrayList<>();
        DeviceData AddressList;
        String Address;
        String Alias;//Build.VERSION_CODES.R 이상
        String Name;
        int type;


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }

        for (BluetoothDevice device : bluetoothAdapter.getBondedDevices()) {
            Address = device.getAddress();
            Name = device.getName();
            type = device.getType();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                Alias = device.getAlias();
            } else {
                Alias = null;
            }
            AddressList = new DeviceData(Address, Alias, Name, type);
            deviceData.add(AddressList);
        }

        return deviceData;
    }

    public boolean Connection(String address, String Name) {
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);


        try {

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
            }
            bluetoothSocket = device.createRfcommSocketToServiceRecord(MY_UUID_INSECURE);
            bluetoothSocket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bluetoothSocket.isConnected();
    }

    public void DataOutput(String text){
        try {
            OutputStream outputStream = bluetoothSocket.getOutputStream();
            //outputStream.write(3);
            char Char_text[] = text.toCharArray();
            for(char c : Char_text){
                outputStream.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void DataOutput(int num){
        try {
            OutputStream outputStream = bluetoothSocket.getOutputStream();
            outputStream.write(num);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int b;
    public int DataInput(){

        try {
            InputStream inputStream = bluetoothSocket.getInputStream();
            inputStream.skip(inputStream.available());
            b = inputStream.read();

            Log.d("===============DataInput", "" + b);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
