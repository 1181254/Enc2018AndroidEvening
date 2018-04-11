package com.auribises.enc2018android;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyLocationActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {

    TextView txtLocation;
    Button btnFetch;

    LocationManager locationManager;

    double latitude,longitude;

    void initViews() {
        txtLocation = findViewById(R.id.textViewLocation);
        btnFetch = findViewById(R.id.buttonFetch);
        btnFetch.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        initViews();
    }

    @Override
    public void onClick(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Please Grant Permissions in Settings !!",Toast.LENGTH_LONG).show();
        }else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60, 10, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        txtLocation.setText("My Location : "+latitude+" , "+longitude);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
