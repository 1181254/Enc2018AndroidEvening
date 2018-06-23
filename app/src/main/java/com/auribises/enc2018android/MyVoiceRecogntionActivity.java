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

public class MyVoiceRecogntionActivity extends AppCompatActivity implements View.OnClickListener, RecognitionListener {

    TextView txtData;
    Button btnSpeak;

    SpeechRecognizer speechRecognizer;
    ProgressDialog progressDialog;

    TextToSpeech tts;

    void initViews() {
        txtData = findViewById(R.id.textViewData);
        btnSpeak = findViewById(R.id.buttonSpeak);
        btnSpeak.setOnClickListener(this);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Listening...");
        progressDialog.setCancelable(false);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS){
                    // Use TTS
                    tts.speak("This is Awesome",TextToSpeech.QUEUE_FLUSH,null);
                }else{
                    // Prompt User to enable TTS
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voice_recogntion);
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
        progressDialog.dismiss();
    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle bundle) {

        ArrayList<String> results = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        if (results != null && results.size() > 0) {
            String closestMatch = results.get(0);
            txtData.setText(closestMatch);

            if (closestMatch.contains("call") && closestMatch.contains("mom")) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+91900000000"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,"Please grant call permissions in settings",Toast.LENGTH_LONG).show();
                }else {
                    startActivity(intent);
                }
            }

        }else{
            txtData.setText("Please Try Again");
        }

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
