package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bind the Layout(Picture) on Activity(Frame)
        setContentView(R.layout.activity_one);

        System.out.println("ActivityOne - onCreate");
        Log.i("ActivityOne","onCreate");
    }

    public void clickHandler(View view){
        // Navigate from ActivityOne to ActivityTwo
        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ActivityOne - onStart");
        Log.i("ActivityOne","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityOne - onResume");
        Log.i("ActivityOne","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityOne - onPause");
        Log.i("ActivityOne","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityOne - onStop");
        Log.i("ActivityOne","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ActivityOne - onDestroy");
        Log.i("ActivityOne","onDestroy");
    }
}
