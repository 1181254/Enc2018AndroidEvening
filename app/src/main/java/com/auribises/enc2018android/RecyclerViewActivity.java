package com.auribises.enc2018android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsRecyclerAdapter recyclerAdapter;
    ArrayList<News> newsList;

    void initViews(){
        recyclerView = findViewById(R.id.recyclerView);

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

        recyclerAdapter = new NewsRecyclerAdapter(this,R.layout.list_item,newsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initViews();
    }
}
