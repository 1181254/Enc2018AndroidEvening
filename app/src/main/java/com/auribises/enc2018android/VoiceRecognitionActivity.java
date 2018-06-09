package com.auribises.enc2018android;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VoiceRecognitionActivity extends AppCompatActivity implements View.OnClickListener, RecognitionListener {

    TextView txtData;
    Button btnSpeak;

    SpeechRecognizer speechRecognizer;
    ProgressDialog progressDialog;

    TextToSpeech tts;

    void initViews() {
        txtData = findViewById(R.id.textViewData);
        btnSpeak = findViewById(R.id.buttonSpeak);
        btnSpeak.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Listening...");

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(TextToSpeech.SUCCESS != i){
                    Toast.makeText(VoiceRecognitionActivity.this,"Please Enable TTS in your Phone",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_recognition);
        initViews();
    }

    @Override
    public void onClick(View view) {
        speechRecognizer.startListening(RecognizerIntent.getVoiceDetailsIntent(this));
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {
        progressDialog.show();
    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle bundle) {

        ArrayList<String> text = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        if (text != null && text.size() > 0) {

            String closestMatch = text.get(0);

            txtData.setText(closestMatch);


            if (closestMatch.toLowerCase().contains("call") && closestMatch.toLowerCase().contains("mom")) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9915571177"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,"Please Grant Permissions in Settings to make calls",Toast.LENGTH_LONG).show();
                }else {
                    
                    tts.speak("I am going to place a phone call to your mom",TextToSpeech.QUEUE_FLUSH,null);

                    startActivity(intent);
                }
            }
        }

        progressDialog.dismiss();

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
