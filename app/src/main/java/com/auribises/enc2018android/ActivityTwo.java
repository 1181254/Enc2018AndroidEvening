package com.auribises.enc2018android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        System.out.println("ActivityTwo - onCreate");
    }

    public void clickHandler(View view){
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ActivityTwo - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityTwo - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityTwo - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityTwo - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ActivityTwo - onDestroy");
    }
}
