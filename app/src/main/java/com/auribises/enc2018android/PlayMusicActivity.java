package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtSongName;
    Button btnPlay, btnStop;

    String songName;

    void initViews(){
        txtSongName = findViewById(R.id.textViewSongName);
        btnPlay = findViewById(R.id.buttonPlay);
        btnStop = findViewById(R.id.buttonStop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        Intent rcv = getIntent();
        songName = rcv.getStringExtra("keySongName");

        txtSongName.setText(songName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initViews();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonPlay){

        }else{

        }
    }
}
