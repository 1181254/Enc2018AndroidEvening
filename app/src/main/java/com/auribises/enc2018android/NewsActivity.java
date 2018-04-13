package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getSupportActionBar().setTitle("News");

        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("Zee News");
        adapter.add("CNN");
        adapter.add("Aaj Tak");
        adapter.add("Star News");
        adapter.add("BBC");
        adapter.add("NDTV");

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String news = adapter.getItem(i);
        Toast.makeText(this,"You Selected: "+news,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(NewsActivity.this,NewsDisplayActivity.class);
        startActivity(intent);

    }
}
