package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Explicit Menu Creation

        // group id, item id, sequence, name
        /*menu.add(1,101,0,"All Songs");
        menu.add(1,201,0,"Artists");
        menu.add(1,301,0,"Recently Played");

        menu.add(2,401,0,"Images");
        menu.add(2,501,0,"Videos");
        menu.add(2,601,0,"Audios");*/

        // Implicit Menu Creation
        getMenuInflater().inflate(R.menu.menu_activityone,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        int gid = item.getGroupId();

        Toast.makeText(this,"Group Id "+gid+" Item Id "+id,Toast.LENGTH_LONG).show();

        /*switch (id){
            case 101:
                    Intent intent = new Intent(ActivityOne.this,AllSongsActivity.class);
                    startActivity(intent);
                break;

            case 201:

                break;

            case 401:

                break;

            case 501:

                break;

            //...
        }*/

        switch (id){
            case R.id.allSongs:
                Intent intent = new Intent(ActivityOne.this,AllSongsActivity.class);
                startActivity(intent);
                break;

            case R.id.amazon:
                Intent intent1 = new Intent(ActivityOne.this,AmazonActivity.class);
                startActivity(intent1);
                break;

            case R.id.favourites:

                break;

            //....
        }

        return super.onOptionsItemSelected(item);
    }
}
