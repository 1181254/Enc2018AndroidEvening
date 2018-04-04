package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {

    EditText eTxtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        eTxtEmail = findViewById(R.id.editTextEmail);

        System.out.println("ActivityTwo - onCreate");


        //Intent rcv = getIntent();

        //String name = rcv.getStringExtra("keyName");
        //int age = rcv.getIntExtra("keyAge",0);

        //Bundle bundle = rcv.getBundleExtra("keyBundle");
        //String name = bundle.getString("keyName");
        //int age = bundle.getInt("keyAge");

        //Person person = (Person) rcv.getSerializableExtra("keyPerson");

        //eTxtEmail.setText(person.name+" - "+person.age);
    }

    public void clickHandler(View view){

        String email = eTxtEmail.getText().toString();

        Intent intent = new Intent(); // dummy intent to hold the data
        intent.putExtra("keyEmail",email);
        intent.putExtra("keyAge",30);

        setResult(201,intent);

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
