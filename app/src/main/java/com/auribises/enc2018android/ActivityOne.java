package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActivityOne extends AppCompatActivity {

    // Declaring Reference to the View
    EditText eTxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bind the Layout(Picture) on Activity(Frame)
        setContentView(R.layout.activity_one);

        // Initializing the View
        eTxtName = findViewById(R.id.editTextName);

        System.out.println("ActivityOne - onCreate");
        Log.i("ActivityOne","onCreate");
    }

    public void clickHandler(View view){

        String name = eTxtName.getText().toString();

        // Navigate from ActivityOne to ActivityTwo
        //Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);

        //intent.putExtra("keyName",name);
        //intent.putExtra("keyAge",30);

        //Bundle bundle = new Bundle();
        //bundle.putString("keyName",name);
        //bundle.putInt("keyAge",30);

        //intent.putExtra("keyBundle",bundle);

        //Person person = new Person(name,30);
        //intent.putExtra("keyPerson",person);

        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==101 && resultCode==201){
            String email = data.getStringExtra("keyEmail");
            int age = data.getIntExtra("keyAge",0);

            eTxtName.setText(email+" - "+age);
        }
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
