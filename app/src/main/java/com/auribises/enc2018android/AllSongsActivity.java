package com.auribises.enc2018android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class AllSongsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;

    String path;

    void initViews(){
        listView = findViewById(R.id.listView);

        path = Environment.getExternalStorageDirectory().getAbsolutePath();

        path = "/storage/16F7-330D";

        Log.i("AllSongsActivity","Path is: "+path);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        //adapter.add("MySong.mp3"); //0
        //adapter.add("YourSong.mp3");//1

        try {
            File file = new File(path);

            String[] files = file.list();
            for(String str : files){
                if(str.endsWith(".mp3")) {
                    adapter.add(str);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        String name = adapter.getItem(pos);
        Toast.makeText(this,"You Selected "+name,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AllSongsActivity.this,PlayMusicActivity.class);
        intent.putExtra("keySongName",name);
        startActivity(intent);
    }
}
