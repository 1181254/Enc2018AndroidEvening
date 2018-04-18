package com.auribises.enc2018android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //ListView listView;
    GridView listView;
    ArrayAdapter<String> adapter;

    ArrayList<News> newsList;
    NewsAdapter newsAdapter;

    void initViews(){

        listView = findViewById(R.id.listView);

        /*adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("Zee News");
        adapter.add("CNN");
        adapter.add("Aaj Tak");
        adapter.add("Star News");
        adapter.add("BBC");
        adapter.add("NDTV");

        listView.setAdapter(adapter);*/

        News n1 = new News(R.drawable.news,"Zee News","http://zeenews.india.com/");
        News n2 = new News(R.drawable.news1,"CNN","http://zeenews.india.com/");
        News n3 = new News(R.drawable.news,"Aaj Tak","http://zeenews.india.com/");
        News n4 = new News(R.drawable.news2,"BBC","http://zeenews.india.com/");
        News n5 = new News(R.drawable.news1,"NDTV","http://zeenews.india.com/");

        newsList = new ArrayList<>();
        newsList.add(n1); //0
        newsList.add(n2);
        newsList.add(n3);
        newsList.add(n4);
        newsList.add(n5);
        newsList.add(n2);
        newsList.add(n3);
        newsList.add(n4); //n-1

        newsAdapter = new NewsAdapter(this,R.layout.list_item,newsList);
        listView.setAdapter(newsAdapter);


        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getSupportActionBar().setTitle("News");

        initViews();


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //String news = adapter.getItem(i);

        News news = newsList.get(i);

        Toast.makeText(this,"You Selected: "+news.newsTitle,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(NewsActivity.this,NewsDisplayActivity.class);
        startActivity(intent);

    }
}
