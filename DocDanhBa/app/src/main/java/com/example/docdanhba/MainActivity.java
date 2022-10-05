package com.example.docdanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  static final  int REQUEST_CONTACTS_ASK_PERMISSSIONS =1001;

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
    }
    private void addEvents(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoHinhDanhBa();
            }
        });
    }
    private void xuLyMoHinhDanhBa(){
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("com.example.docdanhba","com.example.docdanhba.DanhBa");
        startActivity(intent);
    }
    private void addControl(){
        btn1.findViewById(R.id.btn1);
    }
}