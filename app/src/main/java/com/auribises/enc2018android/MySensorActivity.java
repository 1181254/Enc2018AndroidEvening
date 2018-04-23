package com.auribises.enc2018android;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MySensorActivity extends AppCompatActivity implements SensorEventListener{

    TextView txtData;
    Button btnActivate;

    SensorManager sensorManager;
    Sensor sensor;

    double latitude;
    double longitude;

    String phoneNum = "+91 99155 71177";
    String message = "Please Help Me !! I am in Emergency !!\nLocation is "+latitude+" , "+longitude;



    void initViews(){
        txtData = findViewById(R.id.textViewSensor);
        btnActivate = findViewById(R.id.buttonActivate);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    public void clickHandler(View view){

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sensor);
        initViews();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float[] values = sensorEvent.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        txtData.setText(x+" : "+y+" : "+z);

        float cal = ((x*x)+(y*y)+(z*z))/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        if(cal>2){
            txtData.setText("Shake Detected at "+x+" : "+y+" : "+z);
            sensorManager.unregisterListener(this);
            //...

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNum,null,message,null,null);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }
}
