package com.example.ab_sms_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){

                requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},101);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "SMS Permission Granted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Permission is required to proceed!!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}