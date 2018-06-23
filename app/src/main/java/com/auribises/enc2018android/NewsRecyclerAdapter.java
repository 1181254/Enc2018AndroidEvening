package com.auribises.enc2018android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>{


    Context context;
    int resource;
    ArrayList<News> objects;


    public NewsRecyclerAdapter(Context context, int resource, ArrayList<News> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(resource, parent,false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        News news = objects.get(position);

        holder.iv.setBackgroundResource(news.image);
        holder.txtTitle.setText(news.newsTitle);
        holder.txtUrl.setText(news.url);

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    // Nested Class | Which represents list item
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView txtTitle;
        TextView txtUrl;

        public ViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.imageView);
            txtTitle = itemView.findViewById(R.id.textViewNewsTitle);
            txtUrl = itemView.findViewById(R.id.textViewURL);
        }
    }

}
