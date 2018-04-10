package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class ViewsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,RatingBar.OnRatingBarChangeListener{

    // Declare Reference to that View
    CheckBox cbCpp, cbJava, cbPython;
    RadioButton rbMale, rbFemale;

    Spinner spinner;
    ArrayAdapter<String> adapter;

    RatingBar ratingBar;
    EditText eTxtName;
    Button btnSubmit;

    Enquiry enquiry;

    // Initialize all these references above
    void initViews(){

        enquiry = new Enquiry();

        cbCpp = findViewById(R.id.checkBoxCpp);
        cbJava = findViewById(R.id.checkBoxJava);
        cbPython = findViewById(R.id.checkBoxPython);

        rbMale = findViewById(R.id.radioButtonMale);
        rbFemale = findViewById(R.id.radioButtonFemale);

        ratingBar = findViewById(R.id.ratingBar);

        eTxtName = findViewById(R.id.editTextName);

        btnSubmit = findViewById(R.id.button);

        cbCpp.setOnCheckedChangeListener(this);
        cbJava.setOnCheckedChangeListener(this);
        cbPython.setOnCheckedChangeListener(this);

        rbMale.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);

        /*ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });*/

        ratingBar.setOnRatingBarChangeListener(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eTxtName.getText().toString();
                enquiry.name = name;
                Toast.makeText(ViewsActivity.this,"You Entered: "+name,Toast.LENGTH_LONG).show();


                Intent intent = new Intent();
                intent.putExtra("keyEnquiry",enquiry);
                startActivity(intent);
            }
        });
    }

    void initSpinner(){
        spinner = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("--Select City--"); //0
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("Hyderabad");
        adapter.add("Chennai");         //n-1

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                String city = adapter.getItem(pos);

                if(pos!=0) {
                    Toast.makeText(ViewsActivity.this, "You Selected: " + city, Toast.LENGTH_LONG).show();
                    enquiry.city = city;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        initViews();
        initSpinner();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();

        switch (id){
            case R.id.checkBoxCpp:
                if(b) {
                    enquiry.cpp = true;
                    Toast.makeText(this, "You Checked CPP", Toast.LENGTH_LONG).show();
                }else{
                    enquiry.cpp = false;
                    Toast.makeText(this, "You UnChecked CPP", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.checkBoxJava:

                if(b) {
                    enquiry.java = true;
                    Toast.makeText(this, "You Checked Java", Toast.LENGTH_LONG).show();
                }else{
                    enquiry.java = false;
                    Toast.makeText(this, "You UnChecked Java", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.checkBoxPython:

                if(b) {
                    enquiry.python = true;
                    Toast.makeText(this, "You Checked Python", Toast.LENGTH_LONG).show();
                }else{
                    enquiry.python = false;
                    Toast.makeText(this, "You UnChecked Python", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.radioButtonMale:

                if(b) {
                    enquiry.gender = "Male";
                    Toast.makeText(this, "You Selected Male", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.radioButtonFemale:

                if(b) {
                    enquiry.gender = "Female";
                    Toast.makeText(this, "You Selected Female", Toast.LENGTH_LONG).show();
                }
                break;

        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        enquiry.rating = v;
        Toast.makeText(this,"You Gave "+v+" stars !!",Toast.LENGTH_LONG).show();
    }
}
