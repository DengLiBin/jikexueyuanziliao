package com.android.jikexueyuan.clip.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.clip:
                intent.setClass(MainActivity.this, ClipAc.class);
                break;
            case R.id.inset:
                intent.setClass(MainActivity.this, InsetAc.class);
                break;
            case R.id.rotate:
                intent.setClass(MainActivity.this, RotateAc.class);
                break;
            case R.id.scale:
                intent.setClass(MainActivity.this, ScaleAc.class);
                break;


        }
        startActivity(intent);
    }
}
