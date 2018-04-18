package com.auribises.enc2018android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 18/04/18.
 */

/*class Point{

    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}*/

public class NewsAdapter extends ArrayAdapter<News>{

    Context context;
    int resource;
    ArrayList<News> objects;


    public NewsAdapter(Context context, int resource, ArrayList<News> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    // Bind the data of an object in arraylist on listitem


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(resource, parent,false);

        ImageView iv = view.findViewById(R.id.imageView);
        TextView txtTitle = view.findViewById(R.id.textViewNewsTitle);
        TextView txtUrl = view.findViewById(R.id.textViewURL);

        News news = objects.get(position);

        iv.setBackgroundResource(news.image);
        txtTitle.setText(news.newsTitle);
        txtUrl.setText(news.url);


        return view;
    }
}
